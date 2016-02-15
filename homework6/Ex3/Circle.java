package homework6.Ex3;

public class Circle extends Shape
{
 private int ssr;
 
	public Circle(int ssr) {
	super();
	this.ssr = ssr;
}

	@Override
	public int findS() {
		int sum = (int) Math.round(ssr*ssr*Math.PI);
		return sum;
	}

}
