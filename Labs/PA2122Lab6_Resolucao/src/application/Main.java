/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import graph_t1.Edge;
import graph_t1.GraphLinked;
import graph_t1.Vertex;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author PM-Uninova
 */
public class Main {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        UniversityNetwork estNet = new UniversityNetwork();
        estNet.addPerson(new Person(135, "Rodrigo", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(131, "Pedro", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(2, "Ana", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(231, "Rita", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(233, "Zé", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(235, "Joao", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(215, "Catia", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(18, "Alberto", Person.PersonRole.STUDENT));
        estNet.addPerson(new Person(35, "Pedro", Person.PersonRole.TEACHER));
        estNet.addPerson(new Person(31, "Ana", Person.PersonRole.TEACHER));
        estNet.addClassRelationship("Algebra Geral", 31,131);
        estNet.addClassRelationship("Algebra Geral",31, 215);
        estNet.addClassRelationship("Análise Matematica", 31, 18);
        estNet.addClassRelationship("Análise Matematica",31, 131);
        estNet.addClassRelationship("PA", 35, 18);
        estNet.addClassRelationship("PA", 35, 131);
        estNet.addClassRelationship("PA", 35, 235);
        estNet.addGroupRelationship("Colegas Tuna", 231, 18);
        estNet.addGroupRelationship("Colegas Tuna", 231, 131);
        estNet.addGroupRelationship("Colegas Tuna", 231, 215);
        estNet.addGroupRelationship("Colegas Tuna", 18, 215);
        estNet.addGroupRelationship("Colegas Grupo PA-1", 231, 18);
        estNet.addGroupRelationship("Colegas Grupo PA-1", 131, 235);
        estNet.addGroupRelationship("Colegas Grupo Algebra-1", 135, 215);
        estNet.printTeachers();
        estNet.printGroup("Colegas Tuna");
        estNet.printGroup("Colegas Grupo PA-1");
        System.out.println(estNet.getNumberOfStudents(215));
        System.out.println(estNet.getPopular());
        System.out.println(estNet.getIsolated());

    }

}
