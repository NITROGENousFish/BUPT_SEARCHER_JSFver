/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
/**
 *
 * @author lvlaxjh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaapplication1.Testmysql;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "中国梦";
        // TODO code application logic here

        SearchNLP a = new SearchNLP();
        // Testmysql b = new Testmysql();
        String sqlUser = "root";
        String sqlPw = "jhczxcvbnm";
        Map<String,String> contentSQL= new HashMap<String,String>();
        // contentSQL.put("url", "http://www.wenming.cn/xj_pd/zgdlzgm/xjpcszgm/201405/t20140509_1929085.shtml");
        // contentSQL.put("title", "实现中华民族伟大复兴的中国梦");
        // contentSQL.put("content", "我们的民族是伟大的民族。在五千多年的文明发展历程中，中华民族为人类文明进步作出了不可磨灭的贡献。近代以后，我们的民族历经磨难，中华民族到了最危险的时候。自那时以来，为了实现中华民族伟大复兴，无数仁人志士奋起抗争，但一次又一次地失败了。中国共产党成立后，团结带领人民前仆后继、顽强奋斗，把贫穷落后的旧中国变成日益走向繁荣富强的新中国，中华民族伟大复兴展现出前所未有的光明前景。我们的责任，就是要团结带领全党全国各族人民，接过历史的接力棒，继续为实现中华民族伟大复兴而努力奋斗，使中华民族更加坚强有力地自立于世界民族之林，为人类作出新的更大的贡献。——在十八届中央政治局常委同中外记者见面时的讲话(2012年11月15日)每个人都有理想和追求，都有自己的梦想。现在，大家都在讨论中国梦，我以为，实现中华民族伟大复兴，就是中华民族近代以来最伟大的梦想。这个梦想，凝聚了几代中国人的夙愿，体现了中华民族和中国人民的整体利益，是每一个中华儿女的共同期盼。历史告诉我们，每个人的前途命运都与国家和民族的前途命运紧密相连。国家好，民族好，大家才会好。——在参观《复兴之路》展览时的讲话(2012年11月29日)我坚信，到中国共产党成立100年时全面建成小康社会的目标一定能实现，到新中国成立100年时建成富强民主文明和谐的社会主义现代化国家的目标一定能实现，中华民族伟大复兴的梦想一定能实现。——在参观《复兴之路》展览时的讲话(2012年11月29日)");
        // contentSQL.put("click_times", "2");
        // System.out.println(a.getresult(str,contentSQL).toString());//NLP+检索
        try {
            // Map<String,String> contentSQL= new HashMap<String,String>();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buptsearcher?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=CONVERT_TO_NULL",sqlUser,sqlPw);
            String sql = "select * from websites_info"; 
            //查询
            Statement stmt =con.createStatement();  // 创建用于执行静态sql语句的Statement对象 
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String url = rs.getString("url");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String click_times = rs.getString("click_times");

                contentSQL.put("url", url);
                contentSQL.put("title", title);
                contentSQL.put("content", content);
                contentSQL.put("click_times", click_times);

            }
            System.out.println(a.getresult(str,contentSQL).toString());//NLP+检索
        } catch (Exception e) {
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(e);
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }


        
    }
    
}
