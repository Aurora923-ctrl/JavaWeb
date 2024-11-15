package edu.biwu.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/resp/demo05")
public class ResponseDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream os = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        String mimeType = getServletContext().getMimeType("1.jpg");
        System.out.println(mimeType);

        response.setContentType(mimeType);
        InputStream is = getServletContext().getResourceAsStream("/1.jpg");
        BufferedInputStream bis = new BufferedInputStream(is);
        int b;
        while ((b = bis.read())!=-1) {
            bos.write(b);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
