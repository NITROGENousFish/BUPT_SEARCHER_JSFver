/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lizon
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class User {

    String name;
    Integer new_user_today = 10; // how much user add today
    Integer user_all_sum = 210; // sum of all user
    Integer website_access_time = 2019; // access times of our website
    Integer total_seatch_time = 53282; // total search time
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getUserToday(){
        return new_user_today;
    }
    public void setUserToday(Integer new_user_today){
        this.new_user_today = new_user_today;
    }
    
    public Integer getUserAllSum(){
        return user_all_sum;
    }
    public void setUserAllSum(Integer user_all_sum){
        this.user_all_sum = user_all_sum;
    }
    public Integer getAccessTime(){
        return website_access_time;
    }
    public void setAccessTime(Integer website_access_time){
        this.website_access_time = website_access_time;
    }
    public Integer getSearchTime(){
        return total_seatch_time;
    }
    public void setSearchTime(Integer total_seatch_time){
        this.total_seatch_time = total_seatch_time;
    }


    
}
