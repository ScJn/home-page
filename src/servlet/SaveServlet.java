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
import java.sql.Statement;

public class SaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("***********in SaveServlet*******");
        HttpSession session = req.getSession();
        Connection conn;
        try {
            conn = MysqlConn.initConnection();

            String type = req.getParameter("type");
            if (type.equals("job")) {
                System.out.println("*******save job*********");

                String company = req.getParameter("company");
                String position = req.getParameter("position");
                String location = req.getParameter("location");
                String discribe = req.getParameter("discribe");
                String id = req.getParameter("id");
                String sql = "update home.job set company=? , position=? , location=? , discribe=? where id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, company);
                ps.setString(2, position);
                ps.setString(3, location);
                ps.setString(4, discribe);
                ps.setInt(5, Integer.parseInt(id));
                ps.execute();
                ps.close();

            } else if (type.equals("project")) {
                System.out.println("*******save project*********");

                String name = req.getParameter("name");
                String id = req.getParameter("id");
                String character = req.getParameter("character");
                String location = req.getParameter("location");
                String discribe = req.getParameter("discribe");
                String sql = "update home.project set name=? ,character2=?,location=?,discribe=? where id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, character);
                ps.setString(3, location);
                ps.setString(4, discribe);
                ps.setInt(5, Integer.parseInt(id));
                ps.execute();
                ps.close();


            } else if (type.equals("reward")) {

                System.out.println("*******save reward*********");
                System.out.println(req.getParameter("time"));
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String clazz = req.getParameter("clazz");
                String degree = req.getParameter("clazz");
                String time = req.getParameter("time");
                String sql = "update home.reward set name=?, clazz=?, degree=?, time=? where id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, clazz);
                ps.setString(3, degree);
                ps.setString(4, time);
                ps.setInt(5, Integer.parseInt(id));
                ps.execute();
                ps.close();
            } else if (type.equals("info")) {
                System.out.println("***********in info**************");
                String id= (String) session.getAttribute("id");

                System.out.println("*id:"+id);
                String major=req.getParameter("major");
                String phone=req.getParameter("phone");
                String mail=req.getParameter("mail");
                String git=req.getParameter("git");
                String sql="update home.user set major=?,phone=?,mail=?,github=? where id=?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,major);
                ps.setString(2,phone);
                ps.setString(3,mail);
                ps.setString(4,git);

                ps.setString(5,id);
                ps.execute();

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
