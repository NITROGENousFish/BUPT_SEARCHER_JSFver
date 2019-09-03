
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lizon
 */



@ManagedBean(name="topWordData")
@SessionScoped
public class TopWordData implements Serializable{
    public String TestString = 
"[\n" +
"    {\n" +
"        value: 50,\n" +
"        color:\"#F64747\",\n" +
"        highlight: \"#ed2323\",\n" +
"        label: \"Mails\"\n" +
"    },\n" +
"    {\n" +
"        value: 23,\n" +
"        color: \"#ff9704\",\n" +
"        highlight: \"#ff7200\",\n" +
"        label: \"Messages\"\n" +
"    },\n" +
"    {\n" +
"        value: 280,\n" +
"        color: \"#00B16A\",\n" +
"        highlight: \"#01a250\",\n" +
"        label: \"Views\"\n" +
"    }\n" +
"]";
    public String getWordList(){
        return TestString;
    }
    public void setWordList(String TestString){
        this.TestString = TestString;
    }
}
