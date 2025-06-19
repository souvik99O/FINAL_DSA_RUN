class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        List<List<String>> ansBoards = new ArrayList<>();
        
        //creating the board to try out all combos----------------------------
        for(int i=0; i<n; i++)
        {
            List<String> ele = new ArrayList<>();
            for(int j=0; j<n ;j++)
            {
                ele.add(".");
            }
            board.add(ele);
        }
        //-----------------------------------------------

        f(0,board,n,ansBoards);


       return ansBoards; 
    }
    public static void f(int col,List<List<String>> board, int n,List<List<String>> ansBoards)
    {
        if(col>=n)
        {
           List<String> solution = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String str = String.join("", board.get(i));
                solution.add(str);
            }
            ansBoards.add(solution);
            return;
        }


        for(int row=0; row<n; row++)
        {
            if(canPlace(board, row, col, n))
            {
                board.get(row).set(col,"Q");
                f(col+1,board,n,ansBoards);
                board.get(row).set(col,".");
            }
            
            
        }
    }

        public static boolean canPlace(List<List<String>> board, int row, int col, int n) {
        // Check row (left side only, since we're filling column by column)
        for(int j = 0; j < col; j++) {
            if(board.get(row).get(j).equals("Q")) {
                return false;
            }
        }
        
        // Check upper diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).get(j).equals("Q")) {
                return false;
            }
        }
        
        // Check lower diagonal
        for(int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if(board.get(i).get(j).equals("Q")) {
                return false;
            }
        }
        
        return true;
    }
}