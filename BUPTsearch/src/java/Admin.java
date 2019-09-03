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
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;

@ManagedBean
@ReferencedBean
public class Admin implements Serializable{
    
    String admin_account;
    String admin_password;
    int admin_lv;

    public String getAdmin_account() {
        return admin_account;
    }
    public void setAdmin_account(String admin_account){
        this.admin_account = admin_account;
    }
    public String getAdmin_password(){
        return admin_password;
    }
    public void setAdmin_password(String admin_password){
        this.admin_password = admin_password;
    }
    public int getAdmin_lv() {
        return admin_lv;
    }
    public void setAdmin_lv(int admin_lv){
        this.admin_lv = admin_lv;
    }
    
}
