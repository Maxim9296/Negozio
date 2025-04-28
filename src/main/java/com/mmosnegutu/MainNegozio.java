package com.mmosnegutu;
import java.time.DateTimeException;
import java.time.LocalDate;
public class MainNegozio {
	
	private MainNegozio(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author 
	 * @version 
	 */
    public static void main(String[] args){
       Negozio negozio = new Negozio();
       int  opt=0;
	   
	   Prodotto prodotto =null;
  
    do{

      System.out.println("1. Aggiungi Prodotto");
	  System.out.println("2. Visualizza Prodotti");
	  System.out.println("3. Calcola valore totale dell'negozio");
	  System.out.println("4. Esci");
      try{
		  opt = Integer.parseInt(System.console().readLine("Scegli un'opzione: "));
	  } catch (NumberFormatException e) {
		  System.out.println("Opzione non valida. Riprova.");
		  continue;
	  }

switch(opt){

	case 1:
		String nome = System.console().readLine("Inserisci il nome del prodotto: ");
		if(nome == null || nome.isEmpty()){
			System.out.println("Nome non valido. Riprova.");
			continue;
		}
		double prezzo = Double.parseDouble(System.console().readLine("Inserisci il prezzo del prodotto: "));
		if(prezzo <= 0){
			System.out.println("Prezzo non valido. Riprova.");
			continue;
		}
		int quantita = Integer.parseInt(System.console().readLine("Inserisci la quantita del prodotto: "));
		if(quantita <= 0){
			System.out.println("Quantità non valida. Riprova.");
			continue;
		}
		String dataScadenza = System.console().readLine("Inserisci la data di scadenza del prodotto (anno-mese-giorno) : ");
		try{
			LocalDate.parse(dataScadenza);
		} catch (DateTimeException e) {
			System.out.println("Data non valida. Riprova.");
			continue;
		}
		prodotto = new ProdottoAlimentare(nome, prezzo, quantita, dataScadenza);
		negozio.AggiungiProdotto(prodotto);
		System.out.println("Il Prodotto e stato aggiunto.");
		break;
	case 2:
	if(negozio.getNumeroProdotti() == 0){
		System.out.println("Nessun prodotto presente nel negozio.");
	}
		System.out.println("Prodotti nel negozio:");
		negozio.MostraProdotti();
		break;
	case 3:
		System.out.println("Valore totale dell'inventario:");
		negozio.ValoreInventario();
		break;
	case 4:
		System.out.println("Uscita dal programma.");
		break;
	default:
		System.out.println("Opzione non valida. Riprova.");
		break;

}

}while(opt != 4);

    System.out.println("Arrivederci!");
  


    }


}