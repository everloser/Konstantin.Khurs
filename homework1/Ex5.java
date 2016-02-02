package homework1;
/**
 * This program demonstrates
 * Имеется строка, которая содержит символы ? и символы #.  Замените все символы ? на HELLO,
 * а # - удалите. Результат вывести на экран.
 * @version
 * @author
 */
public class Ex5
{
   public static void main(String[] args) 

   {
      String s = "***?#***#***?";
      String s1 = s.replace("?", "HELLO");
      String s2 = s1.replace("#", "");
      System.out.println(s2);
   }
}