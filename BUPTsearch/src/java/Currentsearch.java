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
public class Currentsearch implements Serializable{
    
    int log_id;
    int order;
    String description;
    
    public int getLog_id() {
        return log_id;
    }
    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
