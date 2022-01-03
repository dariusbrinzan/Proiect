package xmas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enums.Category;
import enums.Cities;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Input {
    private Integer numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private Double budgetUnit;
    private AnnualChange[] annualChanges;

    public Input(Integer numberOfYears, Double santaBudget, InitialData initialData) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public Double getBudgetUnit() {
        return budgetUnit;
    }

    public void setBudgetUnit(Double budgetUnit) {
        this.budgetUnit = budgetUnit;
    }

    public void createMapGiftCategoriesSortedByGiftsPrice() {
        getInitialData().initGiftCategoriesSortedByGiftsPrice(getInitialData().getSantaGiftsList());
    }

    @Override
    public String toString() {
        return "Input{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", initialData=" + initialData +
                '}';
    }

    private static <T> T[] concatDistinctWithStream(T[] array1, T[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).distinct()
                .toArray(size -> (T[]) Array.newInstance(array1.getClass().getComponentType(), size));
    }

    private static <T> T[] concatWithStream(T[] array1, T[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray(size -> (T[]) Array.newInstance(array1.getClass().getComponentType(), size));
    }

    private void calculateBudgetUnit() {
        Double sum = 0.0;
        for (Child child: getInitialData().getChildren()) {
            sum += child.getAverageScore();
        }
        setBudgetUnit(getSantaBudget() / sum);
    }

    private void assignBudgetToChildren() {
        for (Child child: getInitialData().getChildren()) {
            child.setAssignedBudget(getBudgetUnit() * child.getAverageScore());
        }
    }

    private void distributeGifts() {
        for (Child child: getInitialData().getChildren()) {
            double childAssignedBudget =  child.getAssignedBudget();
            for (Category giftCategory: child.getGiftsPreferences()) {
                Map<Category, PriorityQueue<Gift>> giftsMap = getInitialData().getGiftCategoriesSortedByGiftsPrice();
                Gift gift = giftsMap.get(giftCategory).peek();
                if (gift != null) {
                    if (childAssignedBudget >= gift.getPrice()) {
                        childAssignedBudget -= gift.getPrice();
                        child.addReceivedGift(gift);
                    }
                }
            }
        }
    }

    private void updateChildren(AnnualChange annualChange) {
        for (ChildUpdate childUpdate: annualChange.getChildrenUpdates()) {
            for (Child child: getInitialData().getChildren()) {
                if (childUpdate.getId().equals(child.getId())) {
                    if (childUpdate.getNiceScore() != null) {
                        child.addNiceScoreToHistory(childUpdate.getNiceScore());
                        child.setNiceScore(childUpdate.getNiceScore());
                    }
                    child.setGiftsPreferences(concatDistinctWithStream(childUpdate.getGiftsPreferences(), child.getGiftsPreferences()));
                }
            }
        }
    }

    private void applyTheAnnualChange(AnnualChange annualChange) {
        getInitialData().incrementChildrenAge();
        getInitialData().removeAdultsFromChildren();
        setSantaBudget(annualChange.getNewSantaBudget());
        getInitialData().setSantaGiftsList(
                concatWithStream(getInitialData().getSantaGiftsList(), annualChange.getNewGifts()));
        getInitialData().addGiftsToEachCategoryInMap(annualChange.getNewGifts());
        getInitialData().getChildren().addAll(Arrays.asList(annualChange.getNewChildren()));
        getInitialData().initChildrenNiceScoreHistory();
        getInitialData().removeAdultsFromChildren();
        updateChildren(annualChange);
    }

    private void initRound() {
        getInitialData().resetChildrenReceivedGifts();
        Collections.sort(getInitialData().getChildren());
        getInitialData().setAverageScoreForEachChild();
        calculateBudgetUnit();
        assignBudgetToChildren();
        distributeGifts();
    }

    public AnnualChildren startNenorocire() throws Exception {
        AnnualChildren annualChildren = new AnnualChildren(numberOfYears);
        getInitialData().removeAdultsFromChildren();
        getInitialData().initChildrenNiceScoreHistory();
        initRound();
        annualChildren.addChildren(0, (ArrayList<Child>) ObjectCloner.deepCopy(getInitialData().getChildren()));
        for (int i = 0; i < numberOfYears; ++i) {
            applyTheAnnualChange(annualChanges[i]);
            initRound();
            annualChildren.addChildren(i + 1, (ArrayList<Child>) ObjectCloner.deepCopy(getInitialData().getChildren()));
        }
        return annualChildren;
    }
}
