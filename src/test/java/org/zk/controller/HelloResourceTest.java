package org.zk.controller;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.Test;
import org.zk.config.MyApplication;

import java.io.IOException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;

public class HelloResourceTest {

    public static final URI PATH = URI.create("http://localhost:8080");

    @Before
    public void before() throws Exception{
        MyApplication myApplication = new MyApplication();
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(PATH, myApplication);
        httpServer.start();
    }

    @Test
    public void sayHello() throws Exception{
        Response response = RestAssured.given().get("hello");
        response.then().body("username", hasItems("zk", "zx"));
    }
}