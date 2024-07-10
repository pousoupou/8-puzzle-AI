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
                if(i == 1 && j == 1){
                    this.board[i][j] = 0;
                    continue;
                }
                
                System.out.println("Enter the value at " + i + " " + j + "(1-8): ");
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

    private int zeroLocation(){
        int zero_x = 0;
        int zero_y = 0;

        int location = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.board[i][j] == 0){
                    zero_x = i;
                    zero_y = j;
                }
            }
        }

        location = zero_x * 10 + zero_y;
        return location;
    }

    private boolean isMoveValid(int tile_x, int tile_y){
        int zero_x = 0;
        int zero_y = 0;
        int location = this.zeroLocation();

        zero_x = location / 10;
        zero_y = location % 10;

        if((zero_x + tile_x > 1) || (zero_y + tile_y > 1)){
            return false;
        }

        return true;
    }

    public ArrayList<Board> getMoves(){
        int zero_x = 0;
        int zero_y = 0;
        int location = this.zeroLocation();

        ArrayList<Board> moves = new ArrayList<Board>();

        zero_x = location / 10;
        zero_y = location % 10;

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
                }
            }
        }
        
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
