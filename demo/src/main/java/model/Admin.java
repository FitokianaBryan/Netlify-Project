package model;

public class Admin {
    public String idAdmin;
    public String user;
    public String mdp;

    public Admin(String user, String mdp) {
        this.user = user;
        this.mdp = mdp;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
