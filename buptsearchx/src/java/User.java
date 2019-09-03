/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lvlaxjh
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
@ManagedBean
@ReferencedBean
public class User implements Serializable{
    
    int user_id;
    String name;
    String passwd;
    int sex;
    String user_post_date;
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int id){
        this.user_id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPasswd(){
        return passwd;
    }
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
    public int getSex(){
        return sex;
    }
    public void setSex(int sex){
        this.sex = sex;
    }
    public String getUser_post_date(){
        return user_post_date;
    }
    public void setUser_post_date(String user_post_date){
        // System.out.println(user_id + "\n"+name + "\n"+passwd + "\n"+sex + "\n"+user_post_date);
        this.user_post_date = user_post_date;
    }

}
