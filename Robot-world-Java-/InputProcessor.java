package java_robot.inputprocessor;

import java_robot.robot.Robot;      //import Robot
import java_robot.wall.Wall;    //import Wall

public class InputProcessor{
    private char moveKey, turnLeftKey, turnRightKey;
    private Robot robot;
    private Wall[] wall;
    private boolean save = false;

    public InputProcessor(Robot robot, Wall[] wall){
        this.moveKey = 'w';
        this.turnLeftKey = 'a';
        this.turnRightKey = 'd';
        this.robot = robot;
        this.wall = wall;
    }

    public InputProcessor(char move, char turnLeft, char turnRight, Robot robot, Wall[] wall){
        this.moveKey = move;
        this.turnLeftKey = turnLeft;
        this.turnRightKey = turnRight;
    }

    public void checkMove(char inputKey, int worldRow, int worldColumn, int maxWall){
        if (inputKey == moveKey){
            for (int i = 0; i < maxWall; i++){
                if (robot.getDegree() == 0 && robot.getRow() + 1 == wall[i].getRow() && robot.getColumn() == wall[i].getColumn()){
                    break;
                } else if (robot.getDegree() == 0 && robot.getRow() + 1 == worldRow){
                    break;
                } else if (robot.getDegree() == 90 && robot.getRow() == wall[i].getRow() && robot.getColumn() + 1 == wall[i].getColumn()){
                    break;
                } else if (robot.getDegree() == 90 && robot.getColumn() + 1 == worldColumn){
                    break;
                } else if (robot.getDegree() == 180 && robot.getRow() - 1 == wall[i].getRow() && robot.getColumn() == wall[i].getColumn()){
                    break;
                } else if (robot.getDegree() == 180 && robot.getRow() - 1 < 0){
                    break;
                } else if (robot.getDegree() == 270 && robot.getRow() == wall[i].getRow() && robot.getColumn() - 1 == wall[i].getColumn()){
                    break;
                } else if (robot.getDegree() == 270 && robot.getColumn() - 1 < 0){
                    break;
                } else if (i == maxWall - 1) {
                    robot.move();
                }
            }
        } else if (inputKey == turnLeftKey){
            robot.turnLeft();
        } else if (inputKey == turnRightKey){
            robot.turnRight();
        } else if ((int)inputKey == 65535) {
            save = true;
        }
    }

    public char getMoveKey(){
        return moveKey;
    }

    public char getLeftKey(){
        return turnLeftKey;
    }

    public char getRightKey(){
        return turnRightKey;
    }

    public boolean getSave(){
        return save;
    }

    public void setSave(boolean saveState){
        save = saveState;
    }
}
