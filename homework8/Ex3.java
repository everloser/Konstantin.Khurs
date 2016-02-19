package homework8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program demonstrates
 * С помощью регулярных выражений написать функцию которая будет выводить формат файла:
 * например ввел kjhkj.xml  - в итоге нам выведет формат xml.
 * Т. e. нужно обрезать все символы после последней точки.
 * Также отдельно сделать проверку файла на формат. Например ввели sfdsgs.txt и нужно проверить
 * это формат xml или json, если что-то другое, то вывести ошибку.
 * @version
 * @author
 */
public class Ex3
	{

		public static void main(String[] args)
			{
				regExExtension("wqwq.wwq.gif");
				regExProverka("dfdfdfd.java");
				regExProverka("dfdfdfd.xml");
				regExProverka("dfdfdfd.json");

			}

		private static void regExExtension(String s)
			{
				Pattern p = Pattern.compile(".+\\.([a-z]+)$");
				   Matcher m = p.matcher(s);
				   if (m.find())
						{String f = m.group(1);
					    System.out.println("Формат файла - \"" + f + "\"");
						}
				   else System.out.println("формат файла не определен");
				
			}
		private static void regExProverka(String s)
			{
				Pattern p = Pattern.compile(".+\\.(xml|json)$");
				   Matcher m = p.matcher(s);
				   if (m.find())
						System.out.println("Проверка пройдена");
				   else System.out.println("Формат не поддерживается");
				
			}

	}
