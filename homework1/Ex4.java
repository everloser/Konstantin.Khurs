package homework1;
import java.util.*;
/**
 * This program demonstrates
 * ������� ����� ����� (�����), ��� ����� � ����� ����� � ������. ������� ��� �����,
 * ������� � ���� ����� ������� � ���������� ������.
 * @version
 * @author
 */
public class Ex4
{
   public static void main(String[] args) 

   {
      Scanner go = new Scanner(System.in);
      System.out.println("������� �����");
      int byr = go.nextInt();
      go.close();
      int by = byr/10;
        if (by %10 == 1)
          System.out.println(byr + " ������");
        else
    	  {
        	switch (byr%10)
        	{
        	  case 1:
        		  System.out.println(byr + " �����");
        	  break;
        	  case 2:
        		  System.out.println(byr + " �����");
        	  break;
        	  case 3:
        		  System.out.println(byr + " �����");
        	  break;
        	  case 4:
        		  System.out.println(byr + " �����");
        	  break;
        	  default:
        	  	  System.out.println(byr + " ������");
        	  break;
            }
          }      
   }
}