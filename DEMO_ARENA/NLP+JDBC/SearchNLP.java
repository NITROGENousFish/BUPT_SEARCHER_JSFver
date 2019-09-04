/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
//
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
/**
 *
 * @author lvlaxjh
 */
public class SearchNLP {
    //标题三级权重
    private static int title_lvl1_w = 10;
    private static int title_lvl2_w = 6;
    private static int title_lvl3_w = 2;
    //正文三级权重
    private static int cont_lvl1_w = 5;
    private static int cont_lvl2_w = 3;
    private static int cont_lvl3_w = 1;
    //标题文字匹配下线
    private static int title_match_min = 2;
    //正文匹配权重下线
    private static int cont_match_min = 10;
    //点击次数权重
    private static int click_w = 4;

    private Map useNlp(String str){
        Result res = ToAnalysis.parse(str);//分词结果
        List<Term> terms = res.getTerms(); 
        String[] res_arr = new String[terms.size()];
        int flag = 0;
        String word = null;//词
        String natureStr = null;//词性
        String[] lvl1 = {"n","nr","ns","nt","nz","nl","ng","nw","t"};
        String[] lvl2 = {"s","f","a","b","z","r","u","v"};
        String[] lvl3 = {"n","nr","ns","nt","nz","nl","ng","nw","t","s","f","a","b","z","r","u","v"};
        List<String> lvl1List = new LinkedList<String>();
        List<String> lvl2List = new LinkedList<String>();
        List<String> lvl3List = new LinkedList<String>();
        Map<String,List> resMap = new HashMap<String,List>();
        //一层
        lvl1List.add(str);
        for(int i=0;i<terms.size();i++){
            word = terms.get(i).getName(); //拿到词
            natureStr = terms.get(i).getNatureStr(); //拿到词性
            for(int j =0;j<lvl1.length;j++){
                if(natureStr.equals(lvl1[j])){
                    lvl1List.add(word);
                }
            }
        }
        //二层
        for(int i=0;i<terms.size();i++){
            word = terms.get(i).getName(); //拿到词
            natureStr = terms.get(i).getNatureStr(); //拿到词性
            for(int j =0;j<lvl2.length;j++){
                if(natureStr.equals(lvl2[j])){
                    lvl2List.add(word);
                }
            }
        }
        //三层
        for(int i=0;i<terms.size();i++){
            word = terms.get(i).getName(); //拿到词
            natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(!lvl1List.contains(word) && !lvl2List.contains(word)){
                lvl3List.add(word);
            }
        }
        resMap.put("lvl1", lvl1List);
        System.err.println(resMap.get("lvl1").getClass().toString());
        resMap.put("lvl2", lvl2List);
        resMap.put("lvl3", lvl3List);
        return resMap;
    }
    private String reject_rubbish(String str){
        str = str.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");  //去除数字，英文，汉字  之外的内容
        String newStr = str.replaceAll("[\\s*|\t|\r|\n]", "");
        return newStr;
    }
    private int[] findUrl(Map contentSQL,Map contentNLP) {
        int[] result = new int[2];
        String title = (String) contentSQL.get("title");//提取标题
        String content = (String) contentSQL.get("content");//提取内容
        title = reject_rubbish(title);//清理
        content = reject_rubbish(content);//清理内容
        List<String> lvl1List = new LinkedList<String>();
        List<String> lvl2List = new LinkedList<String>();
        List<String> lvl3List = new LinkedList<String>();
        lvl1List = (LinkedList)contentNLP.get("lvl1");//取得分词lvl-1
        lvl2List = (LinkedList)contentNLP.get("lvl2");//取得分词lvl-2
        lvl2List = (LinkedList)contentNLP.get("lvl3");//取得分词lvl-3
        int weight = 0 ;//权重
        int commonMatches = 0;//普通匹配数
        //标题匹配
        for(String matchKey : lvl1List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight+index*title_lvl1_w;
        }
        for(String matchKey : lvl2List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight+index*title_lvl2_w;
        }
        for(String matchKey : lvl3List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight+index*title_lvl3_w;
        }
        //内容匹配
        for(String matchKey : lvl1List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight+index*cont_lvl1_w;
        }
        for(String matchKey : lvl2List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight+index*cont_lvl2_w;
        }
        for(String matchKey : lvl3List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight+index*cont_lvl3_w;
        }
        result[0] = commonMatches;
        result[1] = weight;
        // System.out.println(weight);
        // System.out.println(commonMatches);
        return result;
    }
    public Map getresult(String str,Map contentSQL){
        Map<String,String> result = new HashMap<String,String>();//结果map,不符合返回null
        str = reject_rubbish(str);//清理输入搜索文字
        Map<String,List> mapNLP = useNlp(str);//NLP字符串切割-返回map三层切割后字符
        int[] referenceValue= findUrl(contentSQL,mapNLP);//文字匹配,返回[0]普通匹配数量,[1]权重
        if(referenceValue[0]>title_match_min || referenceValue[1]>cont_match_min){
            referenceValue[1] = referenceValue[1] + Integer.valueOf((String)contentSQL.get("click_times")).intValue()*click_w;
            result.put("page_id",String.valueOf(referenceValue[1]));//已更改为:权重
            result.put("title",(String)contentSQL.get("title"));//title
            result.put("url",(String)contentSQL.get("url"));//url
            result.put("content",(String)contentSQL.get("content"));//content
        }
        else{
            result = null;
        }
        return result;
    }
}
