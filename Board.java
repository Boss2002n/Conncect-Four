public class Board {

	private final int cols = 7;
	private final int rows = 6;
	private char[][] board;

	
	public Board() {
		 board = new char[rows][cols];
		 reset();
	}

	public void printBoard() {
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++ ){
				if(i + 1 == rows && board[i][j] == ' '){
					System.out.print("|_");
				}
				else {
					System.out.print("|" + board[i][j]);
				}
			}
			System.out.println("|");
		}
	}


	public boolean containsWin() {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3]){
						return true;
					}
				}
			}
		}


		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length - 3; j++){
				if(board[j][i] != ' '){
					if(board[j][i] == board[j + 1][i] && board[j + 1][i] == board[j + 2][i] && board[j + 2][i] == board[j + 3][i]){
						return true;
					}
				}
			}
		}


		for(int i = 0; i < board.length - 3; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]){
						return true;
					}
				}
			}
		}

		for(int i = 3; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]){
						return true;
					}
				}
			}
		}

		return false;
	}


	public boolean isTie() {
		int moves = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] != ' '){
					moves++;
				}
			}
		}
		if(board[0].length * board.length == moves){
			return true;
		}
		else{
			return false;
		}
	}

	public void reset() {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = ' ';
			}
		}
	}


	public void move(char symbol, int move){
		for(int i = board.length - 1; i >= 0; i--){
			if(board[i][move - 1] == ' '){
				board[i][move - 1] = symbol;
				return;
			}
		}
	}

	public boolean columnFilled(int move){
		for(int i = 0; i < board.length; i++){
			if(board[i][move - 1] == ' '){
				return false;
			}
		}
		return true;
	}


	public int winAvailable(char symbol){
		for(int i = 0; i < board[0].length; i++){
			char[][] temp = new char[board.length][board[0].length];

			for(int x = 0; x < board.length; x++){
				for(int y = 0; y < board[0].length; y++){
					temp[x][y] = board[x][y];
				}
			}


			for(int j = temp.length - 1; j > 0; j--){
				if(temp[j][i] == ' '){
					temp[j][i] = symbol;
					break;
				}
			}

			if(arrayContainsWin(temp)){
				System.out.println("Making a winning move.");
				return i + 1;
			}
		}


		symbol = getOtherSymbol(symbol);
		if(symbol != 0) {

			for (int i = 0; i < board[0].length; i++) {
				char[][] temp = new char[board.length][board[0].length];

				for (int x = 0; x < board.length; x++) {
					for (int y = 0; y < board[0].length; y++) {
						temp[x][y] = board[x][y];
					}
				}

				for (int j = temp.length - 1; j > 0; j--) {
					if (temp[j][i] == ' ') {
						temp[j][i] = symbol;
						break;
					}
				}

				if (arrayContainsWin(temp)) {
					System.out.println("Blocking a winning move.");
					return i + 1;
				}
			}
		}

		return 0;
	}

	private boolean arrayContainsWin(char[][] board) {

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3]){
						return true;
					}
				}
			}
		}

		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length - 3; j++){
				if(board[j][i] != ' '){
					if(board[j][i] == board[j + 1][i] && board[j + 1][i] == board[j + 2][i] && board[j + 2][i] == board[j + 3][i]){
						return true;
					}
				}
			}
		}


		for(int i = 0; i < board.length - 3; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]){
						return true;
					}
				}
			}
		}

		for(int i = 3; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if(board[i][j] != ' '){
					if(board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]){
						return true;
					}
				}
			}
		}

		return false;
	}

	public int getBoardWidth(){
		return cols;
	}

	private char getOtherSymbol(char symbol){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] != symbol && board[i][j] != ' '){
					return board[i][j];
				}
			}
		}
		return 0;
	}
}
