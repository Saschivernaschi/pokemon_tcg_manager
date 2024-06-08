package pokemonAPI.objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonCard {
    private String id;
    private String name;
    private String supertype;
    private List<String> subtypes;
    private String hp;
    private List<String> types;
    private String evolvesFrom;
    private List<Ability> abilities;
    private List<Attack> attacks;
    private List<Weakness> weaknesses;
    private List<String> retreatCost;
    private int convertedRetreatCost;
    private Set set;
    private String number;
    private String artist;
    private String rarity;
    private String flavorText;
    private List<Integer> nationalPokedexNumbers;
    private Legalities legalities;
    private Images images;
    private TcgPlayer tcgPlayer;
    private CardMarket cardMarket;
}


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Ability {
    private String name;
    private String text;
    private String type;
}
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Attack {
    private List<String> cost;
    private String name;
    private String text;
    private String damage;
    private int convertedEnergyCost;
}
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Weakness {
    private String type;
    private String value;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Set {
    private String id;
    private String name;
    private String series;
    private int printedTotal;
    private int total;
    private Legalities legalities;
    private String ptcgoCode;
    private String releaseDate;
    private String updatedAt;
    private Images images;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Images {
    private String small;
    private String large;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class TcgPlayer {
    private String url;
    private String updatedAt;
    private Prices prices;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class CardMarket {
    private String url;
    private String updatedAt;
    private Prices prices;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Prices {
    private Price normal;
    private Price reverseHolofoil;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Price {
    private double low;
    private double mid;
    private double high;
    private double market;
    private double directLow;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Legalities {
    private String unlimited;
    private String standard;
    private String expanded;
}
