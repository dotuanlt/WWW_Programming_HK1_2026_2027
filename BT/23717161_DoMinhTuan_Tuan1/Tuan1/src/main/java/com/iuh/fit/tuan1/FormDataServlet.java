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

@WebServlet(name = "formServlet", value = "/formServlet")
@MultipartConfig
public class FormDataServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("txtName");
        String password = req.getParameter("txtPassword");
        String gender = req.getParameter("rdGender");
        String[] hobbies = req.getParameterValues("ckHobby");
        String country = req.getParameter("cbmCountry");
        String birthDate = req.getParameter("birthDate");
        Part filePart = req.getPart("fileProfile");
        String fileName = filePart.getSubmittedFileName();

        String upLoadPath = System.getProperty("user.home") + File.separator +"uploads";

        File upLoadDir = new File(upLoadPath);
        if(!upLoadDir.exists()) {
            upLoadDir.mkdirs();
        }

        filePart.write(upLoadPath + File.separator + fileName);

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<h2>Form Data Received: </h2>");
        resp.getWriter().println("Name: " + name + "<br>");
        resp.getWriter().println("Password: " + password + "<br>");
        resp.getWriter().println("Gender: " + gender + "<br>");
        resp.getWriter().println("Hobbies: " + (hobbies != null ? String.join(", ", hobbies): "None") + "<br>");
        resp.getWriter().println("Country: " + country + "<br>");
        resp.getWriter().println("Birth Date: " + birthDate + "<br>");
        resp.getWriter().println("Uploaded File: " + (fileName != null ? fileName : "No file") + "<br>");
        resp.getWriter().println("Saved to: " + upLoadPath + "<br>");





    }

}
