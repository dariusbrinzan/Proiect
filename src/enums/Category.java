package enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum Category {

    @SerializedName("Board Games")
    @JsonProperty("Board Games")
    BOARD_GAMES("Board Games"),

    @SerializedName("Books")
    @JsonProperty("Books")
    BOOKS("Books"),

    @SerializedName("Clothes")
    @JsonProperty("Clothes")
    CLOTHES("Clothes"),

    @SerializedName("Sweets")
    @JsonProperty("Sweets")
    SWEETS("Sweets"),

    @SerializedName("Technology")
    @JsonProperty("Technology")
    TECHNOLOGY("Technology"),

    @SerializedName("Toys")
    @JsonProperty("Toys")
    TOYS("Toys");

    private final String value;

    Category(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Category{"
                + "value='" + value + '\'' + '}';
    }
}
