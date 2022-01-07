package xmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnualChildren {
    static class Children {
        private List<Child> children;

        Children() {
            children = new ArrayList<>();
        }

        public void addChild(final Child child) {
            children.add(child);
        }

        public List<Child> getChildren() {
            return children;
        }

        public void setChildren(final List<Child> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Children{"
                    + "children=" + children + '}';
        }
    }

    private final Children[] annualChildren;

    public AnnualChildren(final Integer numberOfYears) {
        annualChildren = new Children[numberOfYears + 1];
        for (int i = 0; i <= numberOfYears; ++i) {
            annualChildren[i] = new Children();
        }
    }

    public final Children[] getAnnualChildren() {
        return annualChildren;
    }

    /**
     * Method to add children
     * @param year
     * @param arr
     */
    public final void addChildren(final int year, final Child[] arr) {
        annualChildren[year].getChildren().addAll(Arrays.asList(arr));
    }

    /**
     * Method to add children
     * @param year
     * @param list
     */
    public final void addChildren(final int year, final List<Child> list) {
        annualChildren[year].getChildren().addAll(list);
    }

    @Override
    public final String toString() {
        return "AnnualChildren{" + "annualChildren=" + Arrays.toString(annualChildren)
                + '}';
    }
}
