package ConnectedNodes;

public class NodeFactory {
    private NodeFactory() {}

    public static Node createNode(int data, String name, Type type) {
        return new Node(data, name, type);
    }

    public static Node createNode(int data, String name) {
        return new Node(data, name);
    }

    public static Node createNode(int data, String name, String typeName) {
        return createNode(data, name, TypeManager.getOrCreate(typeName));
    }

    public static Node createAndConnect(Node from, int data, String targetName, Type type) {
        Node newNode = createNode(data, targetName, type);
        from.addEdge(from.getNodeName() + "-" + targetName, newNode);
        return newNode;
    }

    public static Node createAndConnect(Node from, int data, String targetName) {
        return createAndConnect(from, data, targetName, TypeManager.getDefault());
    }

    public static Node createAndConnect(Node from, int data, String targetName, String typeName) {
        return createAndConnect(from, data, targetName, TypeManager.getOrCreate(typeName));
    }
}
