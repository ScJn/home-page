package servlet;

import dao.MysqlConn;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class SavePicServlet extends HttpServlet {


    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private static final String UPLOAD_DIRECTORY = "home-page-pic";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
//        String filePath=null;
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        String uploadPath="/img/";
//        System.out.println(uploadPath);
//        // 如果目录不存在则创建
//
//        // 设置最大文件上传值
//        upload.setFileSizeMax(MAX_FILE_SIZE);
//
//        // 设置最大请求值 (包含文件和表单数据)
//        upload.setSizeMax(MAX_REQUEST_SIZE);
//        try {
//            @SuppressWarnings("unchecked")
//            List<FileItem> formItems = upload.parseRequest(req);
//            System.out.println("formItems size"+formItems.size());
//            if (formItems != null && formItems.size() > 0) {
//                // 迭代表单数据
//                for (FileItem item : formItems) {
//                    // 处理不在表单中的字段
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        System.out.println("fileName:"+fileName);
//                         filePath = uploadPath + fileName;
//                        File storeFile = new File(filePath);
//                        // 在控制台输出文件的上传路径
//                        System.out.println(filePath);
//
//                        // 保存文件到硬盘
//                        item.write(storeFile);
//                        req.setAttribute("message",
//                                "文件上传成功!");
//                    }
//                }
//            }

        String root = getServletContext().getRealPath("/");


            Connection conn = null;
            try {
                conn = MysqlConn.initConnection();
                HttpSession session = req.getSession();
                System.out.println("*******in pic(**************");
                String id = (String) session.getAttribute("id");
                String name=req.getParameter("pic-path");
                String  filePath="/img/"+name;
                System.out.println("path:" + filePath);
                System.out.println("id"+id);
                String sql = "update home.user set pic=? where id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, filePath);
                ps.setInt(2, Integer.parseInt(id));
                ps.execute();


            } catch (Exception e) {
                e.printStackTrace();
            }

        resp.sendRedirect("/html/back.html");
    }
}


