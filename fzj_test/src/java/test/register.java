/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
/**
 *
 * @author 22236
 */
@Named
@RequestScoped
public class register {
    @EJB
    private test_bean.UserFacade user_test;
    
    private String name;
    private String passwd;
    private int sex;
    private String email;
    private Date user_post_date;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       public Date getUser_post_date() {
        return user_post_date;
    }

    public void setUser_post_date(Date user_post_date) {
        this.user_post_date =user_post_date;
    }
    
    public int getSex(){
        return sex;
    }
    public void setSex(int sex){
        this.sex = sex;
    }
    
    
    public void test(){
        Date date = new Date();
        this.setUser_post_date(date);
        user_test.register_user(name, email, passwd, user_post_date, sex);
    }
}
