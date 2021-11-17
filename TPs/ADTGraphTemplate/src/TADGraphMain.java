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


        graph.insertEdge(localA, localB, new Bridge("a"));
        graph.insertEdge(localA, localB, new Bridge("b"));
        graph.insertEdge(localB, localC, new Bridge("c"));
        graph.insertEdge(localB, localC, new Bridge("d"));
        graph.insertEdge(localA, localD, new Bridge("e"));
        graph.insertEdge(localB, localD, new Bridge("f"));
        graph.insertEdge(localC, localD, new Bridge("g"));

        System.out.println(graph.toString());

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
        System.out.println(bfs(localA, graph));

        System.out.println("\nDijsktra");
        System.out.println(mini(localA, graph););
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

    private void dijkstra(Vertex<Local> orig, Map<Vertex<Local>, Double> costs, Map<Vertex<Local>, Vertex<Local>> predecessors, GraphEdgeList<Local, Bridge> graph) {
        Set<Vertex<Local>> unvisited = new HashSet<>();

        for (Vertex<Local> v:unvisited)
            costs.put(v, Double.MAX_VALUE);

        costs.put(orig, 0.0);

        for (Vertex<Local> v:unvisited)
            predecessors.put(v, null);

        Vertex<Local> u=null;

        while (!unvisited.isEmpty()) {
            u=findMinimumVertex(unvisited, costs);

            if (costs.get(u)==Double.MAX_VALUE)
                return;

            unvisited.remove(u);

            for (Edge<Bridge, Local> e:graph.incidentEdges(u)){
                Vertex w = graph.opposite(u, e);
                double cost = e.element().getCost() + costs.get(u);
            }
        }

    }

    private static Vertex<Local> findMinimumVertex(Set<Vertex<Local>> unvisited, Map<Vertex<Local>, Double> cost) {
        Vertex<Local> vMin=null;
        double minCost=Double.MAX_VALUE;

        for (Vertex<Local> v:unvisited) {
            double minV=cost.get(v);

            if(minV<minCost) {
                vMin = v;
                minCost = minV;
            }
        }

        return vMin;
    }

    public int minimumCostPath(Vertex<Local> orig, Vertex<Local> dst, List<Vertex<Local>> localsPath, GraphEdgeList<Local, Bridge> graph) {
        


        return 0;
    }
}
