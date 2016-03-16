package homework19;

public class Triangle implements Shape {
    private int ssa, ssb, ssc;
    public Triangle(int ssa, int ssb, int ssc)
    {
    	this.ssa = ssa;
    	this.ssb = ssb;
    	this.ssc = ssc;
    }
	@Override
	public void findS() {
		double p = (ssa+ssb+ssc)/2;
		int sum = (int) (Math.sqrt(p*(p-ssa)*(p-ssb)*(p-ssc)));
		System.out.println("Площадь треугольника = " + sum);

	}

}
