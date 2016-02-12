package homework5;

import java.util.Scanner;

/**
 * This program demonstrates
 * Создать класс и объекты описывающие Банкомат. Набор купюр находящихся в банкомате должен задаваться
 * тремя свойствами: количеством купюр номиналом 20 50 100. Создать конструктор с тремя параметрами – количеством купюр
 * Сделать методы для добавления денег в банкомат. Сделать функцию снимающую деньги.
 * На вход передается сумма денег. На выход – булевское значение (операция удалась или нет).
 * При снятии денег функция должна рапечатывать каким количеством купюр какого номинала выдается сумма.. 
 * @version
 * @author
 */
public class Ex3
{ 
   public static void main(String[] args) 

   {
	   boolean d;
	   boolean success = false;
	   int summinus = 0;
	   // объект bankomat  - наличность банкомата
	   Money bankomat = new Money(0,0,0);
	   // объект cash - выдаваемая наличность
	   Money cash = new Money (0,0,0);
	   Scanner s1 = new Scanner(System.in);
		
// для зачисления и списания средств
// использовал алгоритм с равномерным использованием купюр разного номинала
// если ипользовать в основном сотки, а добирать остаток 50-ками и 20-ками,
// можно написать другой алгоритм
	   
	   do
		 {
			 System.out.println("Введите:\n\"1\" - для просмотра доступной суммы\n\"2\" - для зачисления денег"
		      + "\n\"3\" - для снятия денег\nИли любую другую клавишу для выхода из программы");
			 
		     if (s1.hasNextInt())
		     {
		    	 int fnd = s1.nextInt();
		    	 switch (fnd)
		    	 {
		    	 case 1:
		    		 System.out.print("Доступная ");
		    		 bankomat.getMoney();
		    		 break;
		    	 case 2:
		    		 do
		    		   {
		    		    System.out.println("Введите сумму для зачисления\n(min 20 BYR)");
		    		    if(s1.hasNextInt())
		    			{
		    			    	int sumplus = s1.nextInt();
		    			    	d = true;
		    			    	bankomat.addMoney(sumplus);
		    			    	System.out.println("Успешно зачислено");
		    			}
		    		    else 
		    			{
		    				 String s = s1.next();
		    				 System.out.println("Допустимо вводить только целые числа, вы ввели - \"" + s+"\"");
		    				 d = false; 
		    			}
		    		   }
		    	     while (d==false);
		    		 break;
		    	 case 3:
		    		 do
		    		   {
		    		    System.out.println("Введите сумму для снятия\n(min 20 BYR)");
		    		    if(s1.hasNextInt())
		    			{
		    			    	summinus = s1.nextInt();
		    			    	d = true;
		    			    	if (summinus <= bankomat.checkMoney() && summinus >= 0)
		    			    		success = true;
		    			    	else
		    			    		success = false;
		    			    	
		    			}
		    		    else 
		    			{
		    				 String s = s1.next();
		    				 System.out.println("Допустимо вводить только целые числа, вы ввели - \"" + s+"\"");
		    				 d = false; 
		    			}
		    		   }
		    	     while (d==false);
		    	 			
		    		 		if (success)
		    	 			{
		    	 				cash.reset();
		    	 				cash.addMoney(summinus);
		    	 				if (bankomat.getS100()-cash.getS100()<0 ||
		    	 					bankomat.getS50()-cash.getS50()<0 ||
		    	 					bankomat.getS20()-cash.getS20()<0)
		    	 				   {
		    	 					System.out.println("Операция невозможна, не хватает купюр нужного номинала\n"
		    	 							+ " Попробуйте снять другую сумму");
		    	 					cash.reset();
		    	 				   }
		    	 				else 
		    	 				   {
		    	 					bankomat.setS100(bankomat.getS100()-cash.getS100());
		    	 					bankomat.setS50(bankomat.getS50()-cash.getS50());
		    	 					bankomat.setS20(bankomat.getS20()-cash.getS20());
		    	 					System.out.print("Выдана ");
		    	 					cash.getMoney();
		    	 				   }
		    	 					
		    	 				
		    	 			}
		    	 			else System.out.println("Операция невозможна, недостаточно средств");
		    		 break;
		    		 
		    		 
		    	 default:
		    		 System.exit(0);
		    	 }
		     }
		     else System.exit(0);
		 }
		 while (true);
	 
	 
   }
   
  



}
class Money
{
	// задаем поля класса
   private int s100;
   private int s50;
   private int s20;

   // конструируем класс:
   public Money(int s100, int s50, int s20)
   {
      this.s100 = s100;
      this.s50 = s50;
      this.s20 = s20;
   }
// объявляем методы


// метод рассчитывает количество денег в объекте и выводит на печать
public void getMoney()
    
    {
	int b = 100*s100 + 50*s50 + 20*s20;
	System.out.println(" сумма " + b + " BYR\nВ том числе:\nКупюр [100] - " + s100 +
			" шт\nКупюр [50] - " + s50 + " шт\nКупюр [20] - " + s20 + " шт");
	}

// метод добавляет в объект указанную сумму, равномерно распределяя ее по разным купюрам
public void addMoney(int a)
 {
	a=a/10;
	while (a >= 2)
	   {
		if ((a>=17 && a != 20) || (a%2 == 0 && a>=10 && a<17))
		 {
			s100++;
			a-=10;
		 }
		if (a == 15)
		 {
			s100++;
			s50++;
			a-=15;
		 }
		if (a>=9 || a == 7 || a == 5)
		 {
			s50++;
			a-=5;
		 }
		if (a>=2)
		 {s20++;
		  a-=2;
		 }
	   }	
 }

 public int checkMoney()
    {
    int b = 100*s100 + 50*s50 + 20*s20;
    return b;
    }
 
 public void reset()
    {
	 s100 = s50 = s20 = 0;
    }


public int getS100() {
	return s100;
}


public void setS100(int s100) {
	this.s100 = s100;
}


public int getS50() {
	return s50;
}


public void setS50(int s50) {
	this.s50 = s50;
}


public int getS20() {
	return s20;
}


public void setS20(int s20) {
	this.s20 = s20;
}
 
}