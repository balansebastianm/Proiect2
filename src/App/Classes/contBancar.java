package App.Classes;

import App.Interfaces.cbAdd;
import App.Interfaces.cbRetragere;

import java.util.Arrays;

public class contBancar implements cbAdd, cbRetragere {
    private String numeClient;
    private double soldCont;
    private double datorii;
    private int numarLiniiDeCredit;
    private int[] liniiCredit = new int[3];
    private int codClient;

    public contBancar(){
        numeClient = "Marcel";
        soldCont = 0;
        datorii = 10000;
        numarLiniiDeCredit = 2;
        liniiCredit[0] = 213;
        liniiCredit[1] = 1450;
        liniiCredit[2] = 3321;
        codClient = 1852321;
    }

    public int getCodClient() {
        return codClient;
    }

    public void setCodClient(int codClient) {
        this.codClient = codClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public double getSoldCont() {
        return soldCont;
    }

    public void setSoldCont(double soldCont) {
        this.soldCont = soldCont;
    }

    public double getDatorii() {
        return datorii;
    }

    public void setDatorii(double datorii) {
        this.datorii = datorii;
    }

    public int getNumarLiniiDeCredit() {
        return numarLiniiDeCredit;
    }

    public void setNumarLiniiDeCredit(int numarLiniiDeCredit) {
        this.numarLiniiDeCredit = numarLiniiDeCredit;
    }

    public int[] getLiniiCredit() {
        return liniiCredit;
    }

    public void setLiniiCredit(int[] liniiCredit) {
        this.liniiCredit = liniiCredit;
    }

    public void addFunds(double suma){
        this.soldCont += suma;
    }

    public Boolean retragereBani(double suma){
        if(suma <= this.soldCont){
            this.soldCont -= suma;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "<HTML>contBancar{" +
                "<br><br>numeClient='" + numeClient + '\'' +
                ", <br><br>soldCont=" + soldCont +
                ", <br><br>datorii=" + datorii +
                ", <br><br>numarLiniiDeCredit=" + numarLiniiDeCredit +
                ", <br><br>liniiCredit=" + Arrays.toString(liniiCredit) +
                ", <br><br>codClient=" + codClient +
                '}';
    }
    public boolean platesteDatorii(){
        if(this.soldCont >= this.datorii)
            return true;
        else
            return false;
    }

    public boolean platesteDatorii(double suma){
        if(suma > this.soldCont){
            return false;
        }
        else if(suma > datorii){
            this.soldCont -= datorii;
            this.datorii = 0;
            return true;
        }
        else{
            this.datorii -= suma;
            this.soldCont -= suma;
            return true;
        }
    }
}
