package kata5p2.view;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import kata5p2.model.Mail;

public class MailListReaderBD {
    
    public static List<Mail> read(String DB) {
        List<Mail> emails = new ArrayList<>();
        String URL = "jdbc:sqlite:" + DB;
        String SQL = "SELECT MAIL FROM EMAIL";
        
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next())
                emails.add(new Mail(rs.getString("MAIL")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return emails;
    }
}
