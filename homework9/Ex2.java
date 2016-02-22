package homework9;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program demonstrates
 * Запись и чтение из текстового файла
 * @version
 * @author
 */
public class Ex2
	{

		public static void main(String[] args)
			{
				Scanner s1 = new Scanner(System.in);
				File f = new File("homework9/test.txt");
				do
					 {
						 System.out.println("Введите:\n\"1\" - для чтения из файла\n\"2\" - для "
					      + "дозаписи в файл\nИли любую другую клавишу для выхода из программы");
						 
					     if (s1.hasNextInt())
					     {
					    	 int fnd = s1.nextInt();
					    	 switch (fnd)
					    	 {
					    	 case 1:
					    		 try(FileReader reader = new FileReader(f))
									{
									    char[] buffer = new char[(int)f.length()];
									    reader.read(buffer);
									    System.out.println(new String(buffer));
									}
								 catch(IOException ex)
									{
									 System.out.println(ex.getMessage());
									}
					    		 break;
					    	 case 2:
					    		 try(FileWriter writer = new FileWriter(f, true))
					    	        {
					    	        	System.out.println("Введите строку для дозаписи в файл");
					    	        	String text = null;
					    	        	if(s1.hasNext())
					    				text = s1.next();
					    				writer.append('\n');
					    	        	writer.write(text);
					    	            writer.flush();
					    	        }
					    	        catch(IOException ex)
					    			{
					    	           System.out.println(ex.getMessage());
					    	        } 
					    		 break;
					    	 default:
					    		 System.exit(0);
					    	 }
					     }
					     else System.exit(0);
					 }
					 while (true);
				
				
				
			}

	}
