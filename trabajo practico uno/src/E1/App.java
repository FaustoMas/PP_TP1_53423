package E1;

public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE EVENTOS UNIVERSITARIOS ===\n");
        EventoUniversitario evento1 = new EventoUniversitario("EVT-01", "Jornada de Inteligencia Artificial", 15000.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("EVT-02", "Taller de Git y GitHub", 0.0, true);
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);
        System.out.println("DATOS DE LOS EVENTOS:");
        evento1.mostrarDatos();
        evento2.mostrarDatos();
        System.out.println("DATOS DE LA COPIA:");
        copiaEvento1.mostrarDatos();
        System.out.println("Total de eventos creados (instanciados): " + EventoUniversitario.getCantidadEventos());
    }
}