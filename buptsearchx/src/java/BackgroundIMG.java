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
import java.util.*;
// import javax.faces.bean.ManagedBean;
// import javax.faces.bean.ReferencedBean;
// @ManagedBean
// @ReferencedBean
public class BackgroundIMG implements Serializable{
    
    String []allImg;
    BackgroundIMG(){
        allImg = new String[10];
        allImg[0] = "https://pic.superbed.cn/item/5d6e1233451253d178bd81f4.jpg";
        allImg[1] = "https://pic.superbed.cn/item/5d6e1233451253d178bd81f2.jpg";
        allImg[2] = "https://pic.superbed.cn/item/5d6e1233451253d178bd81ef.jpg";
        allImg[3] = "https://pic.superbed.cn/item/5d6e1233451253d178bd81ed.png";
        allImg[4] = "https://pic.superbed.cn/item/5d6e1233451253d178bd81eb.jpg";
        allImg[5] = "https://pic.superbed.cn/item/5d6e1223451253d178bd7d04.jpg";
        allImg[6] = "https://pic.superbed.cn/item/5d6e1223451253d178bd7d02.jpg";
        allImg[7] = "https://pic.superbed.cn/item/5d6e1223451253d178bd7cfd.jpg";
        allImg[8] = "https://pic.superbed.cn/item/5d6e1223451253d178bd7cf7.jpg";
        allImg[9] = "https://pic.superbed.cn/item/5d6e1223451253d178bd7cf3.jpg";
    }
    public String getBKimg(int num){
        return allImg[num];
    }
    public String getRandomBKimg(){
        Random random = new Random();
        return allImg[random.nextInt(10)%(10-0+1) + 0];
    }
}
