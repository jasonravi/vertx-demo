package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import org.example.service.Processor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Processor processor = new Processor();
        MainVerticle mainVerticle = new MainVerticle();
        //mainVerticle.start(Promise.promise());
        Vertx vertx = Vertx.factory.vertx();
        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);
        router.route("/get/users")
                .handler(routerContext -> {
                    System.out.println("Hi dere");
                    try {
                        routerContext.response()
                        .putHeader("content-type", "text/plan")
                        .end(mapper.writeValueAsString(processor.getUser()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        /*vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8888, http -> {
            if (http.succeeded()) {
                startPromise.complete();
                System.out.println("HTTP server started on port 8888");
            } else {
                startPromise.fail(http.cause());
            }
        });*/

        /*Route handler1 = router.get("/dream/pay")
                .handler(routerContext -> {
                    System.out.println("Hi route1");
                    HttpServerResponse httpServerResponse = routerContext.response();
                    httpServerResponse.setChunked(true);
                    httpServerResponse.write("calling rout1... ");
                    routerContext.vertx()
                            .setTimer(5000, tid-> routerContext.next());
                });
        Route handler2= router.route("/dream/pay")
                .handler(routerContext -> {
                    System.out.println("Hi route2");
                    HttpServerResponse httpServerResponse = routerContext.response();
                    httpServerResponse.setChunked(true);
                    httpServerResponse.write("calling route2... ");
                    routerContext.vertx()
                            .setTimer(5000, tid-> routerContext.next());
                });*/

        /*Route handler3 = router.get("/dream/pay/:name")
                .handler(routerContext -> {

                    System.out.println("Hi route3 " + routerContext.request().getParam("name"));
                    HttpServerResponse httpServerResponse = routerContext.response();
                    httpServerResponse.putHeader("content-type", "text/plan");
                    httpServerResponse.end("Hi, Dream Pay " + routerContext.request().getParam("name"));
                });*/

        /*vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8888, http -> {
            if (http.succeeded()) {
                startPromise.complete();
                System.out.println("HTTP server started on port 8888");
            } else {
                startPromise.fail(http.cause());
            }
        });*/

        System.out.println( "Hello World! " );

        httpServer.requestHandler(router::accept).listen(8091, http-> {
            if(http.succeeded()) {
                System.out.println(".....service has been started......." + http);
            } else {
                System.out.println("Service has been stoped . plz try again" + http.cause().toString());
            }
        });
    }
}
