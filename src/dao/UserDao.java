package dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    /**
     * get user by id
     * @param id id
     * @return a user
     */
    public JSONArray getUser(Integer id) throws Exception {
        Connection conn=MysqlConn.initConnection();
        String sql="select * from user where id=?";
        PreparedStatement ps= conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name",rs.getString("name"));
        jsonObject.put("age",rs.getInt("age"));
        jsonObject.put("grade",rs.getString("grade"));
        jsonObject.put("major",rs.getString("major"));
        jsonObject.put("school",rs.getString("school"));
        jsonObject.put("skill",rs.getString("skill"));
        jsonObject.put("phone",rs.getString("phone"));
        jsonObject.put("mail",rs.getString("mail"));
        jsonObject.put("github",rs.getString("github"));
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    public String getUserSkill(Integer id) throws Exception {
        Connection conn=MysqlConn.initConnection();
        String sql="select skill from user where id=?";
        PreparedStatement ps= conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();

        conn.close();
        return rs.getString("skill");
    }

}
