import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import redis.clients.jedis.Jedis;

public class read {

    public static void main(String[] args) throws SQLException {
        Jedis jedis = new Jedis("172.17.0.2");
        mysql mysql = new mysql();
        String sql = "select * from employees";
        Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
        ResultSet rs = null;

        System.out.println("employees 테이블 전체 읽기");
        System.out.println();
        System.out.println("redis에서 읽는 속도");
        long beforeTime = System.currentTimeMillis();
        for (int i = 10001; i < 499999; i++) {
            Map<String, String> fields = jedis.hgetAll(Integer.toString(i));
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) ;
        System.out.println("시간차이: " + secDiffTime);

        stmt = mysql.con.createStatement();
        rs = stmt.executeQuery(sql);

        System.out.println();
        System.out.println("mysql에서 읽는 속도");
        long beforeTime1 = System.currentTimeMillis();
        while (rs.next()) {
            String emp_no = rs.getString("emp_no");
            String birth_date = rs.getString("birth_date");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String gender = rs.getString("gender");
            String hire_date = rs.getString("hire_date");
        }
        long afterTime1 = System.currentTimeMillis();
        long secDiffTime1 = (afterTime - beforeTime) ;
        System.out.println("시간차이 : " + secDiffTime1);

        mysql.dismiss();

    }
}
