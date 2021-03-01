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
  @Test
  public void testPoint1(){
    Point p1 = new Point(10,12);
    Point p2 = new Point(300, 240);
    Assert.assertEquals(p2.distance(p1),Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y- p1.y)*(p2.y- p1.y)));

  }
  @Test
  public void testPoint2(){
    Point p1 = new Point(-5,-12);
    Point p2 = new Point(-10, -24);
    Assert.assertEquals(p2.distance(p1),13.0);

  }


}
