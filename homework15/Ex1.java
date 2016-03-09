package homework15;

import java.util.Arrays;

/**
 * This program demonstrates
 * Есть N переменных типа int в массиве A. Все числа в массиве кроме одного имеют пару
 * (тоесть одно и тоже число встречается в массиве дважды). Ваша задача найти число,
 * которое не имеет пары (не повторяется).

 * @version
 * @author
 */
public class Ex1
{ 
   public static void main(String[] args) 

   {
	 int[] array = {0,0,1,2,1};
//   если с ^:
//	 int res = 0;
//   for(int i = 0; i < array.length; i++)
//   res = res ^ array[i];
//   System.out.println(res);
//	 если без ^:
	 if (array.length>1)
		 {
			 Arrays.sort(array);
			 for (int i = 0; i < array.length-1; i+=2)
				 {
					 if (array[i] != array[i+1])
						 {
							 System.out.println("Искомое число = " + array[i]);
							 break;
						 }
					 if (i == array.length-3)
						 {System.out.println("Искомое число = " + array[i+2]);}
					 
				 }
		 }
	 else System.out.println("Искомое число = " + array[0]);
   }
   
}
