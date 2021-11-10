import pt.pa.adts.graph.*;
import pt.pa.model.Bridge;
import pt.pa.model.Local;

import java.util.*;

public class TADGraphMain {
    public static void main(String[ ] args){

        Graph<Local, Bridge> graph = new GraphEdgeList<>();
    ///Complete

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
        Stack<Vertex<Local>> stack = new Stack();
        stack.push(localA);
        Set<Vertex<Local>> visited = new HashSet();
        visited.add(localA);
        ArrayList list = new ArrayList();

        while (!stack.empty()) {
            Vertex<Local> v = (Vertex) stack.pop();
            list.add(v);
            Iterator var7 = graph.incidentEdges(v).iterator();

            while (var7.hasNext()) {
                Edge edge = (Edge) var7.next();
                Vertex<Local> w = graph.opposite(v, edge);
                if (!visited.contains(w)) {
                    visited.add(w);
                    stack.push(w);
                }
            }
        }

        System.out.println(list);
    }
}
