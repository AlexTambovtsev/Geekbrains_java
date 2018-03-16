package ru.geekbrains.java.lesson_6;

public abstract class Animal {
    private int routeLength;
    private int jumpHigh;
    private int lineLength;


    protected Animal(int routeLength, int jumpHigh) {
        this.routeLength=routeLength;
        this.jumpHigh=jumpHigh;
    }
    protected Animal(int routeLength, int jumpHigh, int lineLength) {
        this.routeLength=routeLength;
        this.jumpHigh=jumpHigh;
        this.lineLength=lineLength;
    }

    protected int getRouteLength() {
        return routeLength;
    }

    protected int getJumpHigh() {
        return jumpHigh;
    }

    protected int getLineLength() {
        return  lineLength;
    }
    protected abstract void run();
    protected abstract void jump();
    protected abstract void swim();
}
