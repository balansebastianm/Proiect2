package App.Classes;

public class textClass {
    contBancar c = new contBancar();
    public String datoriiTotal(contBancar c){
        return "Datorii ramase: " + c.getDatorii();
    }
    public String fonduriInsuficiente(contBancar c){
        return "Fonduri insuficiente. Sold cont:  " + c.getSoldCont();
    }
    public String depuneBani(contBancar c){
        return "Fondurile depuse cu succes. Sold cont:  " + c.getSoldCont();
    }
    public String retragere(contBancar c){
        return "Fondurile au fost retrase cu succes. Sold cont:  " + c.getSoldCont();
    }
    public String plataIntegralaY(contBancar c){
        return "Datoriile pot fi platite integral. Soldul ramas dupa plata integrala: " + (c.getSoldCont()-c.getDatorii());
    }
    public String plataIntegralaN(contBancar c){
        return "Datoriile nu pot fi platite integral, sold extra necesar: " + (c.getDatorii()-c.getSoldCont());
    }
}
