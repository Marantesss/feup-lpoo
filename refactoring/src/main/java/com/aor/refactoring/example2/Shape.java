package com.aor.refactoring.example2;

public abstract class Shape {
    //enum TYPE {RECTANGLE, CIRCLE}

    //private TYPE type;
    protected double x;
    protected double y;

    /*
    public Shape(double x, double y, double width, double height) {
        this.type = TYPE.RECTANGLE;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Shape(double x, double y, double radius) {
        this.type = TYPE.CIRCLE;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    */


    // ---- can be abstract
    public double getArea() throws Exception {
        throw new Exception("Shape has no Area");
    }

    // ---- can be abstract
    public double getPerimeter() throws Exception {
        throw new Exception("Shape has no perimeter");
    }

    public abstract void draw(GraphicFramework graphics);

    // ---- getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // ---- setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
