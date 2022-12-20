package model;


public class TokenAdmin {
    public String idtokenadmin;
    public String idadmin;
    public String token;
    public String datecreation;
    public String dateexpiration;
    public String role;

    public TokenAdmin(String idtokenadmin, String idadmin, String token, String datecreation, String dateexpiration, String role) {
        this.idtokenadmin = idtokenadmin;
        this.idadmin = idadmin;
        this.token = token;
        this.datecreation = datecreation;
        this.dateexpiration = dateexpiration;
        this.role = role;
    }

    public TokenAdmin(String idadmin, String token, String datecreation, String dateexpiration, String role) {
        this.idadmin = idadmin;
        this.token = token;
        this.datecreation = datecreation;
        this.dateexpiration = dateexpiration;
        this.role = role;
    }

    public String getIdtokenadmin() {
        return idtokenadmin;
    }

    public void setIdtokenadmin(String idtokenadmin) {
        this.idtokenadmin = idtokenadmin;
    }

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public String getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(String dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
