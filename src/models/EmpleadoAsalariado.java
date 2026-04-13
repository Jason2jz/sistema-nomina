/**
 * Empleado con salario fijo mensual.
 * Recibe bono del 10% si lleva mas de 5 anos en la empresa.
 * Recibe bono de alimentacion de $1.000.000 por ser empleado permanente.
 */
public class EmpleadoAsalariado extends Empleado {

    private double salarioFijo;

    // Constantes - buena practica para evitar "numeros magicos" en el codigo
    private static final double PORCENTAJE_BONO_ANTIGUEDAD = 0.10;
    private static final double BONO_ALIMENTACION = 1_000_000;
    private static final double PORCENTAJE_SEGURO_PENSION = 0.04;
    private static final int ANOS_PARA_BONO = 5;

    /**
     * @param nombre Nombre del empleado
     * @param id Identificador unico
     * @param aniosEnEmpresa Anos en la empresa
     * @param salarioFijo Salario mensual fijo
     */
    public EmpleadoAsalariado(String nombre, String id, int aniosEnEmpresa, double salarioFijo) {
        super(nombre, id, aniosEnEmpresa);
        this.salarioFijo = salarioFijo;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioFijo;
    }

    @Override
    public double calcularBeneficios() {
        double beneficios = BONO_ALIMENTACION;

        // Bono por antiguedad si lleva mas de 5 anos
        if (getAniosEnEmpresa() > ANOS_PARA_BONO) {
            beneficios += salarioFijo * PORCENTAJE_BONO_ANTIGUEDAD;
        }

        return beneficios;
    }

    @Override
    public double calcularDeducciones() {
        // Seguro social y pension: 4% del salario bruto
        return salarioFijo * PORCENTAJE_SEGURO_PENSION;
    }
}