package Dao;

import Connection.Connexion;
import model.Admin;
import model.Mouvement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class MouvementDao {

    public ArrayList<HashMap<String, Object>> liste() throws Exception {
        ArrayList<HashMap<String, Object>> liste = new ArrayList<HashMap<String, Object>>();
        try {
            String requete = "select*from Mouvement";
         /*   PreparedStatement stm = con.getStatement(requete);
            con.Execute();*/
            Connexion con=new Connexion(requete,"hh");
            ResultSet res=con.getResultset();
            Vector v = new Vector();
            Mouvement dept;
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String id="" , dateMouvement="";
            while (con.getResultset().next()) {
                id= res.getString(1);
                dateMouvement = dateFormat.format(res.getDate(2));
                int departkm = res.getInt(3);
                int arriveekm = res.getInt(4);

                HashMap<String, Object> result = new HashMap<String, Object>();
                result.put("id",id);
                result.put("dateMouvement",dateMouvement);
                result.put("departkm",departkm);
                result.put("arriveekm",arriveekm);
                liste.add(result);
            }
            return liste;
        }

        catch (Exception e) {
            return null;
        }
    }
    public void insererMouvement(String idvehicule,String dateMouvement,int departkm,int arriveekm) throws Exception {
        try {
            String requete = "insert into Mouvement(idvehicule,datemouvement,departkm,arriveekm) values ('"+idvehicule+"','"+dateMouvement+"',"+departkm+","+arriveekm+")";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//            con.getResultset();
        } catch (Exception exc) {
            throw exc;
        } finally {
        }
    }

    public void updateMouvement(String idvehicule,String dateMouvement,int departkm,int arriveekm) throws Exception {
        try {
            String requete = "update Mouvement set datemouvement='"+dateMouvement+"' , departkm="+departkm+" , arriveekm="+arriveekm+" where idvehicule='"+idvehicule+"' ";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//            con.getResultset();
        } catch (Exception exc) {
            throw exc;
        }
    }

    public void deleteMouvement(String idvehicule) throws Exception {
        try {
            String requete = "delete from Mouvement where idvehicule='"+idvehicule+"' ";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//            con.getResultset();
        } catch (Exception exc) {
            throw exc;
        }
    }


}
