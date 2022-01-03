package xmas;

import enums.Category;

import java.util.Arrays;

public class ChildUpdate {
    private Integer id;
    private Double niceScore;
    private Category[] giftsPreferences;

    public ChildUpdate(Integer id, Double niceScore, Category[] giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    //@NotNull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    //@NotNull
    public Category[] getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(Category[] giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    //@Override
    public String toString() {
        return "ChildUpdate{" +
                "id=" + id +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + Arrays.toString(giftsPreferences) +
                '}';
    }
}
