import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class gameLogic {
    private String userName_Player1; //use for store first nickname
    private String userName_Player2; //use for store second nickname
    private static int[] accessPosition = new int[9];//this is mapping available position on table
    Scanner reader = new Scanner(System.in); //used for read from keyboards
    private boolean startGame = false;
    public boolean singleModeON = false;

    //constructors
    //default constructor
    //when nicknames for player 1 and 2 are given as parameters
    public gameLogic(String userName_Player1, String userName_Player2, boolean newGame) {
        //ask dor name of player 1
        if (userName_Player1.length() == 0 || userName_Player1.length() > 21)
            throw new RuntimeException("Invalid length. Type username of max 21 characters.");
        else {
            this.userName_Player1 = userName_Player1;
            //System.out.println("Player 1: " + userName_Player1);
        }
        //ask dor name of player 2
        if (userName_Player2.length() == 0 || userName_Player2.length() > 21)
            throw new RuntimeException("Invalid length. Type username of max 21 characters.");
        else {
            this.userName_Player2 = userName_Player2;
            //System.out.println("Player 2: " + userName_Player2);
        }
        if (newGame)
            accessPosition = new int[9];
    }

    //general constructor
    public gameLogic() {
        //ask for name use methods
    }

    //methods
    //read from keyboard name or commands
    public String inputInfo(int numberPlayer) {
        String userInput; //store user input
        while (true) {
            userInput = reader.nextLine();
            if (userInput.length() > 1 && userInput.length() < 21) {//validate length character for possible name or command
                if (userInput.charAt(0) == '/') {//if for analyzing commands
                    if (userInput.equalsIgnoreCase("/help")) {//./help will give you info about all commands
                        System.out.print("Commands:\n" +
                                "1. /HELP - gives you info about all commands.\n" +
                                "2. /LEADERBOARDS - gives you a leaderboards.\n" +
                                "3. /BEST - gives best player.\n" +
                                "4. /SINGLE - you play versus AI.\n" +
                                "5. /START - for continue the game on normal mode.\n" +
                                "User name Player " + numberPlayer + ": ");
                    } else if (userInput.equalsIgnoreCase("/start")) {
                        if (startGame) {
                            System.out.println("The game is already start.");
                            System.out.print("User name Player " + numberPlayer + ": ");
                        } else {
                            startGame = true;//game will be start in dual players mode / normal mode
                            while (true) {
                                System.out.print("User name Player " + numberPlayer + ": ");
                                userInput = reader.nextLine();
                                if (userInput.length() > 21)
                                    System.out.println("Invalid length. Input max 20 characters.");
                                else break;
                            }
                            break;
                        }
                    } else if (userInput.equalsIgnoreCase("/leaderboards")) {
                        System.out.println("Leaderboards:");
                        //function for display in consol leaderboards of top 10 players:
                        leaderboards();
                        System.out.print("User name Player " + numberPlayer + ": ");
                    } else if (userInput.equalsIgnoreCase("/best")) {
                        //function for display in consol the best player
                        best();
                        System.out.print("User name Player " + numberPlayer + ": ");
                    } else if (userInput.equalsIgnoreCase("/single")) {
                        System.out.println("Start the single player game mode.");
                        //set nickname for player 1 and set nickname for AI player
                        System.out.print("User name Player 1: ");
                        userInput = inputInfo(1);
                        singleModeON = true;
                        break;
                    } else System.out.print("Unknown command.\n" +
                            "User name Player " + numberPlayer + ": ");
                } else { //if userInput don t start with  "/"
                    startGame = true;
                    break;
                }
            } else {//else for if length
                System.out.println("Invalid length. Input max 20 characters.");
                System.out.print("User name Player " + numberPlayer + ": ");
            }
        }
        return userInput;
    }

    public boolean setUserNames() {
        singleModeON = false; // default parameter
        //use when use general constructor
        //ask dor name of player 1
        System.out.print("User name Player 1: ");
        this.userName_Player1 = inputInfo(1);
        //ask dor name of player 2
        if (!singleModeON) { //is true if game mode is set on single
            System.out.print("User name Player 2: ");
            this.userName_Player2 = inputInfo(2);
        } else {
            //set name for IA as nickname player 2
            System.out.println("You enemy is AI.");
            this.userName_Player2 = "AI";
        }
        return startGame;
    }

    public String getUserName_Player1() {
        return this.userName_Player1;
    }

    public String getUserName_Player2() {
        return this.userName_Player2;
    }

    public boolean validMove(int position, boolean repeatForRand) {
        //check for correct interval
        if (position == 0) {
            if (!repeatForRand) {
                System.out.println("Incorrect input.");
            }
            return true;
        } else if (position <= 0 || position >= 10) {
            if (!repeatForRand) {
                System.out.println("Position incorrect!");
            }
            return true;
        }
        //check for correct position
        for (int i = 0; i < 9; i++) {
            if (accessPosition[i] == position) {
                if (!repeatForRand) {
                    System.out.println("Position unavailable!");
                }
                return true;
            }
        }
        //save new available position on array
        accessPosition[position - 1] = position;
        return false;
    }


    public boolean playAgain() {
        String decision;
        System.out.println("\nYou keep playing?");
        while (true) {
            System.out.println("Answer with [yes] or [no]: ");
            decision = inputInfo(0);
            if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no"))
                break;
        }
        return decision.equalsIgnoreCase("yes");
    }

    public int scanPosition(boolean isNUMPAD, boolean singleModeON, int step) {
        Scanner scanPoz = new Scanner(System.in);
        String position = scanPoz.next();
        byte[] keyCode = position.getBytes();

        //isNUMPAD when typing from numpad this will be true
        //when read position from consol, the position 1 2 3
        //be put on position 7 8 9 and reverse
        //because, you numpad reflects game table
        if (singleModeON && step % 2 == 0) { // for position IA
            System.out.println("A ajuns aici!");
            int rand = new Random().ints(1, 1, 10).findFirst().getAsInt();
            for (int i = 0; i < 9; i++) {
                if (accessPosition[i] == rand) {
                    rand = new Random().ints(1, 1, 10).findFirst().getAsInt();
                    break;
                }
            }
            return rand;
        }
        if (keyCode.length == 1) {
            if (isNUMPAD) {
                switch (keyCode[0]) {
                    case 49:
                        return 7;
                    case 50:
                        return 8;
                    case 51:
                        return 9;
                    case 52:
                        return 4;
                    case 53:
                        return 5;
                    case 54:
                        return 6;
                    case 55:
                        return 1;
                    case 56:
                        return 2;
                    case 57:
                        return 3;
                }
            } else {
                switch (keyCode[0]) {
                    case 49:
                        return 1;
                    case 50:
                        return 2;
                    case 51:
                        return 3;
                    case 52:
                        return 4;
                    case 53:
                        return 5;
                    case 54:
                        return 6;
                    case 55:
                        return 7;
                    case 56:
                        return 8;
                    case 57:
                        return 9;
                }
            }
        }
        return 0;
    }

    public static class player {
        //instance for store players from dataBase in list on <best> method
        private final String name;
        private final Integer score;

        public player(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

    }

    private void best() {
        //give best player by wins of the game
        //list for store all players with their score from dataBase
        List<player> listPlayers = new ArrayList<>();
        //find and open dataBase
        File dataFile = new File("DataBase_of_players.txt");
        if (!dataFile.exists()) {
            System.out.println("...File: " + dataFile.getPath() + " are not exist...");
            System.out.println("...Data not save...\n...Creating file...\n");
            try {
                boolean created = dataFile.createNewFile();
                System.out.println("...File was created... " + created);
                System.out.println("...File: " + dataFile.getPath() + " exist...");
            } catch (IOException e) {
                System.out.println("...File can not be created...");
                throw new RuntimeException(e);
            }
        }
        //scanner for read from dataBase
        Scanner readerFromDataBase;
        try {
            readerFromDataBase = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("...Problem when create scanner readerFromDataBase...");
            throw new RuntimeException(e);
        }
        //read and save each player with his score in list <listPlayers>
        do {
            //read from dataBase file
            String player1 = readerFromDataBase.next();
            String player2 = readerFromDataBase.next();
            int scorPlayer1 = Integer.parseInt(readerFromDataBase.next());
            int scorPlayer2 = Integer.parseInt(readerFromDataBase.next());
            //save data in listPlayers
            listPlayers.add(new player(player1, scorPlayer1));
            listPlayers.add(new player(player2, scorPlayer2));
        } while (readerFromDataBase.hasNext());
        //display leaderboards:
        int maxScore = 0;
        String bestPlayer = null;
        for (gameLogic.player player : listPlayers) { //cross each element of the list
            if (player.score > maxScore) { //search for the best player and save his name and score
                maxScore = player.score;
                bestPlayer = player.name;
            }
        }
        //display info about the best player
        System.out.println("The best player: " + bestPlayer + " with " + maxScore + " wins.");
    }

    private void leaderboards() {
        //give leaderboards of the best 10 players of the game
        //same code with the best method until //display leaderboards
        //after this make method for display descendant 10 players by score

        //list for store all players with their score from dataBase
        List<player> listPlayers = new ArrayList<>();
        //find and open dataBase
        File dataFile = new File("DataBase_of_players.txt");
        if (!dataFile.exists()) {
            System.out.println("...File: " + dataFile.getPath() + " are not exist...");
            System.out.println("...Data not save...\n...Creating file...\n");
            try {
                boolean created = dataFile.createNewFile();
                System.out.println("...File was created... " + created);
                System.out.println("...File: " + dataFile.getPath() + " exist...");
            } catch (IOException e) {
                System.out.println("...File can not be created...");
                throw new RuntimeException(e);
            }
        }
        //scanner for read from dataBase
        Scanner readerFromDataBase;
        try {
            readerFromDataBase = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("...Problem when create scanner readerFromDataBase...");
            throw new RuntimeException(e);
        }
        //read and save each player with his score in list <listPlayers>
        do {
            //read from dataBase file
            String player1 = readerFromDataBase.next();
            String player2 = readerFromDataBase.next();
            int scorPlayer1 = Integer.parseInt(readerFromDataBase.next());
            int scorPlayer2 = Integer.parseInt(readerFromDataBase.next());
            //save data in listPlayers
            listPlayers.add(new player(player1, scorPlayer1));
            listPlayers.add(new player(player2, scorPlayer2));
        } while (readerFromDataBase.hasNext());

        //sort list
        listPlayers.sort(Comparator.comparingInt(player::getScore));

        //display players from top
        int topPlayers = 5;
        int count = 0;
        int i = listPlayers.size();
        for (; count < topPlayers; i--, count++) {
            String name = listPlayers.get(i - 1).name;
            int score = listPlayers.get(i - 1).score;
            System.out.println("Position " + (count + 1) + ": " + name + " " + score + " wins.");
        }
    }

    //method for ask if position are pressed form the NUMPAD
    //return true or false
    public boolean fromNupPad() {
        System.out.println("Use NUMPAD?");
        String decision;
        while (true) {
            System.out.println("Answer with [yes] or [no]: ");
            decision = inputInfo(0);
            if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no"))
                break;
            else System.out.println("What do you mean?");
        }
        return decision.equalsIgnoreCase("yes");
    }

    public void gameMode() {

//        - set virtual name for AI player (final variable)
//        - make return true if this class is called for check game mode in main file
//        - in main file, make for the round AI player a class for random position
    }
}

