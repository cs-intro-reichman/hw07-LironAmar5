/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
        
        // Tests the curve function:
        curve(Integer.parseInt(args[0]),
              Double.parseDouble(args[1]), Double.parseDouble(args[2]),
              Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        

        
        // Tests the snowflake function:
		snowFlake(Integer.parseInt(args[0]));
    
    }

    /** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {

        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

       
        double ax = x1 + (x2 - x1) / 3.0;
        double ay = y1 + (y2 - y1) / 3.0;

        double bx = x1 + 2.0 * (x2 - x1) / 3.0;
        double by = y1 + 2.0 * (y2 - y1) / 3.0;

        
        double px = (Math.sqrt(3) / 6.0) * (ay - by) + 0.5 * (ax + bx);
        double py = (Math.sqrt(3) / 6.0) * (bx - ax) + 0.5 * (ay + by);

        
        curve(n - 1, x1, y1, ax, ay);
        curve(n - 1, ax, ay, px, py);
        curve(n - 1, px, py, bx, by);
        curve(n - 1, bx, by, x2, y2);
    }

    
    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);

        
        double x1 = 0.1, y1 = 0.1;
        double x2 = 1.0, y2 = 0.1;

        double side = x2 - x1;                 
        double h = side * Math.sqrt(3) / 2.0;  

        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + h;

        
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}