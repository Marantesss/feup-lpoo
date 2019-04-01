package com.aor.refactoring.example3;

public class FixedDiscount extends Discount {

    private final double fixed;

    public FixedDiscount(int fixed) {
        this.fixed = fixed;
    }

    public double applyDiscount(double price) {
        return price - this.getFixed();
    }

    public double getFixed() {
        return fixed;
    }
}
