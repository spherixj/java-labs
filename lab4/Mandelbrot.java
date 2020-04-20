import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {

    /** Константа с максимальным количеством итераций **/
    public static final int MAX_ITERATIONS = 2000;

    /** Метод позволяет генератору фракталов определить
     * наиболее «интересную» область комплексной плоскости для конкретного фрактала.
     **/
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    /** Метод реализует итеративную функцию для фрактала Мандельброта. **/
    @Override
    public int numIterations(double x, double y) {
        double magSq;
        double re = x;
        double im = y;
        double nextRe;
        double nextIm;
        int i = 0;

        while (i < MAX_ITERATIONS) {
            i += 1;
            nextRe = x + re * re - im * im;
            nextIm = y + 2 * re * im;
            re = nextRe;
            im = nextIm;
            magSq = re * re + im * im;
            if (magSq > 4) {
                return i;
            }
        }
        return -1;
    }
}
