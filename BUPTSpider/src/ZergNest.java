import sun.security.provider.ConfigFile;

public class ZergNest extends Thread{
    private Thread t;
    Spider spider;

    ZergNest(){
        spider = new Spider();
    }

    public void run(){
        try{
            spider.totalWar();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        if(t == null){
            t = new Thread(this, "Zerg");
            t.start();
        }
    }

    public static void main(String[] args){
        String[] start_urls = {"https://www.bupt.edu.cn/"};
        Spider spider = new Spider();
        ZergNest[] zergNests = new ZergNest[10];
        for(String url: start_urls){
            spider.crawl(url);
        }
        for(int i = 0; i <= 9; i++){
            zergNests[i] = new ZergNest();
            zergNests[i].start();
        }
    }
}
