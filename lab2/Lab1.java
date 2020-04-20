import java.lang.reflect.Array;

public class Lab1 {
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double p = (p1)
    }

    public static void main(String[] args) {
        Point3d[] points = new Point3d[]{};
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите x:");
            String xInput = System.console().readLine();

            System.out.println("Введите y:");
            String yInput = System.console().readLine();

            System.out.println("Введите z:");
            String zInput = System.console().readLine();

            Point3d point = new Point3d(Double.parseDouble(xInput), Double.parseDouble(yInput), Double.parseDouble(zInput));
        }
    }
}
