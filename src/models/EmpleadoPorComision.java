/**
 * Empleado con salario base mas comision sobre ventas.
 * Si las ventas superan $20.000.000 recibe bono adicional del 3%.
 * Recibe bono de alimentacion de $1.000.000 por ser empleado permanente.
 */
public class EmpleadoPorComision extends Empleado {

    private double salarioBase;
    private double porcentajeComision;
    private double totalVentas;

    // Constantes
    private static final double LIMITE_VENTAS_BONO = 20_000_000;
    private static final double PORCENTAJE_BONO_VENTAS = 0.03;
    private static final double BONO_ALIMENTACION = 1_000_000;
    private static final double PORCENTAJE_SEGURO_PENSION = 0.04;

    /**
     * @param nombre Nombre del empleado
     * @param id Identificador unico
     * @param aniosEnEmpresa Anos en la empresa
     * @param salarioBase Salario base mensual
     * @param porcentajeComision Porcentaje de comision sobre ventas (ej: 0.05 = 5%)
     * @param totalVentas Total de ventas realizadas en el mes
     */
    public EmpleadoPorComision(String nombre, String id, int aniosEnEmpresa,
                                double salarioBase, double porcentajeComision,
                                double totalVentas) {
        super(nombre, id, aniosEnEmpresa);

        // Validacion: ventas no pueden ser negativas
        if (totalVentas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser menores a $0.");
        }

        this.salarioBase = salarioBase;
        this.porcentajeComision = porcentajeComision;
        this.totalVentas = totalVentas;
    }

    @Override
    public double calcularSalarioBruto() {
        // Salario base + comision sobre ventas
        return salarioBase + (totalVentas * porcentajeComision);
    }

    @Override
    public double calcularBeneficios() {
        double beneficios = BONO_ALIMENTACION;

        // Bono adicional si las ventas superan $20.000.000
        if (totalVentas > LIMITE_VENTAS_BONO) {
            beneficios += totalVentas * PORCENTAJE_BONO_VENTAS;
        }

        return beneficios;
    }

    @Override
    public double calcularDeducciones() {
        // Seguro social y pension: 4% del salario bruto
        return calcularSalarioBruto() * PORCENTAJE_SEGURO_PENSION;
    }
}