package xmas;

import enums.Category;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Arrays;


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

    /**
     * init children linked list
     * @param children
     */
    public void initChildren(final Child[] children) {
        this.children = new LinkedList<Child>();
        Collections.addAll(this.children, children);
    }

    /**
     * add gifts to map
     */
    public void addGiftCategoriesToMap() {
        for (Category category: Category.values()) {
            giftCategoriesSortedByGiftsPrice.put(category, new PriorityQueue<>());
        }
    }

    /**
     * add gifts to each category
     * @param santaGiftsList
     */
    public final void addGiftsToEachCategoryInMap(final Gift[] santaGiftsList) {
        for (Gift gift: santaGiftsList) {
            giftCategoriesSortedByGiftsPrice.get(gift.getCategory()).add(gift);
        }
    }

    /**
     * init gift sorted by gifts price
     * @param santaGiftsList
     */
    public final void initGiftCategoriesSortedByGiftsPrice(final Gift[] santaGiftsList) {
        giftCategoriesSortedByGiftsPrice = new HashMap<>();
        addGiftCategoriesToMap();
        addGiftsToEachCategoryInMap(santaGiftsList);
    }

    public final List<Child> getChildren() {
        return children;
    }

    public final void setChildren(final List<Child> children) {
        this.children = children;
    }

    public final Gift[] getSantaGiftsList() {
        return santaGiftsList;
    }

    public final void setSantaGiftsList(final Gift[] santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public final Map<Category, PriorityQueue<Gift>> getGiftCategoriesSortedByGiftsPrice() {
        return giftCategoriesSortedByGiftsPrice;
    }

    public final void setGiftCategoriesSortedByGiftsPrice(final Map<Category,
            PriorityQueue<Gift>> giftCategoriesSortedByGiftsPrice) {
        this.giftCategoriesSortedByGiftsPrice = giftCategoriesSortedByGiftsPrice;
    }

    /**
     * remove child
     * @param child
     */
    public final void removeChild(final Child child) {
        children.remove(child);
    }

    /**
     * remove one child from list when he's over 18
     */
    public final void removeAdultsChildrenFromChildrenList() {
        children.removeIf(Child::isAdult);
    }

    /**
     * @param child
     * @return average score for specific child
     */
    public final Double averageScoreOfChild(final Child child) {
        double sum = 0.0;
        for (double score: child.getNiceScoreHistory()) {
            sum += score;
        }
        return sum / child.getNiceScoreHistory().size();
    }

    /**
     * @param child
     * @return weighted average score for specific child
     */
    public final Double weightedAverageScoreOfChild(final Child child) {
        double sum = 0.0;
        int i = 1;
        for (double score: child.getNiceScoreHistory()) {
            sum += i * score;
            ++i;
        }
        int sumOfWeights =
                child.getNiceScoreHistory().size() * (child.getNiceScoreHistory().size() + 1) / 2;
        return sum / sumOfWeights;
    }

    /**
     * Average score for each type of child
     */
    public final void setAverageScoreForEachChild() {
        for (Child child: getChildren()) {
            if (child.getAge() < Child.babyMaxAge) {
                child.setAverageScore(10.0);
            } else if (child.getAge() < Child.kidMaxAge) {
                Double averageScore = averageScoreOfChild(child);
                child.setAverageScore(averageScore);
            } else if (child.getAge() < Child.teenMaxAge) {
                Double weightedAverageScore = weightedAverageScoreOfChild(child);
                child.setAverageScore(weightedAverageScore);
            }
        }
    }

    /**
     * Children nice score history
     */
    public final void initChildrenNiceScoreHistory() {
        for (Child child: children) {
            if (child.getNiceScoreHistory() == null) {
                child.addNiceScoreToHistory(child.getNiceScore());
            }
        }
    }

    /**
     * Reset children gifts after passing a new year
     */
    public final void resetChildrenReceivedGifts() {
        for (Child child: getChildren()) {
            child.resetReceivedGifts();
        }
    }

    /**
     * Increment children age after passing a new year
     */
    public final void incrementChildrenAge() {
        for (Child child: getChildren()) {
            child.setAge(child.getAge() + 1);
        }
    }

    @Override
    public final String toString() {
        return "InitialData{"
                + "children=" + children
                + ", santaGiftsList=" + Arrays.toString(santaGiftsList) + '}';
    }
}
