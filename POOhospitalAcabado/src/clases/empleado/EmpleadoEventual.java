package clases.empleado;
import javax.swing.*;
public class EmpleadoEventual extends Empleado{
	private double honorariosPorHora;
	private String fechaTerminoContrato;
	private String desde="EmpleadoE";
	
	
	@Override
	public String registrarDatos() {
		// TODO Auto-generated method stub
		String pasar = super.registrarDatos();
		try {
			honorariosPorHora=Double.parseDouble(JOptionPane. showInputDialog("Ingrese el salario Mensual"));
			fechaTerminoContrato=JOptionPane.showInputDialog("Ingrese fecha nacimiento (dd/mm/aaaa)");
			if(pasar=="si") {
				return "si";
			}else {
				return "no";
			}
		} catch (Exception e) {
			System.out.println("Datos invalidos, verifiquelos e intente nuevamente, error = " + e.getMessage());
			return "no";
		}
		

	}
	public double getHonorariosPorHora() {
	    return honorariosPorHora;
	}
	public void setHonorariosPorHora(double honorariosPorHora) {
	    this.honorariosPorHora = honorariosPorHora;
	}
	public String getFechaTerminoContrato() {
	    return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
	    this.fechaTerminoContrato = fechaTerminoContrato;
	}
}
