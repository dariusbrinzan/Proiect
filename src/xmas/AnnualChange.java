package xmas;

import java.util.Arrays;

public class AnnualChange {
    private Double newSantaBudget;
    private Gift[] newGifts;
    private Child[] newChildren;
    private ChildUpdate[] childrenUpdates;

    public AnnualChange(Double newSantaBudget,
                        Gift[] newGifts,
                        Child[] newChildren,
                        ChildUpdate[] childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public final Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public final void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public final Gift[] getNewGifts() {
        return newGifts;
    }

    public final void setNewGifts(Gift[] newGifts) {
        this.newGifts = newGifts;
    }

    public final Child[] getNewChildren() {
        return newChildren;
    }

    public final void setNewChildren(Child[] newChildren) {
        this.newChildren = newChildren;
    }

    public final ChildUpdate[] getChildrenUpdates() {
        return childrenUpdates;
    }

    public final void setChildrenUpdates(ChildUpdate[] childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    @Override
    public final String toString() {
        return "AnnualChange{" + "newSantaBudget=" + newSantaBudget
                + ", newGifts=" + Arrays.toString(newGifts) + ", newChildren="
                + Arrays.toString(newChildren) + ", childrenUpdates="
                + Arrays.toString(childrenUpdates) + '}';
    }
}
