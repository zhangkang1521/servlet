package org.zk.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by zhangkang on 2017/3/7.
 */
public class HeroServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
//        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Writer writer = resp.getWriter();
        String heroList = "[{\n" +
                "  \"id\": 100,\n" +
                "  \"name\": \"zk\"\n" +
                "}, {\n" +
                "  \"id\": 101,\n" +
                "  \"name\": \"zy\"\n" +
                "}]";
        writer.write(heroList);

    }
}
