package enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum Cities {

    @SerializedName("Bucuresti")
    @JsonProperty("Bucuresti")
    BUCURESTI("Bucuresti"),

    @SerializedName("Constanta")
    @JsonProperty("Constanta")
    CONSTANTA("Constanta"),

    @SerializedName("Buzau")
    @JsonProperty("Buzau")
    BUZAU("Buzau"),

    @SerializedName("Timisoara")
    @JsonProperty("Timisoara")
    TIMISOARA("Timisoara"),

    @SerializedName("Cluj-Napoca")
    @JsonProperty("Cluj-Napoca")
    CLUJ("Cluj-Napoca"),

    @SerializedName("Iasi")
    @JsonProperty("Iasi")
    IASI("Iasi"),

    @SerializedName("Craiova")
    @JsonProperty("Craiova")
    CRAIOVA("Craiova"),

    @SerializedName("Brasov")
    @JsonProperty("Brasov")
    BRASOV("Brasov"),

    @SerializedName("Braila")
    @JsonProperty("Braila")
    BRAILA("Braila"),

    @SerializedName("Oradea")
    @JsonProperty("Oradea")
    ORADEA("Oradea");

    private final String value;

    Cities(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Cities{"
                + "value='" + value + '\'' + '}';
    }
}
