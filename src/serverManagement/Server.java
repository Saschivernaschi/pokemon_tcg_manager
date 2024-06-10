package serverManagement;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Server {
    private static final String INFO_MESSAGE = "SERVER IS RUNNING!";
    private HttpServer httpServer;

    public Server() throws IOException {}

    public void runServer() {
        httpServer.start();
        System.out.println(INFO_MESSAGE);
    }

    public void setupServer(int port) throws IOException {
        this.httpServer = HttpServer.create(new InetSocketAddress(port),0);
        httpServer.createContext("/", new HttpHandler());
    }

    /**
     * Used to stop the serverInformation.Server.
     */
	public void stop() {
        httpServer.stop(0);
	}
}
