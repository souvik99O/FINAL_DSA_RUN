class Solution {
    List<Integer>[] graph;
    int[] subtreeXor;
    int[] parent;
    int totalXor;
    
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build graph
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        subtreeXor = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        // Step 1: Compute total XOR and subtree XORs
        totalXor = dfs(0, -1, nums);

        int minScore = Integer.MAX_VALUE;

        // Step 2: Try all pairs of edges
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = i;
                int y = j;

                // Case 1: one subtree is in another
                if (isAncestor(x, y)) {
                    int a = subtreeXor[y];
                    int b = subtreeXor[x] ^ subtreeXor[y];
                    int c = totalXor ^ subtreeXor[x];
                    minScore = Math.min(minScore, getScore(a, b, c));
                } else if (isAncestor(y, x)) {
                    int a = subtreeXor[x];
                    int b = subtreeXor[y] ^ subtreeXor[x];
                    int c = totalXor ^ subtreeXor[y];
                    minScore = Math.min(minScore, getScore(a, b, c));
                } else {
                    int a = subtreeXor[x];
                    int b = subtreeXor[y];
                    int c = totalXor ^ a ^ b;
                    minScore = Math.min(minScore, getScore(a, b, c));
                }
            }
        }

        return minScore;
    }

    // DFS to compute subtree XORs and parents
    private int dfs(int node, int par, int[] nums) {
        int xor = nums[node];
        parent[node] = par;

        for (int nei : graph[node]) {
            if (nei != par) {
                xor ^= dfs(nei, node, nums);
            }
        }
        subtreeXor[node] = xor;
        return xor;
    }

    // Check if x is ancestor of y
    private boolean isAncestor(int x, int y) {
        while (y != -1) {
            if (y == x) return true;
            y = parent[y];
        }
        return false;
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}
