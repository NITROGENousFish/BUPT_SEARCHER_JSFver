
public class Spider {
    String[] domains;
    MySQLConnector connector;

    Spider(){
        //this.domains = {"bupt.edu.cn"};
        this.connector = new MySQLConnector();
    }
}
