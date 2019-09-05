import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import sun.security.provider.ConfigFile;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {
    String[] domains;
    MySQLConnector connector;
    Map<String, String> userCookies;

    Spider(){
        this.domains = new String[]{"bupt.edu.cn"};
        this.connector = new MySQLConnector();
        try{
            Map<String, String> loginPageCookies = Jsoup.connect("http://auth.bupt.edu.cn/authserver/login")
                    .method(Connection.Method.POST).execute().cookies();

            //部分页面需登陆才能查看，需要学号密码用以登陆
            String userName = "";//填写你的学号
            String password = "";//填写你的密码
            //请勿随意将账号密码git上去

            Connection.Response loginResponse = Jsoup.connect("http://auth.bupt.edu.cn/authserver/login")
                    .data("username", userName, "password", password, "_eventId", "submit", "rmShown", "1")
                    .cookies(loginPageCookies)
                    .method(Connection.Method.POST).execute();

            this.userCookies = loginResponse.cookies();

            //System.out.println(Jsoup.connect("https://www.pixiv.net")
            //        .cookies(userCookies).get().body());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void crawl(String url){
        try{
            Document document = Jsoup.connect(url).cookies(this.userCookies).get();
            Elements links = document.getElementsByTag("a");
            String linkHref;
            for(Element link: links){
                linkHref = link.absUrl("href");
                if(this.isAllowed(linkHref) == 1){
                    this.connector.addUrl(linkHref);
                }
            }
            String content = this.delHtmlTags(document.text());
            String titile = document.title();
            String time = this.getTime(document);

            this.connector.isCrawled(url, titile, content, time);
        }catch (IOException e){
            //e.printStackTrace();
        }
    }

    public void totalWar(){
        String url;
        while(true){
            url = this.connector.getUnCrawled();
            System.out.println(url);
            this.crawl(url);
        }
    }

    public String getTime(Document document){
        String time = null;
        Elements elements = document.select("strong.timeSummary");
        String rex="^(((20\\d{2})-(\\d{2})-(\\d{2}))) ((\\d{2}):(\\d{2}):(\\d{2}))$";
        Pattern pattern=Pattern.compile(rex);
        for(Element element: elements){
            String content = element.text();
            Matcher matcher=pattern.matcher(content);
            if(matcher.matches()){
                time=content;
                System.out.println("新闻发布时间为："+content);
            }
        }
        return time;
    }

    public int isAllowed(String url){
        if(!this.isValidUrl(url)){
            return 0;
        }
        int allowed = 0;
        for(String domain: this.domains){
            int index = url.indexOf(domain);
            if(index != -1){
                allowed = 1;
                break;
            }
        }
        return allowed;
    }

    public boolean isValidUrl(String url){
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]" ;
        Pattern patt = Pattern. compile(regex);
        Matcher matcher = patt.matcher(url);
        boolean  isMatch = matcher.matches();
        return isMatch;
    }

    public String delHtmlTags(String html_str){
        String scriptRegex="<script[^>]*?>[\\s\\S]*?<\\/script>";
        String styleRegex="<style[^>]*?>[\\s\\S]*?<\\/style>";
        String htmlRegex="<[^>]+>";
        String spaceRegex = "\\s*|\t|\r|\n";

        html_str = html_str.replaceAll(scriptRegex, "");
        html_str = html_str.replaceAll(styleRegex, "");
        html_str = html_str.replaceAll(htmlRegex, "");
        html_str = html_str.replaceAll(spaceRegex, "");

        return html_str.trim();
    }

    public static void main(String[] args){
        Spider spider = new Spider();
        int a = spider.isAllowed("https://www.bupt.edu.cn/");
        System.out.println(a);
    }
}
