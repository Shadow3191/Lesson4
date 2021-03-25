package pl.lesson4.kwasny.pawel;

public class Board {
    private Field[][] fields = new Field[3][3];
    int countMoves = 0;
    static boolean win;

    public void add(Sign sign, int column, int row) {
        if (fields[column][row] == null) {
            fields[column][row] = new Field(sign);
            countMoves++;
        } else {
            System.out.println("This field is taken, chose another field");
        }
    }

    public void show() {
        System.out.println("---------");

        for (int row = 0; row < fields.length; row++) {
            System.out.print("|");
            for (int column = 0; column < fields.length; column++) {
                if (fields[column][row] == null) {
                    System.out.print(" |");

                } else {
                    System.out.print(fields[column][row].getSign().getMark() + "|"); // obiekt ktory jest nullem i wywolam na nim metode to mam NullPointException
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public boolean checkColumnWinner() {
        for (int column = 0; column < fields.length; column++) {
            win = true;
            int count = 0;
            for (int row = 0; row < fields.length; row++) {
                if (fields[column][row] == null) {
                    continue;
                } else if ((fields[column][row].getSign().getMark() == Sign.CROSS.getMark())) {
                    count++;
                } else {
                    win = false;
                    count = 0;
                    break;
                }
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                return true;
            }
        }
        return false;
    }

    public boolean checkRowWinner() {
        for (int row = 0; row < fields.length; row++) {
            win = true;
            int count = 0;
            for (int column = 0; column < fields.length; column++) {
                if (fields[column][row] == null) {
                    continue;
                } else if ((fields[column][row].getSign().getMark() == Sign.CROSS.getMark())) {
                    count++;
                } else {
                    win = false;
                    break;
                }
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                return true;
            }
        }
        return false;
    }

    public boolean checkRightSlant() {
        int count = 0;
        for (int i = 0; i < fields.length; i++) {
            win = true;
            if (fields[i][i] == null) {
                continue;
            } else if ((fields[i][i].getSign().getMark() == Sign.CROSS.getMark())) {
                count++;
            } else {
                win = false;
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                return true;
            }
        }
        return false;
    }

    public boolean checkLeftSlant() {
        int count = 0;
        win = true;
        int row = 0;
        for (int column = fields.length-1; column >= 0; column--) {

            if (fields[column][row] == null) {
                row++;
                continue;
            } else if ((fields[column][row].getSign().getMark() == Sign.CROSS.getMark())) {
                count++;
            } else {
                win = false;
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                return true;
            }
            row++;
        }
        return false;
    }

//    public boolean gameContinuation(){
//        if (checkRightSlant() == false){
//            return false;
//        } else if (checkLeftSlant() == false){
//            return false;
//        } else if (checkRowWinner() == false) {
//            return false;
//        } else if (checkColumnWinner() == false){
//            return false;
//        } else {
//            return true;
//        }
//    }
}

