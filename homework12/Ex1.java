package homework12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This program demonstrates
 * Создать массив с данными типа String, с использованием наиболее подходящей коллекции.
 * Заполнить его данными. Данные должны вводиться с консоли, массив может быть любой длинны.
 * Ввод прекрашать по вводу спец. команды.
 * Далее читаем данные массива в цикле и удаляем из строк все буквы "а".
 * Затем выводим получившийся массив.
 * Удаляем дубликаты
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
	ArrayList<String> strings = new ArrayList<>();
		 Scanner s1 = new Scanner(System.in);
		 String s = null;
		 String no = null;
		 do
			 {
			  System.out.println("Создание массива строковых данных.\nВведите строку для записи в массив");
				    if(s1.hasNext())
					{
				       	s = s1.next();
				    }
				    strings.add(s);
			  System.out.println("Требуется ввести еще строки??? (Y/N)");
			  if(s1.hasNext())
					{
				       	no = s1.next();
				    }
			 }
		 while (!no.equalsIgnoreCase("n"));
		 System.out.println("Исходная коллекция строк: " + strings.toString());
		 for (int i = 0; i< strings.size(); i++)
			 {
				 String str = strings.get(i);
				 str = str.replaceAll("a", "");
				 strings.set(i, str);				 
			 }
		 System.out.println("Обработанная коллекция строк: " + strings.toString());
		 HashSet<String> hSet = new HashSet<>(strings);
		 strings.clear();
		 strings.addAll(hSet);
		 System.out.println("Коллекция строк с удаленными дубликатами: " + strings.toString());
   }
}

