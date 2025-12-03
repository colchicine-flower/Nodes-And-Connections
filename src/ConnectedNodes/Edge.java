package ConnectedNodes;

public class Edge {
  private String edgeName;
  private Node connectedTo;

  public Edge(String edgeName, Node connectedTo) {
    this.edgeName = edgeName;
    this.connectedTo = connectedTo;
  }

  public String getEdgeName() {
    return edgeName;
  }

  public void setEdgeName(String edgeName) {
    this.edgeName = edgeName;
  }

  public Node getConnectedTo() {
    return connectedTo;
  }

  public void setConnectedTo(Node connectedTo) {
    this.connectedTo = connectedTo;
  }
}
