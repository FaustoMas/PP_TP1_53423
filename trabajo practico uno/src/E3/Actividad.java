package E3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    protected int id;
    protected String titulo;
    protected int cupoMaximo;
    protected final int CUPO_MINIMO = 5;
    protected List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public final void mostrarIdentificacion() {
        System.out.println("   [" + getTipo().toUpperCase() + "] Actividad #" + this.id + " - " + this.titulo +
                " | Costo materiales: $" + calcularCostoMateriales());
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (this.inscripciones.size() < this.cupoMaximo) {
            Inscripcion nuevaInscripcion = new Inscripcion(LocalDate.now(), "CONFIRMADA", estudiante, this);
            this.inscripciones.add(nuevaInscripcion);
            return nuevaInscripcion;
        } else {
            System.out.println("Cupo lleno para la actividad: " + this.titulo);
            return null;
        }
    }

    public void mostrarInscripciones() {
        if (this.inscripciones.isEmpty()) {
            System.out.println("      (Sin estudiantes inscriptos)");
        } else {
            for (Inscripcion ins : this.inscripciones) {
                System.out.println("      - Estudiante: " + ins.getEstudiante().getNombre() +
                        " (Legajo: " + ins.getEstudiante().getLegajo() + ")" +
                        " | Estado: " + ins.getEstado());
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}