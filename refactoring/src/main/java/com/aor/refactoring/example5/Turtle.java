package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void execute(char command) {
        switch (command) {
            case 'L': this.rotateLeft(); break;
            case 'R': this.rotateRight(); break;
            case 'F': this.moveForward(); break;

        }
    }

    public void rotateLeft() {
        switch (this.getDirection()) {
            case 'N': this.setDirection('W'); break;
            case 'W': this.setDirection('S'); break;
            case 'S': this.setDirection('E'); break;
            case 'E': this.setDirection('N'); break;
        }
    }

    public void rotateRight() {
        switch (this.getDirection()) {
            case 'N': this.setDirection('E'); break;
            case 'W': this.setDirection('N'); break;
            case 'S': this.setDirection('W'); break;
            case 'E': this.setDirection('S'); break;
        }
    }

    public void moveForward() {
        switch (this.getDirection()) {
            case 'N': this.moveUp(); break;
            case 'W': this.moveLeft(); break;
            case 'S': this.moveDown(); break;
            case 'E': this.moveRight(); break;
        }
    }

    public void moveUp() {
        this.row--;
    }

    public void moveDown() {
        this.row++;
    }

    public void moveLeft() {
        this.column--;
    }

    public void moveRight() {
        this.column++;
    }
}
