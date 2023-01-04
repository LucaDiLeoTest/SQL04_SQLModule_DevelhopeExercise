import java.sql.*;
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "devpass");

            Statement statement = conn.createStatement();

            String addCountry = ""
                    + "ALTER TABLE newdb.students "
                    + "ADD country varchar(30) DEFAULT NULL;";

            statement.executeUpdate(addCountry);

            String populateCountry =""
                    + "INSERT INTO newdb.students (last_name,first_name,country) "
                    + "	VALUES "
                    + "('Rossi', 'Valentino', 'Italy'), "
                    + "('Bianchi', 'Roberto', 'Italy'), "
                    + "('Verdi', 'Domenico', 'Germany'), "
                    + "('Marrone', 'Mister', 'Germany');";

            statement.executeUpdate(populateCountry);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(conn != null){
                    conn.close();}
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}