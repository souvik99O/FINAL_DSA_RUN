class pair {
    TreeNode node;
    int HD;
    int level;

    pair(TreeNode node, int HD, int level) {
        this.node = node;
        this.HD = HD;
        this.level = level;
    }
}

class nodeInfo {
    int level;
    int value;

    nodeInfo(int level, int value) {
        this.level = level;
        this.value = value;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        HashMap<Integer, List<nodeInfo>> mainMap = new HashMap<>();
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0, 0));

        while (!q.isEmpty()) {
            pair p = q.poll();
            int HD = p.HD;
            int level = p.level;

            mainMap.putIfAbsent(HD, new ArrayList<>());
            mainMap.get(HD).add(new nodeInfo(level, p.node.val));

            if (p.node.left != null)
                q.offer(new pair(p.node.left, HD - 1, level + 1));
            if (p.node.right != null)
                q.offer(new pair(p.node.right, HD + 1, level + 1));
        }

        // Sort keys (HDs)
        List<Integer> keys = new ArrayList<>(mainMap.keySet());
        Collections.sort(keys);

        // Process each HD
        for (Integer key : keys) {
            List<nodeInfo> infoList = mainMap.get(key);

            // Sort by level first, then by value
            Collections.sort(infoList, (a, b) -> {
                if (a.level == b.level) return a.value - b.value;
                return a.level - b.level;
            });

            // Extract values only
            List<Integer> col = new ArrayList<>();
            for (nodeInfo info : infoList)
                col.add(info.value);

            ansList.add(col);
        }

        return ansList;
    }
}
