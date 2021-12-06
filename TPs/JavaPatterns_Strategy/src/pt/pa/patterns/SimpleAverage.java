package pt.pa.patterns;

import java.util.Map;

public class SimpleAverage implements Average {
    @Override
    public double computeAverage(Map<Course, Integer> record) {
        double sum = 0;

        for (Integer grade : record.values()) {
            sum += grade;
        }

        return sum / record.size();
    }

    @Override
    public String  averageToString(Map<Course, Integer> record) {
        StringBuilder sb = new StringBuilder();

        String header = String.format("%6s | %10s | %50s | %8s | %5s \n",
                "Year",
                "Course ID",
                "Name",
                "Semester",
                "Grade");

        sb.append(header);

        for (Map.Entry<Course, Integer> entry : record.entrySet()) {
            Course c = entry.getKey();
            int grade = entry.getValue();

            String line = String.format("%6d | %10s | %50s | %8s | %5s \n",
                    c.getYear(),
                    c.getId(),
                    c.getName(),
                    c.getSemester(),
                    grade);

            sb.append(line);
        }

        return sb.toString();
    }
}
