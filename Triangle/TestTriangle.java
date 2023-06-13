package Triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side 1: ");
        double side1 = sc.nextDouble();
        System.out.println("Enter side 2: ");
        double side2 = sc.nextDouble();
        System.out.println("Enter side 3: ");
        double side3 = sc.nextDouble();
        System.out.println("Enter color: ");
        String color = sc.next();
        Triangle triangle = new Triangle(side1,side2,side3);
        triangle.setColor(color);
        System.out.println("Triangle information: "+triangle);
        System.out.println("Area : "+triangle.calculateArea());
        System.out.println("Perimeter  :"+triangle.calculatePerimeter());
        sc.close();
    }
}

