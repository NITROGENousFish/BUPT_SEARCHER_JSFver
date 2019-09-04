import java.sql.*

public class MySQLConnector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/buptspider?serverTimezone=UTC&autoReconnect=true&useSSL=false";

    static final String USER = "root";
    static final String PASS = "mysql";

    static final String table_name = "websites_info";
    Connection conn = null;
    Statement stmt = null;

    public MySQLConnector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

            DatabaseMetaData meta = conn.getMetaData();
            String type [] = {"TABLE"};
            ResultSet rs = meta.getTables(null, null, table_name, type);
            boolean flag = rs.next();
            if(!flag){
                String init_sql = "CREATE TABLE `" + this.table_name + "` (\n" +
                        "    `url` VARCHAR(255) NOT NULL,\n" +
                        "    `title` VARCHAR(255),\n" +
                        "    `content` TEXT,\n" +
                        "    `published_time` DATE,\n" +
                        "    `click_times` INT,\n" +
                        "    `crawled` TINYINT DEFAULT 0, \n" +
                        "    `being_crawled` TINYINT DEFAULT 0, \n"+
                        "    PRIMARY KEY (`url`)\n" +
                        ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
                this.stmt.executeUpdate(init_sql);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int addUrl(String url){
        try{
            String insert_sql = "INSERT INTO `%s` (`url`) VALUES (?);";
            insert_sql = String.format(insert_sql, this.table_name);
            PreparedStatement stmt = this.conn.prepareStatement(insert_sql);
            stmt.setString(1, url);
            stmt.executeUpdate();
            return 0;
        }catch (SQLException se){
            se.printStackTrace();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public String getUnCrawled(){
        try{
            String select_sql = "SELECT `url` FROM `%s` WHERE crawled = 0 AND being_crawled = 0 AND url != '' LIMIT 1";
            select_sql = String.format(select_sql, this.table_name);
            PreparedStatement stmt = this.conn.prepareStatement(select_sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String url = rs.getString("url");
            String update_sql = "UPDATE `%s` SET being_crawled = 1 WHERE `url` = ?;";
            update_sql = String.format(update_sql, this.table_name);
            PreparedStatement lock_stmt = this.conn.prepareStatement(update_sql);
            lock_stmt.setString(1, url);
            lock_stmt.executeUpdate();
            return url;
        }catch(SQLException se){
            se.printStackTrace();
            return null;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
