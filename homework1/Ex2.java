package homework1;
/**
 * This program demonstrates
 * Создайте любое число. Определите, является ли последняя цифра числа семеркой.
 * @version
 * @author
 */
public class Ex2
{
   public static void main(String[] args) 
// придумал два метода для решения данной задачи
// для наглядности создал и описал их отдельно
   {
      int x = 127;
      sevenSearch1(x);
      sevenSearch2(x);
   }
   
   private static void sevenSearch1(int a)
   {
	   if (a%10==7)
	      System.out.println("Ends with seven");
	   else 
	      System.out.println("Not ends with seven");
   }
   
   private static void sevenSearch2(int a)
   {
	   String y= ""+a;
	   if (y.endsWith("7"))
	   	   System.out.println("Ends with seven");
	   else 
	  	   System.out.println("Not ends with seven");
   }
}