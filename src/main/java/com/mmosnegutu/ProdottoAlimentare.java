package com.mmosnegutu;
import java.time.LocalDate;
public class ProdottoAlimentare extends Prodotto {
    private String dataScadenza;
    LocalDate scadenza = LocalDate.of(2025, 4, 30);
    LocalDate oggi = LocalDate.now();
    public ProdottoAlimentare(String nome, double prezzo,int quantita, String dataScadenza) {
        super(nome, prezzo, quantita);
        this.dataScadenza = dataScadenza;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public void Scaduto(){
        if (oggi.isAfter(scadenza)){
            System.out.println("Il prodotto è scaduto!");
          
        } else {
            System.out.println("Il prodotto non è scaduto");
        }
    }
    @Override
    public String toString() {
        return "ProdottoAlimentare{" +"dataScadenza='" + dataScadenza + '\'' +", nome='" + getNome() + '\'' +
                ", prezzo=" + getPrezzo() +", quantita=" + getQuantita() +'}';
    }

}
