package homework7;

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;


// исполнено три варианта обращения к интерфейсу
// 1 - объекту интерфейса MoneyListener присваивается ссылка на текущий объект Money
// 2 - объект Money создает объект ProstoClass, на метод которого вешается один из методов интерфейса MoneyListener.
// 3 - использование библиотечного интерфейса ActionListener в классе CountDown для реализации следующего:
// при выборе функции снятия денег, будет установлен таймер, дающий 15 секунд на ввод суммы для снятия
/**
 * This program demonstrates
 * Создать класс и объекты описывающие Банкомат. Набор купюр находящихся в банкомате должен задаваться
 * тремя свойствами: количеством купюр номиналом 20 50 100. Создать конструктор с тремя параметрами – количеством купюр
 * Сделать методы для добавления денег в банкомат. ЧЕРЕЗ ИНТЕРФЕЙС Сделать функцию снимающую деньги.
 * На вход передается сумма денег. На выход – булевское значение (операция удалась или нет).
 * При снятии денег функция должна рапечатывать каким количеством купюр какого номинала выдается сумма.. 
 * @version
 * @author
 */
public class Ex1
{ 
	
	public static void main(String[] args) 

   {
	   MoneyListener listener;
// listener3 -  переменная интерфейса ActionListener,
// ссылающаяся на объект класса CountDown, где описано действие на событие
	   ActionListener listener3 = new CountDown();
	   boolean d;
	   boolean success = false;
	   int summinus = 0;
	   // объект bankomat  - наличность банкомата
	   Money bankomat = new Money(0,0,0);
	   // объект cash - выдаваемая наличность
	   Money cash = new Money (0,0,0);
	   Scanner s1 = new Scanner(System.in);
		listener = cash;
// создаем таймер с установленным действием
		Timer t = new Timer(15000, listener3);
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
		    		    System.out.println("Введите сумму для снятия\n(min 20 BYR)\n"
		    		    		+ "ВНИМАНИЕ!!! ПРИ НЕ ВВОДЕ СУММЫ В ТЕЧЕНИЕ 15 СЕКУНД, РАБОТА ПРОГРАММЫ БУДЕТ ОСТАНОВЛЕНА");
// запускаем таймер, дающий 15 сек для ввода суммы для снятия
		    		    t.start();
		    		    if(s1.hasNextInt())
		    			{
		    			    	t.stop();
		    				    summinus = s1.nextInt();
		    			    	d = true;
// вызов метода интерфейса объект которого имеет ссылку на объект cash класса Money
		    			    	listener.snyatie();
// вызов метода doIt() из класса ProstoClass, вызывающего метод интерфейса
		    			    	cash.doProsto();
		    			    	if (summinus <= bankomat.checkMoney() && summinus >= 0)
		    			    		success = true;
		    			    	else
		    			    		success = false;
		    			    	
		    			}
		    		    else 
		    			{
		    				 t.stop();
		    				 String s = s1.next();
		    				 System.out.println("Допустимо вводить только целые числа, вы ввели - \"" + s+"\"");
		    				 d = false; 
		    			}
		    		   }
		    	     while (d==false);
		    	 			
		    		 		if (success)
		    	 			{
		    	 				cash.reset();
// обращение к объекту интерфейса ссылающегося на объект cash класса Money
		    	 				listener.addMoney(summinus);
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
