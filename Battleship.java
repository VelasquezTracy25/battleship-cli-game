package battleship2;

import java.util.ArrayList;

public class Battleship {
    private ArrayList<String> locationCells;
    private String name;

    //Sets location of cells 
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    //Sets name
    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {

        String result = "miss";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sunk " + name + "!");
            } else {
                result = "hit";
            }
        }
        return result;
    }

    //Overriding toString method to return name
    @Override
        public String toString() {
            return name;
        }
    
}