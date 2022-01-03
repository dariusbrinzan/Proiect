package xmas;

import com.google.gson.annotations.Expose;
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

    public final static Integer BabyMaxAge = 5;      // < 5y
    public final static Integer KidMaxAge = 12;      // 5 - 12y (???)
    public final static Integer TeenMaxAge = 19;     // 12 - 18y (12 again ???)
    // private final static Integer AdultMinAge = 19; // > 18y

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

    //@NotNull
    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    //@NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    //@NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    //@NotNull
    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    //@NotNull
    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    //@NotNull
    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    //@NotNull
    public Category[] getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final Category[] giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public boolean isAdult() {
        return getAge() > 18;
    }

//    @NotNull
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public void addNiceScoreToHistory(final Double niceScore) {
        if (niceScoreHistory == null) {
            niceScoreHistory = new ArrayList<>();
        }
        niceScoreHistory.add(niceScore);
    }

    //@NotNull
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    //@NotNull
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void addReceivedGift(final Gift gift) {
        if (receivedGifts == null) {
            receivedGifts = new ArrayList<>();
        }
        receivedGifts.add(gift);
    }

    public void resetReceivedGifts() {
        setReceivedGifts(new ArrayList<>());
    }

    //@NotNull
    public Double getTotalCostOfGifts() {
        Double sum = 0.0;
        for (Gift gift: getReceivedGifts()) {
            sum += gift.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + Arrays.toString(giftsPreferences) +
                ", averageScore=" + averageScore +
                ", niceScoreHistory=" + niceScoreHistory +
                ", assignedBudget=" + assignedBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }

    @Override
    public int compareTo(Child other) {
        if (id < other.getId()) {
            return -1;
        }
        return 1;
    }
}
