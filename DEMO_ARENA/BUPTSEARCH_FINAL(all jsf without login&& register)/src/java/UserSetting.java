
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userSetting")
@SessionScoped

public class UserSetting implements Serializable {
    //setting.xhtml
    public String searchlanguage;
    public String searchwindowsetting;
    //center.xhtml
    public String username;
    public String userpasswd;
    public String useremail;
    public Integer backgroundpicnum = 1;
    public String backgroundpicurl =  new String("background-image: url('https://ae01.alicdn.com/kf/Hcc4b4e2afabe408a83bd74dc9f237179A.jpg')");
    public String herf1disctiption;
    public String herf1url;
    public String herf2disctiption;
    public String herf2url;
    public String herf3disctiption;
    public String herf3url;
    
    public static final ArrayList<String> PIC_URLS = new ArrayList<String>(Arrays.asList(
        new String("background-image: url('https://ae01.alicdn.com/kf/Hcc4b4e2afabe408a83bd74dc9f237179A.jpg')"),
        new String("background-image: url('https://ae01.alicdn.com/kf/Hcc4b4e2afabe408a83bd74dc9f237179A.jpg')"),
        new String("background-image: url('https://ae01.alicdn.com/kf/Hcc4b4e2afabe408a83bd74dc9f237179A.jpg')")
    ));
    
    public String getSearchLanguage(){
        return searchlanguage;
    }
    public void setSearchLanguage(String searchlanguage){
        
        this.searchlanguage = searchlanguage;
    }
    public String getSearchWindowSetting(){
        return searchwindowsetting;
    }
    public void setSearchWindowSetting(String searchwindowsetting){
        this.searchwindowsetting = searchwindowsetting;
    }

    public String getUserName(){
        return username;
    }
    public void setUserName(String username){
        this.username = username;
    }
    
    public String getUserPasswd(){
        return userpasswd;
    }
    public void setUserPasswd(String userpasswd){
        this.userpasswd = userpasswd;
    }
    
    public String getUsereMail(){
        return useremail;
    }
    public void setUsereMail(String useremail){
        this.useremail = useremail;
    }
    
    
    public Integer getBackGroundPicNum(){
        return backgroundpicnum;
    }
    public void setBackGroundPicNum(Integer backgroundpicnum){
        this.backgroundpicnum = backgroundpicnum;
        setBackGroundPicUrl(PIC_URLS.get(backgroundpicnum-1));
    }
    
    
    public String getBackGroundPicUrl(){
        return backgroundpicurl;
    }
    public void setBackGroundPicUrl(String backgroundpicurl){
        this.backgroundpicurl = backgroundpicurl;
    }
    
    
    public String getHerf1Disctiption(){
        return herf1disctiption;
    }
    public void setHerf1Disctiption(String herf1disctiption){
        this.herf1disctiption = herf1disctiption;
    }
    
    
    public String getHerf1Url(){
        return herf1url;
    }
    public void setHerf1Url(String herf1url){
        this.herf1url = herf1url;
    }
    
    public String getHerf2Disctiption(){
        return herf1disctiption;
    }
    public void setHerf2Disctiption(String herf1disctiption){
        this.herf1disctiption = herf1disctiption;
    }
    
    
    public String getHerf2Url(){
        return herf1url;
    }
    public void setHerf2Url(String herf1url){
        this.herf1url = herf1url;
    }
    
    public String getHerf3Disctiption(){
        return herf1disctiption;
    }
    public void setHerf3Disctiption(String herf1disctiption){
        this.herf1disctiption = herf1disctiption;
    }
    
    
    public String getHerf3Url(){
        return herf1url;
    }
    public void setHerf3Url(String herf1url){
        this.herf1url = herf1url;
    }
    
    
    
}