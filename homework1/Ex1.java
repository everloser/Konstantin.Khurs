package homework1;
/**
 * This program demonstrates
 *�������� ���������� ���� String c ����� �������. ����� �������� �� ����� ���������� �������� � ������ ������.
 *����� ��������� ������ �������, �  ���������� � ��� ������ ���� 2-� ����� ���������� ���� String
 *� ������� �� ����������� ������. ���������� ������ �������� �� �����.
 * @version
 * @author
 */

public class Ex1
{
   public static void main(String[] args) 

   {
	   String full = new String ("Show me the way to the next whiskey bar");
	   int l = full.length();
	   System.out.println(l);
	   
	   String part1 = full.substring(0, l/2);
	   String part2 = full.substring(l/2);
	   System.out.printf("%s%n%s",part1,part2);
      
   }
}