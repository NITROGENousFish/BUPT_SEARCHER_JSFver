/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lvlaxjh
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;



@ManagedBean
@ReferencedBean
public class User {

    String userName;
    String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean save() {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL","root","Nieping5868");
            PreparedStatement stmt = con.prepareStatement("insert into user(name,email) values(?,?)");
            String sql = "insert into user(name,email)" + " values ('111', '111')"; // 插入数据的sql语句 
            Statement stmt1 =con.createStatement();  // 创建用于执行静态sql语句的Statement对象 
            int count = stmt1.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数    
            
            
            stmt.setString(1, this.getUserName());
            stmt.setString(2, this.getEmail());
            result = stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("===============");
            System.out.println(e);
            System.err.println("===============");
        }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String submit() {
        if (this.save()) {
            return "result.xhtml";
        } else {
            return "index.xhtml";
        }
    }
}
