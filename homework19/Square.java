package homework19;

public class Square implements Shape {

	private int ssa;
	private Memento undo;
	public Square(int ssa)
	{
		this.ssa = ssa;
	}
	
	private class Memento
	{
		private int mSsa;

		Memento()
			{
				
				this.mSsa = ssa;
			}

		public int getmSsa()
			{
				return mSsa;
			}
		
		
	}
	
	public void playWithSquare()
		{
			undo = new Memento();
		}
		
		public void undoChangesSquare()
		{
			ssa = undo.getmSsa();
		}
	@Override
	public void findS()
		{
			int sum = ssa*ssa;
			System.out.println("Площадь квадрата = " + sum);
	    }


	public void setSsa(int ssa)
		{
			this.ssa = ssa;
		}

}
