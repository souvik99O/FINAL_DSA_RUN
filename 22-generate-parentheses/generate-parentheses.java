class Solution {
    List<String> mainList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        char[] list = new char[n * 2];
        function(0, list, 0, n * 2);
        return mainList;
    }

    void function(int i, char[] list, int count, int n) {
        // base case
        if (i >= n) {
            if (count == 0)
                mainList.add(new String(list));
            return;
        }

        list[i] = '(';
        function(i + 1, list, count + 1, n);

        if (count != 0) {
            list[i] = ')';

            function(i + 1, list, count - 1, n);
        }
    }

}