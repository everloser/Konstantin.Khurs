package homework2;

import java.util.Arrays;

/**
 * This program demonstrates
 * Создайте массив типа int. Отсортируйте массив любым слособом.
 * Результат вывести на экран.
 * @version
 * @author
 */
public class ExBonus
{
   public static void main(String[] args) 

   {
	  int[] array = new int[10];
	  for (int i = 0; i<10; i++)
	  array[i] = (int)(Math.random()*100);
	  Arrays.sort(array);
	  System.out.println(Arrays.toString(array));
      
   }
}