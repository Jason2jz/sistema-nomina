import java.util.ArrayList;
import java.util.List;

/**
 * Servicio principal de nomina.
 * Principio SOLID: Single Responsibility - solo se encarga de procesar la nomina.
 */
public class NominaService {

    // Lista de empleados registrados
    private List<Empleado> empleados;

    public NominaService() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado al sistema de nomina.
     * @param empleado Empleado a agregar
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Procesa y muestra el reporte de nomina de todos los empleados.
     */
    public void procesarNomina() {
        System.out.println("====================================");
        System.out.println("   SISTEMA DE NOMINA - SOUK 4.0   ");
        System.out.println("====================================\n");

        for (Empleado empleado : empleados) {
            mostrarReporteEmpleado(empleado);
        }

        System.out.println("====================================");
        System.out.println("   NOMINA PROCESADA EXITOSAMENTE   ");
        System.out.println("====================================");
    }

    /**
     * Muestra el reporte individual de un empleado.
     * @param empleado Empleado a reportar
     */
    private void mostrarReporteEmpleado(Empleado empleado) {
        try {
            System.out.println("Empleado   : " + empleado.getNombre());
            System.out.println("ID         : " + empleado.getId());
            System.out.println("Tipo       : " + empleado.getClass().getSimpleName());
            System.out.printf("Bruto      : $%,.2f%n", empleado.calcularSalarioBruto());
            System.out.printf("Beneficios : $%,.2f%n", empleado.calcularBeneficios());
            System.out.printf("Deducciones: $%,.2f%n", empleado.calcularDeducciones());
            System.out.printf("NETO       : $%,.2f%n", empleado.calcularSalarioNeto());
            System.out.println("------------------------------------\n");
        } catch (IllegalStateException e) {
            System.out.println("ERROR con " + empleado.getNombre() + ": " + e.getMessage());
            System.out.println("------------------------------------\n");
        }
    }

    /**
     * Retorna la lista de empleados registrados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }
}