/**
 * Empleado con contrato por tiempo definido.
 * Salario fijo mensual sin bonos ni beneficios adicionales.
 */
public class EmpleadoTemporal extends Empleado {

    private double salarioFijo;
    private String fechaFinContrato;

    // Constantes
    private static final double PORCENTAJE_SEGURO_PENSION = 0.04;

    /**
     * @param nombre Nombre del empleado
     * @param id Identificador unico
     * @param aniosEnEmpresa Anos en la empresa
     * @param salarioFijo Salario mensual fijo
     * @param fechaFinContrato Fecha en que termina el contrato
     */
    public EmpleadoTemporal(String nombre, String id, int aniosEnEmpresa,
                             double salarioFijo, String fechaFinContrato) {
        super(nombre, id, aniosEnEmpresa);
        this.salarioFijo = salarioFijo;
        this.fechaFinContrato = fechaFinContrato;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioFijo;
    }

    @Override
    public double calcularBeneficios() {
        // Los empleados temporales no tienen bonos ni beneficios adicionales
        return 0;
    }

    @Override
    public double calcularDeducciones() {
        // Solo aplica seguro social y pension
        return salarioFijo * PORCENTAJE_SEGURO_PENSION;
    }

    public String getFechaFinContrato() {
        return fechaFinContrato;
    }
}