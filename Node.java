public class Node<T> {
    private T data;
    private Node<T> parent;
    private Node<T> child;

    public Node(T data, Node<T> parent, Node<T> child){
        this.data = data;
        this.child = child;
        this.parent = parent;
    }

    public void setChild(Node<T> child){
        this.child = child;
    }

    public void setParent(Node<T> parent){
        this.parent = parent;
    }

    public Node<T> getParent(){
        return this.parent;
    }

    public T getData(){
        return this.data;
    }
}
