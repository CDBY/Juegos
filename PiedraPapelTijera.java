package Juegos;

import java.util.Scanner;

public class PiedraPapelTijera {
	
	public static final int VALOR_PIEDRA = 1;
	public static final int VALOR_PAPEL = 2;
	public static final int VALOR_TIJERA = 3;
	
	public static final String PIEDRA = "Piedra";
	public static final String PAPEL = "Papel";
	public static final String TIJERA = "Tijera";
	
	public static final int GANA_JUGADOR = 0;
	public static final int GANA_MAQUINA = 1;
	public static final int EMPATE = 2;

	public static void main(String[] args) {

		System.out.println("Juego piedra, papel o tijera");
		System.out.println("----------------------------");
		
		System.out.println();
				
		while(true) {
			
			System.out.println("Seleccione una de las siguientes opciones:");
			System.out.println(" - [1] Piedra");
			System.out.println(" - [2] Papel");
			System.out.println(" - [3] Tijera");
			System.out.println(" - [9] SALIR");
			
			System.out.println();
			
			System.out.print("Opción: ");
			Scanner scanner = new Scanner(System.in);
			
			int opcionSeleccionada = scanner.nextInt();
			
			if(opcionSeleccionada == 9) {
				
				System.out.println("¡Muchas gracias por jugar!");
				break;
			}
			
			int opcionMaquina = (int) (Math.random() * 3 + 1);
			
			System.out.println();
			System.out.println("Opción seleccionada por el jugador: " + opcionSeleccionada(opcionSeleccionada));
			System.out.println("Opción seleccionada por la máquina: " + opcionSeleccionada(opcionMaquina));
			System.out.println();
			
			int ganador = decidirGanador(opcionSeleccionada, opcionMaquina);
			
			switch(ganador) {
			
			case GANA_JUGADOR:
				
				System.out.println("¡Enhorabuena jugador, has ganado!");
				break;
				
			case GANA_MAQUINA:
				
				System.out.println("¡Ha ganado la máquina!");
				break;
				
			case EMPATE:
				
				System.out.println("Ha habido un empate...");
				break;
			}
			
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println();
		}
		
		
	}

	private static int decidirGanador(int opcionJugador, int opcionMaquina) {

		if (opcionJugador == opcionMaquina) {
			
			return EMPATE;
		}
		else {
			
			switch(opcionJugador) {
			
			case VALOR_PIEDRA:
				
				if(opcionMaquina == VALOR_PAPEL) {
					
					return GANA_MAQUINA;
				}
				else {
					
					return GANA_JUGADOR;
				}
				
			case VALOR_PAPEL:
				
				if(opcionMaquina == VALOR_TIJERA) {
					
					return GANA_MAQUINA;
				}
				else {
					
					return GANA_JUGADOR;
				}
				
			case VALOR_TIJERA:
				
				if(opcionMaquina == VALOR_PIEDRA) {
					
					return GANA_MAQUINA;
				}
				else {
					
					return GANA_JUGADOR;
				}
			}
		}
		
		return -1;
	}
	
	private static String opcionSeleccionada(int numeroSeleccionado) {
		
		switch(numeroSeleccionado) {
		
		case VALOR_PIEDRA:
			return PIEDRA;
			
		case VALOR_PAPEL:
			return PAPEL;
			
		case VALOR_TIJERA:
			return TIJERA;
		}
		
		return "¡No existe esa opción!";
	}

}
