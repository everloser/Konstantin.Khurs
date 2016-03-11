package homework16;

import java.util.Scanner;

/**
 * This program demonstrates
 * Синхронизировали метод print10() из Ex2
 * @version
 * @author
 */
public class Ex3
	{

		public static void main(String[] args)
			{
				System.out.println("Введите \"start\" для запуска потоков");
				 Scanner s = new Scanner(System.in);
				 switch (s.next())
				   {
				   case "start":
				   {
					   MySyncThread thread = new MySyncThread();
					   thread.setName("First:");
					   thread.start();
					   MySyncThread thread2 = new MySyncThread();
					   thread2.setName("Second:");
					   thread2.start();
				   }
					 break;
				   default:
					 System.exit(0);
				   }

			}
		public static synchronized void print10()
		{
			System.out.print(Thread.currentThread().getName());
			for (int i = 0; i<10; i++)
			{
				int a = (int) (Math.random()*100);
				System.out.print(" " + a);
			}
			System.out.println();
			
		}
		

	}