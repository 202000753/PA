package pt.pa.refactoring.C_identify_codesmells;

public class Line {
    private final Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return String.format("%s --> %s", start, end);
    }

    public void move(int dx, int dy) {
        getStart().setX(getStart().getX()+dx);
        getStart().setY(getStart().getY()+dy);

        getEnd().setX(getEnd().getX()+dx);
        getEnd().setY(getEnd().getY()+dy);
    }
}
