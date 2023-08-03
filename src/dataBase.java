import java.io.*;
import java.io.File;
import java.util.Scanner;

public class dataBase {
    private String nickname1;
    private String nickname2;
    private int score1;
    private int score2;

    //constructor
    public dataBase() {
        //empty constructor
    }

    //methods
    public void writeDataBase(String nickname1, String nickname2, int winPLayer) {

        String tempName;//to switch nicknames if they are not in alphabetical order
        String lineReplaceWith = null; //this is line which will be modified
        String initialLineReplace = null; //this is the line we look for in original file
        int tempScore;//to switch scores if nicknames are not in alphabetical order
        int score1; //score for player X
        int score2; //score for player O
        boolean oldPlayers = false; //is true if players have played
        File dataFile = new File("DataBase_of_players.txt"); //this is original file for store info player
        File tempFile = new File("tempDataBase_of_players.txt"); //this is a temporary file

        System.out.println("\n<<<SAVING PLAYERS DATA>>>");

        if (winPLayer == 1) { //increment with 1 player's score
            //mean player x is the winner
            score1 = 1;
            score2 = 0;
        } else if (winPLayer == 2) {
            //mean player x is the winner
            score1 = 0;
            score2 = 1;
        }else{
            //when nobody win this round
            score1 = 0;
            score2 = 0;
        }

        //switch nicknames if they are not in alphabetical order
        if (nickname1.compareTo(nickname2) > 0) { // if the nicknames are not in alphabetic order
            //a change will be made between them, including the scor
            //swap nicknames
            tempName = nickname1;
            nickname1 = nickname2;
            nickname2 = tempName;
            //swap score
            tempScore = score1;
            score1 = score2;
            score2 = tempScore;
        }
        //try to open an existent file or open him
        if (!dataFile.exists()) {
            System.out.println("...File: " + dataFile.getPath() + " are not exist...");
            System.out.println("...Data not save...\n...Creating file...\n");
            try {
               boolean created =  dataFile.createNewFile();
                System.out.println("...File was created... " + created);
                System.out.println("...File: " + dataFile.getPath() + " exist...");
            } catch (IOException e) {
                System.out.println("...File can not be created...");
                throw new RuntimeException(e);
            }
        }
        //****************************************************************************************************************************************************************
        //check if the players are in the database
        //and store line where trey and store the same line
        //but with incremented score
        Scanner read_searchPlayers; //use for read dataFile
        try {
            read_searchPlayers = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("...Problem when create scanner read_searchPlayers...");
            throw new RuntimeException(e);
        }
        do {
            //read 4 elements from dataFile witch means information about the players
            String searchNickname1 = read_searchPlayers.next();
            String searchNickname2 = read_searchPlayers.next();
            int scoreNickname1 = Integer.parseInt(read_searchPlayers.next());
            int scoreNickname2 = Integer.parseInt(read_searchPlayers.next());
            //compare the nicknames of the current players with those read from the file
            //witch they are tge same, increment score with those in the file
            if ((searchNickname1.equalsIgnoreCase(nickname1))
                    && searchNickname2.equalsIgnoreCase(nickname2)) {
                score1 += scoreNickname1;
                score2 += scoreNickname2;
                System.out.println("...Players found on data base...");
                //this is line which will be modified
                lineReplaceWith = (nickname1 + " " + nickname2 + " " + score1 + " " + score2);
                //this is the line we look for in original file
                initialLineReplace = (searchNickname1 + " " + searchNickname2 + " " + scoreNickname1 + " " + scoreNickname2);
                oldPlayers = true;
                break;
            }
        } while (read_searchPlayers.hasNext());
        System.out.println("lineReplaceWith: " + lineReplaceWith);
        System.out.println("InitialLineReplace: " + initialLineReplace);
        read_searchPlayers.close();
        //****************************************************************************************************************************************************************
        //clone dataFile in tempFile
        try {
            read_searchPlayers = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("...Problem when create scanner read_searchPlayers...");
            throw new RuntimeException(e);
        }
        //if the players have played
        if (oldPlayers) {
            //edit score and write all information about players in tempFile
            System.out.println("Players have played.");
            String currentLine;
            try {
                BufferedWriter writeTemp = new BufferedWriter(new FileWriter(tempFile));
                while (read_searchPlayers.hasNextLine()) {
                    currentLine = read_searchPlayers.nextLine();
                    if (currentLine.equals(initialLineReplace)) {
                        writeTemp.write(lineReplaceWith + "\n");
                    } else {
                        writeTemp.write(currentLine + "\n");
                    }
                }
                writeTemp.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //overwrite dataFile with value of tempFile
            try {
                Scanner readTempFile = new Scanner(tempFile);
                BufferedWriter writeDataFile = new BufferedWriter(new FileWriter(dataFile));

                while (readTempFile.hasNextLine()) {
                    writeDataFile.write(readTempFile.nextLine() + "\n");
                }
                readTempFile.close();
                writeDataFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            //if the players haven't played
            System.out.println("Players not have played.");
            try {
                BufferedWriter writeData = new BufferedWriter(new FileWriter(dataFile, true));
                writeData.write(nickname1 + " " + nickname2 + " " + score1 + " " + score2 + "\n");
                writeData.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //delete tempFile
        boolean delete = tempFile.delete();
        System.out.println("File: " + tempFile.getName() + " is deleted: " + delete);

        System.out.println("<<<DONE>>>");

        //save actual players as global
        this.nickname1 = nickname1;
        this.nickname2 = nickname2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getNickname1() {
        return nickname1;
    }

    public String getNickname2() {
        return nickname2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void score(String nickname1, String nickname2, int score1, int score2) {
        System.out.println("\n...SCORE...");
        System.out.println("Player: " + nickname1 + " => score: " + score1 +
                "\nPlayer: " + nickname2 + " => score: " + score2);
    }
}

