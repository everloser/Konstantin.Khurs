package homework6;

import java.util.Scanner;

/**
 * This program demonstrates
 * Имеется строка с текстом. Подсчитать количество слов в тексте. Желательно учесть,
 * что слова могут разделяться несколькими пробелами, в начале и конце текста также
 * могут быть пробелы, но могут и отсутствовать.
 * @version
 * @author
 */
public class Ex4

{
// можно было бы сделать через charAt с перебором по всей длине строки, но с indexOf будет меньше оборотов цикла
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = s1.trim();
		int last = s2.lastIndexOf(' ');
		int posit = 0;
		int result = 1;
		while (posit <= last)
		{
			int find = s2.indexOf(' ', posit);
				if (s2.charAt(find+1)!= ' ')
					result++;
				posit = find+1;
		}
		System.out.println("Введенная строка: \"" + s1 + "\"\nИмеет " + result + " слов(-a)");

	}

}
