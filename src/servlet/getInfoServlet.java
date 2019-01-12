package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dao.ProjectDao;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.Job;

public class getInfoServlet extends HttpServlet {

    private void all(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        String id = (String) session.getAttribute("id");
        JSONObject json=new JSONObject();

        UserDao userDao=new UserDao();

        JSONArray users=userDao.getUser(Integer.valueOf(id));
        ProjectDao projectDao = new ProjectDao();
        JSONArray jobs = projectDao.getJobs(Integer.valueOf(id));
        JSONArray rewards= projectDao.getRewards(Integer.valueOf(id));
        JSONArray projects= projectDao.getProjects(Integer.valueOf(id));
        projectDao.close();
        json.put("jobs",jobs);
        json.put("rewards",rewards);
        json.put("projects",projects);
        json.put("users",users);
//        json.put("skills",userDao.getUserSkill(Integer.valueOf(id)));
        PrintWriter out = resp.getWriter();
        try {
            out.println(json);

        } finally {
            out.close();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget in_______");
        try {
            all(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

    }
}


