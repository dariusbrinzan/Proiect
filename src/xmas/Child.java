package xmas;

import enums.Category;
import enums.Cities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Child implements Comparable<Child>, Serializable {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private Category[] giftsPreferences;
    private Double averageScore;
    private Double niceScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public static final Integer babyMaxAge = 5;
    public static final Integer kidMaxAge = 12;
    public static final Integer teenMaxAge = 19;

    public Child(final Integer id,
                 final String lastName,
                 final String firstName,
                 final Integer age,
                 final Cities city,
                 final Double niceScore,
                 final Category[] giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.niceScoreHistory = new ArrayList<>();
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final Integer getAge() {
        return age;
    }

    public final void setAge(final Integer age) {
        this.age = age;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(final Cities city) {
        this.city = city;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public final Category[] getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final Category[] giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final boolean isAdult() {
        return getAge() > 18;
    }

    public final List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * Add nice score to history list
     * @param niceScore
     */
    public final void addNiceScoreToHistory(final Double niceScore) {
        if (niceScoreHistory == null) {
            niceScoreHistory = new ArrayList<>();
        }
        niceScoreHistory.add(niceScore);
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public final List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * Add gift to the list
     * @param gift
     */
    public final void addReceivedGift(final Gift gift) {
        if (receivedGifts == null) {
            receivedGifts = new ArrayList<>();
        }
        receivedGifts.add(gift);
    }

    /**
     *
     */
    public final void resetReceivedGifts() {
        setReceivedGifts(new ArrayList<>());
    }

    /**
     * Return total cost of child gifts
     * @return
     */
    public final Double getTotalCostOfGifts() {
        Double sum = 0.0;
        for (Gift gift: getReceivedGifts()) {
            sum += gift.getPrice();
        }
        return sum;
    }

    @Override
    public final String toString() {
        return "Child{" + "id=" + id + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\'' + ", age=" + age
                + ", city=" + city + ", niceScore=" + niceScore
                + ", giftsPreferences=" + Arrays.toString(giftsPreferences)
                + ", averageScore=" + averageScore + ", niceScoreHistory="
                + niceScoreHistory + ", assignedBudget=" + assignedBudget
                + ", receivedGifts=" + receivedGifts + '}';
    }

    @Override
    public final int compareTo(final Child other) {
        if (id < other.getId()) {
            return -1;
        }
        return 1;
    }
}
