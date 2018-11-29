package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) {

        try {

            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:sqlite:Prueba.db");
            conexion.setAutoCommit(false);

            Statement enunciado;
            enunciado = conexion.createStatement();

            ResultSet resultados;
            resultados = enunciado.executeQuery("SELECT * FROM PEOPLE;");

            while(resultados.next()) {
                System.out.println(resultados.getString("Id") + "\t" +
                        resultados.getString("Name") + "\t" +
                        resultados.getString("Apellidos") + "\t" +
                        resultados.getString("Departamento"));
            }

            resultados.close();
            enunciado.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}