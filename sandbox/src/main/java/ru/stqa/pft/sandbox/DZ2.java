package ru.stqa.pft.sandbox;

public class DZ2 {
  public static void main(String[] args) {
    Point p1 = new Point(10,78);
    Point p2 = new Point(55,105);
    System.out.println("Расстояние между P1 c координатами " + p1.x + ", " + p1.y +
            " и P2 с координатами "+ p2.x + ", " + p2.y +" = " + p1.distance(p2));

  }
}
