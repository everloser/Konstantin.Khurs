package homework6.Ex3;

public class Triangle extends Shape {
    private int ssa, ssb, ssc;
    public Triangle(int ssa, int ssb, int ssc)
    {
    	this.ssa = ssa;
    	this.ssb = ssb;
    	this.ssc = ssc;
    }
	@Override
	public int findS() {
		double p = (ssa+ssb+ssc)/2;
		int sum = (int) (Math.sqrt(p*(p-ssa)*(p-ssb)*(p-ssc)));
		return sum;

	}

}
