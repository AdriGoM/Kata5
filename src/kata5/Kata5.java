package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Kata5 {

    private static Connection c;

    private static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        c = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        c.setAutoCommit(false);
    }

    private static void disconnect() throws SQLException {
        c.close();
    }

    private static void insertIntoEmail(String email) throws SQLException {
        String statement = "INSERT INTO EMAIL(Mail) values ('" + email + "')";
        Statement s = c.createStatement();
        s.execute(statement);
        c.commit();
        s.close();
    }

    public static void main(String[] args) {
        try {
            connect();

            List<String> emails = MailListReader.getInstance().read("/Users/adriangodoymartinez/IdeaProjects/Kata5/mail.txt");

            for (String email : emails) {
                insertIntoEmail(email);
            }

            disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}