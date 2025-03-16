package edu.froliak;

import java.util.Objects;

/*
  @author eugen
  @project LabWork2
  @class Ellipse
  @version 1.0.0
  @since 3/16/2025 - 15.24
*/public class Ellipse {
    private double semiMajorAxis;
    private double semiMinorAxis;

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        if (semiMajorAxis <= 0 || semiMinorAxis <= 0) {
            throw new IllegalArgumentException("Axes must be positive");
        }

        if (semiMinorAxis > semiMajorAxis) {
            this.semiMajorAxis = semiMinorAxis;
            this.semiMinorAxis = semiMajorAxis;
        } else {
            this.semiMajorAxis = semiMajorAxis;
            this.semiMinorAxis = semiMinorAxis;
        }
    }

    public double calculateArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    public double calculatePerimeter() {
        double a = semiMajorAxis;
        double b = semiMinorAxis;

        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    public double calculateEccentricity() {
        return Math.sqrt(1 - Math.pow(semiMinorAxis / semiMajorAxis, 2));
    }

    public double calculateLinearEccentricity() {
        return Math.sqrt(Math.pow(semiMajorAxis, 2) - Math.pow(semiMinorAxis, 2));
    }

    public double calculateFocalDistance() {
        return calculateLinearEccentricity();
    }

    public double calculateSemiLatusRectum() {
        return Math.pow(semiMinorAxis, 2) / semiMajorAxis;
    }

    public int containsPoint(double x, double y) {
        double result = (Math.pow(x, 2) / Math.pow(semiMajorAxis, 2)) +
                (Math.pow(y, 2) / Math.pow(semiMinorAxis, 2));

        double epsilon = 1e-10;

        if (Math.abs(result - 1.0) < epsilon) {
            return 0;
        } else if (result < 1.0) {
            return -1;
        } else {
            return 1;
        }
    }

    public double calculateFocalLength() {
        return 2 * calculateFocalDistance();
    }

    public double calculateDirectrixDistance() {
        double e = calculateEccentricity();
        if (e == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return semiMajorAxis / e;
    }

    public double calculateMajorAxisCurvatureRadius() {
        return Math.pow(semiMinorAxis, 2) / semiMajorAxis;
    }

    public double calculateMinorAxisCurvatureRadius() {
        return Math.pow(semiMajorAxis, 2) / semiMinorAxis;
    }

    public double[] getFociCoordinates() {
        double c = calculateFocalDistance();
        return new double[] {-c, c};
    }

    public boolean isCircle() {
        double epsilon = 1e-10;
        return Math.abs(semiMajorAxis - semiMinorAxis) < epsilon;
    }

    public double calculateAspectRatio() {
        return semiMinorAxis / semiMajorAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ellipse ellipse)) return false;
        return Double.compare(getSemiMajorAxis(), ellipse.getSemiMajorAxis()) == 0 && Double.compare(getSemiMinorAxis(), ellipse.getSemiMinorAxis()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemiMajorAxis(), getSemiMinorAxis());
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiMajorAxis=" + semiMajorAxis +
                ", semiMinorAxis=" + semiMinorAxis +
                '}';
    }
}
