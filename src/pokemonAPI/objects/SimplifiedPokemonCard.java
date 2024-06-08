package pokemonAPI.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//TODO: id, name, images (link), price,
public class SimplifiedPokemonCard {
    private String id;
    private String name;
    private String number;
    private Images images;
    private CardMarket cardMarket;
    private List<Integer> nationalPokedexNumbers;

    public void copyFrom(PokemonCard originalCard) {
        this.id = originalCard.getId();
        this.name = originalCard.getName();
        this.number = originalCard.getNumber();
        this.images = originalCard.getImages();
        this.cardMarket = originalCard.getCardMarket();
        this.nationalPokedexNumbers = originalCard.getNationalPokedexNumbers();
    }
}
