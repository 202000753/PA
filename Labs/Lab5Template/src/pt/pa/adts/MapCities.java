package pt.pa.adts;
import com.brunomnsilva.smartgraph.graph.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MapCities{
    private Graph<City, Integer> map;

    public MapCities() {
        map = new GraphEdgeList<>();
    }

    /**
     * Considera-se como dimensão do grafo o número de vértices
     * @return
     */
    public int size() {
        return map.numVertices();
    }

    /**
     * Returns the graph
     * @return
     */
    public Graph<City, Integer> getMap() {
        return map;
    }

    /**
     * Checks if a city exist in an Iterable
     * @param list to check
     * @param city to find
     * @return a boolean
     */
    public boolean exists(Iterable<City> list, String city) {
        for(City item: list)
            if (item.getCity().equals(city))
                return true;
        return false;
    }

    public void load(String filepath) throws FileNotFoundException {
        map = new GraphEdgeList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int indexStart=0, indexEnd=0, indexDistance=0;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.trim().split( " ");
                switch(tokens.length) {
                    case 1: // (Ex: Abrantes) Apenas uma cidade (um vértice)
                        if(!existCity(tokens[0]))
                            addCity(tokens[0]);
                        break;
                    case 2: // (Ex: Faro 2  ) Uma cidade e a distância para si própria (A ligação a implementar será Faro-->Faro 2kms)
                        if(!existCity(tokens[0]))
                            addCity(tokens[0]);
                        addConnection(tokens[0], tokens[0], parseInt(tokens[1]));
                        break;
                    case 3: // (Ex: Viseu Coimbra 95)
                        if(!existCity(tokens[0]))
                            addCity(tokens[0]);
                        if(!existCity(tokens[1]))
                            addCity(tokens[1]);
                        addConnection(tokens[0], tokens[1], parseInt(tokens[2]));
                        break;
                }
                // Add Cities and Connection, if not exists
            }
        } catch (IOException e) {
            throw new FileNotFoundException(String.format("The file %s does not seem to exist.", filepath));
        }
    }


    /**
     *
     * @return os compontes do grafo como uma string detalhada no conjunto dos vértices e arestas.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MapCities ");
        sb.append("\n\tVertices { ");
        for(Vertex<City> city: map.vertices())
            sb.append(city.element()+" ");
        sb.append("}");
        sb.append("\n\tEdges { ");
        for(Edge<Integer, City> edge : map.edges())
            sb.append("[" + edge.vertices()[0].element() + "-->" + edge.vertices()[1].element()+"] ");
        sb.append("}");
        return sb.toString();
    }

    private Vertex findCity(String city) {
        if(existCity(city)) {
            Collection<Vertex<City>> vertices = map.vertices();

            for (Vertex v:vertices) {
                if(v.element().toString().equals("'"+city+"'"))
                    return v;
            }
        }

        return null;
    }
    //Devolve o vértice onde a cidade city se encontra ou null, c.c.

    private boolean existCity(String city) {
        Collection<Vertex<City>> vertices = map.vertices();

        for (Vertex v:vertices) {

            if(v.element().toString().equals("'"+city+"'")) {
                return true;
            }
        }

        return false;
    }
    //Verifica se a cidade city existe (como vértice).

    private Edge<Integer, City> findConnection(String sourceCity, String destinationCity) throws ConnectionInvalidOperation {
        if(!existCity(sourceCity) || !existCity(destinationCity))
            throw new ConnectionInvalidOperation();

        Vertex<City> source = findCity(sourceCity);
        Vertex<City> destination = findCity(destinationCity);
        Collection<Edge<Integer, City>> edges = map.incidentEdges(source);

        for (Edge<Integer, City> e:edges) {
            if(map.opposite(source, e) == destination)
                return e;
        }

        return null;
    }
    //Devolve a aresta que liga os vértices sourceCity e destinationCity ou null. Caso alguma das cidades não exista é lançada uma exceção.

    private boolean existConnection(String sourceCity, String destinationCity) {
        if (findConnection(sourceCity, destinationCity)!=null)
            return true;

        return false;
    }
    //Verifica se existe a ligação (aresta) entre sourceCity e destinationCity.

    public void addCity(String city) throws CityInvalidOperation {
        if (existCity(city))
            throw new CityInvalidOperation();

        map.insertVertex(new City(city));
    }
    //Insere uma nova cidade no mapa (um novo vértice). Se a cidade já existir é lançada uma exceção.

    public Vertex removeCity(String city) throws CityInvalidOperation {
        if (!existCity(city))
            throw new CityInvalidOperation();

        Vertex<City> vertex = findCity(city);
        map.removeVertex(vertex);

        return vertex;
    }
    //Remove e devolve a cidade enviada ao método. Se a cidade não existir é lançada a exceção.

    public void addConnection(String sourceCity, String destinationCity, int distance) throws ConnectionInvalidOperation {
        if (existConnection(sourceCity, destinationCity))
            throw new ConnectionInvalidOperation();

        map.insertEdge(findCity(sourceCity), findCity(destinationCity), distance);
    }
    //Adiciona ao grafo a ligação entre duas cidades (aresta entre dois vértices). Se a ligação entre as cidades já existir é lançada a exceção.

    public void removeConnection(String sourceCity, String destinationCity) throws ConnectionInvalidOperation {
        if (!existConnection(sourceCity, destinationCity))
            throw new ConnectionInvalidOperation();

        map.removeEdge(findConnection(sourceCity, destinationCity));
    }
    //Remove do grafo a ligação entre duas cidades. Se a ligação não existir é lançada a exceção.

    public boolean isIsolated(String city) throws CityInvalidOperation {
        if(!existCity(city))
            throw new CityInvalidOperation();

        if(map.incidentEdges(findCity(city)).isEmpty())
            return true;

        return false;
    }
    //Verifica se uma cidade está isolada, isto é, se existe no grafo, mas não tem ligações a qualquer outra cidade (nem a ela própria).

    public Collection neighbors(String city) throws CityInvalidOperation {
        if (isIsolated(city))
            //throw new CityInvalidOperation();
            System.out.println("Invalid Operation");

        Vertex<City> v = findCity(city);
        Collection<Edge<Integer, City>> edges = map.incidentEdges(v);
        Collection<City> cities = new ArrayList<>();

        for (Edge<Integer, City> e:edges) {
            cities.add(map.opposite(v, e).element());
        }

        return cities;
    }
    //Devolve a lista de cidades "vizinhas" de uma determinada cidade.
}

