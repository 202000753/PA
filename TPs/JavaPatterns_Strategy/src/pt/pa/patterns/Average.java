package pt.pa.patterns;

import java.util.Map;

public interface Average {

    public double computeAverage(Map<Course, Integer> record);

    public String averageToString(Map<Course, Integer> record);
}
