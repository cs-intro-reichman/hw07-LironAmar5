/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setScale(0.0, 1.0);
		
		double h = Math.sqrt(3) / 2.0;
		double x1 = 0.0, y1 = 0.0;
		double x2 = 1.0, y2 = 0.0;
		double x3 = 0.5, y3 = h;
		
		StdDraw.setPenColor(StdDraw.BLACK);
        filledTriangle(x1, x2, x3, y1, y2, y3);

		sierpinski(n, x1, x2, x3, y1, y2, y3);

	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if(n == 0){ return;}
		double mx12 = (x1 + x2) / 2.0, my12 = (y1 + y2) / 2.0;
        double mx23 = (x2 + x3) / 2.0, my23 = (y2 + y3) / 2.0;
        double mx31 = (x3 + x1) / 2.0, my31 = (y3 + y1) / 2.0;

		StdDraw.setPenColor(StdDraw.WHITE);
		filledTriangle(mx12, mx23, mx31, my12, my23, my31);

		StdDraw.setPenColor(StdDraw.BLACK);

		sierpinski(n - 1, x1,  mx12, mx31,  y1,  my12, my31);
		sierpinski(n - 1, mx12, x2,  mx23, my12, y2,  my23);
		sierpinski(n - 1, mx31, mx23, x3,  my31, my23, y3);

	}

	public static void filledTriangle(double x1, double x2, double x3, double y1, double y2, double y3){
		double[] xs = {x1, x2, x3};
		double[] ys = {y1, y2, y3};
		StdDraw.filledPolygon(xs, ys);
	}

	
}
