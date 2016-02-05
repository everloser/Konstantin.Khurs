package homework2;

import java.util.Arrays;

/**
 * This program demonstrates
 * Создайте массив с 10-ю переменными типа int. Используя оператор "for" найдите и выведите на экран
 * наименьшее и наибольшее значение в массиве.
 * min value =  "значение".
 * max value =  "значение".
 * Далее замените наименьшее значение на 0, а наибольшее значение на 99
 * выведите получившийся массив на экран в виде: [23, 0, 34, 99, 43534]
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
	   int[] array = new int[10];
	   for (int i = 0; i<10; i++)
	   array[i] = (int)(Math.random()*100);
      
	   int max = (int)Double.MIN_VALUE;
	   int min = (int)Double.MAX_VALUE;
	   int indexMax = 0;
	   int indexMin = 0;
	   for (int i = 0; i<array.length; i++)
	      {
		   if (array[i]>max)
		      {
			   max = array[i];
			   indexMax = i;
		      }
		   if (array[i]<min)
		      {
			   min = array[i];
			   indexMin = i;
		      }
	      }
	   System.out.println("min value =  \""+ min +"\"");
	   System.out.println("max value =  \""+ max +"\"");
	   array[indexMax] = 99;
	   array[indexMin] = 0;
	   System.out.println(Arrays.toString(array));
   }
}