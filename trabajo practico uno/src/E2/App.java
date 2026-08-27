package E2;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: GESTIÓN DE EVENTOS, SALAS E INSCRIPCIONES ===\n");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("50201", "Lucía Fernández"));
        estudiantes.add(new Estudiante("50202", "Matías Romero"));
        estudiantes.add(new Estudiante("50203", "Valentina Rossi"));
        estudiantes.add(new Estudiante("50204", "Joaquín Navarro"));

        EventoUniversitario evento1 = new EventoUniversitario("EVT-101", "Congreso Tecnológico 2026", 20000.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("EVT-102", "Jornada de Software Libre", 0.0, true);

        Sala salaMagna = new Sala(1, "Aula Magna");
        Sala laboratorioRedes = new Sala(2, "Laboratorio de Redes");

        evento1.asignarSala(salaMagna);
        evento2.asignarSala(laboratorioRedes);

        evento1.crearActividad(1, "Introducción a Cloud Computing", 30);
        evento1.crearActividad(2, "Microservicios con Spring Boot", 20);

        evento2.crearActividad(3, "Instalación y Configuración de Linux", 25);

        Actividad act1 = evento1.getActividades().get(0);
        Actividad act2 = evento1.getActividades().get(1);

        Actividad act3 = evento2.getActividades().get(0);

        act1.inscribir(estudiantes.get(0));
        act1.inscribir(estudiantes.get(1));

        act2.inscribir(estudiantes.get(2));

        act3.inscribir(estudiantes.get(1));
        act3.inscribir(estudiantes.get(3));

        System.out.println("RESUMEN DE EVENTOS:\n");
        evento1.mostrarDatos();
        evento2.mostrarDatos();

        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}