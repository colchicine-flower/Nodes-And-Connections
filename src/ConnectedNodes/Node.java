package ConnectedNodes;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private List<Edge> outgoingEdges;
  private int data;
  private String nodeName;
  private Type type;

  public Node(int data, String nodeName, Type type) {
        this.data = data;
        this.nodeName = nodeName;
        this.type = type;
    this.outgoingEdges = new ArrayList<>();
    type.addNode(this);
    }

    public Node(int data, String nodeName) {
    this(data, nodeName, TypeManager.getDefault());
    }

  public void addEdge(String edgeName, Node target) {
    outgoingEdges.add(new Edge(edgeName, target));
    }

  // Getters and setters
  public List<Edge> getOutgoingEdges() {
    return outgoingEdges;
  }

  public void setOutgoingEdges(List<Edge> outgoingEdges) {
    this.outgoingEdges = outgoingEdges;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type newType) {
    if (newType == null) throw new IllegalArgumentException("Type cannot be null");
    if (this.type != null) {
      this.type.removeNode(this);
    }
    this.type = newType;
    newType.addNode(this);
    }
}
