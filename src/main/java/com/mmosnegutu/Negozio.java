package com.mmosnegutu;

public class Negozio {

    private Prodotto[] scaffale;
    private int numeroProdotti;

    public Negozio() {
        scaffale = new Prodotto[50];
        numeroProdotti = 0;
    }

    public int getNumeroProdotti() {
        return numeroProdotti;  
    }

    public void AggiungiProdotto(Prodotto p) {
        if (numeroProdotti < scaffale.length) {
            scaffale[numeroProdotti] = p;
            numeroProdotti++;
        } else {
            System.out.println("Scaffale pieno, non puoi aggiungere altri prodotti.");
        }
    }

    public void ValoreInventario() {
        double valoreTotale = 0;
        for (int i = 0; i < numeroProdotti; i++) {
            valoreTotale += scaffale[i].calcolaValoreTotale();
        }
        System.out.println("Il valore totale dell'inventario è: " + valoreTotale);
    }

    public void MostraProdotti() {
        for (int i = 0; i < numeroProdotti; i++) {
            if (scaffale[i] instanceof ProdottoAlimentare) {
                ((ProdottoAlimentare) scaffale[i]).Scaduto();
            }
            System.out.println(scaffale[i].toString());
        }
    }
}
