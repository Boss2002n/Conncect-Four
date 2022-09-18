import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name){
        super(symbol, board, name);
    }

    public void makeMove(Board board){
        Scanner x = new Scanner(System.in);
        System.out.print(getName() + ", please enter your move: ");

        int move = x.nextInt();
        while(move < 1 || move > 7 || board.columnFilled(move) && !board.isTie()){
            System.out.println("Invalid input.");
            System.out.print(getName() + ", please enter your move: ");
            move = x.nextInt();
        }
        board.move(symbol, move);
    }

}
