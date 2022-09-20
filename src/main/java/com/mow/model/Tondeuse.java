package com.mow.model;


public class Tondeuse {
    int positionX;
    int positionY;
    char orientation;

    public Tondeuse(int positionX, int positionY, char orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    
    
}
