package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    /* ---- useful function total order price ----
     * replaces the old for loop in isElegibleForFreeDelivery()
     * with a useful getTotalPrice() function
     */
    public double getTotalPrice() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getTotalPrice();

        return total;
    }

    /* ---- old bloater -> long method
     * inline temp
     */
    public boolean isElegibleForFreeDelivery() {
        return this.getTotalPrice() > 100;
    }

    // ---- old bloater -> long method
    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line);

        printBuffer.append("Total: " + this.getTotalPrice());

        return printBuffer.toString();
    }
}