package servlet;

import dao.MysqlConn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String school = req.getParameter("school");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("mail");
        System.out.println(name);
        String sql =
                "INSERT INTO `home`.`user` " +
                        "(`name`, `pwd`, `school`, `mail`, `phone`) " +
                        "VALUES ('" + name + "', '" + password + "', '" + school + "','" + mail + "' , '" + phone + "')";
        Connection conn = null;
        try {
            conn = MysqlConn.initConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            HttpSession session = req.getSession();
            session.setAttribute("msg", "注册成功");
            resp.sendRedirect("/html/login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
