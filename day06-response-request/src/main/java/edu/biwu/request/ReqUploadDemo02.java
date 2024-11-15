package edu.biwu.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet("/req/upload02")

@MultipartConfig
public class ReqUploadDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Collection<Part> uploadFiles = request.getParts();
        for (Part uploadFile : uploadFiles) {
            String fileName = uploadFile.getSubmittedFileName();
            String extended = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + extended;
            File dir = new File("D:/uploadFile");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            uploadFile.write(dir+"/"+newFileName);
        }
        response.setContentType("text/html;charset=utf-8");
        String files = uploadFiles.stream().map(uploadFile -> uploadFile.getSubmittedFileName())
                .collect(Collectors.joining(","));
        response.getWriter().write(files+"上传成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
