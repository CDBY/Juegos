package Juegos;

import java.util.Scanner;

public class TresEnRayaFinal {

	public static void main(String[] args) {
		
		//INSTRUCCIONES	
		//-----------------------------------------------	
		//SELECCIONdeMODO Y restart//	
		do {
			
		switch (a) {
		case 0:	
			instruccionesInicio();
			a++;
			break;
		case 1:
			instruccionesRecordatorio();
			break;
		}
			
			System.out.println("__________________________________________________________________________________________________________________________________");
			crearTablero(); /* Hay que crear de nuevo para que 
							no repita el tablero de la partida anterior */
			imprimirTablero();
			System.out.println("\n"+"\n"+"Número: ");
			//--------------------------------------------------//			
			System.out.println();
			seleccionarModo();
			puntos();
			
		}while (finalizar == false);
		System.out.println ("\n" + "\n" +"\n" +"\n");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t"+"\t"+"GRACIAS POR JUGAR, VUELVE PRONTO!");
		System.out.println("-------------------------------------------------------------------");
	}

//_______________________________________\\
//-----------------METODOS---------------//
//--------------------------------------//

	//------->texto por pantalla
	public static void instruccionesInicio() {


		System.out.println("\t" +"  ____BIENVENIDO____" );
		System.out.println("\t" +"\t" +"  AL" );
		System.out.println("\t" +"____¡TRES EN RAYA!____" + "\n"+ "\n");
		System.out.println("¡¡Primero decidiremos el tablero!! " +"\n");
		valorTablero();
		System.out.println("____________________________________________________" + "\n");
		System.out.println("\n" + "\t" +"Escoge la opción deseada " + "\n" +
				"\t" + "entre una de las siguientes");
		System.out.println("\t" +"______________________________" + "\n");
		System.out.println(" -->  [0] - ¿CAMBIAR LONGITUD DEL TABLERO?");
		System.out.println(" -->  [1] - M. Un Jugador");
		System.out.println(" -->  [2] - M. Jugador VS Jugador");
		System.out.println(" -->  [3] - M. COM vs COM" + "\n");
		System.out.println(" -> [9] - SALIR");
		System.out.println("\t" +"______________________________");
		System.out.println("\t" +"______________________________");
		System.out.println("\t" +"------------------------------" + "\n");
	}

	public static void instruccionesRecordatorio() {
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-" );
		System.out.println("Comienza una partida nueva");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-" + "\n");
		System.out.println(" -->  [0] - ¿CAMBIAR LONGITUD DEL TABLERO?");
		System.out.println(" -->  [1] - M. Un Jugador");
		System.out.println(" -->  [2] - M. Jugador VS Jugador");
		System.out.println(" -->  [3] - M. COM vs COM" + "\n");
		System.out.println(" -> [9] - SALIR");
		System.out.println("\t" +"______________________" + "\n");
		System.out.println("[Recordatorio de opciones]" + "\n");
	}

	//__________________________________________//
	//-->Seleccion de los tres modos de juego

	public static void seleccionarModo () {
		/* lo utilizo para dar linealidad al programa con un swich
 que hace que se elija el modo que se quiera */
		modo = modo1.nextInt();
		switch (modo) {
		
			case 0:
				valorTablero();
				crearTablero();
				System.out.println();
				System.out.println("________________________________________________" + "\n");
				System.out.println("\t"+ "Cambiado el tamaño correctamente" + "\n");
				System.out.println("________________________________________________" + "\n");
				instruccionesRecordatorio();
				break;
			
		case 1:
			turnoConMaquina();
			revancha();
			if (revancha == true) {
				switch (empieza) { // al ser revancha QUIEN EMPIEZA ESTA AL REVES
				case 1:
					crearTablero();
					System.out.println();
					imprimirTablero();
					primeroMaquinaJ();
					break;
				case 2:
					crearTablero();
					System.out.println();
					imprimirTablero();
					primeroJugadorM();
					break;
				}	
			}else {
			instruccionesRecordatorio();	
		
			}break;
		case 2:
			turnoConJugador();
			revancha();
			if (revancha == true) {
				switch (empieza) { // al ser revancha QUIEN EMPIEZA ESTA AL REVES
				case 1:
					crearTablero();
					System.out.println();
					imprimirTablero();
					primeroJugador2();
					break;
				case 2:
					crearTablero();
					System.out.println();
					imprimirTablero();
					primeroJugador();
					break;
				}	
			}else {
			instruccionesRecordatorio();	
			
			}break;
		case 3:
			maquinaVsMaquina2();
			revancha();
			if(revancha == true) {
				switch (empieza) { // al ser revancha QUIEN EMPIEZA ESTA AL REVES
				case 1:
					crearTablero();
					System.out.println();
					imprimirTablero();
					primeroMaquina();
					break;
				case 2:
					crearTablero();
					System.out.println();
					imprimirTablero();
					primeroMaquina2();
					break;
				}	
			}else {
			instruccionesRecordatorio();	
			
			}break;
			
		case 9:
			finalizar=true;
			break;

		}	
	}
	//__________________________________________//
	//------->tablero
	public static void valorTablero () {

		System.out.println("Añade un número de columnas deseado: " + "\n" +
				"[El número que introduzcas será la dimension del tablero] " +"\n"
				+" 	Minimo debe ser:  3 (Es decir:  3x3 )" + "\n"
				+"	[5x5, 4x4, 10x10]" + "\n" );//valor_tablero2

		System.out.print("Número: ");
		valor_tablero1 = scannerTablero2.nextInt();

		valor_tablero2 = valor_tablero1;

		tablero = new String[valor_tablero1][valor_tablero2];
	}

	public static void crearTablero () {

		int n = 1 ;

		for (int i = 0; i < tablero.length; i++) {
			for (int x = 0; x < tablero[i].length; x++) {

				String num = Integer.toString(n);
				n++;
				tablero[i][x] = num;
			}	
		}
	}

	public static void imprimirTablero () {

		int contador = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int x = 0; x < tablero.length; x++) {



				if (contador < 9) {
					System.out.print("\t" + " |  " +tablero[i][x]+ "  | ");
					contador++;
				}else {
					if(tablero[i][x]=="X" || tablero[i][x]=="0" || tablero[i][x]=="O" || tablero[i][x]=="#") {
						System.out.print("\t"+" |  " +tablero[i][x]+ "  | ");

					}else {
						System.out.print("\t" +" | " +tablero[i][x]+ "  | ");

					}
				}

				if(x +1 == valor_tablero2) {
					System.out.println();
				}

			}
		}
	}

	//__________________________________________//
	//------->posiciones de todos los jugadores

	public static void posicionesJ(int numero) {

		int posicion1 = 0;
		int posicion2 = 0;
		int[] marca = new int[2];

		do {
			System.out.print("Número: ");

			movimiento = in.nextInt();
			System.out.println("\n"+"--> El jugador 1 seleccionó la casila: " 
					+ movimiento + "\n" + 
					"[Recuerda no introduccir una casilla que este siendo ya usada]" );
			movimiento = movimiento - 1;
			numero = movimiento;



			posicion1 = (numero / valor_tablero1);
			posicion2 = (numero % valor_tablero2);

			marca[0] = posicion1;
			marca[1] = posicion2;
			posicionJ[0]= marca[0];
			posicionJ[1]= marca[1];

		} while(tablero [marca[0]] [marca[1]] == "X" || 
				tablero [marca[0]] [marca[1]] == "0" );

		tablero [posicionJ[0]] [posicionJ[1]] = "X";
	}

	public static void posicionesJ2(int numero) {

		int posicion1 = 0;
		int posicion2 = 0;
		int[] marca3 = new int[2];

		do {
			System.out.print("Numero: ");
			movimiento2 = in2.nextInt();

			System.out.println("--> El jugador 2 seleccionó la casila: " 
					+ movimiento2 + "\n" 
					+ "Recuerda no introduccir una casilla que este siendo ya usada" );
			
			movimiento2 = movimiento2 - 1;
			numero = movimiento2;

			posicion1 = (numero / valor_tablero1);
			posicion2 = (numero % valor_tablero2);

			marca3[0] = posicion1;
			marca3[1] = posicion2;
			posicionJ2[0]= marca3[0];
			posicionJ2[1]= marca3[1];

		} while(tablero [marca3[0]] [marca3[1]] == "X" || 
				tablero [marca3[0]] [marca3[1]] == "O");

		tablero [posicionJ2[0]] [posicionJ2[1]] = "O";


	}

	public static int[] posicionesMaquina () {

		int[] marca2 = new int[2];

		int numeroAleatorio;
		do {
			numeroAleatorio = (int) (Math.random() * (valor_tablero1*valor_tablero2) +1 );
			numeroAleatorio = numeroAleatorio -1;
			marca2[0] = (numeroAleatorio / valor_tablero1 );
			marca2[1] = (numeroAleatorio % valor_tablero1 );

		}while(	tablero [marca2[0]] [marca2[1]] == "X" || 
				tablero [marca2[0]] [marca2[1]] == "0" || 
				tablero [marca2[0]] [marca2[1]] == "#" );
		System.out.println("--> La maquina ha seleccionado: "+ ( numeroAleatorio +1));
		tablero [marca2[0]] [marca2[1]] = "0"  ;
		return marca2;

	}

	public static int[] posicionesMaquina2 () {

		int[] marca4 = new int[2];

		int numeroAleatorio;
		do {
			numeroAleatorio = (int) (Math.random() * (valor_tablero1*valor_tablero2) +1 );
			numeroAleatorio = numeroAleatorio -1;
			marca4[0] = (numeroAleatorio / valor_tablero1 );
			marca4[1] = (numeroAleatorio % valor_tablero1 );

		}while(tablero [marca4[0]] [marca4[1]] == "#" || 
				tablero [marca4[0]] [marca4[1]] == "0");
		System.out.println("--> La maquina 2 ha seleccionado: "+ ( numeroAleatorio +1));
		tablero [marca4[0]] [marca4[1]] = "#"  ;
		return marca4;

	}

	//__________________________________________//
	//------->turnos de cada modo de juego
	//-->J vs Maquina

	public static void turnoConMaquina () {
		switch ( empieza() ) {
		case 1:
			primeroJugadorM();
			break;

		case 2:
			primeroMaquinaJ();
			break;
		}
	}


	public static void primeroJugadorM () {

		while (true) {
			turno = 0;
			while (turno < (valor_tablero1*valor_tablero2)/2 ) {
				turno++;
				posicionesJ(movimiento);//jugador
				//-------------------------------
				if (ganador() == true) {
					if(empate == true) {
						System.out.println("\n"+"¡EMPATE!");
						break;
					}
				}
				//-------------------------------
				if (ganador() == false) {//maquina
					posicionM = posicionesMaquina();
					tablero [posicionM[0]] [posicionM[1]] = VALOR_MAQUINA;
				}
				System.out.println();
				System.out.println("\n" + "TURNO: " + turno);
				imprimirTablero();
				System.out.println();
				//----------------------------------------
				if (ganador () == false) {	
					System.out.print("_Vuelve a poner una casilla LIBRE_ " + "\n");
				}
				if (ganador() == true) {
					if(empate == true) {
						System.out.println("\n"+"¡EMPATE!");
						break;
					}
				}
				if (ganador() == true) {
					System.out.println();
					sumaPuntos();
					System.out.println("\t" + "_ __________________ _");
					System.out.println();
					System.out.println("\t" + "     _ ¡GANADOR! _");
					System.out.println("\t" + "_ __________________ _"+ "\n"+ "\n");
					break;	
				}
			}if (ganador() == false) {

				System.out.println("¡EMPATE!");
			}
			break;
		}
	}

	public static void primeroMaquinaJ () {

		while (true) {
			turno = 0;
			while (turno < (valor_tablero1*valor_tablero2)/2 ) {
				turno++;
				if (ganador() == false) {
					posicionM = posicionesMaquina();
					tablero [posicionM[0]] [posicionM[1]] = VALOR_MAQUINA;
				}
				//-------------------------------
				if (ganador() == true) {
					if(empate == true) {
						System.out.println("\n"+"¡EMPATE!");
						break;
					}
				}
				//-------------------------------
				if (ganador() == false) {
					posicionesJ(movimiento);
				}
				System.out.println();
				System.out.println("\n" + "TURNO: " + turno);
				imprimirTablero();
				System.out.println();
				//----------------------------------------
				if (ganador () == false) {	
					System.out.println("\n" + "_Vuelve a poner una casilla LIBRE_ " + "\n");
				}
				if (ganador() == true) {
					System.out.println();
					sumaPuntos();
					System.out.println("\t" + "_ __________________ _");
					System.out.println();
					System.out.println("\t" + "     _ ¡GANADOR! _");
					System.out.println("\t" + "_ __________________ _"+ "\n"+ "\n");
					break;	
				}
			}if (ganador() == false) {

				System.out.println("¡EMPATE!");
			}
			break;
		}
	}

	//__________________________________________//	
	//-->M vs M2

	public static void maquinaVsMaquina2 () {

		switch ( empieza() ) {
		case 1:
			primeroMaquina();
			break;
		case 2:
			primeroMaquina2();
			break;
		}
	}	


	public static void primeroMaquina() {

		while (true) {
			turno = 0;
			while (turno < (valor_tablero1*valor_tablero2)/2 ) { 
				turno++;
				if (ganador() == false) {
				posicionM = posicionesMaquina();//maquina 1
				tablero [posicionM[0]] [posicionM[1]] = VALOR_MAQUINA;
				}
				//-------------------------------
				if (ganador() == true) {
					if (empate == true) {
						System.out.println("¡EMPATE!");
						break;
					}
				}
				//-------------------------------
				if (ganador() == false && turno != 5) {
					posicionM2 = posicionesMaquina2();//maquina2
					tablero [posicionM2[0]] [posicionM2[1]] = VALOR_MAQUINA2;
				}

				System.out.println();
				System.out.println("TURNO: " + turno);
				imprimirTablero();
				System.out.println("-- - -- - -- - -- - -- - -- -- - -- - -- -");
				System.out.println();
				//----------------------------------------

				if (ganador() == true) {
					sumaPuntos();
					System.out.println();
					System.out.println("\t" + "_ __________________ _");
					System.out.println();
					System.out.println("\t" + "     _ ¡GANADOR! _");
					System.out.println("\t" + "_ __________________ _");
					break;	
				}
			}
			if (ganador() == false) {

				System.out.println("¡EMPATE!");

			}
			break;
		}
	}

	public static void primeroMaquina2() {
		while (true) {
			turno = 0;
			while (turno < (valor_tablero1*valor_tablero2)/2 ) {
				turno++;
				if (ganador() == false) {
				posicionM = posicionesMaquina2();//maquina 1
				tablero [posicionM[0]] [posicionM[1]] = VALOR_MAQUINA;
				}
				//-------------------------------
				if (ganador() == true) {
					if (empate == true) {
						System.out.println("¡EMPATE!");
						break;
					}
				}
				//-------------------------------
				if (ganador() == false) {
					posicionM2 = posicionesMaquina();//maquina2
					tablero [posicionM2[0]] [posicionM2[1]] = VALOR_MAQUINA2;
				}
				System.out.println();
				System.out.println("TURNO: " + turno);
				imprimirTablero();
				System.out.println("-- - -- - -- - -- - -- - -- -- - -- - -- -");
				System.out.println();
				//----------------------------------------

				if (ganador() == true) {
					sumaPuntos();
					System.out.println();
					System.out.println("\t" + "_ __________________ _");
					System.out.println();
					System.out.println("\t" + "     _ ¡GANADOR! _");
					System.out.println("\t" + "_ __________________ _"+ "\n"+ "\n");
					break;	
				}
			}if (ganador() == false) {

				System.out.println("¡EMPATE!");
			}
			break;
		}
	}

	//__________________________________________//
	//-->J vs J2

	public static void turnoConJugador() {
		
			switch ( empieza() ) {
			case 1:
				primeroJugador();
				break;
			case 2:
				primeroJugador2();
				break;
			}
		
	}


	public static void primeroJugador() {

		while (true) {
			turno = 0;
			while (turno < (valor_tablero1*valor_tablero2)/2 ) {
				turno++;
				if (ganador() == false) {	
				posicionesJ(movimiento);
				System.out.println("_ _ _ _ _ _ _" + "\n" + "\n");
				}
				if (ganador() == empate) { //si empata
					if(empate == true) {
						System.out.println("¡EMPATE!");
						break;
					}
				}	
				if (ganador() == false) {// si jugador 1 no ha ganado
					System.out.println("Jugador 2 selecciona un número: ");
					posicionesJ2(movimiento2);
					System.out.println();
					System.out.println();
				}
				imprimirTablero();
				System.out.println();
				if (ganador() == true) {// si encuentra un ganador
					sumaPuntos();
					System.out.println();
					System.out.println("\t" + "_ __________________ _");
					System.out.println();
					System.out.println("\t" + "     _ ¡GANADOR! _");
					System.out.println("\t" + "_ __________________ _" + "\n" + "\n");
					break;	
				}
			}if (ganador() == false) {

				System.out.println("¡EMPATE!");
			}
			break;
		}
	}

	public static void primeroJugador2 () {
		while (true) {
			turno = 0;
			while (turno < (valor_tablero1*valor_tablero2)/2 ) {
				turno++;
				if (ganador() == false) {
				posicionesJ2(movimiento2);
				System.out.println("_ _ _ _ _ _ _" + "\n" + "\n");
				}
				if (ganador() == empate) { //si empata
					if(empate == true) {
						System.out.println("¡EMPATE!");
						break;
					}
				}	
				if (ganador() == false) {// si jugador 1 no ha ganado
					System.out.println("Jugador 2 Pulsa un número ");
					posicionesJ(movimiento);
					System.out.print("El jugador 2 ha pulsado: " + movimiento2 + "\n");
				}
				imprimirTablero();
				System.out.println();
				if (ganador() == true) {// si encuentra un ganador
					sumaPuntos();
					System.out.println();
					System.out.println("\t" + "_ __________________ _");
					System.out.println();
					System.out.println("\t" + "     _ ¡GANADOR! _");
					System.out.println("\t" + "_ __________________ _" + "\n" + "\n");
					break;	
				}
			}if (ganador() == false) {

				System.out.println("¡EMPATE!");
			}
			break;
		}
	}

	//__________________________________________//	
	//------->identifica el ganador

	public static boolean ganador() {


		for(int i = 0; i < tablero.length -2; i++) { // LA LG.TABLERO -2 porque no queremos que se salga del array 
			for(int x = 0; x < tablero.length -2; x++) {//(la formula es restarle 2 a la longitud , con dibujo es mas sencillo de ver)

				if ( (tablero[i][x] == (tablero[i][x +1]) ) 
						&& 	(tablero[i][x] == tablero[i][x +2]) ) {	//BUSCA COINCIDENCIAS EN HORIZONTAL PARA VER SI HAY GANADOR
					switch (tablero[i][x]) {
					case "X":
						ganadorJ = true;
						return ganadorJ;

					case "O":
						ganadorJ2 = true;
						return ganadorJ2;

					case "0":
						ganadorM = true;
						return ganadorM;

					case "#":
						ganadorM2 = true;
						return ganadorM2;	


					} 
				}
			}
		}

		for(int i = 0; i < tablero.length -2 ; i++) { 
			for(int x = 0; x < tablero[i].length; x++) {

				if ((tablero[i][x]==tablero[i + 1][x]) 
						&& (tablero[i][x]==tablero[i + 2][x])) { //BUSCA COINCIDENCIAS EN VERTICAL PARA VER SI HAY GANADOR
					switch (tablero[i][x]) {
					case "X":
						ganadorJ = true;
						return ganadorJ;

					case "O":
						ganadorJ2 = true;
						return ganadorJ2;

					case "0":
						ganadorM = true;
						return ganadorM;

					case "#":
						ganadorM2 = true;
						return ganadorM2;
					} 

				}
			}
		}

		for(int i = 0; i < tablero.length -2 ; i++) { 
			for(int x = 0; x < tablero.length - 2 ; x++) {
				if ((tablero[i][x]==tablero[i+1][x+1]) 
						&& (tablero[i][x]==tablero[i+2][x+2])) {
					switch (tablero[i][x]) {
					case "X":
						ganadorJ = true;
						return ganadorJ;

					case "O":
						ganadorJ2 = true;
						return ganadorJ2;

					case "0":
						ganadorM = true;
						return ganadorM;

					case "#":
						ganadorM2 = true;
						return ganadorM2;	
					}
				}

			}

		}//DIAGONAL IZQUIERDA 
		for(int i = 2; i < tablero.length -2 ; i++) { 
			for(int x = 2; x < tablero.length -2 ; x++) {
				if ((tablero[i][x]==tablero[i+1][x-1])
						&& (tablero[i][x]==tablero[i+2][x-2])) {
					switch (tablero[i][x]) {
					case "X":
						ganadorJ = true;
						return ganadorJ;

					case "O":
						ganadorJ2 = true;
						return ganadorJ2;

					case "0":
						ganadorM = true;
						return ganadorM;

					case "#":
						ganadorM2 = true;
						return ganadorM2;	
					}
				}
			}
		}
		for(int i = 0; i < tablero.length ; i++) {
			for(int x = 0; x < tablero.length ; x++) {
				if((tablero[i][x] == VALOR_JUGADOR) && (tablero[i][x] == VALOR_MAQUINA) 
						&& (tablero[i][x] == VALOR_JUGADOR2) && (tablero[i][x] == VALOR_MAQUINA2)
						){

					System.out.println("¡¡¡¡EMPATE!!!!");
					empate = true;
					return empate;
				}
			}
		}
		return seguir;	
	}

	//-------------------AÑADIDO-------------------//
	//------------------//*//-------------------//

	public static int empieza () {
		System.out.println("Elige quien quieres que empiece"+ 
				"\n" +"o deja que sea aleatorio " + "\n");
		
		System.out.println("[1] Jugador 1 / Maquina 1");
		System.out.println("[2] Jugador 2 / Maquina 2");
		System.out.println("[3] Aleatorio" + "\n");
		System.out.println("Número: ");

		empieza = emp.nextInt();
		int random = 0;

		switch (empieza) {
		case 1:
			System.out.println("\n" + "Comienza el J1 / M1 ");
			System.out.println("_______________________________________________________________");
			imprimirTablero();

			return j1M1;
		case 2:
			System.out.println("\n" + "Comienza el J2 / M2 ");
			System.out.println("_______________________________________________________________");
			imprimirTablero();

			return j2M2;
		case 3:
			random = (int) (Math.random() * (2-0)+1);
			if (random == 1) {
				System.out.println("\n" + "Comienza el J1 / M1 ");
				System.out.println("_______________________________________________________________");
				imprimirTablero();
				return j1M1;
			}
			if (random == 2) {
				System.out.println("\n" + "Comienza el J2 / M2 ");
				System.out.println("_______________________________________________________________");
				imprimirTablero();
				return j2M2;
			}
		}
		return j2M2;
	}
	
	public static void revancha () {
		System.out.println("\t" + "___________________________" + "\n");
		System.out.println("\t" + " ¿Quieres la revancha?" + "\n");
		System.out.println("\t" + "___________________________" + "\n");
		System.out.println("[1] SI");
		System.out.println("[2] NO");
		System.out.print("Elegiste: ");

		int revan;
		revan = revancha1.nextInt();

		switch (revan) {
		case 1:
			revancha = true;
			break;
		case 2:
			revancha = false;
			break;
		}


	}

	public static int puntos () {

		if (ganadorJ == true) { 
			System.out.println("Jugador tiene: " + puntuacionJ + " punto/s");
			ganadorJ = false;	//VUELVO A PONER TODO EN FALSE PARA QUE EN LA SIGUIENTE PARTIDA 
			//NO LO CONTENGA COMO TRUE Y DE FALLOS
			return puntuacionJ;

		}
		if (ganadorJ2 == true) { 
			System.out.println("Jugador2 tiene: " + puntuacionJ2 + " punto/s");
			ganadorJ2 = false; //*FALSE
			return puntuacionJ2;
		}
		if (ganadorM == true) { 
			System.out.println("Maquina tiene: " + puntuacionM + " punto/s");
			ganadorM = false;//*FALSE
			return puntuacionM;	
		}
		if (ganadorM2 == true) { 
			System.out.println("Maquina 2 tiene: " + puntuacionM2 + " punto/s");
			ganadorM2 = false;//*FALSE
			return puntuacionM2;
		}	
		if (empate == true) { 
			System.out.println("_ _ NADIE RECIBE PUNTOS POR EMPATE _ _" );
			return -1;
		}
		return -1;
	}

	public static void sumaPuntos() {


		if (ganadorJ == true) { 
			System.out.println("EL JUGADOR 1 WINS!");
			puntuacionJ++;
		} ganadorJ = false; 
		if (ganadorJ2 == true) { 
			System.out.println("EL JUGADOR 2 WINS!");	
			puntuacionJ2++;
		} ganadorJ2 = false;
		if (ganadorM == true) { 
			System.out.println("MAQUINA WINS!");
			puntuacionM++;
		} ganadorM = false; 
		if (ganadorM2 == true) { 
			System.out.println("MAQUINA 2 WINS!");
			puntuacionM2++;
		}ganadorM2 = false;
		if (empate == true){
			System.out.println("\n"+"¡Nadie ha ganado!");
		} empate = false;
		
	}
	//_______________________________________________//
	//-----------------------------------------------//
	//________________VARIABLES GLOBALES_____________//

	public static int valor_tablero1=0;
	public static int valor_tablero2=0;
	private static String[][] tablero;
	//-------------------------------------------
	public static int modo = 0; public static int modo2 = 0;
	//------------------------------------//
	public static Scanner in = new Scanner (System.in);
	public static Scanner in2 = new Scanner (System.in);
	public static Scanner modo1 = new Scanner (System.in);
	public static Scanner modo0 = new Scanner (System.in);
	public static Scanner emp = new Scanner (System.in);
	public static Scanner scannerTablero2 = new Scanner ( System.in);
	public static Scanner numElegido = new Scanner (System.in);
	public static Scanner revancha1 = new Scanner (System.in);
	//------------------------------------//
	public static int movimiento = 0; public static int movimiento2 = 0;
	//------------------------------------//
	public static int puntuacionJ = 0; public static int puntuacionJ2 = 0; 
	public static int puntuacionM = 0; public static int puntuacionM2 = 0;
	//------------------------------------//
	public static boolean ganadorJ = false;
	public static boolean ganadorJ2 = false;
	public static boolean ganadorM = false;
	public static boolean ganadorM2 = false;
	public static boolean empate = false;
	//------------------------------------//
	public static boolean seguir = false;
	public static int empieza;
	public static int finalizar1= 9;
	public static boolean finalizar= false;
	public static boolean revancha = false;
	//------------------------------------//
	public final static int JUGADOR = 1;
	public final static int JUGADOR2 = 2;
	public final static int MAQUINA = 3;
	public final static int MAQUINA2 = 4;
	//------------------------------------//
	public final static String VALOR_JUGADOR = "X";
	public final static String VALOR_JUGADOR2 = "O";
	public final static String VALOR_MAQUINA = "0";
	public final static String VALOR_MAQUINA2 = "#";
	//------------------------------------//
	public static int j1M1 = 1; public static int j2M2 = 2;
	//------------------------------------//
	public static int turno = 0; public static int a = 0;
	//------------------------------------//
	public static int [] posicionJ = new int[2];
	public static int [] posicionJ2 = new int[2]; 
	public static int [] posicionM; public static int [] posicionM2;
	//--------------------------------------------------------------------//
	
}
