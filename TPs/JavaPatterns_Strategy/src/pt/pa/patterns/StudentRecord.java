package pt.pa.patterns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentRecord {

    private String studentId;
    private String studentName;

    private Average average;
    private Map<Course, Integer> record;

    public StudentRecord(String studentId, String studentNamem, Average average) {
        this.studentId = studentId;
        this.studentName = studentName;

        this.average = average;
        this.record = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setAverage(Average average) {
        this.average = average;
    }

    public double computeAverage() {
        return  this.average.computeAverage(record);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Record of: %s | %s \n", studentId, studentName));
        sb.append(this.average.averageToString(record));
        return sb.toString();
    }

    public void importFromFile(String filename) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            /* discard header*/
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int year = Integer.valueOf( values[0] );
                String name = values[1].trim();
                String id = values[2].trim();
                String semester = values[3].trim();
                int ects = Integer.valueOf( values[4] );

                int grade = Integer.valueOf( values[5] );

                Course c = new Course(id, year, name, semester, ects);

                record.put(c, grade);

            }
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
