import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private int[][] board;

    private Scanner input;

    public Board(){
        this.board = new int[3][3];
    }

    public Board(int[][] board){
        this.board = board;
    }

    //TODO: make sure the board has only values from 0-8.
    public void initBoard(){
        input = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println("Enter the value at " + i + " " + j + "(0-8): ");
                this.board[i][j] = input.nextInt();
            }
        }

        input.close();
    }

    public void printBoard(){
        System.out.println("Board: \n\n");

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.board[i][j] == 0){
                    System.out.print("  ");
                } else {
                    System.out.print(this.board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private boolean isMoveValid(int tile_x, int tile_y){
        int zero_x = 0;
        int zero_y = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.board[i][j] == 0){
                    zero_x = i;
                    zero_y = j;
                }
            }
        }

        if((zero_x + tile_x > 1) || (zero_y + tile_y > 1)){
            return false;
        }

        return true;
    }

    public ArrayList<Board> getMoves(){
        ArrayList<Board> moves = new ArrayList<Board>();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.board[i][j] == 0){
                    continue;
                }

                if(isMoveValid(i, j)){
                    Board newBoard = new Board(this.board);
                    newBoard.board[i][j] = 0;
                    newBoard.board[zero_x + i][zero_y + j] = this.board[i][j];
                    moves.add(newBoard);
        
        return moves;
    }

    public boolean isGoal(){
        int[][] goal = {{6, 5, 4}, {7, 0, 3}, {8, 1, 2}};

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.board[i][j] != goal[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
