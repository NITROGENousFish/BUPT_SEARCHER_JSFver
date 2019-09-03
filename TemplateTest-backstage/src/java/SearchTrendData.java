/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lizon
 */
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

@ManagedBean(name="searchTrendData")
@SessionScoped
public class SearchTrendData implements Serializable{
    
    public Integer[] seven_days_search_times = new Integer[]{1,20,3,40,5,6,7}; // origin data of recent search times in seven days
    public String[] seven_recentdates;
    
            
    public Integer[] getSevenDaysSearchTimes() {
        return seven_days_search_times;
    }
    public void setSevenDaysSearchTimes(Integer[] seven_days_search_times) {
        this.seven_days_search_times = seven_days_search_times;
    }
    public String getSevenDaysSearchTimesString() {
        return Arrays.toString(seven_days_search_times).replace(" ", "").replace("[", "").replace("]", "");
    }
        
    public String[] getSevenDays(){
        return seven_recentdates;
    }
    public void setSevenDays(String[] today_dates){
        this.seven_recentdates = seven_recentdates;
    }
    
    public String getSevenDaysString(){
           String output = "";
           seven_recentdates = new String[7];
           SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
           Calendar c = null;
           for (int i=0;i<7;i++){
               c=Calendar.getInstance();
               c.add(Calendar.DAY_OF_MONTH, - i-1);
               seven_recentdates[6-i] =sdf.format(c.getTime());
           }
           for (int i=0;i<7;i++){
               output = output + seven_recentdates[i] +",";
           }
           System.err.println("================================================="); 
           System.err.println(seven_recentdates[6]);
           System.err.println(output);
           System.err.println("=================================================");
           
           return output;
           
    }
}

// <h:inputHidden value="#{jsData.favNumber1InString}" id="hidden_data"/>
//                                <h:outputText value="#{jsData.favNumber1InString}" style="color: red"/>
//           System.err.println("=================================================");