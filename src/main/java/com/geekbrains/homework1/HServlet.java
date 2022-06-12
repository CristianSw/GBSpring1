package com.geekbrains.homework1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="ServletHomeworkOne", urlPatterns = "/homeworkOne")
public class HServlet extends HttpServlet {

    private static Logger ogger = LoggerFactory.getLogger(HServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ArrayList<Product> products = new ArrayList<>();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            products.add(new Product(i + 1, "Product" + (i + 1), i + 23 * 0.35f));
        }
        out.printf(products.toString());
        out.printf("</body></html>");
        out.close();
    }
}
