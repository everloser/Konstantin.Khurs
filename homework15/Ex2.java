package homework15;

/**
 * На вход программе поступает трёхзначное число (от 100 до 999).
 * Необходимо определить является ли число счастливым.
 * Счастливое число, это число у которого все цифры совпадают (например 777),
 * либо число у которого каждая последующая цифра на 1 больше предыдущей (123 или 456). 
 * @author
 */
public class Ex2
	{

		public static void main(String[] args)
			{
				int number = (int)(Math.random()*900)+100;
		        int c3 = number%10;
		        number = number/10;
		        int c2 = number%10;
		        number = number/10;
		        int c1 = number%10;
		        
		        if (c1 == c2 && c2==c3 || c2 == c1+1 && c3 == c2+1)
		        	System.out.println("Happy "+ c1 + c2 + c3);	
		        else
		        	System.out.println("Unhappy "+ c1 + c2 + c3);
			}

	}
