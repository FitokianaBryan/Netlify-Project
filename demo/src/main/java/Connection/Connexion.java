package Connection;

import java.sql.*;

public class Connexion
{
    Connection con;
    public Statement stat;
    ResultSet res;

    private static String DB = "ws1";
    private static String Username = "postgres";
    private static String Password = "1618";

    public Connexion(String req)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB, Username, Password);

            this.stat= this.con.createStatement();
//  			this.res=stat.executeQuery(req);
            stat.execute(req);
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public Connexion()
    {

    }
    public Connexion(String req,String ide)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB, Username, Password);

            this.stat= this.con.createStatement();
            this.res=stat.executeQuery(req);
            //	stat.execute(req);
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public ResultSet getResultset()
    {
        return this.res;
    }

    public void getCommit() throws Exception
    {
        this.stat.executeQuery("commit");
    }

    public Statement getStat()
    {
        return this.stat;
    }

    //CLOSING CONNEXION
    public void CloseAll() throws Exception {
        try {
            this.res.close();
            this.stat.close();
            this.con.close();
        }
        catch(Exception e) { throw e; }
        finally {}
    }

    public void CloseRC() throws Exception {
        try {
            this.res.close();
            this.con.close();
        }
        catch(Exception e) { throw e; }
    }

    public void CloseSC() throws Exception {
        try {
            this.stat.close();
            this.con.close();
        }
        catch(Exception e) { throw e; }
    }
}

