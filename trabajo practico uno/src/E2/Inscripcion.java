package E2;

import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante, Actividad actividad) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
        this.actividad = actividad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }
}