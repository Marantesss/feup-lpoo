package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // ---- useful function total orderLine price
    public double getTotalPrice() {
        return this.getQuantity() * this.getProduct().getPrice();
    }

    /*
     * Simplifies the for loop in Order.printOrder()
     */
    @Override
    public String toString() {
        return this.product.getName() + "(x" + this.getQuantity() + "): " + (this.product.getPrice() * this.getQuantity()) + "\n";
    }

    // ---- getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // ---- setters
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
