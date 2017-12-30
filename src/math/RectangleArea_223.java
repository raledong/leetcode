package math;

/**
 * @author rale
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea_223 {

	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
	{
		int area1 = (C-A) * (D-B);
		int area2 = (G-E) * (H-F);
	    int x = Math.min(G, C) > Math.max(E, A) ? (Math.min(G, C) - Math.max(E, A)) : 0;
	    int y = Math.min(D, H) > Math.max(B, F) ? (Math.min(D, H) - Math.max(B, F)) : 0;
	    return area1 + area2 - x * y;
	}
	
}
