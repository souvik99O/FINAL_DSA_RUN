class Solution {
    public void solveSudoku(char[][] board) {
       solve(board); 
    }

   public static boolean solve(char board[][])
    {
        for(int row=0; row<board.length;row++)
        {
            for(int col=0;col<board.length;col++)
            {
                if(board[row][col]=='.')
                {
                    for(int k=1; k<=9;k++)
                    {
                        if(canPlace(board,k,row,col))
                        {
                            board[row][col]= (char) ('0' + k );
                            if(solve(board)==true)
                            return true;
                            else
                            {
                             board[row][col]= '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canPlace(char board[][], int k, int row, int col) {
    boolean rowCheck = false;
    boolean colCheck = false;
    boolean matCheck = false;
    
    char digit = (char)('0' + k); // Convert int k to char
    
    // Row check
    for(int i = 0; i < 9; i++) {
        if(board[row][i] == digit) {
            rowCheck = false;
            break;
        }
        rowCheck = true;
    }
    
    // Column check
    for(int i = 0; i < 9; i++) {
        if(board[i][col] == digit) {
            colCheck = false;
            break;
        }
        colCheck = true;
    }
    
    // 3x3 matrix check
    int startRow = (row / 3) * 3;  // Find starting row of 3x3 box
    int startCol = (col / 3) * 3;  // Find starting column of 3x3 box
    
    for(int i = startRow; i < startRow + 3; i++) {
        for(int j = startCol; j < startCol + 3; j++) {
            if(board[i][j] == digit) {
                matCheck = false;
                return false; // Early exit if found
            }
        }
    }
    matCheck = true;
    
    return rowCheck && colCheck && matCheck;
}



}