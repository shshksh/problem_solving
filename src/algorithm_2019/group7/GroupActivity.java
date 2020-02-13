package algorithm_2019.group7;

import java.util.HashMap;

public class GroupActivity {

    static class Node {
        String word;
        Node leftNode = null;
        Node rightNode = null;
        Node superNode;

        public Node(String word, Node superNode) {
            this.word = word;
            this.superNode = superNode;
        }

    }

    static class WordTree {
        Node root = null;
        int size = 0;

        Node find(String target) {
            Node curr = this.root;
            while (curr != null) {
                if (curr.word.compareTo(target) == 0) {
                    return curr;
                } else if (curr.word.compareTo(target) < 0) {
                    curr = curr.rightNode;
                } else
                    curr = curr.leftNode;
            }
            return null;
        }

        public int getSize() {
            return size;
        }

        void add(String word) {
            Node curr = this.root;
            Node prev = null;

            while (curr != null) {
                prev = curr;
                if (curr.word.compareTo(word) > 0)
                    curr = curr.leftNode;
                else
                    curr = curr.rightNode;
            }

            if (prev == null) {
                this.root = new Node(word, null);
            } else if (prev.word.compareTo(word) > 0) {
                prev.leftNode = new Node(word, prev);
            } else
                prev.rightNode = new Node(word, prev);

            this.size++;
        }

        void delete(String target) {
            Node targetNode = find(target);
            Node deleteNode, subNode;
            if (targetNode.leftNode == null || targetNode.rightNode == null) { // 1개 이하
                deleteNode = targetNode;
            } else {
                deleteNode = successor(targetNode); // 변경 해야 할 노드
            }
            if (deleteNode.leftNode != null) {
                subNode = deleteNode.leftNode;
            } else {
                subNode = deleteNode.rightNode;
            }
            if (subNode != null) {
                subNode.superNode = deleteNode.superNode;
            }
            if (deleteNode.superNode == null) {
                root = subNode;
            } else if (deleteNode == deleteNode.superNode.leftNode) {
                deleteNode.superNode.leftNode = subNode;
            } else {
                deleteNode.superNode.rightNode = subNode;
            }
            if (deleteNode != targetNode) {
                targetNode.word = deleteNode.word;
            }
        }

        private Node successor(Node curr) {
            if (curr.rightNode != null) {
                Node tmp = curr.rightNode;
                Node tmp2 = curr;
                while (tmp != null) {
                    tmp2 = tmp;
                    tmp = tmp.leftNode;
                }
                return tmp2;
            }
            Node y = curr.superNode;
            while (y != null && curr == y.rightNode) {
                curr = y;
                y = y.superNode;
            }
            return y;
        }
    }

    public static void main(String[] args) {
        WordTree wordTree = new WordTree();

        wordTree.add("f");
        wordTree.add("c");
        wordTree.add("h");
        wordTree.add("b");
        wordTree.add("d");
        wordTree.add("g");
        wordTree.add("i");
        wordTree.add("a");
        wordTree.add("e");

        System.out.println(isBST(wordTree.root));
        System.out.println(lowestCommonAncestor(wordTree.find("f"), wordTree.find("i")).word);
        System.out.println(diameter(wordTree.root));

    }

    private static int diameter(Node root) {
        return depthOf(root.leftNode, 0) + depthOf(root.rightNode, 0)+1;
    }

    private static int depthOf(Node root, int level) {
        if(root == null)
            return level;
        return Math.max(depthOf(root.leftNode, level+1), depthOf(root.rightNode, level+1));
    }

    private static Node lowestCommonAncestor(Node a, Node g) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Node curr = a;
        while(curr != null) {
            hashMap.put(curr.word, 1);
            curr = curr.superNode;
        }
        curr = g;
        while(curr != null){
            if(hashMap.containsKey(curr.word))
                return curr;
            curr = curr.superNode;
        }
        return null;
    }

    private static boolean isBST(Node root) {
        if(root == null)
            return true;
        if(isBST(root.leftNode) && isBST(root.rightNode))
            return compareLeft(root.leftNode, root) && compareRight(root, root.rightNode);
        return false;
    }

    private static boolean compareRight(Node root, Node rightNode) {
        if(rightNode == null)
            return true;
        return root.word.compareTo(rightNode.word) < 0;
    }

    private static boolean compareLeft(Node leftNode, Node root) {
        if(leftNode == null)
            return true;
         return leftNode.word.compareTo(root.word) < 0;
    }

}
