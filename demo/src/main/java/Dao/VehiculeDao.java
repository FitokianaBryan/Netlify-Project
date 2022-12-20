package Dao;
import Connection.Connexion;
import model.*;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class VehiculeDao {

    public ArrayList<HashMap<String, Object>>  liste() throws Exception {
        ArrayList<HashMap<String, Object>> liste = new ArrayList<HashMap<String, Object>>();
        try {
            String requete = "select*from Vehicule";
         /*   PreparedStatement stm = con.getStatement(requete);
            con.Execute();*/
            Connexion con=new Connexion(requete,"hh");
            ResultSet res=con.getResultset();
            Vehicule dept;
            String id="" , nomvehicule="",numero="";
            while (con.getResultset().next()) {
                id= res.getString(1);
                nomvehicule = res.getString(2);
                numero = res.getString(3);
                HashMap<String, Object> result = new HashMap<String, Object>();
                result.put("id",id);
                result.put("nomvehicule",nomvehicule);
                result.put("numero",numero);
                liste.add(result);
            }
            return liste;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Vehicule> ListVehicule() throws Exception {
        ArrayList<Vehicule> list = new ArrayList<Vehicule>();
        Connexion con = null;;;
        try {
            con = new Connexion("SELECT * FROM Vehicule","");
            ResultSet rs = con.getResultset();
            while(rs.next()) {
                String ID = rs.getString("idvehicule");
                String NomVehicule = rs.getString("nomvehicule");
                String Numero = rs.getString("numero");
                Vehicule vehicule = new Vehicule(ID,NomVehicule,Numero);
                list.add(vehicule);
            }
        }
        catch(Exception e) { throw e; }
        finally {
            con.CloseAll();
            return list;
        }
    }
    public void insererVehicule(String nomvehicule,String numero) throws Exception {
        try {
            String requete ="insert into Vehicule(nomvehicule,numero) values ('"+nomvehicule+"','"+numero+"')";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//            con.getResultset();
        } catch (Exception exc) {
            throw exc;
        } finally {
        }
    }

    public void updateVehicule(String idvehicule,String nomvehicule,String numero) throws Exception {
        try {
            String requete = "update Vehicule set nomvehicule='"+nomvehicule+"' , numero='"+numero+"'  where idvehicule='"+idvehicule+"' ";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//            con.getResultset();
        } catch (Exception exc) {
            throw exc;
        }
    }

    public void deleteVehicule(String idvehicule) throws Exception {
        try {
            String requete = "delete from Vehicule where idvehicule='"+idvehicule+"' ";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//            con.getResultset();
        } catch (Exception exc) {
            throw exc;
        }
    }
}
