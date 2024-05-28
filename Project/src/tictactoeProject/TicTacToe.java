package tictactoeProject;

import java.util.Random;
import java.util.Scanner;

class TicTac{
	static char[][]board;
	
	public TicTac() {
		board=new char[3][3];
		
		initBoard();
	}
	//initializing board with spaces rather than unicode/empty
	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
			
		}
	}
static void display_Board() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j] +" | ");
			}
			System.out.println();
			System.out.println("-------------");
			
		}
	}
	
	static void placeMark(int row,int col,char mark) {
		if(row>=0&&row<3&&col>=0&&col<3) {
		board[row][col]=mark;
	}
		else {
			System.out.println("invalid position");
		}
	}
	
	//checking for win condition
	static boolean checkColWin() {
		for(int j=0;j<=2;j++) {
			if(board[0][j]!=' '&&board[0][j]==board[1][j]&& board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
		
	}
	static boolean checkRowWin() {
		for(int i=0;i<=2;i++) {
			if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}

	static boolean diagonalWin() {
		if(board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2]||board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]) {
			return true;
		}
		return false;
	}
	
	static boolean checkDraw() {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
}


//parent class
abstract class Player{
	String name;
	char mark;
	
	abstract void makeMove() ;
boolean isValidMove(int row,int col) {
		
		if(row>=0&&row<=2&&col>=0&&col<=2) {
			if(TicTac.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
}


class HumanPlayer extends Player{
	
	
	public HumanPlayer(String name,char mark) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.mark=mark;
	}
	
	void makeMove() {
		Scanner scan = new Scanner(System.in);
		int row=0;
		int column=0;
		do {
			System.out.println("Enter the row and column");
			row=scan.nextInt();
			column=scan.nextInt();
			
		}
		while(!isValidMove(row, column)) ;
		TicTac.placeMark(row, column, mark);	
		
	}
	
	
}

class AIPlayer extends Player{

	
	public AIPlayer(String name,char mark) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.mark=mark;
	}
	
	void makeMove() {
		Scanner scan = new Scanner(System.in);
		int row=0;
		int column=0;
		do {
			Random r = new Random();
			row = r.nextInt(3);
			column=r.nextInt(3);
			
			
		}while(!isValidMove(row, column)) ;
		TicTac.placeMark(row, column, mark);	
		
	}

}



class TicTacToe {
	public static void main(String[] args) {
		TicTac t = new TicTac();
		HumanPlayer p1 = new HumanPlayer("Bob", 'X');
//		HumanPlayer p2 = new HumanPlayer("Alex", 'O');
		AIPlayer p2 = new AIPlayer("TAI", 'O');
		Player cp;
		cp=p1;
		
		while(true) {
			System.out.println(cp.name+" turn");
			cp.makeMove();
			TicTac.display_Board();
			
			if(TicTac.checkColWin()||TicTac.checkRowWin()||TicTac.diagonalWin()) {
				System.out.println(cp.name+" Has Won");
				break;
			}
			
			else if(TicTac.checkDraw()) {
				System.out.println("Game is Draw!");
				break;
			}
			else {
				if(cp==p1) {
					cp=p2;
				}
				else {
					cp=p1;
				}
			}
		}	
	}
}
