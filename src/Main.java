import pokemonAPI.PokemonApiClient;
import pokemonAPI.objects.PokemonCard;
import pokemonAPI.objects.SimplifiedPokemonCard;
import serverManagement.Server;


public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		String id = "xy1-1"; //Debug
		// get PokemonCard + sort attributes of object
 		try {
			String resp = PokemonApiClient.sendGetRequest("https://api.pokemontcg.io/v2/cards/" + id);
			PokemonCard pokemonCard = PokemonApiClient.mapString(resp);
            SimplifiedPokemonCard simplifiedPokemonCard = new SimplifiedPokemonCard();
            simplifiedPokemonCard.copyFrom(pokemonCard);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//server.runServer();
	}
}
