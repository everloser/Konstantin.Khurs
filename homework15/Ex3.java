package homework15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Вывести все слова из заданного текста (текст читается из файла)
 * в порядке возрастания количества букв в каждом из них.
 * @author
 */
public class Ex3
	{

		public static void main(String[] args)
			{
				ArrayList<String> words = new ArrayList<>();
				Scanner in;
// читаем файл "пословно", записываем слова в коллекцию
				try
					{
						in = new Scanner(new File("homework15/House.txt"));
						while (in.hasNext())
							{
								String word = in.next();
								words.add(word);
							}
					} 
				catch (FileNotFoundException e)
					{
						System.out.println("Файл не найден, "+ e.getMessage());
					}
// Сортируем коллекцию компоратором
				Comparator<String> comporator = new Comparator<String>()
					{
						
						@Override
						public int compare(String o1, String o2)
							{
								int result = 0;
								if (o1.length()>o2.length())
										result = 1;
								if (o1.length()<o2.length())
										result = -1;
								return result;
							}
					};
				
					Collections.sort(words, comporator);
					System.out.println(words);

			}

	}
