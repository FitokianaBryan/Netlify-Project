package Connection;


import Dao.TokenDao;
import Dao.VehiculeDao;
import model.Vehicule;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        //TokenDao td = new TokenDao();
        //int dd = td.isAdminToken("5534c0154ab1e96205ea308c6174953ec02fe47e","Admin");
        //System.out.println(dd);

        ArrayList<Vehicule> list = new VehiculeDao().ListVehicule();

    }
}
