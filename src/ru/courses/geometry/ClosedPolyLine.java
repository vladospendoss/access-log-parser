package ru.courses.geometry;

import java.util.List;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(List<Point> points) {
        super(points);
    }

    // используется реализация Ломаной сделанная в более ранних задачах
    @Override
    public List<Line> getLines() {
        List<Line> lines = super.getLines();
        lines.add(new Line(points.get(points.size() - 1), points.get(0)));
        return lines;
    }

    @Override
    public double getLength() {
        return super.getLength();
    }
}
