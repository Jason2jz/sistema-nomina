/**
 * Clase principal del Sistema de Nomina - Souk 4.0
 * Aqui se crean los empleados de ejemplo y se procesa la nomina.
 */
public class Main {

    public static void main(String[] args) {

        // Crear el servicio de nomina
        NominaService nomina = new NominaService();

        // Empleado Asalariado - lleva 6 anos (recibe bono de antiguedad)
        EmpleadoAsalariado emp1 = new EmpleadoAsalariado(
            "Jason Posada", "001", 6, 3_500_000
        );

        // Empleado por Horas - 45 horas trabajadas (5 horas extra)
        EmpleadoPorHoras emp2 = new EmpleadoPorHoras(
            "Kevin Garcia", "002", 2, 25_000, 45, true
        );

        // Empleado por Comision - ventas superiores a $20.000.000
        EmpleadoPorComision emp3 = new EmpleadoPorComision(
            "Sebastian Torres", "003", 3, 2_000_000, 0.05, 25_000_000
        );

        // Empleado Temporal
        EmpleadoTemporal emp4 = new EmpleadoTemporal(
            "Didier Martinez", "004", 0, 2_000_000, "2025-12-31"
        );

        // Agregar empleados al sistema
        nomina.agregarEmpleado(emp1);
        nomina.agregarEmpleado(emp2);
        nomina.agregarEmpleado(emp3);
        nomina.agregarEmpleado(emp4);

        // Procesar y mostrar la nomina
        nomina.procesarNomina();
    }
}