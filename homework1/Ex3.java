package homework1;
import java.util.*;
/**
 * This program demonstrates
 *Имеется прямоугольное отверстие размерами a и b, определить, можно ли его полностью закрыть
 *круглой картонкой радиусом r.
 * @version
 * @author
 */
public class Ex3
{
   public static void main(String[] args)

   {
      boolean d = true;
       	do
    	{	 
    		Scanner go = new Scanner(System.in);	
    		try 
        		{
    			System.out.println("Input side \"a\""); 
    			int a = go.nextInt();
    			System.out.println("Input side \"b\""); 
    			int b = go.nextInt();
    			System.out.println("Input radius");
    			int r = go.nextInt();
    			go.close();
    				if (4*r*r >= a*a + b*b)
    				System.out.println("Rectangle is closed by the circle");
    				else
    				System.out.println("Rectangle isn't closed by the circle");
    			d = true;
    		 	}
       		catch (InputMismatchException e)
    		 	{  
    		 	d = false;
    		 	System.out.println("Only int values are permitted. Try again!");
    		 	}
    	}
    	while (d == false);	
   }
}