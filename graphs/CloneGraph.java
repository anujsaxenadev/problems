package graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    private Node dfs(Node initialNode, HashMap<Node, Node> visitedMap){
        if(initialNode == null){
            return null;
        }
        else if (visitedMap.containsKey(initialNode)){
            return visitedMap.get(initialNode);
        }
        visitedMap.put(initialNode, new Node(initialNode.val));
        ArrayList<Node> duplicateNeighbors = new ArrayList<>();
        for(Node neighbor: initialNode.neighbors){
            Node duplicatedNode = dfs(neighbor, visitedMap);
            if(duplicatedNode != null){
                duplicateNeighbors.add(duplicatedNode);
            }
        }
        visitedMap.get(initialNode).neighbors.addAll(duplicateNeighbors);
        return visitedMap.get(initialNode);
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> visitedMap = new HashMap<Node, Node>();
        return dfs(node, visitedMap);
    }
}
