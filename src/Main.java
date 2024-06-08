import pokemonAPI.PokemonApiClient;
import pokemonAPI.objects.pokemonCard;
import serverManagement.Server;


public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		String id = "xy1-1"; //Debug
		// get Pokemon JSON file
 		try {
			String resp = PokemonApiClient.sendGetRequest("https://api.pokemontcg.io/v2/cards/" + id);
			pokemonCard pokemonCard = PokemonApiClient.mapString(resp);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//server.runServer();
	}
}
