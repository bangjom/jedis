import java.sql.*;
import redis.clients.jedis.Jedis;

public class mysqlredis {

    public static void main(String[] args) throws SQLException {

        mysql mysql = new mysql();
        Jedis jedis = new Jedis("172.17.0.2");
        String sql = "select * from employees";
        Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
        ResultSet rs = null;


        stmt = mysql.con.createStatement();
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String emp_no = rs.getString("emp_no");

            String birth_date = rs.getString("birth_date");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String gender = rs.getString("gender");
            String hire_date = rs.getString("hire_date");

            jedis.hset(emp_no, "birth_date", birth_date);
            jedis.hset(emp_no, "first_name", first_name);
            jedis.hset(emp_no, "last_name", last_name);
            jedis.hset(emp_no, "gender", gender);
            jedis.hset(emp_no, "hire_date", hire_date);
        }


        mysql.dismiss();
    }
}
