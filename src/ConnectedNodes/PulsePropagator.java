package ConnectedNodes;

import java.util.HashSet;
import java.util.Set;

public class PulsePropagator {
    public static void propagate(WireNode start) {
        propagate(start, new HashSet<>());
    }

    private static void propagate(WireNode node, Set<WireNode> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        for (Edge edge : node.getOutgoingEdges()) {
            Node neighbor = edge.getConnectedTo();
            if (neighbor instanceof WireNode) {
                WireNode wireNeighbor = (WireNode) neighbor;
                wireNeighbor.setData(wireNeighbor.getData() + node.getData());
                propagate(wireNeighbor, visited);
            } else {
                System.out.println("Warning: Node " + neighbor.getNodeName() + " is not a WireNode, pulse not propagated further from it.");
            }
        }
    }
}
