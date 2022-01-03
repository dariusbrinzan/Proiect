package xmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //@NotNull
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    //@NotNull
    public Gift[] getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(Gift[] newGifts) {
        this.newGifts = newGifts;
    }

    //@NotNull
    public Child[] getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(Child[] newChildren) {
        this.newChildren = newChildren;
    }

    //@NotNull
    public ChildUpdate[] getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(ChildUpdate[] childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    //@Override
    public String toString() {
        return "AnnualChange{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + Arrays.toString(newGifts) +
                ", newChildren=" + Arrays.toString(newChildren) +
                ", childrenUpdates=" + Arrays.toString(childrenUpdates) +
                '}';
    }
}
