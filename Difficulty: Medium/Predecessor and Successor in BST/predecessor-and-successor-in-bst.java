import java.util.*;

class Solution {
    public static ArrayList<Node> ans;
    public static Node prev;
    public static Node succ;

    public static void inorder(Node root, int key) {
        if (root == null) return;

        inorder(root.left, key);

        if (root.data < key) {
            prev = root;
        }
        else if (root.data > key && succ == null) {
            succ = root;
        }

        inorder(root.right, key);
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {

        ans = new ArrayList<>();
        prev = null;
        succ = null;

        inorder(root, key);

        ans.add(prev);
        ans.add(succ);

        return ans;
    }
}