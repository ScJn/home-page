package servlet;

import com.zhenzi.sms.ZhenziSmsClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phone=req.getParameter("phone");
        String apiUrl = "https://sms_developer.zhenzikj.com";
        String appId = "100427";
        String appSecret = "f31d2327-b403-4d2b-9e15-658225739d7d";
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        String secret = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        String result = null;
        try {
            result = client.send(phone, "您的验证码为" + secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("number", secret);
        System.out.println("验证码："+secret);
        resp.getWriter().write("已发送");
        System.out.println("send a message");
        System.out.println(result);
    }
}
