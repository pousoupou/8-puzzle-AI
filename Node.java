public class Node<T> {
  private T data;
  private Node<T> parent;

  public Node(T data, Node<T> parent) {
    this.data = data;
    this.parent = parent;
  }

  public void setParent(Node<T> parent) {
    this.parent = parent;
  }

  public Node<T> getParent() {
    return this.parent;
  }

  public T getData() {
    return this.data;
  }
}
