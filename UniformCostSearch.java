import java.util.ArrayList;

public class UniformCostSearch {
    private ArrayList<Node<Board>> frontier;
    private ArrayList<Node<Board>> explored;
    private ArrayList<Board> moves;
    private Board initialState;
    private ArrayList<Board> path;

    public UniformCostSearch(Board initialState){
        this.frontier = new ArrayList<Node<Board>>();
        this.explored = new ArrayList<Node<Board>>();
        this.initialState = initialState;
        this.moves = initialState.getMoves();
        this.path = new ArrayList<Board>();
        this.path.add(initialState);
        this.frontier.add(new Node<Board>(initialState, null, null));
    }

    public ArrayList<Board> getPath(Node<Board> node) {
        while (node != null) {
            this.path.add(0, node.getData());
            node = node.getParent();
        }

        return this.path;
    }

    public ArrayList<Board> search() {

        System.out.println(frontier.isEmpty());

        while (!frontier.isEmpty()) {
            Node<Board> currentNode = frontier.get(0);
            frontier.remove(0);
            
            if (currentNode.getData().isGoal()) {
                return this.getPath(currentNode);
            }
            
            explored.add(currentNode);

            ArrayList<Board> successors = currentNode.getData().getMoves();
            for (Board successor : successors) {
                Node<Board> newNode = new Node<Board>(successor, currentNode, null);
                if (!explored.contains(newNode) && !frontier.contains(newNode)) {
                    frontier.add(newNode);
                    newNode.getData().printBoard();
                }
            }
        }
    
        System.out.println("Goal state not found.");
        return null; // Return null if goal state is not found
    }
}
