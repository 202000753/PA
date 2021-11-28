/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import graph_t1.Edge;
import graph_t1.Graph;
import graph_t1.GraphLinked;
import graph_t1.InvalidVertexException;
import graph_t1.Vertex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author patricia.macedo
 */
public class UniversityNetwork {

    private Graph<Person, Relationship> network;

    public UniversityNetwork() {
        network = new GraphLinked<>();
    }

    public Vertex<Person> findPerson(int id) {
        for (Vertex<Person> v : network.vertices()) {
            if (v.element().getId() == id) {
                return v;
            }
        }
        return null;
    }

    public void addPerson(Person person) throws NetworkException {
        if (findPerson(person.getId()) != null) {
            throw new NetworkException("the person with this id, already exists");
        }
        try {
            network.insertVertex(person);
        } catch (InvalidVertexException e) {
            throw new NetworkException();

        }
    }

    public void addClassRelationship(String description, int idTeacher, int idStudent) throws NetworkException {
        try {
            Vertex<Person> p1 = findPerson(idTeacher);
            Vertex<Person> p2 = findPerson(idStudent);
            if (p1 == null) {
                throw new NetworkException(" id " + idTeacher + " not exist");
            }
            if (p2 == null) {
                throw new NetworkException(" id " + idStudent + " not exist");
            }
            if (!p1.element().isRole(Person.PersonRole.TEACHER) || !p2.element().isRole(Person.PersonRole.STUDENT)) {
                throw new NetworkException(" Wrong type of Persons");
            }
            Relationship rel = new Relationship(description, Relationship.RelRole.CLASS);

            network.insertEdge(p1, p2, rel);
        } catch (InvalidVertexException e) {
            throw new NetworkException();
        }
    }

    public void addGroupRelationship(String description, int idStudent1, int idStudent2) throws NetworkException {
        try {
            Vertex<Person> p1 = findPerson(idStudent1);
            Vertex<Person> p2 = findPerson(idStudent2);
            if (p1 == null) {
                throw new NetworkException(" id " + idStudent1 + " not exist");
            }
            if (p2 == null) {
                throw new NetworkException(" id " + idStudent2 + " not exist");
            }
            if (!p1.element().isRole(Person.PersonRole.STUDENT) || !p2.element().isRole(Person.PersonRole.STUDENT)) {
                throw new NetworkException(" Wrong type of Persons");
            }
            Relationship rel = new Relationship(description, Relationship.RelRole.GROUP);

            network.insertEdge(p1, p2, rel);
        } catch (InvalidVertexException e) {
            throw new NetworkException();
        }
    }

    public void removeRelation(int id1, int id2) throws NetworkException {

        try {
            Vertex<Person> p1 = findPerson(id1);
            Vertex<Person> p2 = findPerson(id2);

            for (Edge<Relationship, Person> edge : network.incidentEdges(p1)) {
                if (network.opposite(p1, edge) == p2) {
                    network.removeEdge(edge);
                }
            }
        } catch (InvalidVertexException e) {
            throw new NetworkException();

        }
    }

    void printTeachers() {
        System.out.println("Docentes");
        for (Vertex<Person> pV : network.vertices()) {
            if (pV.element().isRole(Person.PersonRole.TEACHER)) {
                System.out.println(pV.element().toString());
                for (Edge<Relationship, Person> edge : network.incidentEdges(pV)) {
                    Vertex<Person> v = network.opposite(pV, edge);
                    System.out.println(" \tde" + edge.element().toString() + " de " + v.element().toString());
                }
            }
        }
    }

    Iterable<Person> getPersons(String groupName) {
        Set<Person> groupMembers = new HashSet<>();
        for (Edge<Relationship, Person> edge : network.edges()) {
            if (edge.element().getDescription().equalsIgnoreCase(groupName)) {
                if (edge.element().isRole(Relationship.RelRole.CLASS)) {
                    throw new NetworkException(" Wrong type of Relationship");
                }
                Person p1 = edge.vertices()[0].element();
                Person p2 = edge.vertices()[1].element();
                groupMembers.add(p1);
                groupMembers.add(p2);
            }
        }
        return groupMembers;
    }

    void printGroup(String groupName) {
        System.out.println("GRUPO " + groupName);
        for (Person p : getPersons(groupName)) {
            System.out.println("\t" + p);
        }

    }

    public int getNumberOfStudents(int id) throws NetworkException {
        Vertex<Person> vPerson = findPerson(id);
        if (vPerson.element().isRole(Person.PersonRole.STUDENT)) {
            throw new NetworkException(" Wrong argument is not a teacher");
        }
        return ((Collection) network.incidentEdges(vPerson)).size();

    }

    public Person getPopular() {
        if (network.numVertices() == 0) {
            return null;
        }
        Vertex<Person> popular = null;
        int max = -1;
        for (Vertex<Person> vPerson : network.vertices()) {
            int numberContacts = ((Collection) network.incidentEdges(vPerson)).size();
            if (numberContacts > max) {
                popular = vPerson;
                max = numberContacts;
            }
        }
        return popular.element();
    }

    public boolean personExists(String name) {
        for (Vertex<Person> v : network.vertices()) {
            if (v.element().getName() == name) {
                return true;
            }
        }
        return false;
    }


    public List<Person> getIsolated() {
        List<Person> isolados = new ArrayList<>();
        if (network.numVertices() == 0) {
            return null;
        }
        for (Vertex<Person> vPerson : network.vertices()) {
            int numberContacts = ((Collection) network.incidentEdges(vPerson)).size();
            if (numberContacts == 0) {
                isolados.add(vPerson.element());
            }
        }
        return isolados;
    }

    public List<Relationship> getRelationShip(int id1, int id2) throws NetworkException {
        List<Relationship> relations = new ArrayList<>();

            Vertex<Person> p1 = findPerson(id1);
            Vertex<Person> p2 = findPerson(id2);
            if(p1==null || p2==null) throw new NetworkException(" Not a valid ID ");

            for (Edge<Relationship, Person> edge : network.incidentEdges(p1)) {
                if (network.opposite(p1, edge) == p2) {
                    relations.add(edge.element());
                }
            }
            return relations;
    }

}
