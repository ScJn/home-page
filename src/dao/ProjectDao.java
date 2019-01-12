package dao;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.Job;
import vo.Project;
import vo.Reward;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectDao {

    private Connection conn=null;
    public ProjectDao() throws Exception {
        conn=MysqlConn.initConnection();
    }
    public JSONArray getProjects(Integer uid) throws  Exception{


        ArrayList<Project> projects=new ArrayList<>();
        String sql = "select * from project where uid = ?";
        JSONArray jsonArray=new JSONArray();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,uid);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            JSONObject jsonObject= new JSONObject();
            jsonObject.put("character",rs.getString("character2"));
            jsonObject.put("discribe",rs.getString("discribe"));
            jsonObject.put("id",rs.getString("id"));
            jsonObject.put("name",rs.getString("name"));
            jsonObject.put("location",rs.getString("location"));
            jsonObject.put("uid",rs.getString("uid"));
            jsonArray.add(jsonObject);
        }

        return jsonArray;

    }

    public JSONArray getRewards(Integer uid)throws Exception{
        ArrayList<Reward>rewards=new ArrayList<>();
        String sql="select * from reward where uid=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,uid);

        ResultSet rs=ps.executeQuery();
        JSONArray jsonArray=new JSONArray();
        while(rs.next()){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("clazz",rs.getString("clazz"));
            jsonObject.put("degree",rs.getString("degree"));
            jsonObject.put("id",rs.getString("id"));
            jsonObject.put("name",rs.getString("name"));
            jsonObject.put("time",rs.getString("time"));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray getJobs(Integer uid)throws Exception{
        ArrayList<Job>jobs=new ArrayList<>();
        String sql="select * from home.job where uid=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,uid);
        ResultSet rs=ps.executeQuery();
        JSONObject json=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        while(rs.next()){
            JSONObject jsonObject=new JSONObject();

            jsonObject.put("begin",rs.getString("begin"));
            jsonObject.put("company",rs.getString("company"));
            jsonObject.put("discribe",rs.getString("discribe"));
            jsonObject.put("location",rs.getString("location"));
            jsonObject.put("id",rs.getString("id"));
            jsonObject.put("uid",rs.getString("uid"));
            jsonObject.put("position",rs.getString("position"));
            jsonArray.add(jsonObject);

        }
        return jsonArray;
    }
    public void close() throws SQLException {
        conn.close();
    }
}
