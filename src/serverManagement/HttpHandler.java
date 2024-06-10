package serverManagement;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import pokemonAPI.PokemonApiClient;
import pokemonAPI.objects.PokemonCard;
import pokemonAPI.objects.SimplifiedPokemonCard;

//TODO: Access API with queries to get cards by name
public class HttpHandler implements com.sun.net.httpserver.HttpHandler {
	private Charset charset = StandardCharsets.UTF_8;
	private static final String POKEMON_TCP_URL = "https://api.pokemontcg.io/v2/cards/";
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		int status = 200;
		String exchangeUri = (String.valueOf(exchange.getRequestURI()));
        String body = null;

		//get pokemonCards
		if ("/cards".startsWith(exchangeUri)){
			try {
				body = getPokemonCard(exchange);
			} catch (Exception e) {
				status = 404;
				body = "";
			}
		} else {
			DatabaseManagement.handleUserRequest(exchangeUri);
		}

		// prepare and send response
		byte[] bytes = Objects.requireNonNull(body).getBytes(charset);
		int bodyLength = bytes.length;
		exchange.sendResponseHeaders(status, bodyLength);

		//print data
		try (Writer writer = new OutputStreamWriter(exchange.getResponseBody(), charset)) {
			writer.write(body);
		} catch (IOException e) {
			System.out.println("Exception thrown.");
		} finally {
			exchange.close();
		}
	}
	private static String getPokemonCard(HttpExchange exchange) throws Exception {
			String body = PokemonApiClient.sendGetRequest(POKEMON_TCP_URL + String.valueOf(exchange.getRequestURI()));
			PokemonCard pokemonCard = PokemonApiClient.mapString(body);
			//simplify pokemonCard
			SimplifiedPokemonCard simplifiedPokemonCard = new SimplifiedPokemonCard();
			simplifiedPokemonCard.copyFrom(pokemonCard);
			return new ObjectMapper().writeValueAsString(simplifiedPokemonCard);
	}
}
