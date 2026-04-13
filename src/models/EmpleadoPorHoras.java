/**
 * Empleado que cobra por horas trabajadas.
 * Horas extras (mas de 40) se pagan a 1.5x la tarifa normal.
 * Si lleva mas de 1 ano, puede acceder a fondo de ahorro del 2%.
 */
public class EmpleadoPorHoras extends Empleado {

    private double tarifaPorHora;
    private double horasTrabajadas;
    private boolean aceptaFondoAhorro;

    // Constantes
    private static final int HORAS_NORMALES = 40;
    private static final double MULTIPLICADOR_HORAS_EXTRA = 1.5;
    private static final double PORCENTAJE_FONDO_AHORRO = 0.02;
    private static final double PORCENTAJE_SEGURO_PENSION = 0.04;
    private static final int ANOS_PARA_FONDO = 1;

    /**
     * @param nombre Nombre del empleado
     * @param id Identificador unico
     * @param aniosEnEmpresa Anos en la empresa
     * @param tarifaPorHora Valor pagado por cada hora trabajada
     * @param horasTrabajadas Total de horas trabajadas en el mes
     * @param aceptaFondoAhorro Si el empleado acepta el fondo de ahorro
     */
    public EmpleadoPorHoras(String nombre, String id, int aniosEnEmpresa,
                            double tarifaPorHora, double horasTrabajadas,
                            boolean aceptaFondoAhorro) {
        super(nombre, id, aniosEnEmpresa);

        // Validacion: horas no pueden ser negativas
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas.");
        }

        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }

    @Override
    public double calcularSalarioBruto() {
        if (horasTrabajadas <= HORAS_NORMALES) {
            return horasTrabajadas * tarifaPorHora;
        }

        // Horas normales + horas extra a 1.5x
        double pagoNormal = HORAS_NORMALES * tarifaPorHora;
        double horasExtra = horasTrabajadas - HORAS_NORMALES;
        double pagoExtra = horasExtra * tarifaPorHora * MULTIPLICADOR_HORAS_EXTRA;

        return pagoNormal + pagoExtra;
    }

    @Override
    public double calcularBeneficios() {
        // Fondo de ahorro si lleva mas de 1 ano y acepta el beneficio
        if (getAniosEnEmpresa() > ANOS_PARA_FONDO && aceptaFondoAhorro) {
            return calcularSalarioBruto() * PORCENTAJE_FONDO_AHORRO;
        }
        return 0;
    }

    @Override
    public double calcularDeducciones() {
        double deducciones = calcularSalarioBruto() * PORCENTAJE_SEGURO_PENSION;

        // El fondo de ahorro tambien se descuenta del salario
        if (getAniosEnEmpresa() > ANOS_PARA_FONDO && aceptaFondoAhorro) {
            deducciones += calcularSalarioBruto() * PORCENTAJE_FONDO_AHORRO;
        }

        return deducciones;
    }
}