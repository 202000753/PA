package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MapCitiesTest {
    private MapCities map;

    @BeforeEach
    void setUp() {
        map = new MapCities();

        map.addCity("Porto");
        map.addCity("Leiria");
        map.addCity("Lisboa");
        map.addCity("Coimbra");
        map.addCity("Faro");

        map.addConnection("Porto", "Leiria", 185);
        map.addConnection("Lisboa", "Porto", 300);
        map.addConnection("Coimbra", "Coimbra", 10);
        map.addConnection("Lisboa", "Leiria", 130);
        map.addConnection("Coimbra", "Faro", 255);
        map.addConnection("Porto", "Faro", 550);
    }

    @Test
    @DisplayName("Is isIsolated Correct?")
    void isIsolated_isCorrect_AfterInsertRemoveCitiesAndConnections() {
        map.addCity("Setubal");
        assertTrue(map.isIsolated("Setubal"));

        map.addConnection("Porto", "Setubal", 500);
        assertFalse(map.isIsolated("Setubal"));

        map.removeConnection("Porto", "Setubal");
        assertTrue(map.isIsolated("Setubal"));

        map.addConnection("Porto", "Setubal", 500);
        map.addConnection("Lisboa", "Setubal", 200);
        map.removeConnection("Porto", "Setubal");
        assertFalse(map.isIsolated("Setubal"));
    }
    /*Verifica se:
    Um vértice depois de criado é considerado isolado;
    Um vértice depois de ligado a outro não é considerado isolado;
    Um vértice ligado a outro volta a ser considerado isolado se for removida a única ligação entre eles;
    Um vértice com >=2 ligações a outros vértices não é isolado depois de remover uma das ligações.*/

    @Test
    @DisplayName("Is addConection correct?")
    void addConnection_isCorrect_whenSourceIsEqualToDestination() {
        map.addCity("Setubal");
        map.addConnection("Setubal", "Setubal", 1);
    }
    //Verifica se se pode fazer uma ligação de uma cidade a ela própria, isto é, se não é lançada qualquer a exceção.

    @Test
    @DisplayName("Exists after Insert?")
    void neighbors_isCorrect_afterInsertAndRemoveVerticesAndEdges() {
        map.addCity("Setubal");
        assertTrue(map.neighbors("Setubal").isEmpty());

        map.addConnection("Porto", "Setubal", 500);
        assertTrue(exists(map.neighbors("Setubal"), "Porto"));

        map.removeConnection("Porto", "Setubal");
        assertFalse(exists(map.neighbors("Setubal"), "Porto"));


        map.addConnection("Lisboa", "Setubal", 200);
        assertTrue(exists(map.neighbors("Setubal"), "Lisboa"));
        map.removeCity("Lisboa");
        assertFalse(exists(map.neighbors("Setubal"), "Lisboa"));
        map.addCity("Lisboa");
        assertFalse(exists(map.neighbors("Setubal"), "Lisboa"));
    }
    /*Verifica se a lista de cidades vizinhas é gerada corretamente, isto é:
    Se X for uma cidade sem ligações, então não tem vizinhos;
    Se X->Y, então Y faz parte da lista de vizinhos de X
    Se X->Y e se removermos a ligação entre X e Y, então Y não faz parte da lista de vizinhos de X;
    Se X->Y, se removermos Y e voltarmos a adicionar a cidade Y (mas não a ligação), então Y não faz parte da lista de vizinhos de X.*/

    private boolean exists(Iterable<City> list, String city) {
        for(City item: list)
            if (item.toString().equals("'"+city+"'"))
                return true;
        return false;
    }
}