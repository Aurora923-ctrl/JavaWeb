package edu.biwu.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/resp/download02")
public class RespDownload02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        System.out.println(fileName);

        String newFileName = URLEncoder.encode(fileName, "UTF-8");

        String mimeType = getServletContext().getMimeType("fileName");
        response.setHeader("Content-Type", mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=" + newFileName);

        InputStream is = getServletContext().getResourceAsStream("/download/" + fileName);
        BufferedInputStream bis = new BufferedInputStream(is);

        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

        int b;
        while( (b = bis.read()) != -1 ) {
            bos.write(b);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
