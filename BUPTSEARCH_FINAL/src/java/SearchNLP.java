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
    // 标题匹配命中三级权重
    private static int title_lvl1_w = 10;
    private static int title_lvl2_w = 6;
    private static int title_lvl3_w = 2;
    // 正文匹配命中三级权重
    private static int cont_lvl1_w = 5;
    private static int cont_lvl2_w = 3;
    private static int cont_lvl3_w = 1;
    // 标题文字匹配命中个数下线
    private static int title_match_min = 0;
    // 正文匹配命中权重下线
    private static int cont_match_min = 10;
    // 点击次数权重值
    private static int click_w = 4;
    //短文本长度(正文搜索后返回的长度)
    private static int shortContentLong = 100;
    //----------------------------------------------------------------
    private Map useNlp(String str) {//----------------------------分词
        Result res = ToAnalysis.parse(str);// 分词结果
        List<Term> terms = res.getTerms();// 分词结果
        String word = null;// 分词
        String natureStr = null;// 分词词性
        String[] lvl1 = { "n", "nr", "ns", "nt", "nz", "nl", "ng", "nw", "t" };
        String[] lvl2 = { "s", "f", "a", "b", "z", "r", "u", "v" };
        String[] lvl3 = { "n", "nr", "ns", "nt", "nz", "nl", "ng", "nw", "t", "s", "f", "a", "b", "z", "r", "u", "v" };
        List<String> lvl1List = new LinkedList<String>();//lvl1分词后的词
        List<String> lvl2List = new LinkedList<String>();//lvl2分词后的词
        List<String> lvl3List = new LinkedList<String>();//lvl3分词后的词
        Map<String, List> resMap = new HashMap<String, List>();//函数返回值,Map
        // 一层
        lvl1List.add(str);
        for (int i = 0; i < terms.size(); i++) {
            word = terms.get(i).getName(); // 拿到词
            natureStr = terms.get(i).getNatureStr(); // 拿到词性
            for (int j = 0; j < lvl1.length; j++) {
                if (natureStr.equals(lvl1[j])) {
                    lvl1List.add(word);
                }
            }
        }
        // 二层
        for (int i = 0; i < terms.size(); i++) {
            word = terms.get(i).getName(); // 拿到词
            natureStr = terms.get(i).getNatureStr(); // 拿到词性
            for (int j = 0; j < lvl2.length; j++) {
                if (natureStr.equals(lvl2[j])) {
                    lvl2List.add(word);
                }
            }
        }
        // 三层
        for (int i = 0; i < terms.size(); i++) {
            word = terms.get(i).getName(); // 拿到词
            natureStr = terms.get(i).getNatureStr(); // 拿到词性
            if (!lvl1List.contains(word) && !lvl2List.contains(word)) {
                lvl3List.add(word);
            }
        }
        resMap.put("lvl1", lvl1List);
        resMap.put("lvl2", lvl2List);
        resMap.put("lvl3", lvl3List);
        return resMap;
    }

    private String reject_rubbish(String str) {//字符串清洗,去除多余字符
        str = str.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", ""); // 去除数字，英文，汉字 之外的内容
        String newStr = str.replaceAll("[\\s*|\t|\r|\n]", "");
        return newStr;
    }

    private int[] findUrl(Map contentSQL, Map contentNLP) {//正文和标题的分词匹配,返回值
        int[] result = new int[2];//函数返回值
        String title = (String) contentSQL.get("title");// 提取标题
        String content = (String) contentSQL.get("content");// 提取内容
        title = reject_rubbish(title);// 清理标题
        content = reject_rubbish(content);// 清理内容
        List<String> lvl1List = new LinkedList<String>();
        List<String> lvl2List = new LinkedList<String>();
        List<String> lvl3List = new LinkedList<String>();
        lvl1List = (LinkedList) contentNLP.get("lvl1");// 取得分词-lvl-1
        lvl2List = (LinkedList) contentNLP.get("lvl2");// 取得分词-lvl-2
        lvl2List = (LinkedList) contentNLP.get("lvl3");// 取得分词-lvl-3
        int weight = 0;// 权重
        int commonMatches = 0;// 普通匹配数
        // 标题匹配
        for (String matchKey : lvl1List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight + index * title_lvl1_w;
        }
        for (String matchKey : lvl2List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight + index * title_lvl2_w;
        }
        for (String matchKey : lvl3List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(title);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight + index * title_lvl3_w;
        }
        // 内容匹配
        for (String matchKey : lvl1List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight + index * cont_lvl1_w;
        }
        for (String matchKey : lvl2List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight + index * cont_lvl2_w;
        }
        for (String matchKey : lvl3List) {
            int index = 0;
            Pattern pattern = Pattern.compile(matchKey);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                index++;
            }
            commonMatches = commonMatches + index;
            weight = weight + index * cont_lvl3_w;
        }
        result[0] = commonMatches;
        result[1] = weight;
        return result;//返回值[0]普通匹配次数,[1]权重值
    }

    public Map getresult(String str, Map contentSQL) {//返回一个成功的匹配
        Map<String, String> result = new HashMap<String, String>();// 返回值map,不符合返回null
        str = reject_rubbish(str);// 清理输入搜索文字
        Map<String, List> mapNLP = useNlp(str);// NLP字符串切割-返回map三层切割后字符
        int[] referenceValue = findUrl(contentSQL, mapNLP);// 文字匹配,返回[0]普通匹配数量,[1]权重
        if (referenceValue[0] > title_match_min || referenceValue[1] > cont_match_min) {
            referenceValue[1] = referenceValue[1] + Integer.valueOf((String) contentSQL.get("click_times")).intValue() * click_w;//权重+点击次数权重
            String shortContent = contentSQL.get("content").toString().substring(0,shortContentLong);//切割为限制长度短文本
            StringBuilder title111 = new StringBuilder(contentSQL.get("title").toString());//染色-标题
            StringBuilder content111 = new StringBuilder(shortContent);//染色-内容
            String emStart = "<em>";//html染色标签-前
            String emEnd = "</em>";//html染色标签-后
            Pattern pattern = Pattern.compile(str);//正则匹配
            Matcher matcher = pattern.matcher(title111);//正则匹配
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                title111.insert(start, emStart);
                title111.insert(end+str.length()+1,emEnd);
            }
            pattern = Pattern.compile(str);//正则匹配
            matcher = pattern.matcher(content111);//正则匹配
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                title111.insert(start, emStart);
                title111.insert(end+str.length()+1,emEnd);
            }
            String returnTitle = title111.toString();//加过染色标签的-标题
            String returnContent = content111.toString();//加过染色标签的-内容
            //写入返回值map
            result.put("page_id", String.valueOf(referenceValue[1]));// 已更改为:权重
            result.put("title", (String) contentSQL.get("title"));// title
            result.put("url", (String) contentSQL.get("url"));// url
            result.put("content", (String) shortContent);// content
            result.put("colorTitle", (String) returnTitle);// 标红标题
            result.put("colorContent", (String) returnContent);// 标红内容
        } else {
            result = null;
        }
        return result;
    }

}
