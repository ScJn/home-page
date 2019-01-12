package servlet;

import dao.MysqlConn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String type = req.getParameter("type");
        HttpSession session=req.getSession();
        String id= (String) session.getAttribute("id");
        try {
            Connection connection = MysqlConn.initConnection();

            if (type.equals("reward")) {
                System.out.println("********in add_reward*********");
                String name = req.getParameter("name");
                String degree = req.getParameter("degree");
                String clazz = req.getParameter("clazz");
                String time = req.getParameter("time");
                String sql="INSERT INTO `home`.`reward` " +
                        "(`name`, `clazz`, `degree`, `time`, `uid`) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,clazz);
                ps.setString(3,degree);
                ps.setString(4,time);
                ps.setString(5,id);
                ps.execute();


            }else if(type.equals("job")){
                System.out.println("********in add_job*********");

                String company = req.getParameter("company");
                String position = req.getParameter("position");
                String location = req.getParameter("location");
                String discribe = req.getParameter("discribe");
                String sql="INSERT INTO `home`.`job` " +
                        "(`company`, `position`, `location`, `discribe`, `uid`) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setString(1,company);
                ps.setString(2,position);
                ps.setString(3,location);
                ps.setString(4,discribe);
                ps.setString(5,id);
                ps.execute();
            }else if(type.equals("project")){

                System.out.println("********in add_project*********");

                String name = req.getParameter("name");
                String character = req.getParameter("character");
                String location = req.getParameter("location");
                String discribe = req.getParameter("discribe");
                String sql="INSERT INTO `home`.`project` " +
                        "(`name`, `character`, `location`, `discribe`, `uid`) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,character);
                ps.setString(3,location);
                ps.setString(4,discribe);
                ps.setString(5,id);
                ps.execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
}
