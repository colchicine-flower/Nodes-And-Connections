package ConnectedNodes;

import java.util.HashSet;
import java.util.Set;

public class NodePrinter {
    public static void printNode(Node node) {
        System.out.println("Node Name: " + node.getNodeName());
        System.out.println("Node Data: " + node.getData());
        System.out.println("Node Type: " + node.getType().getName());
        System.out.println();
    }

    public static void printConnections(Node node) {
        if (node.getOutgoingEdges().isEmpty()) {
            System.out.println("No connections.");
            return;
        }
        System.out.print("Connections: ");
        for (Edge edge : node.getOutgoingEdges()) {
            System.out.print(edge.getEdgeName() + " ");
        }
        System.out.println();
    }

    public static void printSumByType(Node start, Type type) {
        printTreeByType(start, type);
        int sum = SumCalculator.sumByType(start, type);
        System.out.println("Total Value Of Data Sum " + sum + " For Type " + type.getName());
        System.out.println();
    }

    public static void printTreeByType(Node start, Type type) {
        printTreeDFS(start, type, new HashSet<>(), 0, true);
    }

    private static void printTreeDFS(Node node, Type type, Set<Node> visited, int depth, boolean isStart) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        if (node.getType() == type) {
            if (isStart) {
                System.out.println("Start " + node.getNodeName() + " (data=" + node.getData() + ")");
            } else if (depth == 1) {
                System.out.println(node.getNodeName() + " (data=" + node.getData() + ")");
            } else {
                String indent = "  ".repeat(depth - 1);
                System.out.println(indent + "└─ " + node.getNodeName() + " (data=" + node.getData() + ")");
            }
        }
        for (Edge edge : node.getOutgoingEdges()) {
            printTreeDFS(edge.getConnectedTo(), type, visited, depth + 1, false);
        }
    }
}
