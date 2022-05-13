import java.sql.*;

public class ConnectToMySQL {
    public static Connection getConnection() throws SQLException, java.lang.ClassNotFoundException {
        String url = "jdbc:mysql://chlzu.xyz:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String userName = "root";
        String password = "Passwordsql1";
        Connection con = DriverManager.getConnection(url, userName, password);
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            Statement sql = con.createStatement();
            sql.execute("DROP TABLE IF EXISTS student");
            sql.execute("CREATE TABLE student(id int not null auto_increment,name varchar(20) not null default 'name',math int NOT NULL default 60,PRIMARY KEY(id))");
            sql.execute("INSERT student values(1,'AAA','99')");
            sql.execute("INSERT student values(2,'BBB','77')");
            sql.execute("INSERT student values(3,'CCC','65')");
            String query = "SELECT * FROM student";
            ResultSet result = sql.executeQuery(query);
            System.out.println("Student表数据如下：");
            System.out.println("-----------------------------");
            System.out.println("学号 姓名 数学成绩");
            System.out.println("-----------------------------");
            int number;
            String name;
            String math;
            while (result.next()) {
                number = result.getInt("id");
                name = result.getString("name");
                math = result.getString("math");
                System.out.println(number + " " + name + " " + math);
            }
            sql.close();
            con.close();
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException:" + e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException:"+ex.getMessage());
        }
    }
}