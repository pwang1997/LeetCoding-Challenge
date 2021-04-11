```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        helper(root, 0, map);
        
        int sum = 0;
        int maxLevel = -1;
        for(Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            if(maxLevel < entry.getKey()) 
                maxLevel = entry.getKey();
        }
        
        if(map.get(maxLevel) != null) {
            for(TreeNode node : map.get(maxLevel)) {
                sum += node.val;
            }
            return sum; 
        } else {
            return 0;
        }
    }
    
    void helper(TreeNode node, int level, Map<Integer, List<TreeNode>> map) {
        if(node == null) {
            return;
        } else if(node.left == null && node.right == null) { // leaf node
            if(map.get(level) != null) {
                map.get(level).add(node);
            } else {
                map.put(level, new ArrayList<>());
                map.get(level).add(node);
            }
            return;
        } 
        
        if(node.left != null) {
            helper(node.left, level+1, map);
        }
        
        if(node.right != null) {
            helper(node.right, level+1, map);
        }
    }
}
```