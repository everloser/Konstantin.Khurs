package homework10;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This program demonstrates
 * Создание массива объектов (Студент) из консоли,
 * запись массива объектов в файл.
 * На основе содержимого файла создавать массив объектов (Студентов) в том же виде как  изначально.
 * Пример содержимого файла:
 *  name|23.10.2010
 *  name2|21.08.2008
 *  name3|10.12.2011
 * @version
 * @author
 */
public class Ex1
	{

		public static void main(String[] args)
			{
				Scanner s1 = new Scanner(System.in);
				Student[] studArray = null;
				do
					{
						System.out.println("Введите:\n\"1\" - для создания массива студентов и записи его в файл\n\""
								+ "2\" - для чтения массива из файла\nИли любую другую клавишу для выхода из программы");

						if (s1.hasNextInt())
							{
								int fnd = s1.nextInt();
								switch (fnd)
								{
								case 1:
									studArray = makeStudArray(5);
									writeToFile(studArray);
									break;
								case 2:
									studArray = readFromFile();
									break;
								default:
									System.exit(0);
								}
							} else
							System.exit(0);
						for (Student e : studArray)
							{
								System.out.printf("Студент= %1$-10s %2$-10s д.р %3$te %3$tB %3$tY%n", e.getName(),
										e.getSurName(), e.getbDay());
							}
					} while (true);
			}

		private static Student[] makeStudArray(int st)
			{
				Student[] array = new Student[st];
				 Scanner s1 = new Scanner(System.in);
				 boolean d = true;
				 for (int i = 0; i<array.length; i++)
					{
						Date myDate = null;
						String s = null;
						String sN = null;
					    System.out.println("Введите имя "+ (i+1) +"-ого студента");
						    if(s1.hasNext())
							{
						       	s = s1.next();
						    	s = s.toUpperCase();
						    	
							}
						
				 			System.out.println("Введите фамилию "+ (i+1) +"-ого студента");
						    if(s1.hasNext())
							{
								sN = s1.next();
						    	sN = sN.toUpperCase();
						    	
							}
						
				 		do
				 		 {
				 			System.out.println("Введите дату рождения "+ (i+1) +"-ого студента, в виде дд.мм.гг");
				 			String sd = s1.next();
				 			Pattern p = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{2}$");
				 		    Matcher m = p.matcher(sd);
				 		    if(m.find())
							{
						    	d = true;
						    	SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yy");
						    	
								try {
									formats.setLenient(false);
									myDate = formats.parse(sd);
								} catch (ParseException e) {
									d = false;
									System.out.println("Вы ввели некорректную дату");
								}
						   	}
						    else 
							{
							 System.out.println("Допустимо вводить строку формата дд.мм.гг, вы ввели - \"" + sd+"\"");
							 d = false; 
							}
				 		 }
				 		 while (d==false);
				 		array[i] = new Student(s, sN, myDate);
				 	}		
				 return array;
			   }

		private static void writeToFile(Student[] array)
			{
				File f = new File("homework10/StudArray.txt");
				try (FileWriter writer = new FileWriter(f, false))
					{
						for (Student e : array)
							{
								String text = null;
								text = e.toString();
								writer.write(text);
								writer.append('\n');
								writer.flush();
							}
						writer.close();

					} catch (IOException ex)
					{
						System.out.println(ex.getMessage());
					}

			}

		private static Student[] readFromFile()
			{
				File f = new File("homework10/StudArray.txt");
				String longer = null;
				Date myDate = null;
				SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yy");
				try (FileReader reader = new FileReader(f))
					{
						char[] buffer = new char[(int) f.length()];
						reader.read(buffer);
						longer = new String(buffer);
						reader.close();
					} catch (IOException ex)
					{
						System.out.println(ex.getMessage());
					}
				String[] rows = longer.split("\\n");
				int lng = rows.length;
				int st = 0;
				Student[] array = new Student[lng];
				for (String e : rows)
					{
						String[] student = e.split("\\|");
						try
							{
								myDate = formats.parse(student[2]);
							} catch (ParseException er)
							{
							}
						array[st] = new Student(student[0], student[1], myDate);
						st++;
					}

				return array;

			}

	}
