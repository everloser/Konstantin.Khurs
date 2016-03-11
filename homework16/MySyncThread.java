package homework16;

public class MySyncThread extends Thread
	{
		public void run()
			{
				for (int i = 0; i<13;i++)
					{
						Ex3.print10();
						try
							{
								Thread.sleep(1050);
							} catch (InterruptedException e)
							{
								System.out.println("sleep error " + e.getMessage());
							}
			 		}
			}
	}
