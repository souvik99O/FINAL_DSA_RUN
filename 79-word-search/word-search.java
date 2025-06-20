class Solution {
    public boolean exist(char[][] board, String word) {

        int copyVisitStartingPoint[][] = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copyVisitStartingPoint[i][j] = 0;
            }
        }

        int wPtr = 0;
        char w[] = word.toCharArray();

        return f1(board, w, wPtr, copyVisitStartingPoint);

    }

    public static boolean f1(char[][] board, char[] w, int wPtr, int[][] copyVisitStartingPoint) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[wPtr] && copyVisitStartingPoint[i][j] != 1) {
                    copyVisitStartingPoint[i][j] = 1;
                    wPtr++;

                    if (f(board, i, j, w, wPtr, copyVisitStartingPoint) == true)
                        return true;
                    else {
                        wPtr--;
                        copyVisitStartingPoint[i][j] = 0;
                    }
                }
            }
        }
        return false;

    }

    public static boolean f(char[][] board, int row, int col, char[] w, int wPtr, int[][] visited) {
        if (wPtr >= w.length) {
            return true;
        }

        if (up(board, row, col, w, wPtr, visited)) {
            // move up
            visited[row - 1][col] = 1;
            wPtr++;
            if (f(board, row - 1, col, w, wPtr, visited) == true)
                return true;
            else {
                visited[row - 1][col] = 0;
                wPtr--;
            }
        }

        if (down(board, row, col, w, wPtr, visited)) {
            // move down
            visited[row + 1][col] = 1;
            wPtr++;
            if (f(board, row + 1, col, w, wPtr, visited) == true)
                return true;
            else {
                visited[row + 1][col] = 0;
                wPtr--;
            }
        }

        if (right(board, row, col, w, wPtr, visited)) {
            // move right
            visited[row][col + 1] = 1;
            wPtr++;
            if (f(board, row, col + 1, w, wPtr, visited) == true)
                return true;
            else {
                visited[row][col + 1] = 0;
                wPtr--;
            }
        }

        if (left(board, row, col, w, wPtr, visited)) {
            // move left
            visited[row][col - 1] = 1;
            wPtr++;
            if (f(board, row, col - 1, w, wPtr, visited) == true)
                return true;
            else {
                visited[row][col - 1] = 0;
                wPtr--;
            }
        }

        return false;
    }

    public static boolean up(char[][] board, int row, int col, char[] w, int wPtr, int[][] visited) {
        int newRow = row - 1;
        // Check if not out of matrix bounds AND character matches
        return (newRow >= 0) &&
                (visited[newRow][col] != 1) &&
                (board[newRow][col] == w[wPtr]);
    }

    public static boolean down(char[][] board, int row, int col, char[] w, int wPtr, int[][] visited) {
        int newRow = row + 1;
        // Check if not out of matrix bounds AND character matches
        return (newRow < board.length) &&
                (visited[newRow][col] != 1) &&
                (board[newRow][col] == w[wPtr]);
    }

    public static boolean right(char[][] board, int row, int col, char[] w, int wPtr, int[][] visited) {
        int newCol = col + 1;
        // Check if not out of matrix bounds AND character matches
        return (newCol < board[0].length) &&
                (visited[row][newCol] != 1) &&
                (board[row][newCol] == w[wPtr]);
    }

    public static boolean left(char[][] board, int row, int col, char[] w, int wPtr, int[][] visited) {
        int newCol = col - 1;
        // Check if not out of matrix bounds AND character matches
        return (newCol >= 0) &&
                (visited[row][newCol] != 1) &&
                (board[row][newCol] == w[wPtr]);
    }

}
