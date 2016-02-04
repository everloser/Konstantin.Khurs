package homework1;
/**
 * This program demonstrates
 * Создайте переменную типа String c любым текстом.
 * Выведите на экран количество символов в данной строке.
 * Далее разделите строку пополам. Полученные строки выведите на экран.
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
	   String full = new String ("Show me the way to the next whiskey bar");
	   int l = full.length();
	   System.out.println(l);
	   
	   String part1 = full.substring(0, l/2);
	   String part2 = full.substring(l/2);
// для вывода использовал форматирование
	   System.out.printf("%s%n%s",part1,part2);
      
   }
}