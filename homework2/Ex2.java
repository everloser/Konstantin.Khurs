package homework2;
/**
 * This program demonstrates
 * Создайте массив с 10-ю переменными типа float. Найдите дубликаты и выведите их количество.
 * В результате выполнения программы на экран должно вывести:
 * [число1] - повторений a
 * [числоi] - повторений b
 * @version
 * @author
 */
public class Ex2
{
   public static void main(String[] args) 

   {
	   float[] array = {2, 3, 5, 7, 6, 5, 7, 3, 7, 20};
	   for (int i = 0; i<array.length-1; i++)
	   {
		   int d = 1;
		   for (int n = i+1; n<array.length; n++)
		   {
// если значение i равно n, и n не дробное, прибавляем счетчику 1, и делаем n дробным 
			   if (array[i]==array[n] && array[i]-(int)array[i]==0)
			   {
				   d+=1;
				   array[n] += 0.5;
			   }
// если значение счетчика больше единицы и мы перебрали весь архив, выводим строку
			   if (d>1 && n==array.length-1)
				   System.out.printf("[%.0f] - повторений %d%n", array[i], d);
		   }
	   }
      
   }
}