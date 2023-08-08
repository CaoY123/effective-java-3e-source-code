package effectivejava.chapter3.item10.composition;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

import java.util.Objects;

// Adds a value component without violating the equals contract (page 44)

/**
 * 使用 复合优先于继承 组织 ColorPoint 与 Point 的关系更有利于类的 equals 的设计。
 * 当涉及到 超类 与 子类 之间的 equals 时，只要不是超类与子类混合起来比较、或是同一个超类的不同
 * 子类混合起来比较，一般不会存在 equals 的传递性问题。
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}