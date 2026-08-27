package E1;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private static int cantidadEventos;

    public EventoUniversitario(String id, String titulo,  double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (this.gratuito == true) {
            return 0;
        } else {
            return this.costoBase;
        }
    }

    public void mostrarDatos() {
        System.out.println("ID del Evento: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Costo Estimado: $" + this.calcularCostoEstimado());
        if (this.gratuito == true) {
            System.out.println("El evento es: GRATUITO");
        } else {
            System.out.println("El evento es: PAGO");
        }
        System.out.println("-------------------------------------------------");
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    static {
        cantidadEventos = 0;
        System.out.println("Inicializador estático: se cargó la clase EventoUniversitario.");
    }
}