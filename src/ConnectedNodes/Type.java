package ConnectedNodes;

import java.util.HashSet;
import java.util.Set;

public class Type {
    private final String name;
    private final Set<Node> nodes = new HashSet<>();

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Set<Node> getNodes() {
        return nodes;
    }

    void addNode(Node node) {
        nodes.add(node);
    }

    void removeNode(Node node) {
        nodes.remove(node);
    }

    @Override
    public String toString() {
        return name;
    }
}
