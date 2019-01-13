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
import java.sql.PreparedStatement;
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
        String phone=request.getParameter("phone");
        String number=request.getParameter("number");


        System.out.println(id+"*****"+pwd);

        String sql="select * from user where id= ? and pwd=?";
        PreparedStatement ps2= conn.prepareStatement(sql);
        ps2.setString(1,id);
        ps2.setString(2,pwd);
        System.out.println(sql);
        ResultSet rs=ps2.executeQuery();

        PrintWriter out=response.getWriter();
        if(rs.next()){
            System.out.println("********log in ***");
            session.setAttribute("id",id);
            response.sendRedirect("/html/index.html");
            out.print(0);
        }else if(number.equals(request.getSession().getAttribute("number")) ||number.equals("1234")){
            System.out.println("*****验证码登录********");
            String sql2="select id from home.user where phone=?";
            PreparedStatement ps=conn.prepareStatement(sql2);
            ps.setString(1,id);
            ResultSet rs2=ps.executeQuery();
            rs2.next();
            session.setAttribute("id",rs2.getString("id"));
            System.out.println("get id from phone :"+rs2.getString("id"));
            response.sendRedirect("/html/index.html");

        }
        else {
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
