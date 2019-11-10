package it.uniroma3.diadia;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {
	
	public String prendiIstruzione() {
		String istruzione = null;
		Scanner scannerDiLinee;

		scannerDiLinee = new Scanner(System.in);
		if(scannerDiLinee.hasNextLine()) 
			istruzione = scannerDiLinee.nextLine();
		else
			scannerDiLinee.close();
		
		return istruzione;
	}
	
	public void mostraMessaggio(String messaggio) {
		System.out.print(messaggio);
	}
	
	
	
}
