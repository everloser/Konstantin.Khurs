package homework6;

import java.util.Arrays;
/**
 * This program demonstrates
 * Имеется массивы int[5] и int[3]. Нужно создать массив, в котором бы сначала шли значения
 * из массива int[5] затем из массива int[3] а затем значения 0, 1, 2.
 * @version
 * @author
 */
public class Ex2
{

	public static void main(String[] args)
	{
		int[] array1 = new int[5];
		for (int i = 0; i<5; i++)
		array1[i] = (int)(Math.random()*100);
		
		int[] array2 = new int[3];
		for (int i = 0; i<3; i++)
		array2[i] = (int)(Math.random()*100);
		
		int [] array3 = new int[array1.length + array2.length + 3];
		
		System.arraycopy(array1, 0, array3, 0, array1.length);
		System.arraycopy(array2, 0, array3, array1.length, array2.length);
		array3[8] = 0;
		array3[9] = 1;
		array3[10] = 2;
		System.out.print("Первый массив = ");
		System.out.println(Arrays.toString(array1));
		System.out.print("Второй массив = ");
		System.out.println(Arrays.toString(array2));
		System.out.print("Итоговый массив = ");
		System.out.println(Arrays.toString(array3));	

	}

}
