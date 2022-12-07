package com.squares.pages;

public class MultiplyPage {

    private int num;

    public MultiplyPage(String num) {
        this.num = Integer.parseInt(num);
    }

    public int getSquare() {
        return num * num;
    }
}
