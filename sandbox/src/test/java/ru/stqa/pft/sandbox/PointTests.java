package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPoint(){
    Point p1 = new Point(5,12);
    Point p2 = new Point(10, 24);
    Assert.assertEquals(p2.distance(p1),13.0);

  }

}
