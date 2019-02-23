import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcDemo02 {
    public static void main(String[] args) throws Exception {
            t1();
}
public static void t1() throws Exception{
    // 加载类路径下，即src目录下的druid.properties这个文件
    InputStream is = JdbcDemo02.class.getResourceAsStream("druid.properties");

    Properties pp = new Properties();
    pp.load(is);
    // 创建连接池，使用配置文件中的参数
    DataSource ds = DruidDataSourceFactory.createDataSource(pp);

    // for (int i = 0; i < 10; i++) {
// Connection conn = ds.getConnection();
// System.out.println(conn);
    // }
    // 从连接池中取出连接
    Connection conn = ds.getConnection();

    // 执行SQL语句
    String sql="insert into cst_customer values(null,?,?,?,?,?,?)";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1,"北京");
    pst.setString(2,"金融");
    pst.setString(3,"Vip");
    pst.setString(4,"诸葛");
    pst.setString(5,"1435643276");
    pst.setString(6,"面谈");
    int i = pst.executeUpdate();
    System.out.println("影响的行数： " + i);
    // 执行查询
 /*sql="SELECT * FROM cst_customer;";
        ResultSet resultSet = pst.executeQuery(sql);*/
    pst.close();
    conn.close();

}

}

