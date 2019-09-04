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
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
/**
 *
 * @author lvlaxjh
 */
public class SearchNLP {
    
    public Map run(String str){
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
        resMap.put("lvl2", lvl2List);
        resMap.put("lvl3", lvl3List);
        return resMap;
    }
}
