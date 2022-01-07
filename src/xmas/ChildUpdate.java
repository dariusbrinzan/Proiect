package xmas;

import enums.Category;

import java.util.Arrays;

public class ChildUpdate {
    private Integer id;
    private Double niceScore;
    private Category[] giftsPreferences;

    public ChildUpdate(final Integer id,
                       final Double niceScore,
                       final Category[] giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public final Category[] getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(Category[] giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public final String toString() {
        return "ChildUpdate{"
                + "id=" + id
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + Arrays.toString(giftsPreferences) + '}';
    }
}
