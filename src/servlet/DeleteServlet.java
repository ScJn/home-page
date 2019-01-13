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

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        String uid = (String) session.getAttribute("id");
        System.out.println(uid+"***uid");
        try {
            Connection conn = MysqlConn.initConnection();
            String type = req.getParameter("type");
            switch (type) {
                case "job": {
                    System.out.println("*********in delete job*******");
                    String id = req.getParameter("id");
                    String sql = "delete from home.job   where  id=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(id));
                    ps.execute();
                    break;
                }
                case "reward": {
                    System.out.println("*********in delete reward*******");

                    String id = req.getParameter("id");
                    String sql = "delete from home.reward  where  id=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(id));
                    ps.execute();
                    break;
                }
                case "project": {
                    System.out.println("*********in delete project*******");

                    String id = req.getParameter("id");
                    String sql = "delete from home.project  where  id=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(id));
                    ps.execute();
                    break;
                }
            }

            resp.sendRedirect("/html/back.html");
            resp.setHeader("refresh", "1;url=/html/back.html");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
