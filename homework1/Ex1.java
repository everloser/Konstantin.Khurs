package homework1;
/**
 * This program demonstrates
 *Создайте переменную типа String c любым текстом. Далее выведите на экран количество символов в данной строке.
 *Далее разделите строку пополам, в  результате у вас должно быть 2-е новых переменных типа String
 *с частями из изначальной строки. Полученные строки выведите на экран.
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
	   System.out.printf("%s%n%s",part1,part2);
      
   }
}