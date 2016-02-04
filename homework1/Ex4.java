package homework1;
import java.util.*;
/**
 * This program demonstrates
 * Имеется целое число — сумма денег в рублях. Вывести это число,
 * добавив к нему слово «рублей» в правильном падеже.
 * @version
 * @author
 */
public class Ex4
{
   public static void main(String[] args) 

   {
      Scanner go = new Scanner(System.in);
      System.out.println("Введите число");
      int byr = go.nextInt();
      go.close();
      int by = byr/10;
        if (by %10 == 1)
          System.out.println(byr + " рублей");
        else
    	  {
        	switch (byr%10)
        	{
        	  case 1:
        		  System.out.println(byr + " рубль");
        	  break;
        	  case 2:
        		  System.out.println(byr + " рубля");
        	  break;
        	  case 3:
        		  System.out.println(byr + " рубля");
        	  break;
        	  case 4:
        		  System.out.println(byr + " рубля");
        	  break;
        	  default:
        	  	  System.out.println(byr + " рублей");
        	  break;
            }
          }      
   }
}