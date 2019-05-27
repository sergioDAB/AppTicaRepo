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
    public static List<ApplicationEntity> getAllApps() throws SQLException {
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

    public static List<ApplicationEntity> getAppById(String id) throws SQLException {
        ApplicationRepository a = new ApplicationRepository();

        List<ApplicationEntity> apps= new ArrayList<ApplicationEntity>();

        Connection con = a.conectar();

        String sSQL = "select * from app where id_app = "+id+";";

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



    public static List<ApplicationEntity> getAppByDev(String id) throws SQLException {
        ApplicationRepository a = new ApplicationRepository();

        List<ApplicationEntity> apps= new ArrayList<ApplicationEntity>();

        Connection con = a.conectar();

        String sSQL = "select * from app where desarrollador = "+id+";";

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

    public static List<ApplicationEntity> getAppByCategory(String id) throws SQLException {
        ApplicationRepository a = new ApplicationRepository();

        List<ApplicationEntity> apps= new ArrayList<ApplicationEntity>();

        Connection con = a.conectar();

        String sSQL = "select * from app where categoria = "+id+";";

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

    //insert into calificacion (puntacion,id_usu,id_app) values (4,1,1);

    public static String AppCalification(String puntos,String id_app,String id_usuario) throws SQLException {
        try{
            if(Integer.parseInt(puntos)> 5 || Integer.parseInt(puntos)<1){
                return "puntuacion invalida";
            }
            int i= Integer.parseInt(id_app)+Integer.parseInt(id_usuario);

            ApplicationRepository a = new ApplicationRepository();
            Connection con = a.conectar();

            String sSQL = "insert into calificacion (puntacion,id_usu,id_app) values ("+puntos+","+id_usuario+","+id_app+");";

            try {
                Statement st = (Statement) con.createStatement();
                ResultSet r = st.executeQuery(sSQL);
                return "02000";

            } catch (SQLException e){
                return e.getSQLState();
            }
        }catch (Exception e){
            return "error de tipos de datos";
        }

    }

    public Response saveApplications(ApplicationEntity app){

        // insert in the data base the new app
        return  new Response(200,"success");
    }


    public static void main (String[] args) throws SQLException {
        String puntos = "7";
        String id_usuario="1";
        String id_app="1";

        if(Integer.parseInt(puntos)> 5 && Integer.parseInt(puntos)<1){
            System.out.println("puntuacion invalida");
            return;
        }
        ApplicationRepository a = new ApplicationRepository();
        Connection con = a.conectar();

        String sSQL = "insert into calificacion (puntacion,id_usu,id_app) values ("+puntos+","+id_usuario+","+id_app+");";
        try{


            try {
                Statement st = (Statement) con.createStatement();
                st.executeQuery(sSQL);
                System.out.println("insercion exitosa");
                return;

            } catch (SQLException e){
                System.out.println(e.toString());
                return;
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return;
        }
    }




}


