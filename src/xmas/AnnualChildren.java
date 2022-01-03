package xmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnualChildren {
    static class Children {
        List<Child> children;

        public Children() {
            children = new ArrayList<>();
        }

        public void addChild(final Child child) {
            children.add(child);
        }

        public List<Child> getChildren() {
            return children;
        }

        public void setChildren(List<Child> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Children{" +
                    "children=" + children +
                    '}';
        }
    }

    private final Children[] annualChildren;

    public AnnualChildren(final Integer numberOfYears) {
        annualChildren = new Children[numberOfYears + 1];
        for (int i = 0; i <= numberOfYears; ++i) {
            annualChildren[i] = new Children();
        }
    }

    public Children[] getAnnualChildren() {
        return annualChildren;
    }

    public void addChildren(final int year, final Child[] arr) {
        annualChildren[year].getChildren().addAll(Arrays.asList(arr));
    }

    public void addChildren(final int year, final List<Child> list) {
        annualChildren[year].getChildren().addAll(list);
    }

    @Override
    public String toString() {
        return "AnnualChildren{" +
                "annualChildren=" + Arrays.toString(annualChildren) +
                '}';
    }
}
