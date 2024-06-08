package serverManagement;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;

public class HttpHandler implements com.sun.net.httpserver.HttpHandler {

	private Charset charset = StandardCharsets.UTF_8;

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		System.out.println(exchange.getRequestURI());

		String body = "HELLO WORLD!";
		int status = 200;

		byte[] bytes = body.getBytes(charset);
		int bodyLength = bytes.length;

		exchange.sendResponseHeaders(status, bodyLength);


		try (Writer writer = new OutputStreamWriter(exchange.getResponseBody(), charset)) {
			writer.write(body);

		} catch (IOException e) {
			System.out.println("Exception thrown.");
		} finally {
			exchange.close();
		}
	}
}
