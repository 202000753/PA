package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityNetworkTest {

    private UniversityNetwork estNet;

    @BeforeEach
    void setUp() {
        estNet = new UniversityNetwork();
    }

    @Test
    void test_personDoesNotExists_whenEmptyGraph(){
        assertFalse(estNet.personExists("Rodrigo"));
    }

    @Test
    void isThrown_Exception_AfterAddExistentPerson(){
        estNet.addPerson(new Person(135, "Rodrigo", Person.PersonRole.STUDENT));
        assertThrows(NetworkException.class, ()->
                estNet.addPerson(new Person(135, "Rodrigo", Person.PersonRole.STUDENT)));
    }

    @Test
    void test_personExists_afterInsert(){
        estNet.addPerson(new Person(135, "Rodrigo", Person.PersonRole.STUDENT));
        assertTrue(estNet.personExists("Rodrigo"));
    }

    @Test
    void isThrown_Exception_AfterGetInvalidRelationship(){
        estNet.addPerson(new Person(135, "Rodrigo", Person.PersonRole.STUDENT));

        assertThrows(NetworkException.class, ()->
                estNet.getRelationShip(135,12));

    }

}