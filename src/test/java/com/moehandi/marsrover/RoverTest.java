package com.moehandi.marsrover;

import org.junit.Test;

import static com.moehandi.marsrover.Rover.E;
import static com.moehandi.marsrover.Rover.N;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;

public class RoverTest {

    @Test
    public void createRover() {
        Rover rover1 = new Rover();
        rover1.setPosition(1, 2, N);
        assertThat(rover1, isA(Rover.class));
    }

    @Test
    public void testRover() {
        Rover rover1 = new Rover();
        rover1.setPosition(5, 5);
        rover1.setPosition(1, 2, N);
        rover1.commandRover("LMLMLMLMM");
        assertEquals("1 3 N", rover1.getPosition());

        Rover rover2 = new Rover();
        rover2.setPosition(3, 3, E);
        rover2.commandRover("MMRMMRMRRM");
        assertEquals("5 1 E", rover2.getPosition());
    }

}


