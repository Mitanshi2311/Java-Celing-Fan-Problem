package com.fan;

import static com.fan.Direction.FORWARD;
import static com.fan.Direction.BACKWARD;


public class Fan {
    
    // Constant variable to represent "off" setting
    public static final int OFF = 0;
    
    private Direction direction;
    private int speed;

    Fan() {
	this.direction = FORWARD;
	this.speed = OFF;
    }

    public int getSpeed() {
	return this.speed;
    }

    public Direction getDirection() {
	return this.direction;
    }

    public void pullSpeedCord() {
	this.speed  = (this.speed == 3) ? OFF : ++this.speed; 
    }

    public void pullDirectionCord() {
	this.direction = (this.direction == FORWARD) ? BACKWARD : FORWARD;
    }

    @Override
    public String toString() {
	return "Fan speed = " + this.speed + " | Fan direction" + this.direction;
    }
}
