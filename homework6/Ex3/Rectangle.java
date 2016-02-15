package homework6.Ex3;

public class Rectangle extends Shape {
    
	private int ssa,ssb;
	
	public Rectangle (int ssa, int ssb)
	{
	this.ssa = ssa;
	this.ssb = ssb;
	}
    @Override
	public int findS() {
		int sum = ssa*ssb;
		return sum;

	}

}
