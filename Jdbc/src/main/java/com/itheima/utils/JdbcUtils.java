package com.itheima.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
//创建一个成员变量
private static DataSource ds;
static {

     try {
         Properties properties = new Properties();
         //加载类路径下，即src目录下的druid.properties这个文件

        // InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
       InputStream is = JdbcUtils.class.getResourceAsStream("/druid.properties");
         properties.load(is);
         //读取属性文件创建连接池
         ds = DruidDataSourceFactory.createDataSource(properties);

     } catch (Exception e) {
         e.printStackTrace();
     }

 }

     public static DataSource getDataSource() {
 return ds;
   }
/**
     * 得到连接对象
     */
     public static Connection getConnection() {
 try {
return ds.getConnection();
 } catch (SQLException e) {
 throw new RuntimeException(e);
 }
 }
       /**
     * 释放资源
     */
        public static void close(Connection conn, Statement stmt, ResultSet rs) {
 if (rs!=null) {
 try {
rs.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 if (stmt!=null) {
 try {
 stmt.close();
  } catch (SQLException e) {
 e.printStackTrace();
  }
 }
 if (conn!=null) {
     try {
         conn.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
 }
 public static void close(Connection conn, Statement stmt) {
close(conn, stmt, null);
   }
}

