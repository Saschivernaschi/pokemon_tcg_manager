package pokemonAPI.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class pokemonCard {
    private Data data;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String id;
        private String name;
        private String supertype;
        private List<String> subtypes;
        private String hp;
        private List<String> types;
        private List<String> evolvesTo;
        private List<String> rules;
        private List<Attack> attacks;
        private List<Weakness> weaknesses;
        private List<String> retreatCost;
        private int convertedRetreatCost;
        private Set set;
        private String number;
        private String artist;
        private String rarity;
        private List<Integer> nationalPokedexNumbers;
        private Legalities legalities;
        private Images images;
        private TcgPlayer tcgplayer;
        private Cardmarket cardmarket;

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Cardmarket {
            private String url;
            private String updatedAt;
            private Map<String, Price> prices;
            }
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Price {
            private double low;
            private double mid;
            private double high;
            private double market;
            private double directLow;

            // Standard-Konstruktor
            public Price() {
            }

            // Konstruktor für die Deserialisierung
            @JsonCreator
            public Price (@JsonProperty("value") double value) {
                this.low = low;
                this.mid = mid;
                this.high = high;
                this.market = market;
                this.directLow = directLow;
            }
        }
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Attack {
            private String name;
            private List<String> cost;
            private int convertedEnergyCost;
            private String damage;
            private String text;
        }

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Weakness {
            private String type;
            private String value;
        }

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Set {
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
        public static class Legalities {
            private String unlimited;
            private String expanded;
        }

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Images {
            private String small;
            private String large;
        }

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TcgPlayer {
            private String url;
            private String updatedAt;
            private Map<String, Price> prices;
        }
    }
}