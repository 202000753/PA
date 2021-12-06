package pt.pa.patterns;

import java.util.Map;

public class WeightedAverage implements Average {
    @Override
    public double computeAverage(Map<Course, Integer> record) {
        double sumGrade = 0;
        double sumEcts = 0;

        for (Course course : record.keySet()) {
            int ects = course.getEcts();
            sumGrade += record.get(course) * ects;

            sumEcts += ects;
        }

        return sumGrade / sumEcts;
    }

    @Override
    public String averageToString(Map<Course, Integer> record) {
        StringBuilder sb = new StringBuilder();

        String header = String.format("%6s | %10s | %50s | %8s | %5s | %5s \n",
                "Year",
                "Course ID",
                "Name",
                "Semester",
                "Grade",
                "ECTS");

        sb.append(header);

        for (Map.Entry<Course, Integer> entry : record.entrySet()) {
            Course c = entry.getKey();
            int grade = entry.getValue();

            String line = String.format("%6d | %10s | %50s | %8s | %5s | %5s \n",
                    c.getYear(),
                    c.getId(),
                    c.getName(),
                    c.getSemester(),
                    grade,
                    c.getEcts());

            sb.append(line);
        }

        return sb.toString();
    }
}
