package model;

public class Vehicule {
    public String idvehicule;
    public String nomvehicule;
    public String numero;

    public Vehicule(String idvehicule, String nomvehicule, String numero) {
        this.idvehicule = idvehicule;
        this.nomvehicule = nomvehicule;
        this.numero = numero;
    }

    public String getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(String idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getNomvehicule() {
        return nomvehicule;
    }

    public void setNomvehicule(String nomvehicule) {
        this.nomvehicule = nomvehicule;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
