package xmas;

import enums.Category;

import java.io.Serializable;

public class Gift implements Comparable<Gift>, Serializable {
    private String productName;
    private Double price;
    private Category category;

    public Gift(final String productName,
                final Double price,
                final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final void setPrice(Double price) {
        this.price = price;
    }

    public final Category getCategory() {
        return category;
    }

    public final void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public final String toString() {
        return "Gift{" + "productName='" + productName
                + '\'' + ", price=" + price
                + ", category=" + category + '}';
    }

    @Override
    public int compareTo(final Gift other) {
        if (this.getPrice() < other.getPrice()) {
            return -1;
        }
        return 1;
    }
}
