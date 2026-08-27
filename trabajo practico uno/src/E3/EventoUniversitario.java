package E3;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    protected double costoBase;
    protected boolean gratuito;
    private Sala sala;
    private List<Actividad> actividades;

    private static int cantidadEventos;

    static {
        cantidadEventos = 0;
    }

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
        cantidadEventos++;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearCharla(int id, String titulo, int cupo, String disertante) {
        Charla nuevaCharla = new Charla(id, titulo, cupo, disertante);
        this.actividades.add(nuevaCharla);
    }

    public void crearTaller(int id, String titulo, int cupo, boolean requiereNotebook) {
        Taller nuevoTaller = new Taller(id, titulo, cupo, requiereNotebook);
        this.actividades.add(nuevoTaller);
    }

    public double calcularCostoEstimado() {
        if (this.gratuito == true) {
            return 0.0;
        }

        double totalActividades = 0.0;
        for (Actividad act : this.actividades) {
            totalActividades = totalActividades + act.calcularCostoMateriales();
        }

        return (this.costoBase + totalActividades) * 1.21;
    }

    public void mostrarDatos() {
        System.out.println("ID del Evento: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Costo Estimado (c/IVA): $" + this.calcularCostoEstimado());
        System.out.println("Tipo: " + (this.gratuito == true ? "GRATUITO" : "PAGO"));
        if (this.sala != null) {
            System.out.println("Sala asignada: " + this.sala.getNombre() + " (ID: " + this.sala.getId() + ")");
        } else {
            System.out.println("Sala asignada: Sin sala asignada");
        }

        System.out.println("Actividades del evento:");
        if (this.actividades.isEmpty()) {
            System.out.println("  (No posee actividades registradas)");
        } else {
            for (Actividad act : this.actividades) {
                act.mostrarIdentificacion();
                act.mostrarInscripciones();
            }
        }
        System.out.println("-------------------------------------------------");
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}