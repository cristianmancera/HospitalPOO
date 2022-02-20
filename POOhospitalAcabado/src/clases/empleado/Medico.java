package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{
	private String especialidad;
	private int numeroDeConsultorio;
	
	private String desde = "Medico";
	
	@Override
	public String registrarDatos() {
		// TODO Auto-generated method stub
		String pasar = super.registrarDatos();
		try {
			especialidad=JOptionPane.showInputDialog("Ingrese su especialidad");
			numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Num consultorio"));
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
	public String getEspecialidad() {
	    return especialidad;
	}
	public void setEspecialidad(String especialidad) {
	    this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
	    return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
	    this.numeroDeConsultorio = numeroDeConsultorio;
	}
}
