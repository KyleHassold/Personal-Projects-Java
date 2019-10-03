import java.lang.Math;
import java.util.Scanner;
import java.io.*;
public class problemOne {

    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        dataRequest();
    
    }
    public static void dataRequest(){
        try {
            FileReader file = new FileReader("sample1.txt");
            BufferedReader read = new BufferedReader(file);
            
            int datasets = Integer.parseInt(read.readLine()); //How many datasets
            System.out.println("Analyzing " + datasets + " data set(s)");
            
            for(int d=0; d<datasets; d++) {
                System.out.println("Data Set " + (d+1));
                String[] dim = new String[2]; //variable to store the string version of the dimensions
                dim = read.readLine().split(" "); //Seperates dimensions within the line
                int col = Integer.parseInt(dim[0]);
                int row = Integer.parseInt(dim[1]);
                
                int[][] board = new int[row][col]; //sets up a board of ints
                
                int elmSiz = Integer.parseInt(read.readLine()); //size a row or column has to be to be eliminated
                int rowSiz = Integer.parseInt(read.readLine()); //how many rows are defined with values
                
                String[] data = new String[col]; //gets initial board values
                for(int y=(row-rowSiz); y<row; y++) {
                    data = read.readLine().split(" ");
                    for(int x=0; x<col; x++) {
                        board[y][x] = Integer.parseInt(data[x]);
                    }
                }
                
                int numMove = Integer.parseInt(read.readLine()); //gets move set
                String[] moveData = new String[numMove];
                int[][] coors = new int[numMove][4];
                for(int y=0; y<numMove; y++) {
                    moveData = read.readLine().split(" ");
                    for(int x=0; x<4; x++) {
                        coors[y][x] = Integer.parseInt(moveData[x]);
                    }
                    coors[y][1] = row-1-coors[y][1];
                    coors[y][3] = row-1-coors[y][3];
                }
                printBoard(board);
                
                System.out.println("After move 0:");
                board = move(board, coors, 0, elmSiz); //Runs initial move
                for(int m=0; m<numMove; m++) {
                    System.out.println("After move " + (m+1) + ":");
                    board = move(board, coors, m+1, elmSiz); //Runs all given moves
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static int[][] move(int[][]board, int[][] coors, int m, int elmSiz) {
        int[][] newBoard = new int[board.length][board[0].length];
        if (m!=0) {
            m--;
            newBoard = movePiece(board, coors[m]);
            if (newBoard == board) {
                return board;
            } else {
                board = newBoard;
                printBoard(board);
            }
        }
        board = drops(board);
        board = elims(board, elmSiz);
        return board;
    }
    
    public static int[][] movePiece(int[][] board, int[] coors) {
        if (!(coors[0] < board[0].length && coors[0] >= 0) || !(coors[2] < board[0].length && coors[2] >= 0)) { //Check is coordinates are inbounds
            System.out.println("Move is invalid.1");
            return board;
        } else if (!(coors[1] < board.length && coors[1] >= 0) || !(coors[3] < board.length && coors[3] >= 0)) {
            System.out.println("Move is invalid.2");
            return board;
        }
        
        if (Math.abs(coors[0]-coors[2]) + Math.abs(coors[1]-coors[3]) > 1 ) { //Checks if the coords are one spot away
            System.out.println("Move is invalid.3");
            return board;
        }
        
        if (board[coors[0]][coors[1]] == 0) { //Checks if the piece being moved exists
            System.out.println("Move is invalid.4");
            return board;
        }
        
        int temp = board[coors[1]][coors[0]];
        board[coors[1]][coors[0]] = board[coors[3]][coors[2]];
        board[coors[3]][coors[2]] = temp;
        System.out.println("Move sucessful.");
        printBoard(board);
        return board;
    }
    public static int[][] drops(int[][] board){
        int[][] boardCheck = board;
        boolean change = false;
        do{
            
            for (int x=board.length-1; x > 1; x--){
                for (int y = board[0].length-1; y > 1; y--){
                    if(boardCheck[x][y] != 0){
                        if(boardCheck[x-1][y] == 0){
                            boardCheck[x-1][y] = boardCheck[x][y];
                            boardCheck[x][y] = 0;
                            change = true;
                        }
                    }
                    else if (!(boardCheck[x][y] != 0) && x == board[0].length-1 && y == board[x].length)
                    {
                        change = false;
                    }
                        
                }
            }
            
        }while(change);
        if (!change)
            System.out.println("No drops.");
        return board;
    }
    
    public static int[][] elims(int[][] board, int elmSiz) {
        boolean change = false;
        for(int x=0; x<board.length-elmSiz; x++) {
            for(int y=0; y<board.length; y++) {
                int i = 0;
                while(board[x][y] == board[x+i+1][y]) {
                    i++;
                }
                if (i >= elmSiz) {
                    change = true;
                    for (int j=0; j<=i; j++) {
                        board[x+i][y] = 0;
                    }
                }
            }
        }
        if (!change) {
            System.out.println("No eliminations.");
        } else {
            System.out.println("Board after eliminations:");
            printBoard(board);
        }
        return board;
    }
    
    public static void printBoard(int[][] board) { //prints the given 2D array
        System.out.println("Board Position:");
        for(int y=0; y<board.length; y++) {
            for(int x=0; x<board[0].length; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.println();
        }
    }
}