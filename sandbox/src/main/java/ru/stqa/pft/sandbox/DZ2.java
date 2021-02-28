package ru.stqa.pft.sandbox;

public class DZ2 {
  public static void main(String[] args) {
    Point p = new Point(1,10,50,100);

    System.out.println("Расстояние между P1 c координатами " + p.x1 + ", " + p.y1 +
            " и P2 с координатами "+ p.x2 + ", " + p.y2 +" = " + distance(p));

  }
  public static double distance(Point p){
    return Math.sqrt((p.x2-p.x1)*(p.x2-p.x1)+(p.y2- p.y1)*(p.y2- p.y1));
  }
}
