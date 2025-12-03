package ConnectedNodes;

public class SumCalculator {
    public static int sumByType(Node start, Type type) {
        final int[] sum = {0};
        GraphTraverser.dfs(start, node -> {
            if (node.getType() == type) {
                sum[0] += node.getData();
            }
        });
        return sum[0];
    }
}
