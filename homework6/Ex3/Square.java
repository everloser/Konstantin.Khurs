package homework6.Ex3;

public class Square extends Shape {

	private int ssa;
	public Square(int ssa)
	{this.ssa = ssa;}
	@Override
	public int findS() {
		// TODO Auto-generated method stub
		
			int sum = ssa*ssa;
			return sum;
	}

}
