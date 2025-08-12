package ru.courses.geometry;

import java.util.Objects;

public class Line implements Measurable, Cloneable {

    Point startPoint;
    Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }

    public double getLength() {
        int diff = endPoint.x - startPoint.x;
        int diff1 = endPoint.y - startPoint.y;
        return Math.sqrt(diff * diff + diff1 * diff1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Line other = (Line) obj;
        return Objects.equals(this.startPoint, other.startPoint) &&
                Objects.equals(this.endPoint, other.endPoint);
    }

    @Override
    public int hashCode() {
        return 31 * startPoint.hashCode() + endPoint.hashCode();
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Point startPointClone = this.startPoint.clone();
        Point endPointClone = this.endPoint.clone();
        return new Line(startPointClone, endPointClone);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }
}