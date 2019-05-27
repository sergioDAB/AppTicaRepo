package aplicactions.ticas.appticas.dao;


import aplicactions.ticas.appticas.models.ApplicationEntity;
import aplicactions.ticas.appticas.utils.Response;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class ApplicationRepository  {

    public Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/appticas",
                    "postgres", "12345");
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }

        return null;

    }
    //cada metodo retorna una lista de objetos con los records de la base de datos.
    public List<ApplicationEntity> getAllApps() throws SQLException {
        ApplicationRepository a = new ApplicationRepository();

        List<ApplicationEntity> apps= new ArrayList<ApplicationEntity>();

        Connection con = a.conectar();

        String sSQL = "select * from app";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet r = st.executeQuery(sSQL);
            while(r.next()){
                ApplicationEntity app = new ApplicationEntity(
                        Integer.parseInt(r.getString(1)),
                        r.getString(2),
                        Integer.parseInt(r.getString(3)),
                        Integer.parseInt(r.getString(4)),
                        r.getString(5),
                        "vacio");
                apps.add(app);
                }
        } catch (SQLException e){
            System.out.println(e.toString());
        }


        return apps;
    }

    public Response saveApplications(ApplicationEntity app){

        // insert in the data base the new app
        return  new Response(200,"success");
    }

    public static void main (String[] args) throws SQLException {
        ApplicationRepository a = new ApplicationRepository();

        Connection con = a.conectar();

        String sSQL = "select * from app";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet r = st.executeQuery(sSQL);
            while(r.next()){
                System.out.println (r.getString(1));
                System.out.println (r.getString(2));
                System.out.println (r.getString(3));
                System.out.println (r.getString(4));
                System.out.println (r.getString(5));}
        } catch (SQLException e){
                System.out.println(e.toString());
            }

    }



}


