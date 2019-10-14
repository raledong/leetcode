package math;

public class GenerateRandomPointinaCircle_478 {

    double radius, x_center, y_center;

	public GenerateRandomPointinaCircle_478(double radius, double x_center, double y_center) {
		this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
    	//稍后解释为何要取随机数的开根值
    	double len= Math.sqrt(Math.random())*radius;
        double deg= Math.random()*2*Math.PI;
        double x= x_center+len*Math.cos(deg);
        double y= y_center+len*Math.sin(deg);
        return new double[]{x,y};
    }
    
    public double[] randPoint2() {
    	double x0 = x_center - radius;
        double y0 = y_center - radius;
    	while(true) {
            double xg = x0 + Math.random() * radius * 2;
            double yg = y0 + Math.random() * radius * 2;
            if (Math.pow((xg - x_center) , 2) + Math.pow((yg - y_center), 2) <= radius * radius)
                return new double[]{xg, yg};
        }
    }
}
