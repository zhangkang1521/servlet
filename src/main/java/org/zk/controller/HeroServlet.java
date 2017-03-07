package org.zk.controller;

import com.alibaba.fastjson.JSON;
import org.zk.common.Result;
import org.zk.entity.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by zhangkang on 2017/3/7.
 */
public class HeroServlet extends HttpServlet {

    List<Hero> heroList = new ArrayList<Hero>();

    @Override
    public void init() throws ServletException {
        for(int i = 0; i < 10; i++) {
            Hero hero = new Hero();
            hero.setId(100 + i);
            hero.setName("zk" + i);
            heroList.add(hero);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Writer writer = resp.getWriter();
        String heroListJson = JSON.toJSONString(heroList);
        writer.write(heroListJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取 content-type: application/x-www-form-urlencoded,可以使用req.getParameter(String)
//        String name = req.getParameter("name");
//        System.out.println(name);

        // 读取 content-type: application/json 用req.getParameter(String)读取不到
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = null;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        resp.setContentType("application/json; charset=utf-8");
        Writer writer = resp.getWriter();
        String heroListJson = JSON.toJSONString(Result.SUCCESS);
        writer.write(heroListJson);
    }

}
