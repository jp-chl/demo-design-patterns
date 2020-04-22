package com.jpvr.demodesignpatterns.abstractions;

public class Animal {
    public void draw(int headSize, int earSize, int eyesSize, int noseSise, int mouthSize) {

        drawHead(headSize);
        drawEars(earSize);
        drawEyes(eyesSize);
        drawNose(noseSise);
        drawMouth(mouthSize);
    }

    private void drawMouth(int mouthSize) {
        System.out.println("Drawing mouth...");
    }

    private void drawNose(int noseSise) {
        System.out.println("Drawing nose...");
    }

    private void drawEyes(int eyesSize) {
        System.out.println("Drawing eyes...");
    }

    private void drawEars(int earSize) {
        System.out.println("Drawing ears...");
    }

    private void drawHead(int headSize) {
        System.out.println("Drawing head...");
    }
} // end class Animal
