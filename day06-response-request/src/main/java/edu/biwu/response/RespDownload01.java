package edu.biwu.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/resp/download01")
public class RespDownload01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        System.out.println(fileName);

        String mimeType = getServletContext().getMimeType("fileName");
        response.setHeader("Content-Type", mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

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
