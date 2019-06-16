package aplicactions.ticas.appticas.dao;
import aplicactions.ticas.appticas.models.UserEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
@Service
public class UserRepository {

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


    public static UserEntity logIn(String us,String pass) throws SQLException {
        UserRepository a = new UserRepository();
        Connection con = a.conectar();

        String sSQL = "select id_usu,correo,contraseña,tipo from usuario where correo= '"+us+"' and contraseña = '"+pass+"';";
        UserEntity user = new UserEntity(-1,"","","");

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet r = st.executeQuery(sSQL);
            while(r.next()){
                UserEntity user2 = new UserEntity(
                        Integer.parseInt(r.getString(1)),
                        r.getString(2),
                        r.getString(3),
                        r.getString(4)
                );
                return user2;
            }


        } catch (SQLException e){
            System.out.println(e.toString());
        }


        return user;
    }
}
