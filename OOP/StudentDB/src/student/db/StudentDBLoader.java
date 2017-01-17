package student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDBLoader implements StudentDataLoader {
    private Connection connection;

    private static String facultyNumber;
    private static String firstName;
    private static String familyName;

    public StudentDBLoader(String fNumber) {
        StudentDBLoader.facultyNumber = fNumber;
        this.getDataById(fNumber);
    }

    @Override
    public String getFacultyNumber() {
        return StudentDBLoader.facultyNumber;
    }

    @Override
    public String getName() {
        return StudentDBLoader.firstName;
    }

    @Override
    public String getFamilyName() {
        return StudentDBLoader.familyName;
    }

    /**
     *
     * @param name [0] - First Name , [1] Second Name
     * @return the unique id of this student
     */
    private String getFacultyNumberByName(String[] name)
    {
        Connection connnection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String data = null;
        try {
            connnection = this.getConnection();
            statement = connnection.prepareStatement("SELECT id FROM students WHERE firstName=? AND lastName=?");
            statement.setString(1, name[0]);
            statement.setString(2, name[1]);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                data = resultSet.getString("id");
            }

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.closeDB();
        }

        return data;
    }

    public void getDataById(String id) {
        String[] data = this.getNamebyId(id).split(" ");
        StudentDBLoader.firstName = data[0];
        StudentDBLoader.familyName = data[1];
    }

    /**
     *
     * @param name [0] - First Name , [1] Second Name
     * @return the unique id of this student
     */
    public String getNamebyId(String number) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rset = null;
        StringBuilder sb = new StringBuilder();
        try {
            con = this.getConnection();
            statement = con.prepareStatement("SELECT * FROM students WHERE id=?");
            statement.setString(1, number);
            rset = statement.executeQuery();

            if(rset.next()) {
                sb.append(rset.getString("firstName") + " " + rset.getString("lastName"));
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            this.closeDB();
        }

        return sb.toString();
    }

    private Connection getConnection()
    {
        if (this.connection == null) {
            this.initDB();
        }

        return this.connection;
    }

    private void initDB() {
        try {
            // Load MS accces driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // location to your db file
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "C:\\path-to-your-db-file";

            // "username", "password" - enter your secrets...
            this.connection = DriverManager.getConnection(url, "username", "password");

            System.out.println("Connected to Database Succesfully!");
        } catch (Exception e) {
            System.out.println("Cannot init the database...");
            System.err.println(e.getMessage());

        }
    }

    private void closeDB() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
