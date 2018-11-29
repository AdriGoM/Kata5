package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");

            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
            conexion.setAutoCommit(false);

            Statement enunciado;
            enunciado = conexion.createStatement();

            enunciado.execute("CREATE TABLE 'EMAIL'('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL);");
            conexion.commit();

            enunciado.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}