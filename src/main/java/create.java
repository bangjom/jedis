import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import redis.clients.jedis.Jedis;

public class create {

    public static void main(String[] args) throws SQLException {
        Jedis jedis = new Jedis("172.17.0.2");
        mysql mysql = new mysql();
        PreparedStatement pstmt = null;
        String sql = "insert into employees(emp_no, birth_date, first_name, last_name, gender,hire_date) values(?, ?, ?, ?, ?,?)";

        Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
        ResultSet rs = null;

        System.out.println("employees 테이블 전체 읽기");
        System.out.println();
        System.out.println("redis에서 쓰 속도");
        long beforeTime = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++) {
            jedis.hset(Integer.toString(i), "birth_date", LocalDate.now().toString());
            jedis.hset(Integer.toString(i), "first_name", Integer.toString(i));
            jedis.hset(Integer.toString(i), "last_name", LocalDate.now().toString());
            jedis.hset(Integer.toString(i), "gender", Integer.toString(i));
            jedis.hset(Integer.toString(i), "hire_date", LocalDate.now().toString());
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) ;
        System.out.println("시간차이: " + secDiffTime);





        System.out.println();
        System.out.println("mysql에서 쓰 속도");
        long beforeTime1 = System.currentTimeMillis();
        for(int i=1;i<10000;i++) {
            pstmt = mysql.con.prepareStatement(sql);
            pstmt.setInt(1, i);
            pstmt.setString(2,  LocalDate.now().toString());
            pstmt.setString(3, Integer.toString(i));
            pstmt.setString(4, Integer.toString(i));
            pstmt.setString(5, "M");
            pstmt.setString(6, LocalDate.now().toString());
            int r = pstmt.executeUpdate();
        }
        long afterTime1 = System.currentTimeMillis();
        long secDiffTime1 = (afterTime - beforeTime) ;
        System.out.println("시간차이 : " + secDiffTime1);

        mysql.dismiss();
    }
}
