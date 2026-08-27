package E3;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: POLIMORFISMO Y HERENCIA ===\n");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("50201", "Lucía Fernández"));
        estudiantes.add(new Estudiante("50202", "Matías Romero"));
        estudiantes.add(new Estudiante("50203", "Valentina Rossi"));

        EventoUniversitario evento = new EventoUniversitario("EVT-301", "Simposio de Innovación", 10000.0, false);

        Sala auditorio = new Sala(1, "Auditorio Central");
        evento.asignarSala(auditorio);

        evento.crearCharla(1, "Tendencias en Arquitectura de Software", 50, "Dr. Carlos Benítez");
        evento.crearTaller(2, "Programación Funcional en Haskell", 20, true);

        Actividad charla = evento.getActividades().get(0);
        Actividad taller = evento.getActividades().get(1);

        charla.inscribir(estudiantes.get(0));
        charla.inscribir(estudiantes.get(1));

        taller.inscribir(estudiantes.get(1));
        taller.inscribir(estudiantes.get(2));

        System.out.println("RESUMEN DEL EVENTO:\n");
        evento.mostrarDatos();

        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}