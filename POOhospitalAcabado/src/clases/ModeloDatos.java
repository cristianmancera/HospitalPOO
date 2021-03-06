package clases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;
public class ModeloDatos {
	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;
	
	private ArrayList<String> dnis = new ArrayList<String>();
	
	public ModeloDatos() {
		pacientesMap=new HashMap<String, Paciente>();
		empleadosPlanillaMap=new HashMap<String, EmpleadoPlanilla>();
		medicosMap=new HashMap<String, Medico>();
		empleadosEventualMap=new HashMap<String, EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();
	}
	
	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente=null;
		if(pacientesMap.containsKey(documentoPaciente)) {
			miPaciente = pacientesMap.get(documentoPaciente);
		}
		return miPaciente;
	}
	public String comprobarVacio(String numeroDNI, String desde) {
		if(desde=="Paciente") {
			if(pacientesMap.containsKey(numeroDNI)==false) {
				return "no";
			}
		}else if(desde=="EmpleadoP") {
			if(empleadosPlanillaMap.containsKey(numeroDNI)==false) {
				return "no";
			}
		}else if(desde=="medicos") {
			if(medicosMap.containsKey(numeroDNI)==false) {
				return "no";
			}
		}else if(desde=="EmpleadoE") {
			if(empleadosEventualMap.containsKey(numeroDNI)==false) {
				return "no";
			}
		}
		return "Invalido";
	}
	
	public Medico consultarMedicoPorNombre(String nombreMedico) {
		   
		for (Medico medico : medicosMap.values()) {
		        if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
		            return medico;
		        }
		}
		    return null;
	}
	public void buscarPaciente(String dniB) {
		if(pacientesMap.isEmpty()==false) {
			String msj="PACIENTE BUSCADO\n";
			boolean buscar = pacientesMap.containsKey(dniB);
			if(buscar==true) {
				pacientesMap.get(dniB).imprimirDatosPersona(msj);
			}else {
				System.out.println("Paciente no encontrado.");
			}
		}else {
			System.out.println("No hay ningun paciente registrado.");
		}
	}
	
	public void buscarEmpleadoE(String dniB) {
		if(empleadosEventualMap.isEmpty()==false) {
			String msj="EMPLEADO EVENTUAL BUSCADO\n";
			boolean buscar = empleadosEventualMap.containsKey(dniB);
			if(buscar==true) {
				empleadosEventualMap.get(dniB).imprimirDatosPersona(msj);
			}else {
				System.out.println("Empleado eventual no encontrado.");
			}
		}else {
			System.out.println("No hay ningun empleado eventual registrado.");
		}
		
	}
	
	public void buscarEmpleadoP(String dniB) {
		if(empleadosPlanillaMap.isEmpty()==false || medicosMap.isEmpty()==false) {
			String msj="EMPLEADO POR PLANILLA BUSCADO\n";
			boolean buscar = empleadosPlanillaMap.containsKey(dniB);
			boolean buscar2 = medicosMap.containsKey(dniB);
			if(buscar==true) {
				empleadosPlanillaMap.get(dniB).imprimirDatosPersona(msj);
			}else if (buscar2==true) {
				System.out.println("MEDICO");
				medicosMap.get(dniB).imprimirDatosPersona(dniB);
			}else {
				System.out.println("Paciente no encontrado.");
			}
			
			
		}else {
			System.out.println("No hay ningun empleado por planilla registrado.");
		}
		
	}
	
	public void buscarCitaMedica(String dniB) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void registrarPersona(Paciente miPaciente) {
		if(pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
			System.out.println("No se ha podido registrar el paciente, DNI ya existente.");
		}else {
			pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
			System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" Satisfactoriamente");
		}
	}
	public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
		if(empleadosPlanillaMap.containsKey(miEmpPlanilla)) {
			System.out.println("No se ha podido registrar el empleado de planilla, DNI ya existente.");
		}else {
			empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
		    System.out.println("Se ha registrado el empleado por planilla "+miEmpPlanilla.getNombre()+" Satisfactoriamente");
		}
		
	}
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		if(empleadosEventualMap.containsKey(miEmpEventual)) {
			System.out.println("No se ha podido registrar el empleado eventual, DNI ya existente.");
		}else {
			empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
		    System.out.println("Se ha registrado el empleado eventual "+miEmpEventual.getNombre()+" Satisfactoriamente");
		}
	    
	}
	public void registrarPersona(Medico miMedico) {
		if(medicosMap.containsKey(miMedico)) {
			System.out.println("No se ha podido registrar el medico, DNI ya existente.");
		}else {
			medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
		    System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
		}
	    
	}
	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
	}
	
	public void imprimirPacientes () {
		if(pacientesMap.isEmpty()==false) {
			String msj="PACIENTES REGISTRADOS\n";
		    Iterator<String> iterador=pacientesMap.keySet().iterator();
		    while (iterador.hasNext()) {
		        String clave = iterador.next();
		        pacientesMap.get(clave).imprimirDatosPersona(msj);
		    }
		}else {
			System.out.println("No hay ningun paciente registrado.");
		}
		    
	                      
	}
	public void imprimirCitasProgramadas() {
		if(citasList.isEmpty()==false) {
			String msj = "CITAS MEDICAS PROGRAMADAS\n";
			CitaMedica miCita = null;
			System.out.println(msj+"\n");
			if (citasList.size()>0) {
			     for (int i = 0; i < citasList.size(); i++) {
			          miCita=citasList.get(i);
			          System.out.println(miCita.informacionCitaMedica());
			     }
			}else {
			     System.out.println("No existen citas programadas");
			}
		}else {
			System.out.println("No hay ninguna cita medica programada.");
		}
		
	}
	public void imprimirEmpleadosEventuales() {
		if(empleadosEventualMap.isEmpty()==false) {
			String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
		    for (String clave : empleadosEventualMap.keySet()) {
		        empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
		    }
		}else {
			System.out.println("No hay ningun empleado eventual registrado.");
		}
	    
	}
	public void imprimirEmpleadosPorPlanilla() {
		if(empleadosPlanillaMap.isEmpty()==false) {
			String msj="EMPLEADOS POR PLANILLA REGISTRADOS\n";
			   
			for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
		        empleadoPlanilla.imprimirDatosPersona (msj);
		  
			}
		}else {
			System.out.println("No hay ningun empleado por planilla registrado.");
		}
		
	}
	public void imprimirMedicos() {
		if(medicosMap.isEmpty()==false) {
			String msj = "Medicos Registrados\n";
			for( Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
				elemento.getValue().imprimirDatosPersona(msj);
			}
		}else {
			System.out.println("No hay ningun medico registrado.");
		}
		
	}

	

	


	
	
}
