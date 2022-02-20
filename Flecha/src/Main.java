import java.util.Scanner;

public class Main {
	
	Flecha flecha;

	public static void main(String[] args) {
		Main mimain=new Main();
	}
	public Main() {
		Scanner entrada = new Scanner(System.in);
		
		
		
		System.out.println("¿De que longitud desea la flecha?;");
		int largo = entrada.nextInt();
		
		System.out.println("¿De que color desea la flecha?; ");
		String colora = entrada.next();
		flecha = new Flecha();
		flecha.longitud=largo;
		flecha.color=colora;
		flecha.construirFlecha();
		flecha.imprimirEspacio();
	}

}
