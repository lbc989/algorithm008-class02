
class Solution {
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i));
        }
    }
}