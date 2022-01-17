import pt.pa.adts.graph.*;
import pt.pa.model.Bridge;
import pt.pa.model.Local;

import java.util.*;


public class TADGraphMain {
    public static void main(String[ ] args){
        Graph<Local, Bridge> graph = new GraphEdgeList<>();

        Vertex<Local> localA = graph.insertVertex(new Local("A"));
        Vertex<Local> localB = graph.insertVertex(new Local("B"));
        Vertex<Local> localC = graph.insertVertex(new Local("C"));
        Vertex<Local> localD = graph.insertVertex(new Local("D"));

        graph.insertEdge(localA, localB, new Bridge("a", 2));
        graph.insertEdge(localA, localB, new Bridge("b", 1));
        graph.insertEdge(localA, localC, new Bridge("c", 3));
        graph.insertEdge(localA, localC, new Bridge("d", 1));
        graph.insertEdge(localA, localD, new Bridge("e", 15));
        graph.insertEdge(localB, localD, new Bridge("f", 4));
        graph.insertEdge(localC, localD, new Bridge("g", 5));

        /*System.out.println(graph.toString());

        System.out.println("\nEdges Incident with local A");
        for (Edge<Bridge, Local> e:graph.incidentEdges(localA)) {
            System.out.println(e.element().getName());
        }

        System.out.println("\nAdjacent Vertices of B");
        Collection<Vertex<Local>> vertices = graph.vertices();
        for (Vertex<Local> v:vertices) {
            if (graph.areAdjacent(localB, v))
                System.out.println(v.element().getName());
        }

        System.out.println("\nNumber of Edges Incident with local C");
        System.out.println(graph.incidentEdges(localC).size());

        System.out.println("\nAre Adjacents A, B " + (graph.areAdjacent(localA, localB)?"y":"n"));

        System.out.println("\nDFS");
        System.out.println(dfs(localA, graph));

        System.out.println("\nBFS");
        System.out.println(bfs(localA, graph));*/

        System.out.println("\nDijsktra");
        List<Vertex<Local>> localsPath = new ArrayList<>();
        System.out.println(minimumCostPath(localA, localB, localsPath, graph));
        System.out.println(localsPath);
    }

    public static Collection<Vertex<Local>> dfs(Vertex<Local> vertice_root, Graph<Local, Bridge> graph) {
        HashSet<Vertex<Local>> visited = new HashSet<>();
        Stack<Vertex<Local>> stack = new Stack<>();
        ArrayList<Vertex<Local>> list = new ArrayList<>();

        visited.add(vertice_root);
        stack.push(vertice_root);

        while (!stack.isEmpty()) {
            Vertex<Local> v = stack.pop();
            list.add(v);

            for (Edge<Bridge, Local> e:graph.incidentEdges(v)){
                Vertex w = graph.opposite(v, e);

                if (!visited.contains(w)) {
                    stack.push(w);
                    visited.add(w);
                }
            }
        }

        return list;
    }

    public static Collection<Vertex<Local>> bfs(Vertex<Local> vertice_root, Graph<Local, Bridge> graph) {
        HashSet<Vertex<Local>> visited = new HashSet<>();
        Queue<Vertex<Local>> queue = new LinkedList<>();
        ArrayList<Vertex<Local>> list = new ArrayList<>();

        visited.add(vertice_root);
        queue.offer(vertice_root);

        while (!queue.isEmpty()) {
            Vertex<Local> v = queue.poll();
            list.add(v);

            for (Edge<Bridge, Local> e:graph.incidentEdges(v)){
                Vertex w = graph.opposite(v, e);

                if (!visited.contains(w)) {
                    queue.offer(w);
                    visited.add(w);
                }
            }
        }

        return list;
    }

    private static void dijkstra(Vertex<Local> orig, Map<Vertex<Local>, Double> costs, Map<Vertex<Local>, Vertex<Local>> predecessors, Graph<Local, Bridge> graph) {
        double cost = 0.0;

        for (Vertex<Local> v:graph.vertices()) {
            costs.put(v, Double.MAX_VALUE);
            predecessors.put(v, null);
        }

        costs.replace(orig, 0.0);

        List<Vertex<Local>> unvisited = (List<Vertex<Local>>) graph.vertices();

        while (!unvisited.isEmpty()) {
            Vertex<Local> vertex = findLowerVertex(costs, unvisited);

            if (costs.get(vertex) == Double.MAX_VALUE)
                return;

            unvisited.remove(vertex);

            List<Vertex<Local>> adjacents = new ArrayList<>();

            for (Vertex<Local> v:unvisited) {
                if (graph.areAdjacent(vertex, v))
                    adjacents.add(v);
            }

            for (Vertex<Local> vertexAdjacent:adjacents) {
                cost = 0.0;
                cost = costs.get(vertex) + cost_between(vertex, vertexAdjacent, graph);

                if(cost < costs.get(vertexAdjacent)) {
                    costs.replace(vertexAdjacent, cost);
                    predecessors.replace(vertexAdjacent, vertex);
                }
            }
        }
    }

    private static Double cost_between(Vertex<Local> vertex, Vertex<Local> vertexAdjacent, Graph<Local, Bridge> graph) {
        Double cost = Double.MAX_VALUE;

        for (Edge<Bridge, Local> edge:graph.incidentEdges(vertex)) {
            if ((edge.vertices()[0] == vertexAdjacent || edge.vertices()[1] == vertexAdjacent) && cost > edge.element().getCost())
                cost = Double.valueOf(edge.element().getCost());
        }

        return cost;
    }

    private static Vertex<Local> findLowerVertex(Map<Vertex<Local>, Double> costs, List<Vertex<Local>> unvisited) {
        Vertex<Local> vertex = null;
        Double cost = Double.MAX_VALUE;

        for (Vertex<Local> v:unvisited) {
            if(costs.get(v) < cost) {
                vertex = v;
                cost = costs.get(v);
            }
        }

        return vertex;
    }

    public static double minimumCostPath(Vertex<Local> orig, Vertex<Local> dst, List<Vertex<Local>> localsPath, Graph<Local, Bridge> graph) {
        double cost = 0;
        Map<Vertex<Local>, Double> costs = new HashMap<>();
        Map<Vertex<Local>, Vertex<Local>> predecessors = new HashMap<>();
        Vertex<Local> vertex = dst;

        dijkstra(orig, costs, predecessors, graph);

        while (vertex != orig) {
            localsPath.add(vertex);
            vertex = predecessors.get(vertex);
        }

        localsPath.add(vertex);
        cost = costs.get(dst);

        return cost;
    }
}
