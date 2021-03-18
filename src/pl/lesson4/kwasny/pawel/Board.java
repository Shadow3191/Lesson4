package pl.lesson4.kwasny.pawel;

public class Board {
    private Field[][] fields = new Field[3][3];
    int count = 0;

    public void add(Sign sign, int column, int row) {
        fields[column][row] = new Field(sign);
        count++;
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
//            System.out.println("+-+-+-+");
        }
        System.out.println("---------");

        /*
       +------------+
       | X | X | X |
       +------------+
       | X | X | X |
       +------------+
       | X | X | X |
       +------------+

        */
    }

    public void checkWinner() {
        for (int row = 0; row < fields.length; row++){
            boolean win = true;
            for (int column = 0; column < fields.length; column++){
                if (fields[column][row] == null){
                    continue;
                } else if ((fields[row][column].getSign().getMark() != Sign.CROSS.getMark())){
                    win = false;
                    break;
                }
            }
        }
    }
}
//}
