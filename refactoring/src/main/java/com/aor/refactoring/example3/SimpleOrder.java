package com.aor.refactoring.example3;

public class SimpleOrder {
    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
        this.discount = new NullDiscount();
    }

    public boolean hasDiscount() {
        return discount != null;
    }

    public double getTotal() {
        return this.getDiscount().applyDiscount(this.getPrice());
    }

    // ---- getters
    public Discount getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    // ---- setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
