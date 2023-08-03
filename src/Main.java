import java.util.*;
public class Main {

    private static void gameVersion() {
        System.out.println("GAME VERSION 1...CONSOLE ONLY...\n");
    }

    public static void main(String[] args) {
        //instances
        dataBase storage = new dataBase();//use for read position on table witch the player chooses
        Random rand;
        //variables
        boolean play; //for run the game
        int countRound = 0; //this count rounds of the game
        int winPlayer; //this is use for store winner
        boolean isNUMPAD;
        //GAME VERSION
        gameVersion();
        //Set usernames of players
        //Game with only 2 players
        gameLogic ask = new gameLogic();
        //when nickname are not give as parameters, use next line
        //give value true or false to "play" because we can have 2 situation
        //1 - when give player name
        //2 - when give an command "/..."
        //variable play dictate fi the game will be start or not
        play = ask.setUserNames();
        //load array for draw table of game
        //create instance of consolDisplay witch will create
        //and draw the table on consol
        consolDisplay display = new consolDisplay();
        //game brain
        while (play) {
            if (countRound > 0) {
                ask = new gameLogic(ask.getUserName_Player1(), ask.getUserName_Player2(), true);
                display = new consolDisplay();
            }
            //method for random first player
            rand = new Random();
            String firsPlayer;
            String secondPlayer;
            if (!ask.singleModeON) {
                int randPlayer = rand.nextInt(2); //random for player order
                if (randPlayer == 0) {
                    firsPlayer = ask.getUserName_Player1();
                    secondPlayer = ask.getUserName_Player2();
                } else {
                    firsPlayer = ask.getUserName_Player2();
                    secondPlayer = ask.getUserName_Player1();
                }
            } else {//if game mode is in single mod
                //set player nickname as first player by default
                firsPlayer = ask.getUserName_Player1();
                secondPlayer = ask.getUserName_Player2();
                System.out.println("single mode activated");
            }
            //Display the player who will be the first
            System.out.println("\nPlayer X: " + firsPlayer + "\nPlayer O: " + secondPlayer);
            //next lines are responsible for game logic
            int possition; //the position the player has chosen
            int needSymbol; //the symbol corresponding to the player who has chosen
            //his position on the table
            int step; //use for count step of game(max: 9 steps)

            //for preview lines when someone win
//        display.consoleDraw();

            //method for read position from NUMPAD
            isNUMPAD = ask.fromNupPad();
            //when players choose to use the standard number on  the keyboard, the table on of game
            //will be drawn with digits symbolizing the position to be entered by the players
            if (!isNUMPAD)
                display.playWithStandardNumber();
            display.consoleDraw();
            for (step = 1; step <= 9; step++) {
                if (step % 2 != 0) { //if pas is odd, that mean player X action
                    do {
                        System.out.print("Move for player X (" + firsPlayer + "): ");
                        possition = ask.scanPosition(isNUMPAD, ask.singleModeON, step);
                    } while (ask.validMove(possition, false));
                    //if validMove is true mean an incorrect position on the table
                    //if is false, loop breaks and logic flows to the next step
                    needSymbol = 1; // that is use in virtualDraw for draw symbol X on chosen position
                } else { //if pas is even, that mean player O action
                    do {
                        System.out.print("Move for player O (" + secondPlayer + "): ");
                        possition = ask.scanPosition(isNUMPAD, ask.singleModeON, step);
                    } while (ask.validMove(possition, false));
                    //if validMove is true mean an incorrect position on the table
                    //if is false, loop breaks and logic flows to the next step
                    needSymbol = 0; // that is use in virtualDraw for draw symbol O on chosen position
                }
                //clear the digits
                display.clearBox(possition);
                //display board of game
                display.virtualDraw(possition, needSymbol);
                //verified if game is over
                if (!display.validWin(step)) { //check if someone won and draw table
                    //else game continues and loop of game will break
                    display.consoleDraw();
                    break; //for break for loop
                } else display.consoleDraw();
            }
            //info winner
            if (display.isNobodyWin()) {
                System.out.println("Nobody win this game!\nGood luck next time!");
                winPlayer = 0;
            } else {
                if (step % 2 != 0) {  //that mean winner is player X else mean winner is player O
                    System.out.println("Winner is: " + firsPlayer);
                    winPlayer = 1;
                } else {
                    System.out.println("Winner is: " + secondPlayer);
                    winPlayer = 2;
                }
            }
            //save info of players
            storage.writeDataBase(firsPlayer, secondPlayer, winPlayer);
            storage.score(storage.getNickname1(), storage.getNickname2(), storage.getScore1(), storage.getScore2());

            play = ask.playAgain(); //the game will continue if the returned value is true
            countRound++;//count the rounds of the game for restart the game when the players continue the game
        }
        //final consol text message
        System.out.println("Game over!");
    }


}