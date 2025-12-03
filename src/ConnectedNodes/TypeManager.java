package ConnectedNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeManager {
    private static final Map<String, Type> types = new HashMap<>();
    private static final String DEFAULT_TYPE_NAME = "default";
    
    static {
        types.put(DEFAULT_TYPE_NAME, new Type(DEFAULT_TYPE_NAME));
    }

    public static Type getDefault() {
        return types.get(DEFAULT_TYPE_NAME);
    }

    public static Type getOrCreate(String name) {
        return types.computeIfAbsent(name, Type::new);
    }

    public static Type addType(String name) {
        if (types.containsKey(name)) {
            throw new IllegalArgumentException("Type already exists: " + name);
        }
        Type type = new Type(name);
        types.put(name, type);
        return type;
    }

    public static void removeType(String name) {
        if (name.equals(DEFAULT_TYPE_NAME)) {
            throw new IllegalArgumentException("Cannot remove default type");
        }
        Type type = types.get(name);
        if (type != null) {
            // copy to avoid ConcurrentModificationException
            List<Node> nodes = new ArrayList<>(type.getNodes());
            for (Node node : nodes) {
                node.setType(getDefault());
            }
            types.remove(name);
        }
    }

    public static Type getType(String name) {
        Type type = types.get(name);
        if (type == null) {
            throw new IllegalArgumentException("Type not found: " + name);
        }
        return type;
    }
}
