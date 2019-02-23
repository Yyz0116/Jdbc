import com.itheima.utils.DruidUtils;
import com.itheima.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) {

        Connection connection=null;
        PreparedStatement statement=null;
        try {
//            connection = DruidUtils.getConnection();
            connection = JdbcUtils.getConnection();
            String sql="insert into cst_customer values(null,?,?,?,?,?,?)";
             statement = connection.prepareStatement(sql);
             statement.setString(1,"北京");
             statement.setString(2,"金融");
             statement.setString(3,"Vip");
             statement.setString(4,"诸葛小二");
             statement.setString(5,"1435643276");
             statement.setString(6,"面谈");
            int i = statement.executeUpdate();
            System.out.println("影响了："+i+" 行");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            DruidUtils.close(connection,statement);
        JdbcUtils.close(connection,statement);


        }


    }
}
