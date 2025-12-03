package ConnectedNodes;

public class WireNode extends Node {
  public WireNode(int data, String nodeName, Type type) {
        super(data, nodeName, type);
    }

    public WireNode(int data, String nodeName) {
        super(data, nodeName);
    }

    public void sendPulse() {
    PulsePropagator.propagate(this);
    }
}
