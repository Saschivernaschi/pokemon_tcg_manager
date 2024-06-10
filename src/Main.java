import pokemonAPI.PokemonApiClient;
import serverManagement.HttpHandler;
import serverManagement.Server;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.setupServer(8000);
		server.runServer();
	}
}
