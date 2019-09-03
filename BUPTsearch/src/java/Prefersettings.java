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
public class Prefersettings implements Serializable{
    
    int user_id;
    int background_id;    
    int is_use_js;  
    public int getUser_id() {
        return user_id;
    }  
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getBackground_id() {
        return background_id;
    }
    public void setBackground_id(int background_id) {
        this.background_id = background_id;
    }
    public int getIs_use_js() {
        return is_use_js;
    }
    public void setIs_use_js(int is_use_js){
        this.is_use_js = is_use_js;
    }
}
