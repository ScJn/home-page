package servlet;

import dao.MysqlConn;
import dao.UserDao;
import form.CommonForm;
import net.sf.json.JSONArray;
import vo.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class LoginServlet extends HttpServlet {


    private void all(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset = utf-8");

        Connection conn = MysqlConn.initConnection();
        UserDao userDao=new UserDao();
        HttpSession session=request.getSession();
        String id=request.getParameter("id");
        String pwd=request.getParameter("password");
        System.out.println(id+"*****"+pwd);

        String sql="select * from user where id="+id+" and pwd='"+pwd+"'";
        Statement statement= conn.createStatement();

        System.out.println(sql);
        ResultSet rs=statement.executeQuery(sql);

        PrintWriter out=response.getWriter();
        if(rs.next()){
            System.out.println("********log in ***");
            session.setAttribute("id",id);
            response.sendRedirect("/html/index.html");
            out.print(0);
        }else {
            response.setStatus(400);
            System.out.println("************fail log");
            session.setAttribute("msg","登录失败");
            out.print(400);
            response.sendRedirect("/html/login.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            all(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            all(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
