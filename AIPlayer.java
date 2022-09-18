import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char symbol, Board board, String name){
        super(symbol, board, name);
    }

    public void makeMove(Board board){

        if (board.winAvailable(symbol) != 0){
            board.move(symbol, board.winAvailable(symbol));
        }
        else{
            Random r = new Random();
            board.move(symbol, r.nextInt(board.getBoardWidth()) + 1);
        }

    }

}