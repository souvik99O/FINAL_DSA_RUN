class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = BS(0, matrix.length - 1, target, matrix, matrix[0].length - 1);
        System.out.println(rowIndex);
        
        if (rowIndex == 300)
            return true;
        
        if (rowIndex == -1)
            return false;
            
        int result = binarySearch(matrix[rowIndex], target);
        return result != -1;
    }

    public int BS(int rowstart, int rowend, int target, int[][] mat, int colend) {
        if (rowstart > rowend)
            return -1;
            
        if (rowstart == rowend) {
            // Check if target can be in this row
            if (target >= mat[rowstart][0] && target <= mat[rowstart][colend])
                return rowstart;
            else
                return -1;
        }

        int rowmid = (rowstart + rowend) / 2;
        
        if (target > mat[rowmid][colend]) {
            return BS(rowmid + 1, rowend, target, mat, colend);
        } else if (target < mat[rowmid][0]) {
            return BS(rowstart, rowmid - 1, target, mat, colend);
        } else if (target == mat[rowmid][colend]) {
            return 300;  // Found exact match in last column
        } else {
            // target is between first and last element of this row
            return rowmid;
        }
    }

    public int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1; // Not found
    }
}