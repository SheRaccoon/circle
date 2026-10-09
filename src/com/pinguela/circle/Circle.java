
package com.pinguela.circle;

/**
 * Represents an immutable circle with a centre and a non-negative radius.
 * All measurements use the same unit as the radius; area uses squared units.
 *
 * @author Carla Gonzalez
 * @version 1.0
 */
public final class Circle {
    /** Finite horizontal coordinate of the centre. */
    private final double x;
    /** Finite vertical coordinate of the centre. */
    private final double y;
    /** Finite, non-negative radius whose calculated measurements are finite. */
    private final double radius;

    /**
     * Creates a circle, allowing radius zero as a degenerate circle.
     *
     * @param x horizontal coordinate of the centre
     * @param y vertical coordinate of the centre
     * @param radius non-negative radius
     * @throws IllegalArgumentException if any value is non-finite, the radius
     *         is negative, or a calculated measurement would overflow
     */
    public Circle(double x, double y, double radius) {
        if (!Double.isFinite(x) || !Double.isFinite(y)
                || !Double.isFinite(radius) || radius < 0
                || !Double.isFinite(Math.PI * radius * radius)
                || !Double.isFinite(2 * Math.PI * radius)
                || !Double.isFinite(2 * radius)) {
            throw new IllegalArgumentException("Coordinates and radius must be finite; "
                    + "radius must be non-negative and measurements must not overflow.");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * Gets the horizontal centre coordinate.
     * @return horizontal coordinate of the centre
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the vertical centre coordinate.
     * @return vertical coordinate of the centre
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the radius.
     * @return radius in linear units
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculates the diameter using {@code 2 * radius}.
     * @return diameter in linear units
     */
    public double diameter() {
        return 2 * radius;
    }

    /**
     * Calculates the circumference using {@code 2 * Math.PI * radius}.
     * @return circumference in linear units
     */
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates the area using {@code Math.PI * radius * radius}.
     * @return area in squared units
     */
    public double area() {
        return Math.PI * radius * radius;
    }
}
