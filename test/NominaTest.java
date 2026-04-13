/**
 * Pruebas unitarias del Sistema de Nomina - Souk 4.0
 */
public class NominaTest {

    static int pruebasPasadas = 0;
    static int pruebasFallidas = 0;

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   PRUEBAS UNITARIAS - SOUK 4.0   ");
        System.out.println("====================================\n");

        probarEmpleadoAsalariado();
        probarEmpleadoAsalariadoConBono();
        probarEmpleadoPorHorasNormales();
        probarEmpleadoPorHorasExtras();
        probarEmpleadoPorComision();
        probarEmpleadoPorComisionConBono();
        probarEmpleadoTemporal();
        probarValidacionHorasNegativas();
        probarValidacionVentasNegativas();

        System.out.println("====================================");
        System.out.println("Pruebas pasadas : " + pruebasPasadas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
        System.out.println("====================================");
    }

    static void verificar(String prueba, double esperado, double obtenido) {
        if (Math.abs(esperado - obtenido) < 0.01) {
            System.out.println("PASO: " + prueba);
            pruebasPasadas++;
        } else {
            System.out.println("FALLO: " + prueba);
            System.out.println("  Esperado: " + esperado + " | Obtenido: " + obtenido);
            pruebasFallidas++;
        }
    }

    static void verificarError(String prueba, boolean lanzoError) {
        if (lanzoError) {
            System.out.println("PASO: " + prueba);
            pruebasPasadas++;
        } else {
            System.out.println("FALLO: " + prueba);
            pruebasFallidas++;
        }
    }

    static void probarEmpleadoAsalariado() {
        EmpleadoAsalariado emp = new EmpleadoAsalariado("Test", "001", 3, 3_500_000);
        verificar("Asalariado - Salario bruto", 3_500_000, emp.calcularSalarioBruto());
        verificar("Asalariado - Deducciones 4%", 140_000, emp.calcularDeducciones());
        verificar("Asalariado - Beneficios sin bono", 1_000_000, emp.calcularBeneficios());
    }

    static void probarEmpleadoAsalariadoConBono() {
        EmpleadoAsalariado emp = new EmpleadoAsalariado("Test", "002", 6, 3_500_000);
        verificar("Asalariado - Bono antiguedad 10%", 1_350_000, emp.calcularBeneficios());
        verificar("Asalariado - Neto con bono", 4_710_000, emp.calcularSalarioNeto());
    }

    static void probarEmpleadoPorHorasNormales() {
        EmpleadoPorHoras emp = new EmpleadoPorHoras("Test", "003", 0, 25_000, 40, false);
        verificar("PorHoras - Bruto 40 horas normales", 1_000_000, emp.calcularSalarioBruto());
    }

    static void probarEmpleadoPorHorasExtras() {
        EmpleadoPorHoras emp = new EmpleadoPorHoras("Test", "004", 2, 25_000, 45, true);
        verificar("PorHoras - Bruto con horas extra", 1_187_500, emp.calcularSalarioBruto());
    }

    static void probarEmpleadoPorComision() {
        EmpleadoPorComision emp = new EmpleadoPorComision("Test", "005", 2, 2_000_000, 0.05, 10_000_000);
        verificar("Comision - Bruto base + comision", 2_500_000, emp.calcularSalarioBruto());
        verificar("Comision - Sin bono ventas", 1_000_000, emp.calcularBeneficios());
    }

    static void probarEmpleadoPorComisionConBono() {
        EmpleadoPorComision emp = new EmpleadoPorComision("Test", "006", 2, 2_000_000, 0.05, 25_000_000);
        verificar("Comision - Bono por ventas altas", 1_750_000, emp.calcularBeneficios());
    }

    static void probarEmpleadoTemporal() {
        EmpleadoTemporal emp = new EmpleadoTemporal("Test", "007", 0, 2_000_000, "2025-12-31");
        verificar("Temporal - Sin beneficios", 0, emp.calcularBeneficios());
        verificar("Temporal - Neto", 1_920_000, emp.calcularSalarioNeto());
    }

    static void probarValidacionHorasNegativas() {
        boolean lanzoError = false;
        try {
            new EmpleadoPorHoras("Test", "008", 0, 25_000, -5, false);
        } catch (IllegalArgumentException e) {
            lanzoError = true;
        }
        verificarError("Validacion - Horas negativas", lanzoError);
    }

    static void probarValidacionVentasNegativas() {
        boolean lanzoError = false;
        try {
            new EmpleadoPorComision("Test", "009", 0, 2_000_000, 0.05, -1000);
        } catch (IllegalArgumentException e) {
            lanzoError = true;
        }
        verificarError("Validacion - Ventas negativas", lanzoError);
    }
}