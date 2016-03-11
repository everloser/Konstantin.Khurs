package homework16;

import java.util.Scanner;

/**
 * This program demonstrates
 * использовать 2 потока(класс один и тот же). Класс потока должен обеспечивать в методе run
 * построчный несинхронизированный вывод в консольное окно метода print10() класса main
 * в котором идет вывод  чисел от 1 до 100 порциями по 10 чисел в строке, разделенных пробелами,
 * причем перед каждой такой порцией должна стоять надпись:
 * "Thread 1:" для первого потока, "Thread 2:" — для второго.
 * Для вывода строки чисел задать в Main классе метод print10() -
 * в нем запускать цикл на печать 10-ти чисел.
 * В приложении при вводе с клавиатуры "start" потоки должны стартовать.
 * @version
 * @author
 */
public class Ex2
	{

		public static void main(String[] args)
			{
				System.out.println("Введите \"start\" для запуска потоков");
				 Scanner s = new Scanner(System.in);
				 switch (s.next())
				   {
				   case "start":
				   {
					   MySuperThread thread = new MySuperThread();
					   thread.setName("First:");
					   thread.start();
					   MySuperThread thread2 = new MySuperThread();
					   thread2.setName("Second:");
					   thread2.start();
				   }
					 break;
				   default:
					 System.exit(0);
				   }

			}
		public static void print10()
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
