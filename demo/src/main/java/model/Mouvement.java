package model;

public class Mouvement {

    public String idvehicule;
    public String dateMouvement;
    public int departKm;
    public int arriveeKm;

    public String getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(String idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(String dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public int getDepartKm() {
        return departKm;
    }

    public void setDepartKm(int departKm) {
        this.departKm = departKm;
    }

    public Mouvement(String idvehicule, String dateMouvement, int departKm, int arriveeKm) {
        this.idvehicule = idvehicule;
        this.dateMouvement = dateMouvement;
        this.departKm = departKm;
        this.arriveeKm = arriveeKm;
    }

    public int getArriveeKm() {
        return arriveeKm;
    }

    public void setArriveeKm(int arriveeKm) {
        this.arriveeKm = arriveeKm;
    }
}
