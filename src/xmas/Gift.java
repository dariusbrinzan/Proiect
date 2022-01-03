package xmas;

import enums.Category;

import java.io.Serializable;

public class Gift implements Comparable<Gift>, Serializable {
    private String productName;
    private Double price;
    private Category category;

    public Gift(String productName, Double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public int compareTo(Gift other) {
        if (this.getPrice() < other.getPrice()) {
            return -1;
        }
        return 1;
    }
}
