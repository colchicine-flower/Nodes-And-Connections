package ConnectedNodes;

public class NodesApp {

    public static void main(String[] args) {
    // Create nodes using NodeFactory (types will be created if not exist)
    Node node0 = NodeFactory.createNode(35, "Node0", "A");
    Node node1 = NodeFactory.createNode(8, "Node1", "B");
    Node node2 = NodeFactory.createNode(1, "Node2", "A");
    Node node3 = NodeFactory.createNode(81, "Node3", "B");
    Node node5 = NodeFactory.createNode(28, "Node5", "C");
    Node node6 = NodeFactory.createNode(3, "Node6"); // default
    Node node7 = NodeFactory.createNode(5, "Node7"); // default
    Node node9 = NodeFactory.createNode(44, "Node9", "C");

    // Connect nodes
    node0.addEdge("c1", node1);
    node0.addEdge("c2", node2);
    node0.addEdge("c3", node3);
    node2.addEdge("c4", node3);
    node3.addEdge("c5", node5);
    node5.addEdge("c6", node1);
    node5.addEdge("c7", node6);
    node6.addEdge("c8", node7);
    node6.addEdge("c9", node9);

    // Add a new node connected to node0
    NodeFactory.createAndConnect(node0, 101, "Node101");

    // Print sum for default type
    NodePrinter.printSumByType(node0, TypeManager.getDefault());

    // Print sum for type A
    Type typeA = TypeManager.getType("A");
    NodePrinter.printSumByType(node0, typeA);

    // Replace type C to A
    TypeReplacer.replaceType(node0, TypeManager.getType("C"), typeA);

    // Print sum for type A again
    NodePrinter.printSumByType(node0, typeA);

    // Find and print node "Node101"
    Node found = NodeFinder.findNode(node0, "Node101");
    if (found != null) {
      NodePrinter.printNode(found);
    } else {
      System.out.println("Node not found.");
    }
    }
}
