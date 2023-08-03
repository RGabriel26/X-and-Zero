public class boxs {
    private static final char symbolLineWin = '@';

    public static void box1(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 20; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box2(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 26; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box3(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 32; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box4(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 134; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box5(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 140; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box6(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 146; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box7(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 248; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box8(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 254; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    public static void box9(int boxSymbol, char[] poz, char sym) {
        //boxSymbol == 1 for X
        //boxSymbol ==0 for O
        int k; //this use for poz in array
        int startAt = 260; //this indicates point for start drawing box
        //this use for framing box
        switch (boxSymbol) {
            case 1:
                k = startAt;
                for (int i = 1; i <= 9; i++) {
                    switch (i) {
                        case 1:
                            break;
                        case 2:
                        case 9:
                            k += 4;
                            break;
                        case 3:
                        case 8:
                            k += 16;
                            break;
                        case 4:
                        case 7:
                            k += 2;
                            break;
                        case 5:
                        case 6:
                            k += 18;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
            case 0:
                k = startAt; //reset poz on array
                for (int i = 1; i <= 12; i++) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            k++;
                            break;
                        case 4:
                        case 10:
                            k += 16;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            k += 4;
                            break;
                        case 6:
                        case 8:
                            k += 15;
                            break;
                        case 11:
                        case 12:
                            k += 1;
                            break;
                    }
                    poz[k] = sym;
                }
                break;
        }
    }

    //these methods are use for draw line over row of three consecutive symbols
    //when someone win
    public static void drawLineWin1(char[] poz, int possition) {
        //start from possition 58
        for (int step = 0; step < 17; step++, possition++) {
            poz[possition] = symbolLineWin;
        }
    }

    public static void drawLineWin2(char[] poz, int possition) {
        for (int step = 0; step < 17; step++, possition += 19) {
            poz[possition] = symbolLineWin;
        }
    }

    public static void drawLineWin3(char[] poz, int possition) {
        for (int step = 0; step < 15; step++, possition += 20) {
            poz[possition] = symbolLineWin;
        }
    }

    public static void drawLineWin4(char[] poz, int possition) {
        for (int step = 0; step < 17; step++, possition += 19) {
            poz[possition] = symbolLineWin;
        }
    }

    public static void drawLineWin5(char[] poz, int possition) {
        for (int step = 0; step < 15; step++, possition += 18) {
            poz[possition] = symbolLineWin;
        }
    }

    public static void drawLineWin6(char[] poz, int possition) {
        for (int step = 0; step < 17; step++, possition += 19) {
            poz[possition] = symbolLineWin;
        }
    }

    public static void drawLineWin7(char[] poz, int possition) {
        for (int step = 0; step < 17; step++, possition++) {
            poz[possition] = symbolLineWin;

        }
    }

    public static void drawLineWin8(char[] poz, int possition) {
        for (int step = 0; step < 17; step++, possition++) {
            poz[possition] = symbolLineWin;

        }
    }

}
