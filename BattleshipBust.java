package battleship2;

import java.util.ArrayList;

public class BattleshipBust {

    // Declare and initialize variables we need
    private GameHelper helper = new GameHelper();
    private ArrayList<Battleship> battleshipsList = new ArrayList<Battleship>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        //TODO: Makes three battleships
        //TODO: Give each battleship a name
        //Create 3 battleship objects and set their names
        Battleship battleship1 = new Battleship();  
        battleship1.setName("Lil Yachty");    
        Battleship battleship2 = new Battleship();      
        battleship2.setName("Seas the Day");    
        Battleship battleship3 = new Battleship();      
        battleship3.setName("Usain Boat");    
        battleshipsList.add(battleship1);
        battleshipsList.add(battleship2);
        battleshipsList.add(battleship3);


        //Print out instructions to user
        System.out.println("Your goal is to sink all three battleships.");
        System.out.println(battleship1.toString() + ", " + battleship2.toString() + " and " + battleship3.toString() + ".");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        //User GameHelper class to set 3 battleship locations
        for (Battleship battleshipToSet : battleshipsList){
            ArrayList<String> newLocation = helper.placeBattleship(3);
            battleshipToSet.setLocationCells(newLocation);
        }
    }
    // TODO: gets user input
    // TODO: plays until all battleships are gone
    // TODO: check user guess with all three battleship
    // While the battleships list is not empty continue asking user for guesses
    private void startPlaying() {
        while (!battleshipsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess.");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (int x = 0; x < battleshipsList.size(); x++) {

            result = battleshipsList.get(x).checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                battleshipsList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("All battleships are dead!");
        if(numOfGuesses <= 18){
            System.out.println("It only took you " + numOfGuesses + " guesses!");
        } else {
            System.out.println("It took you " + numOfGuesses + "! Better luck next time!");

        }
    }

    // TODO: keep playing the game

    public static void main(String[] args) {
        // TODO: Main will instantiate the BattleshipBust object that does all the game process
        BattleshipBust game = new BattleshipBust();
        game.setUpGame();
        game.startPlaying();

    }
}
