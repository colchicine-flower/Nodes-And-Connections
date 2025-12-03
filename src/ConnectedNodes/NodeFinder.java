package ConnectedNodes;

import java.util.HashSet;
import java.util.Set;

public class NodeFinder {
    public static Node findNode(Node start, String targetName) {
        return dfsFind(start, targetName, new HashSet<>());
    }

    private static Node dfsFind(Node node, String targetName, Set<Node> visited) {
        if (node == null || visited.contains(node)) return null;
        visited.add(node);
        if (node.getNodeName().equals(targetName)) return node;
        for (Edge edge : node.getOutgoingEdges()) {
            Node found = dfsFind(edge.getConnectedTo(), targetName, visited);
            if (found != null) return found;
        }
        return null;
    }
}
