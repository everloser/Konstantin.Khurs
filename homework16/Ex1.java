package homework16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This program demonstrates
 * Добавить многопоточность в итоговый проект
 * 
 * Т.к. итоговый проект у меня реализован при помощи библиотеки Swing в одном JFrame
 * Втиснуть туда многопоточность на том уровне, который мы затронули на занятиях не выходит
 * JFrame уже реализован в рамках EventQueue.invokeLater(new Runnable(){public void run()...
 * Поэтому в итоговом проекте добавил класс SwingWorker, который создает отдельный поток и 
 * имеет метод doInBackground() в котором у меня происходит скачивание и парсинг, кроме того,
 * т.к. данных мало и процесс быстротечен в SwingWorker был добавлет спец счетчик, растягивающий
 * выполнение данного потока и добавлена визуализация процесса в JTextArea и создан ProgressMonitor
 * 
 * В данном классе реализована многопоточность для консольной версии
 * @version
 * @author
 */
public class Ex1
{ 
   public static void main(String[] args) 

   {
	   Thread thread = new Thread(new Runnable()
				{
					
					@Override
					public void run()
						{
							// всё, что тут запустится в другом потоке
							System.out.println("Downloading...");
							Manage.parseXML();
							try
								{
									Thread.sleep(3000);
								} catch (InterruptedException e)
								{
									System.out.println("hread error = " + e.getMessage());
								}
						}
				});
	 System.out.println("Введите \"1\" для скачивания и парсинга файла");
	 Scanner s = new Scanner(System.in);
	 switch (s.nextInt())
	   {
	   case 1:
		 thread.start();
		 break;
	   default:
		 System.exit(0);
	   }
	 while(thread.isAlive())
		 {
			 System.out.println("..................");
			 try
					{
						Thread.sleep(500);
					} catch (InterruptedException e)
					{
						System.out.println("hread error = " + e.getMessage());
					}
		 }
	 if (Manage.getRoot() != null)
		 {
			 System.out.println("Download complete");
			 System.out.println(Manage.getRoot().toString());
		 }
   }
   
}
