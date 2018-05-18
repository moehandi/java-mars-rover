package com.moehandi.marsrover;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rover {
    public static final int N = 1;
    public static final int E = 2;
    public static final int S = 3;
    public static final int W = 4;

    private int x = 0;
    private int y = 0;
    private int front = N; // default when no set

    public Rover() {}

    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setPosition(5, 5);
        rover.setPosition(1, 2, N);
        rover.commandRover("LMLMLMLMM");
        rover.getResult(); // prints 1 3 N

        rover.setPosition(3, 3, E);
        rover.commandRover("MMRMMRMRRM");
        rover.getResult(); // prints 5 1 E
    }

    public void setPosition(int x, int y, int front) {
        this.x = x;
        this.y = y;
        this.front = front;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getPosition() {
        char direction = 'N';
        if (front == 1) {
            direction = 'N';
        } else if (front == 2) {
            direction = 'E';
        } else if (front == 3) {
            direction = 'S';
        } else if (front == 4) {
            direction = 'W';
        }

        return this.x   + " " +  this.y  +" "+  direction;
    }

    public void getResult(){
        System.out.println(getPosition());
    }

    public void commandRover(String commands) {
        areValidCommands(commands);
        for (int idx = 0; idx < commands.length(); idx++) {
            commandRover(commands.charAt(idx));
        }

    }

    public void commandRover(char command) {
        switch (command) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                move();
                break;
        }

    }

    private void move() {
        switch (front) {
            case N:
                this.y++;
                break;
            case E:
                this.x++;
                break;
            case S:
                this.y--;
                break;
            case W:
                this.x--;
                break;
        }
    }

    private void turnLeft() {
        front = (front - 1) < N ? W : front - 1;
    }

    private void turnRight() {
        front = (front + 1) > W ? N : front + 1;
    }

    private void areValidCommands(String commands) {
        Pattern pattern = Pattern.compile("^[LRM]+$");
        Matcher matcher = pattern.matcher(commands);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid command");
        }
    }
}