package org.example.service;

import io.vertx.core.Vertx;
import org.example.verticles.MyFirstVerticle;

public class MainService {

    public static void main(String args[]) {
        Vertx vertx = Vertx.factory.vertx();
        MyFirstVerticle myFirstVerticle = new MyFirstVerticle();
        vertx.deployVerticle(myFirstVerticle);
    }
}
