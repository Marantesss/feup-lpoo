package com.aor.refactoring.example3;

public abstract class Discount {

    /*
    public Discount(int fixed) {
        this.fixed = fixed;
        this.percentage = 0;
    }

    public Discount(double percentage) {
        this.percentage = percentage;
        this.fixed = 0;
    }
    */

    public abstract double applyDiscount(double price);
}
