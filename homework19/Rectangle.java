package homework19;

public class Rectangle implements Shape
{
    
	private int ssa,ssb;
	
	public Rectangle (int ssa, int ssb)
	{
	this.ssa = ssa;
	this.ssb = ssb;
	}
    @Override
	public void findS()
    	{
    		int sum = ssa*ssb;
    		System.out.println("Площадь прямоугольника = " + sum);
    	}

}
