public class consolDisplay extends boxs {
    private final char[] poz = new char[361]; //array for save table
    private final static char sym = 'X'; //the symbol to be used for X or O
    public static int[] mapSymbol = new int[9];//this is mapping symbol on board

    private static boolean nobodyWin = false;//use for check if nobody win this game

    //constructor
    public consolDisplay() {
        //put value for each index of mapSymbol for correct validation on validWin
        //step need for validWin()
        for (int i = 0; i < 9; i++) {
            mapSymbol[i] = 2;
        }
        //set symbol of each position of array as default
        for (int i = 0; i < 361; i++) {
            if (i > 0 && i <= 18 || i >= 114 && i <= 132 || i >= 228 && i <= 246 || i >= 342 && i < 360)
                poz[i] = '_'; //symbol for horizontal lines
            else if (i % 19 == 0 || i % 19 == 6 || i % 19 == 12 || i % 19 == 18) {
                poz[i] = '|'; //symbol for vertical lines
            } else poz[i] = ' ';
        }
        //first and last position on array poz
        poz[0] = '_';
        poz[360] = '_';
    }

    //consolDraw is use for display table of game on consol
    public void consoleDraw() {
        int space = 1;//use for next line on table
        //spacer between tables
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        /*
        if you want to see what the lines like look
        unmarked next lines and from Main.java, commands display.consoleDisplay
        may be on position 54 or >

                drawLineWin1(poz, 58);
                drawLineWin2(poz, 22);
                drawLineWin3(poz, 40);
                drawLineWin4(poz, 28);
                drawLineWin5(poz, 54);
                drawLineWin6(poz, 34);
                drawLineWin7(poz, 172);
                drawLineWin8(poz, 286);
        */


        for (int i = 0; i < 361; i++) {
            System.out.print(poz[i] + " ");
            if (space == 19) {
                System.out.println();
                space = 0;
            }
            space++;
        }
    }

    //make a virtual board to be displayed in the console through the consoleDraw function
    //in other words, this function edit symbols on each position of array poz[]
    public void virtualDraw(int needBox, int needSymbol) {
        //here you choose the required box and the symbol it should contain
        //mapSymbol is use for store symbol of each position on table for
        //verification of a possible winner
        switch (needBox) {
            case 1:
                boxs.box1(needSymbol, poz, sym);
                mapSymbol[0] = needSymbol;
                break;
            case 2:
                boxs.box2(needSymbol, poz, sym);
                mapSymbol[1] = needSymbol;
                break;
            case 3:
                boxs.box3(needSymbol, poz, sym);
                mapSymbol[2] = needSymbol;
                break;
            case 4:
                boxs.box4(needSymbol, poz, sym);
                mapSymbol[3] = needSymbol;
                break;
            case 5:
                boxs.box5(needSymbol, poz, sym);
                mapSymbol[4] = needSymbol;
                break;
            case 6:
                boxs.box6(needSymbol, poz, sym);
                mapSymbol[5] = needSymbol;
                break;
            case 7:
                boxs.box7(needSymbol, poz, sym);
                mapSymbol[6] = needSymbol;
                break;
            case 8:
                boxs.box8(needSymbol, poz, sym);
                mapSymbol[7] = needSymbol;
                break;
            case 9:
                boxs.box9(needSymbol, poz, sym);
                mapSymbol[8] = needSymbol;
                break;
        }
    }


    //this function check used mapSymbol if and when game is done and
    //set for table a line over more than three consecutive boxes
    //corresponding to the winning row
    //or if nobody win the game, set for nobodyWin value true
    public boolean validWin(int pas) {
        if (pas >= 3) {
            //for position form 012
            if ((mapSymbol[0] == mapSymbol[1] && mapSymbol[0] == mapSymbol[2]) && (mapSymbol[0] == 1 || mapSymbol[0] == 0)) {
                drawLineWin1(poz, 58);
                return false;
            } else
                //for position from 036
                if ((mapSymbol[0] == mapSymbol[3] && mapSymbol[0] == mapSymbol[6]) && (mapSymbol[0] == 1 || mapSymbol[0] == 0)) {
                    drawLineWin2(poz, 22);
                    return false;
                } else
                    //from position from 048
                    if ((mapSymbol[0] == mapSymbol[4] && mapSymbol[0] == mapSymbol[8]) && (mapSymbol[0] == 1 || mapSymbol[0] == 0)) {
                        drawLineWin3(poz, 40);
                        return false;
                    } else

                        //for position from 147
                        if ((mapSymbol[1] == mapSymbol[4] && mapSymbol[1] == mapSymbol[7]) && (mapSymbol[1] == 1 || mapSymbol[1] == 0)) {
                            drawLineWin4(poz, 28);
                            return false;
                        } else

                            //for position from 246
                            if ((mapSymbol[2] == mapSymbol[4] && mapSymbol[2] == mapSymbol[6]) && (mapSymbol[2] == 1 || mapSymbol[2] == 0)) {
                                drawLineWin5(poz, 54);
                                return false;
                            } else
                                //for position from 258
                                if ((mapSymbol[2] == mapSymbol[5] && mapSymbol[2] == mapSymbol[8]) && (mapSymbol[2] == 1 || mapSymbol[2] == 0)) {
                                    drawLineWin6(poz, 34);
                                    return false;
                                } else

                                    //for position from 345
                                    if ((mapSymbol[3] == mapSymbol[4] && mapSymbol[3] == mapSymbol[5]) && (mapSymbol[3] == 1 || mapSymbol[3] == 0)) {
                                        drawLineWin7(poz, 172);
                                        return false;
                                    } else

                                        //for position from 678
                                        if ((mapSymbol[6] == mapSymbol[7] && mapSymbol[6] == mapSymbol[8]) && (mapSymbol[6] == 1 || mapSymbol[6] == 0)) {
                                            drawLineWin8(poz, 286);
                                            return false;
                                        } else {
                                            //nobody win the game
                                            if (pas == 9) {
                                                System.out.println("Nobody win this game! Good luck next time!");
                                                nobodyWin = true;
                                            }
                                        }
        }
        return true;
    }

    public boolean isNobodyWin() {
        return nobodyWin;
    }

    //this function is called when the players choose to play with the
    //standard numbers on the keyboard
    public void playWithStandardNumber() {
        poz[60] = '1';
        poz[66] = '2';
        poz[72] = '3';
        poz[174] = '4';
        poz[180] = '5';
        poz[186] = '6';
        poz[288] = '7';
        poz[294] = '8';
        poz[300] = '9';
    }

    //this function is called for clear the digits in the box for drawing symbol
    public void clearBox(int position){
        switch (position){
            case 1:
                poz[60] = ' ';
                break;
            case 2:
                poz[66] = ' ';
                break;
            case 3:
                poz[72] = ' ';
                break;
            case 4:
                poz[174] = ' ';
                break;
            case 5:
                poz[180] = ' ';
                break;
            case 6:
                poz[186] = ' ';
                break;
            case 7:
                poz[288] = ' ';
                break;
            case 8:
                poz[294] = ' ';
                break;
            case 9:
                poz[300] = ' ';
                break;
        }
    }


}
