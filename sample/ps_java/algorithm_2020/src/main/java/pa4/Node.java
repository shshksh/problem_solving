package pa4;

public class Node {
    Node leftNode;
    Node rightNode;
    Node superNode;
    CSVData data;

    public Node(String[] info) {
        data = new CSVData(info);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
