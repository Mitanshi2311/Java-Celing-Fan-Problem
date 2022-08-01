package com.fan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.fan.Direction.FORWARD;
import static com.fan.Direction.BACKWARD;
import static com.fan.Fan.OFF;

class FanTest {

    private Fan fan;

    @BeforeEach
    void setUp() {
	this.fan = new Fan();
    }

    @Test
    void newObjectStateTest() {
	assertEquals(FORWARD, this.fan.getDirection());
	assertEquals(OFF, this.fan.getSpeed());
    }

    @Test
    void reverseDirectionTest() {
	// As we pull direction cord it reverses the direction of fan
	this.fan.pullDirectionCord();
	assertEquals(BACKWARD, this.fan.getDirection());
    }

    @Test
    void speedTest() {
	assertEquals(OFF, this.fan.getSpeed());

	// As we pull speed cord for the first time fan speed should become 1 from "OFF" setting
	this.fan.pullSpeedCord();
	assertEquals(1, this.fan.getSpeed());

	// As we pull speed cord for the second time fan speed should become 2 from 1
	this.fan.pullSpeedCord();
	assertEquals(2, this.fan.getSpeed());

	// As we pull speed cord for the second time fan speed should become 3 from 2
	this.fan.pullSpeedCord();
	assertEquals(3, this.fan.getSpeed());

	// As we pull speed cord for the second time fan speed should become "OFF" setting from 3
	this.fan.pullSpeedCord();
	assertEquals(OFF, this.fan.getSpeed());
    }
    
    @Test
    void speedDirectionTest() {
	// Check operations alternatively
	
	fan.pullDirectionCord();
	assertEquals(OFF, fan.getSpeed());
	assertEquals(BACKWARD, fan.getDirection());

	fan.pullDirectionCord();
	assertEquals(OFF, fan.getSpeed());
	assertEquals(FORWARD, fan.getDirection());
	
	fan.pullSpeedCord();
	assertEquals(1, fan.getSpeed());
	assertEquals(FORWARD, fan.getDirection());

	fan.pullSpeedCord();
	assertEquals(2, fan.getSpeed());
	assertEquals(FORWARD, fan.getDirection());

	fan.pullDirectionCord();
	assertEquals(2, fan.getSpeed());
	assertEquals(BACKWARD, fan.getDirection());

	fan.pullDirectionCord();
	assertEquals(2, fan.getSpeed());
	assertEquals(FORWARD, fan.getDirection());
	
	fan.pullSpeedCord();
	assertEquals(3, fan.getSpeed());
	assertEquals(FORWARD, fan.getDirection());

	fan.pullSpeedCord();
	assertEquals(OFF, fan.getSpeed());
	assertEquals(FORWARD, fan.getDirection());

	fan.pullDirectionCord();
	assertEquals(OFF, fan.getSpeed());
	assertEquals(BACKWARD, fan.getDirection());
    }

}
