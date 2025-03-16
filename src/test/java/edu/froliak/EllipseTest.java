package edu.froliak;

import org.junit.Test;

import static org.junit.Assert.*;

/*
  @author eugen
  @project LabWork2
  @class EllipseTest
  @version 1.0.0
  @since 3/16/2025 - 16.01
*/public class EllipseTest {
    private Ellipse standardEllipse = new Ellipse(5, 3);
    private Ellipse circle = new Ellipse(4, 4);
    private double delta = 0.01;

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenArea_15Pi() {
        assertEquals(Math.PI * 5 * 3, standardEllipse.calculateArea(), delta);
    }

    @Test
    public void whenRadius_4_ThenCirclePerimeter_8Pi() {
        assertEquals(2 * Math.PI * 4, circle.calculatePerimeter(), delta);
    }

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenEccentricity_0_8() {
        double expected = Math.sqrt(1 - Math.pow(3.0 / 5.0, 2));
        assertEquals(expected, standardEllipse.calculateEccentricity(), delta);
    }

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenLinearEccentricity_4() {
        double expected = Math.sqrt(25 - 9);
        assertEquals(expected, standardEllipse.calculateLinearEccentricity(), delta);
    }

    @Test
    public void whenEllipseIsStandard_ThenFocalDistanceEqualsLinearEccentricity() {
        assertEquals(standardEllipse.calculateLinearEccentricity(),
                standardEllipse.calculateFocalDistance(), delta);
    }

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenSemiLatusRectum_1_8() {
        double expected = 3 * 3 / 5.0;
        assertEquals(expected, standardEllipse.calculateSemiLatusRectum(), delta);
    }

    @Test
    public void whenPointIsOrigin_ThenItIsInsideStandardEllipse() {
        assertEquals(-1, standardEllipse.containsPoint(0, 0));
    }

    @Test
    public void whenPointIsOnMajorAxis_ThenItIsOnStandardEllipse() {
        assertEquals(0, standardEllipse.containsPoint(5, 0));
    }

    @Test
    public void whenPointIsOnMinorAxis_ThenItIsOnStandardEllipse() {
        assertEquals(0, standardEllipse.containsPoint(0, 3));
    }

    @Test
    public void whenPointIsOutsideMajorAxis_ThenItIsOutsideStandardEllipse() {
        assertEquals(1, standardEllipse.containsPoint(6, 0));
    }

    @Test
    public void whenPointIsOutsideMinorAxis_ThenItIsOutsideStandardEllipse() {
        assertEquals(1, standardEllipse.containsPoint(0, 4));
    }

    @Test
    public void whenRadius_4_ThenCircleFocalLength_0() {
        assertEquals(0, circle.calculateFocalLength(), delta);
    }

    @Test
    public void whenRadius_4_ThenCircleDirectrixDistanceIsPositiveInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, circle.calculateDirectrixDistance(), delta);
    }

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenMajorAxisCurvatureRadius_1_8() {
        double expected = 3 * 3 / 5.0;
        assertEquals(expected, standardEllipse.calculateMajorAxisCurvatureRadius(), delta);
    }

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenMinorAxisCurvatureRadius_8_33() {
        double expected = 5 * 5 / 3.0;
        assertEquals(expected, standardEllipse.calculateMinorAxisCurvatureRadius(), delta);
    }

    @Test
    public void whenEllipseIsCircle_ThenFociCoordinatesAreAt_0_0() {
        double[] circleFoci = circle.getFociCoordinates();
        assertEquals(0, circleFoci[0], delta);
        assertEquals(0, circleFoci[1], delta);
    }

    @Test
    public void whenSemiMajorEqualsMinorAxis_ThenShapeIsCircle() {
        assertTrue(circle.isCircle());
    }

    @Test
    public void whenSemiMajorAxis_5_AndSemiMinorAxis_3_ThenAspectRatio_0_6() {
        assertEquals(3.0 / 5.0, standardEllipse.calculateAspectRatio(), delta);
    }
}