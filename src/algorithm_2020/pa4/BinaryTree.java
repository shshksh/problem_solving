package algorithm_2020.pa4;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinaryTree {
    Node root;

    public void read(String fileName) {
        File file = new File("algorithm/src/algorithm_2020/res/" + fileName);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();

            while (sc.hasNextLine()) {
                String[] token = tokenize(sc.nextLine());
                add(new Node(token));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nonexistent file name");
        }
    }

    private String[] tokenize(String line) {
        String[] arr = new String[6];
        int i = 0;

        StringTokenizer st1 = new StringTokenizer(line, ",");
        StringTokenizer st2 = new StringTokenizer(line, "\"");

        while (i < 6) {
            String token = st1.nextToken();
            if (token.startsWith("\"")) {
                st2.nextToken();
                while (!token.endsWith("\"")) {
                    token = st1.nextToken();
                }
                token = st2.nextToken();
            }
            arr[i++] = token;
        }

        return arr;
    }

    private void add(Node node) {
        Node curr = root, prev = null;
        if (root == null) {
            root = node;
        }
        while (curr != null) {
            prev = curr;
            if (node.data.name.compareTo(curr.data.name) < 0) {
                curr = curr.leftNode;
            } else {
                curr = curr.rightNode;
            }
        }
        curr = node;
        if (prev != null) {
            if (curr.data.name.compareTo(prev.data.name) < 0)
                prev.leftNode = curr;
            else
                prev.rightNode = curr;
        }
        curr.superNode = prev;
    }

    public void list() {
        inorderPrint(root);
    }

    private void inorderPrint(Node root) {
        if (root == null)
            return;
        inorderPrint(root.leftNode);
        System.out.println(root.data);
        inorderPrint(root.rightNode);
    }

    public void find(String name) {
        Node curr = search(name);

        if (curr != null)
            System.out.println(curr.data);
        else
            System.out.println("Nonexistent name");
    }

    public void trace(String name) {
        Node curr = root;

        while (curr != null) {
            System.out.println(curr.data.name);
            if (curr.data.name.equals(name)) {
                break;
            } else if (curr.data.name.compareTo(name) < 0)
                curr = curr.rightNode;
            else if (curr.data.name.compareTo(name) > 0)
                curr = curr.leftNode;
        }
        if (curr != null)
            System.out.println(curr.data);
        else
            System.out.println("Nonexistent name");
    }

    public void deleteProcess(String name) {
        Node target = search(name);
        if (target != null)
            delete(target);
    }

    private Node search(String name) {
        Node curr = root, prev = null;
        while (curr != null) {
            prev = curr;
            if (curr.data.name.compareTo(name) < 0)
                curr = curr.rightNode;
            else if (curr.data.name.compareTo(name) > 0)
                curr = curr.leftNode;
            else
                break;
        }
        return curr;
    }

    private void delete(Node target) {
        Node x, y;
        if (target.leftNode == null || target.rightNode == null) {
            y = target;
        } else {
            y = successorOf(target);
        }

        if(y.leftNode != null) {
            x = y.leftNode;
        } else {
            x = y.rightNode;
        }

        if(x != null) {
            x.superNode = y.superNode;
        }
        if(y.superNode == null)
            root = x;
        else if (y == y.superNode.leftNode)
            y.superNode.leftNode = x;
        else
            y.superNode.rightNode = x;

        if(y != target)
            target.data = y.data;
    }

    private Node successorOf(Node target) {
        if (target.rightNode != null) {
            Node rightNode = target.rightNode;
            while(rightNode.leftNode != null)
                rightNode = rightNode.leftNode;
            return rightNode;
        }
        Node y = target.superNode;
        while (y != null && target == y.rightNode) {
            target = y;
            y = y.superNode;
        }
        return y;
    }

    public void save(String fileName) {
        File file = new File("algorithm/src/algorithm_2020/res/" + fileName);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("name,company_name,address,zip,phone,email");
            bw.newLine();
            preorderSave(root, bw);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preorderSave(Node root, BufferedWriter bw) throws IOException {
        if (root == null)
            return;
        bw.write(root.data.saveFormat());
        bw.newLine();
        preorderSave(root.leftNode, bw);
        preorderSave(root.rightNode, bw);
    }
}
