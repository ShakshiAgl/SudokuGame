public class SudokuGame {
    private static final int n = 9;

    public static void main(String[] args){
        int [][]board = {
             {3,0,6,5,0,8,4,0,0},
             {5,2,0,0,0,0,0,0,0},
             {0,8,7,0,0,0,0,3,1},
             {0,0,3,0,1,0,0,8,0},
             {9,0,0,8,6,3,0,0,5},
             {0,5,0,0,9,0,6,0,0},
             {1,3,0,0,0,0,2,5,0},
             {0,0,0,0,0,0,0,7,4},
             {0,0,5,2,0,6,3,0,0}
         };
         printBoard(board);
         if(solveBoard(board)){
            System.out.println("The solved sudoku is: ");
            System.out.println();
        }
            else{
            System.out.println("The input is an unsolvable Sudoku board");
            System.out.println();
        }
        printBoard(board);
         }

         private static void printBoard(int [][]board){
            for( int row=0; row<n; row++){
                if(row%3==0 && row!=0){
                    System.out.println("............");
                }
                for(int col=0;col<n;col++){
                    if(col%3==0 && col!=0){
                        System.out.print("|");
                    }
                    System.out.print(board[row][col]);
                }
                System.out.println();
            }
         }

         private static boolean isNumInRow(int[][] board,int number,int row){
            for(int i = 0;i<n; i++ ){
                if(board[row][i]==number){
                    return true;
                }
            }
            return false;
        }
        private static boolean isNumInCol(int[][] board,int number, int col){
            for(int i = 0; i<n; i++){
                if(board[i][col]==number){
                    return true;
                }
            }
            return false;
        }
        private static boolean isNumInBox(int [][]board,int number,int row,int col){
            int gridRowBox = row - row % 3;
            int gridColBox = col - col % 3;
            for(int i=gridRowBox; i<gridRowBox+3; i++){
                for(int j = gridColBox; j<gridColBox+3; j++){
                    if(board[i][j]==number){
                    return true;
                }
            }
        }
        return false;
        }
    private static boolean isValidPlacement(int [][]board,int number, int row, int col){
        return !isNumInRow(board,number,row) &&
        !isNumInCol(board,number,col)&&
        !isNumInBox(board,number,row,col);
    }
    private static boolean solveBoard (int[][] board){
        for(int row=0; row<n; row++){
            for(int col= 0; col<n; col++){
                if(board[row][col]==0){
                    for(int numberToTry=1; numberToTry<=n; numberToTry++){
                        if(isValidPlacement(board,numberToTry,row,col)){
                            board[row][col] = numberToTry;
                            if(solveBoard(board)){
                                return true;
                            }else{
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
            return true;
    }
}
