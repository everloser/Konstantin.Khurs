package homework2;

import java.util.Arrays;

/**
 * This program demonstrates
 * печатает массив, затем инвертирует (то есть меняет местами первый элемент с последним,
 * второй — с предпоследним и т.д.), и вновь печатает.
 * @version
 * @author
 */
public class Ex3
{
   public static void main(String[] args) 

   {
	   int[] array = new int[10];
	   for (int i = 0; i<10; i++)
	   array[i] = (int)(Math.random()*100);
	   System.out.println(Arrays.toString(array));  
       int ar;
       int n = array.length-1;
       for (int i = 0; i<array.length/2; i++)
    	   {
    	    ar = array[i];
    	    array[i] = array[n];
    	    array[n] = ar;
    	    n--;
    	   }
       System.out.println(Arrays.toString(array));
   }
}