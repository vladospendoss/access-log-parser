package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PolyLine implements Measurable{

    List<Point> points;

    public PolyLine() {
        this.points = new ArrayList<>();
    }

    public PolyLine(List<Point> points) {
        this();
        this.points = points;
    }

    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            lines.add(new Line(points.get(i), points.get(i + 1)));
        }
        return lines;
    }

    public double getLength() {
        double length = 0;
        List<Line> lines = getLines();
        for (int i = 0; i < lines.size(); i++){
            length += lines.get(i).getLength();
        }
        return length;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}