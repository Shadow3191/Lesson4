package pl.lesson4.kwasny.pawel;

public class Board {
    private Field[][] fields = new Field[3][3];
    static boolean win = false;

    public void add(Sign sign, int column, int row) {
        do {
            if (fields[column][row] != null) {
                System.out.println("This field is taken, chose another field");
                ChangePlayer.changePlayer();

            } else {
                fields[column][row] = new Field(sign);
            }
        } while (fields[column][row] == null);
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

    static boolean continueGame = false;

    public boolean checkColumnWinner(Player currentPlayer) {
        for (int column = 0; column < fields.length; column++) {
            int count = 0;
            for (int row = 0; row < fields.length; row++) {
                if (fields[column][row] == null) {
                    continue;
                } else if ((fields[column][row].getSign().getMark() == currentPlayer.getSign().getMark())) {
                    count++;
                    if (count == 3) {
                        win = true;
                    }
                } else {
                    count = 0;
                    break;
                }
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
        }
        return false;
    }

    public boolean checkRowWinner(Player currentPlayer) { // dodac parametr - przekazywac dla kogo sprawdzam winnera
        for (int row = 0; row < fields.length; row++) {
            int count = 0;
            for (int column = 0; column < fields.length; column++) {
                if (fields[column][row] == null) {
                    continue;
                } else if ((fields[column][row].getSign().getMark() == currentPlayer.getSign().getMark())) { // teraz porownuje znak ktory ma obecny player
                    count++;
                    if (count == 3) {
                        win = true;
                    }
                } else {
                    count = 0;
                    break;
                }
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }

        }
        return false;
    }

    public boolean checkRightSlant(Player currentPlayer) {
        int count = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][i] == null) {
                continue;
            } else if ((fields[i][i].getSign().getMark() == currentPlayer.getSign().getMark())) {
                count++;
                if (count == 3) {
                    win = true;
                }
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
        }
        return false;
    }

    public boolean checkLeftSlant(Player currentPlayer) {
        int count = 0;
        win = true;
        int row = 0;
        for (int column = fields.length - 1; column >= 0; column--) {

            if (fields[column][row] == null) {
                row++;
                continue;
            } else if ((fields[column][row].getSign().getMark() == currentPlayer.getSign().getMark())) {
                count++;
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
            row++;
        }
        return false;
    }

    public boolean checkDraw() {
        int count = 0;
        for (int column = 0; column < fields.length; column++) {
            for (int row = 0; row < fields.length; row++) {
                if (fields[column][row] != null) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("Draw, no one won.");
            show();
            continueGame = true;
            return true;
        } else {
            return false;
        }
    }


    public boolean checkWinner(Player currentPlayer) {
        for (int column = 0; column < fields.length; column++) {
            int count = 0;
            for (int row = 0; row < fields.length; row++) {
                if (fields[column][row] == null) {
                    continue;
                } else if ((fields[column][row].getSign().getMark() == currentPlayer.getSign().getMark())) {
                    count++;
                    if (count == 3) {
                        win = true;
                    }
                } else {
                    count = 0;
                    break;
                }
            }

            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
        }

        for (int row = 0; row < fields.length; row++) {
            int count = 0;
            for (int column = 0; column < fields.length; column++) {
                if (fields[column][row] == null) {
                    continue;
                } else if ((fields[column][row].getSign().getMark() == currentPlayer.getSign().getMark())) {
                    count++;
                    if (count == 3) {
                        win = true;
                    }
                } else {
                    count = 0;
                    break;
                }
            }

            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
        }

        int count = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][i] == null) {
                continue;
            } else if ((fields[i][i].getSign().getMark() == currentPlayer.getSign().getMark())) {
                count++;
            }
            if (count == 3) {
                win = true;
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
        }

        count = 0;
        int row = 0;
        for (int column = fields.length - 1; column >= 0; column--) {
            if (fields[column][row] == null) {
                row++;
                continue;
            } else if ((fields[column][row].getSign().getMark() == currentPlayer.getSign().getMark())) {
                count++;
                if (count == 3){
                    win = true;
                }
            }
            if (win == true && count == 3) {
                System.out.println("You Win! Congratulations.");
                show();
                continueGame = true;
                return true;
            }
            row++;
        }

        count = 0;
        for (int column = 0; column < fields.length; column++) {
            for (row = 0; row < fields.length; row++) {
                if (fields[column][row] != null) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("Draw, no one won.");
            show();
            continueGame = true;
            return true;
        } else {
            return false;
        }

    }
}

