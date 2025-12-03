package ConnectedNodes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class GraphTraverser {
    public static void dfs(Node start, Consumer<Node> visitor) {
        dfs(start, visitor, new HashSet<>());
    }

    private static void dfs(Node node, Consumer<Node> visitor, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        visitor.accept(node);
        for (Edge edge : node.getOutgoingEdges()) {
            dfs(edge.getConnectedTo(), visitor, visited);
        }
    }

    // Optionally BFS can be added later
}
