package pokemonAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import pokemonAPI.objects.pokemonCard;

public class PokemonApiClient {
	public static String sendGetRequest(String urlString) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // Erfolg
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		} else {
			return "GET request not worked";
		}
	}
	public static pokemonCard mapString(String jsonResponse){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
            return objectMapper.readValue(jsonResponse, pokemonCard.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
