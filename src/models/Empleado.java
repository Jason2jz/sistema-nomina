/**
 * Clase abstracta base para todos los tipos de empleados.
 * Principio SOLID: Open/Closed - abierta para extension, cerrada para modificacion.
 */
public abstract class Empleado {

    // Atributos comunes a todos los empleados
    private String nombre;
    private String id;
    private int aniosEnEmpresa;

    /**
     * Constructor base del empleado.
     * @param nombre Nombre completo del empleado
     * @param id Identificador unico
     * @param aniosEnEmpresa Anos que lleva en la empresa
     */
    public Empleado(String nombre, String id, int aniosEnEmpresa) {
        this.nombre = nombre;
        this.id = id;
        this.aniosEnEmpresa = aniosEnEmpresa;
    }

    // Metodos abstractos que cada tipo de empleado debe implementar
    public abstract double calcularSalarioBruto();
    public abstract double calcularBeneficios();
    public abstract double calcularDeducciones();

    /**
     * Calcula el salario neto final del empleado.
     * Valida que nunca sea negativo.
     */
    public double calcularSalarioNeto() {
        double neto = calcularSalarioBruto() + calcularBeneficios() - calcularDeducciones();
        if (neto < 0) {
            throw new IllegalStateException("El salario neto no puede ser negativo.");
        }
        return neto;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public int getAniosEnEmpresa() { return aniosEnEmpresa; }
}