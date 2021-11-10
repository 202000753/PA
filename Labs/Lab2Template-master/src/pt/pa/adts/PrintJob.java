package pt.pa.adts;

public class PrintJob implements Comparable <PrintJob> {
    private String name;
    private Level priority;
    private int getNumberPages;

    public PrintJob(String name, Level priority, int getNumberPages) {
        this.name = name;
        this.priority = priority;
        this.getNumberPages = getNumberPages;
    }

    @Override
    public int compareTo(PrintJob o) {
        return this.priority.ordinal()-o.priority.ordinal();
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", getNumberPages=" + getNumberPages +
                '}';
    }

    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }
}
