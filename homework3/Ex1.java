package homework3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This program demonstrates
 * Создать метод для ввода массива с клавиатуры, вида int[10]
 * Создать методы для сортировки
 * Создать метод для вывода на консоль в виде "v1" | "v2" | "v3" и т.д.
 * Создать массив, вывести его на консоль, отсортировать, снова вывести, вывести только четные.
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
	 int[] intArray = makeIntArray(10);
	 printOut(intArray);
	 Scanner s = new Scanner(System.in);
	 System.out.println("Введите:\n\"1\" - для сортировки методом класса Arrays\n\"2\" - для "
	 + "сортировки массива методом перебора\n\"3\" - для сортировки массива методом пузырька");
	 switch (s.nextInt())
	   {
	   case 1:
		 Arrays.sort(intArray);
		 break;
	   case 2:
		 selectSort(intArray);
		 break;
	   case 3:
		 bubbleSort(intArray);
		 break;
	   default:
		 System.exit(0);
	   }
	 printOut(intArray);
	 printOutEven(intArray);
	 
   }

   
   
   
 public static int[] makeIntArray(int lng)
   {
	 int[] array = new int[lng];
	 Scanner s1 = new Scanner(System.in);
	 	for (int i = 0; i<array.length; i++)
			{
	 		 System.out.println("Введите "+ (i+1) +"-ое значение массива");
			 if(s1.hasNextInt())
				{
				 array[i] = s1.nextInt();
				}
			 else 
				{
				 String s = s1.next();
				 System.out.println("Допустимо вводить только целые числа, вы ввели - \"" + s+"\"");
				 i--; 
				}
			}
		return array;
   }
 
 public static void printOut(int[] array)
   {
	 for (int i = 0; i<array.length; i++)
	 {
		 if (i!=array.length-1)
		 System.out.print("\""+array[i]+"\" | ");
		 else
		 System.out.println("\""+array[i]+"\"");
// можно использовать форматирование
//System.out.printf("\"%6d\" |", array[i]);
	 }
   }
 
 public static void selectSort(int[] array)
 {
    for (int i = 0; i < array.length; i++) 
    {
        int min = array[i];
        int mini = i; 
        for (int j = i+1; j < array.length; j++) 
        {
            if (array[j] < min)
            {
                min = array[j];
                mini = j;
            }
        }
        if (i != mini) 
        {
            int ar = array[i];
            array[i] = array[mini];
            array[mini] = ar;
        }
     }
 }
 
public static void bubbleSort(int[] array)
{
    for(int i = array.length-1 ; i > 0 ; i--)
    {
        for(int j = 0 ; j < i ; j++)
        {
            if( array[j] > array[j+1] )
            {
                int ar = array[j];
                array[j] = array[j+1];
                array[j+1] = ar;
            }
        }
    }
}

public static void printOutEven(int[] array)
{
	boolean d = true;
	int k = 0;
	do 
	 {
		if (array[k]%2 == 0)
	     {
		   System.out.print("\""+array[k]+"\"");
	       d = false;
	     }
	  k++;
	 }
	while (d == true && k<array.length);
	for (int i = k; i<array.length; i++)
	 {
		 if (array[i]%2 == 0)
		 System.out.print(" | \""+array[i]+"\"");
	 }
	System.out.println("");
}

}