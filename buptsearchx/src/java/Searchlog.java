/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lvlaxjh
 */
import java.sql.Date;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;

@ManagedBean
@ReferencedBean
public class Searchlog implements Serializable{

    
    int log_id;
    int user_id;
    String search_word;
    Date time;
    String ip;

    public int getLog_id() {
        return log_id;
    }
    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getSearch_word() {
        return search_word;
    }
    public void setSearch_word(String search_word) {
        this.search_word = search_word;
    }
    public Date getTime(){
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getIp(){
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }


}
