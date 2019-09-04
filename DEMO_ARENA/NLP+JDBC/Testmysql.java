/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author lvlaxjh
 */
public class Testmysql {
    public void testsql(){
        try {
            //插入删除使用标准sql语句 + // stmt1.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数   
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=CONVERT_TO_NULL","root","jhczxcvbnm");
            // String sql = "insert into spiderlist(url,title,content,click_times)" + " values ('111', '111','123','123')"; // 插入数据的sql语句 
            String sql = "select * from spiderlist"; 

            //查询
            Statement stmt1 =con.createStatement();  // 创建用于执行静态sql语句的Statement对象 
            ResultSet rs = stmt1.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("spider_id");
                String url = rs.getString("url");
                String title = rs.getString("title");
                String cont = rs.getString("content");
                int times  = rs.getInt("click_times");
                //Display values
                
                System.out.print(id);
                System.out.print(url);
                System.out.print(title);
                System.out.print(cont);
                System.out.print(times);
             }
            
            // System.out.println(stmt1.executeUpdate(sql)); // 执行插入操作的sql语句，并返回插入数据的个数
        } catch (Exception e) {
            System.err.println("==================================");
            System.out.println(e);
            System.err.println("==================================");
        }
}
}
