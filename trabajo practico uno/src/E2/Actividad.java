package E2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    private final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    // Inscribe a un estudiante creando la instancia de la clase asociativa Inscripcion
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
        System.out.println("   Inscripciones para '" + this.titulo + "':");
        if (this.inscripciones.isEmpty()) {
            System.out.println("     (Sin inscriptos por el momento)");
        } else {
            for (Inscripcion ins : this.inscripciones) {
                System.out.println("     - Estudiante: " + ins.getEstudiante().getNombre() +
                        " (Legajo: " + ins.getEstudiante().getLegajo() + ")" +
                        " | Fecha: " + ins.getFecha() +
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