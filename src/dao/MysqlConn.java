package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MysqlConn {

    public static Connection initConnection() throws Exception{
        Connection conn;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/home?useUnicode=true&amp;characterEncoding=utf-8&useSSL=false","root","123456");
        return conn;



    }

    public static void main(String[] args) throws Exception {
//        Connection conn=initConnection();
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        jsonObject.put("as","1");
        jsonObject.put("ff","2");
        jsonArray.add(jsonObject);

    }
}
