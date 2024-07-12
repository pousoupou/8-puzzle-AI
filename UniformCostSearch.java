import java.util.ArrayList;

public class UniformCostSearch {
    private ArrayList<Node<Board>> frontier;
    private ArrayList<Node<Board>> explored;
    private Board initialState;
    private ArrayList<Board> path;

    public UniformCostSearch(Board initialState){
        this.frontier = new ArrayList<Node<Board>>();
        this.explored = new ArrayList<Node<Board>>();
        this.initialState = initialState;
        this.path = new ArrayList<Board>();
        this.frontier.add(new Node<Board>(initialState, null));
    }

    public ArrayList<Board> getPath(Node<Board> node) {
        while (node != null) {
            this.path.add(0, node.getData());
            node = node.getParent();
        }

        return this.path;
    }

    public ArrayList<Board> search() {
        while (!frontier.isEmpty()) {
            Node<Board> currentNode = frontier.get(0);
            frontier.remove(0);
            
            if (currentNode.getData().isGoal()) {
                System.out.println("\nGoal state found.\nPath:\n");

                return this.getPath(currentNode);
            }
            
            explored.add(currentNode);

            ArrayList<Board> successors = currentNode.getData().getMoves();
            for (Board successor : successors) {
                Node<Board> newNode = new Node<Board>(successor, currentNode);
                if (!explored.contains(newNode) && !frontier.contains(newNode)) {
                    frontier.add(newNode);
                }
            }
        }
    
        System.out.println("Goal state not found.");
        return null;
    }
}
