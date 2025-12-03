package ConnectedNodes;

public class TypeReplacer {
    public static void replaceType(Node start, Type fromType, Type toType) {
        GraphTraverser.dfs(start, node -> {
            if (node.getType() == fromType) {
                node.setType(toType);
            }
        });
    }
}
