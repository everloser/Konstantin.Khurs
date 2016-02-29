package homework12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This program demonstrates
 * Необходимо удалить дубликаты из массива предыдущего задания (сделал в Ex1).
 * Читает слова из файла и:
 * выводит общее количество слов
 * удаляет дубликаты
 * выводит количество уникальных слов
 * @version
 * @author
 */
public class Ex2
	{

		public static void main(String[] args)
			{
				ArrayList<String> words = new ArrayList<>();
				Scanner in;
				try
					{
						in = new Scanner(new File("homework12/House.txt"));
						while (in.hasNext())
							{
								String word = in.next();
								words.add(word);
							}
					} 
				catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
				HashSet<String> stSet = new HashSet<>(words);
				System.out.println(
					"Количество слов в файле: " + words.size() + "\nКоличество уникальных слов: " + stSet.size());
			}

	}
