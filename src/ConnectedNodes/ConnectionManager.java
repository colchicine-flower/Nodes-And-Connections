package ConnectedNodes;

public class ConnectionManager {
    public static void removeConnection(Node node, String edgeName) {
        for (Edge edge : node.getOutgoingEdges()) {
            if (edge.getEdgeName().equals(edgeName)) {
                node.getOutgoingEdges().remove(edge);
                System.out.println("Required Connection Deleted");
                return;
            }
        }
        System.out.println("No Connection Found to Delete");
    }
}
