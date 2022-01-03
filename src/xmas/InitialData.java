package xmas;

import enums.Category;

import java.util.*;

public class InitialData {
    private List<Child> children;
    private Gift[] santaGiftsList;
    private Map<Category, PriorityQueue<Gift>> giftCategoriesSortedByGiftsPrice;

    public InitialData(final Child[] children,
                       final Gift[] santaGiftsList) {
        initChildren(children);
        this.santaGiftsList = santaGiftsList;
        initGiftCategoriesSortedByGiftsPrice(santaGiftsList);
    }

    public InitialData(final List<Child> children,
                       final Gift[] santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
        initGiftCategoriesSortedByGiftsPrice(santaGiftsList);
    }

    private void initChildren(final Child[] children) {
        this.children = new LinkedList<Child>();
        Collections.addAll(this.children, children);
    }

    private void addGiftCategoriesToMap() {
        for (Category category: Category.values()) {
            giftCategoriesSortedByGiftsPrice.put(category, new PriorityQueue<>());
        }
    }

    public void addGiftsToEachCategoryInMap(final Gift [] santaGiftsList) {
        for (Gift gift: santaGiftsList) {
            giftCategoriesSortedByGiftsPrice.get(gift.getCategory()).add(gift);
        }
    }

    public void initGiftCategoriesSortedByGiftsPrice(final Gift [] santaGiftsList) {
        giftCategoriesSortedByGiftsPrice = new HashMap<>();
        addGiftCategoriesToMap();
        addGiftsToEachCategoryInMap(santaGiftsList);
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Gift[] getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(Gift[] santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public Map<Category, PriorityQueue<Gift>> getGiftCategoriesSortedByGiftsPrice() {
        return giftCategoriesSortedByGiftsPrice;
    }

    public void setGiftCategoriesSortedByGiftsPrice(Map<Category, PriorityQueue<Gift>> giftCategoriesSortedByGiftsPrice) {
        this.giftCategoriesSortedByGiftsPrice = giftCategoriesSortedByGiftsPrice;
    }

    public void removeChild(Child child) {
        children.remove(child);
    }

    public void removeAdultsFromChildren() {
        children.removeIf(Child::isAdult);
    }

    public Double averageScoreOfChild(Child child) {
        double sum = 0.0;
        for (double score: child.getNiceScoreHistory()) {
            sum += score;
        }
        return sum / child.getNiceScoreHistory().size();
    }

    public Double weightedAverageScoreOfChild(Child child) {
        double sum = 0.0;
        int i = 1;
        for (double score: child.getNiceScoreHistory()) {
            sum += i * score;
            ++i;
        }
        int sum_of_weights = child.getNiceScoreHistory().size() * (child.getNiceScoreHistory().size() + 1) / 2;
        return sum / sum_of_weights;
    }

    public void setAverageScoreForEachChild() {
        for (Child child: getChildren()) {
            if (child.getAge() < Child.BabyMaxAge) {
                child.setAverageScore(10.0);
            } else if (child.getAge() < Child.KidMaxAge) {
                Double averageScore = averageScoreOfChild(child);
                child.setAverageScore(averageScore);
            } else if (child.getAge() < Child.TeenMaxAge) {
                Double weightedAverageScore = weightedAverageScoreOfChild(child);
                child.setAverageScore(weightedAverageScore);
            }
        }
    }

    public void initChildrenNiceScoreHistory() {
        for (Child child: children) {
            if (child.getNiceScoreHistory() == null) {
                child.addNiceScoreToHistory(child.getNiceScore());
            }
        }
    }

    public void resetChildrenReceivedGifts() {
        for (Child child: getChildren()) {
            child.resetReceivedGifts();
        }
    }

    public void incrementChildrenAge() {
        for (Child child: getChildren()) {
            child.setAge(child.getAge() + 1);
        }
    }

    @Override
    public String toString() {
        return "InitialData{" +
                "children=" + children +
                ", santaGiftsList=" + Arrays.toString(santaGiftsList) +
                '}';
    }
}
