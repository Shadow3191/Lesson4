package pl.lesson4.kwasny.pawel;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Player firstPlayer = new Player(Sign.CROSS);
    private static Player secondPlayer = new Player(Sign.CIRCLE);
    private static Player currentPlayer = firstPlayer;

    public static void main(String[] args) {
	/*
	Napisz grę w kółko i krzyżyk :
	O - kółko
	X - krzyżyk
	Liniami odrysowaćtablicę a "+" kąty
	Po każdym ruchu tabela ma się odświerzać aż ktoś wygra lub przegra albo zremisuje. Przy starcie gry pojawia się pusta plansza.
	Na początku losuję jaka figira losuje i piszę kogo ruch czyli osoby która ma daną figurę. Pytam na jaką pozycję wstawić kółko
	pozycje określam kolumnami ABC i wiersze 123 i pytam o kolumnę i wiersz gdzie wstawić, sprawdzenie czy jest wygrana i pytam kolejnego
	gracza aż do remisu lub wygranej. Położyć nacisk na obiektowość czyli plansza, pole i gracz są obiektami.
	*/

//         Dopracować kreski między znakami

//        Player firstPlayer = new Player(Sign.CROSS);
//        Player secondPlayer = new Player(Sign.CIRCLE);
//        Player currentPlayer = firstPlayer;
        Board board = new Board();
//        board.add(Sign.CIRCLE,0, 0);
//        board.add(Sign.CROSS,0, 1);
//        board.add(Sign.CIRCLE,0, 2);
//        board.add(Sign.CIRCLE,1, 0);
//        board.add(Sign.CROSS,1, 1);
//        board.add(Sign.CIRCLE,1, 2);
//        board.add(Sign.CIRCLE,2, 0);
//        board.add(Sign.CROSS,2, 1);
//        board.add(Sign.CIRCLE,2, 2);
//        board.show();


        boolean shouldContinue = true;

        do {
//            1. showBoard  - mam
            board.show();
//            2. get coordinate from player
            System.out.println("Player : " + currentPlayer.getSign().getMark());
            int column = getColumn();
            int row = getRow(); // ten proces to refactoring - wydzielanie fragmenty logiczne do mniejszych metod

//            2.1 wstaw znak gracza na borda (add) - mam
            board.add(currentPlayer.getSign(), column,row);

//            3. sprawdz kto wygrał lub zremisował   - do domu
//            for (int chechWin = 0; chechWin < f)

//            4. wypisz kto wygrał lub że był remis jeśli tak było i zakończ gę     - do domu
//            Przy 4 założeniu zmieniam shouldContunous na false
//            muszę zrobić sprawdzenie czy toś wygrał
//            5. zmień gracza na przeciwnego - tutaj first będzie secound a jak był secound to zmienia gracza na first (currentPlayes);
//            if (currentPlayer == firstPlayer){  // 55 - 59 zrobić metodę chandePlayer
//                currentPlayer = secondPlayer;
//            } else {
//                currentPlayer = firstPlayer;
//            }
            changePlayer();

// gra do dokończenia jeśli mało to napisać jeszcze warcaby
//  ekstrachowanie - wydzielanie fragmentu kodu do osobnych metod na przykladzie pobierania kolumny :

/*
1. Zrobić planszę do gry i przypisać że białe mogą tylko po białych a czarne po czarnych symulować znaczek na białe i czarne
2. Zrobić sobie tablicę i wypisać które pola są dla białych i dać info czy może to wchodzić czy nie
3.
**/
        } while (shouldContinue);

    }
    private static int getRow(){
        System.out.println("Insert row : ");
        return scanner.nextInt();
    }

    private static int getColumn(){
        System.out.println("Insert column : ");
        return scanner.nextInt();
    }

    private static void changePlayer(){
        if (currentPlayer == firstPlayer){  // 55 - 59 zrobić metodę chandePlayer
            currentPlayer = secondPlayer;
        } else {
            currentPlayer = firstPlayer;
        }
    }

    private static void checkWin(){
//        for (int checkColumn = 0; checkColumn <  )
    }
}
