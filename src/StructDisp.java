import java.io.*;
import java.sql.*;

public class StructDisp{
    static String colLabel[];
    static int colCount;

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Statement stmt = con.createStatement();
            boolean status = stmt.execute("select * from stu");
            ResultSet rs = stmt.getResultSet();
            showStruct(rs);
            showData(rs);
            stmt.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}