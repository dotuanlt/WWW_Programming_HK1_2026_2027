package com.iuh.fit.tuan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "multiFileUpload", value = "/uploadMulti")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class MultiFileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public MultiFileUploadServlet() {};
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String upLoadPath = getServletContext().getRealPath("") +UPLOAD_DIR;

        File upLoadDir = new File(upLoadPath);
        if(!upLoadDir.exists()) {
            upLoadDir.mkdirs();
        }

        for(Part part: req.getParts()){
            String filename = getFileName(part);
            if(filename != null && !filename.isEmpty()){
                part.write(upLoadPath + File.separator +filename);
            }
        }

        resp.setContentType("text/html; charset = UTF-8");
        resp.getWriter().println("<h3>Files uploaded successfully to : <br>" + upLoadPath + "</h3>");
    }

    private String getFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");

        for(String token: tokens){
            if(token.trim().startsWith("filename")){
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return null;
    }
}
