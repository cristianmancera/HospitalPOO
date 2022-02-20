package clases.empleado;
import javax.swing.*;
public class EmpleadoPlanilla extends Empleado{
	private double salarioMensual;
	private double porcentajeAdicionalPorHoraExtra;
	private String desde="EmpleadoP";
	
	
	
	@Override
	public void imprimirDatosPersona(String datos) {
		// TODO Auto-generated method stub
		super.imprimirDatosPersona(datos);
		try {
			datos = "Salario Mensual: "+ salarioMensual + "\n";
			datos += "Porcentaje Adicional Por Hora Extra: " + porcentajeAdicionalPorHoraExtra + "\n";
			System.out.println(datos);
		} catch (Exception e) {
			System.out.println("Datos invalidos, verifiquelos e intente nuevamente, error = " + e.getMessage());
		}
		
	}
	@Override
	public String registrarDatos() {
		// TODO Auto-generated method stub
		String pasar = super.registrarDatos();
		try {
			salarioMensual=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
			porcentajeAdicionalPorHoraExtra=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Porcentaje Adicional por Hora Extra"));
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
	public double getSalarioMensual() {
	    return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
	    this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeAdicionalPorHoraExtra() {
	    return porcentajeAdicionalPorHoraExtra;
	}
	public void setPorcentajeAdicionalPorHoraExtra (double porcentajeAdicionalPorHoraExtra) {
	    this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
	}
}
