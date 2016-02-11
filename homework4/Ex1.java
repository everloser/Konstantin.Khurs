package homework4;

import java.util.Scanner;

/**
 * This program demonstrates
 * Вам необходимо создать программу с 1-м собственным объектом (классом): Пациент.
 * В объекте вам нужно описать переменные характерные для данной сущности.
 * В классе должны быть обязательно переменные типов int, String, boolean.
 * В классе должны быть созданы методы set и get для переменных свойств.
 * В основном классе(файле) вы должны создать минимум 3 объекта Пациента
 * Заполнить их данными из консоли (ввод данных сделать в красивом виде).
 * После ввода данных вы должны вывести данные на экран в вледующем виде:
 * Пациент “ФИО” - Возрас = “возраст”
 * Далее вы должны дать пользователю возможность найти пациента по фамилии и по возрасту. 
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
	 Scanner s1 = new Scanner(System.in);
	 Pacient[] pacArray = makePacArray(3);
	 printOut(pacArray);
	 
	 do
	 {
		 System.out.println("Введите:\n\"1\" - для поиска пациента по фамилии\n\"2\" - для "
	      + "для поиска пациента по возрасту\nИли любую другую клавишу для выхода из программы");
		 
	     if (s1.hasNextInt())
	     {
	    	 int fnd = s1.nextInt();
	    	 switch (fnd)
	    	 {
	    	 case 1:
	    		 findBySurname(pacArray);
	    		 break;
	    	 case 2:
	    		 findByAge(pacArray);
	    		 break;
	    	 default:
	    		 System.exit(0);
	    	 }
	     }
	     else System.exit(0);
	 }
	 while (true);
   }

   
   
   
   
   
   
 // Метод создает и заполняет через консоль массив объектов Pacient.
 public static Pacient[] makePacArray(int lng)
   {
	 Pacient[] array = new Pacient[lng];
	 Scanner s1 = new Scanner(System.in);
	 boolean d = true;
	 for (int i = 0; i<array.length; i++)
		{
	 		array[i] = new Pacient(); 
		    //do
	 		//{
	 			System.out.println("Введите имя "+ (i+1) +"-ого пациента");
			    if(s1.hasNext())
				{
			    	//d = true;
			    	String s = s1.next();
			    	s = s.toUpperCase();
			    	array[i].setName(s);
				}
			/*    else 
				{
				 String s = s1.next();
				 System.out.println("Допустимо вводить только символы кирилицы/латиницы, вы ввели - \"" + s+"\"");
				 d = false; 
				}
	 		  }
	 		  while (d==false);
	 		 */
	 		//do
	 		// {
	 			System.out.println("Введите фамилию "+ (i+1) +"-ого пациента");
			    if(s1.hasNext())
				{
			   // 	d = true;
			    	String s = s1.next();
			    	s = s.toUpperCase();
			    	array[i].setSurname(s);
				}
			/*    else 
				{
				 String s = s1.next();
				 System.out.println("Допустимо вводить только символы кирилицы/латиницы, вы ввели - \"" + s+"\"");
				 d = false; 
				}
	 		 }
	 		 while (d==false);
	 		 */
	 		//do
	 		// {
	 			System.out.println("Введите отчество "+ (i+1) +"-ого пациента");
			    if(s1.hasNext())
				{
			    //	d = true;
			    	String s = s1.next();
			    	s = s.toUpperCase();
			    	array[i].setPatname(s);
				}
			/*    else 
				{
				 String s = s1.next();
				 System.out.println("Допустимо вводить только символы кирилицы/латиницы, вы ввели - \"" + s+"\"");
				 d = false; 
				}
	 		 }
	 		 while (d==false);
	 		 */
	 		do
	 		 {
	 			System.out.println("Введите возраст "+ (i+1) +"-ого пациента");
			    if(s1.hasNextInt())
				{
			    	int agg = s1.nextInt();
			    	d = true;
			    	array[i].setAge(agg);
				}
			    else 
				{
				 String s = s1.next();
				 System.out.println("Допустимо вводить только целые числа, вы ввели - \"" + s+"\"");
				 d = false; 
				}
	 		 }
	 		 while (d==false);
	 		do
	 		 {
	 			System.out.println("Введите номер амб.карты "+ (i+1) +"-ого пациента");
			    if(s1.hasNextLong())
				{
			    	long num = s1.nextLong();
			    	d = true;
			    	array[i].setCard(num);
				}
			    else 
				{
				 String s = s1.next();
				 System.out.println("Допустимо вводить только целые числа, вы ввели - \"" + s+"\"");
				 d = false; 
				}
	 		 }
	 		 while (d==false);
	 		do
	 		 {
	 			System.out.println("Проходил ли  "+ (i+1) +"-ый пациент вакцинацию, Y/N");
	 			String s = s1.next();
	 			s = s.toUpperCase();
			    if(s.equals("Y") || s.equals("N"))
				{
			    	d = true;
			    	
			    	switch (s)
			    	{
			    	case "Y":
			    		array[i].setVaccina(Pacient.Y);
			    	break;
			    	case "N":
			    		array[i].setVaccina(Pacient.N);
			    	break;
			    	}
			    	
				}
			    else 
				{
				 System.out.println("Допустимо вводить только Y/N, вы ввели - \"" + s+"\"");
				 d = false; 
				}
	 		 }
	 		 while (d==false);
	 		do
	 		 {
	 			System.out.println("Введите пол "+ (i+1) +"-ого пациента, \"0\"-муж, \"1\"-жен.");
	 			
			    if(s1.hasNextInt()) 
				{ 
			    int sss = s1.nextInt();	
			    switch (sss)
			    {
				case 0:
					array[i].setSex(Pacient.M);
					d = true;
					break;
				case 1:
					array[i].setSex(Pacient.W);
					d = true;
					break;
				default : 
					{System.out.println("Допустимо вводить только 1/0");
					d = false;
					}				
			    }
				}
			    else 
				{
				 String st = s1.next();
				 System.out.println("Допустимо вводить только 1/0, вы ввели - \"" + st+"\"");
				 d = false; 
				}
	 		 }
	 		 while (d==false);
	 	}		
	 return array;
   }
 // метод выводит на консоль массив, в указанном в условии виде 
 public static void printOut(Pacient[] array)
   {
	 for (int i = 0; i<array.length; i++)
	 {
		 System.out.println("Пациент " +array[i].getName() +" "+ array[i].getSurname()+" "+array[i].getPatname()
				 +" - возраст = \""+array[i].getAge() + "\"");

	 }
   }
 
 // метод производит поиск в массиве по значению "фамилия" и выводит найденные объекты на консоль
 public static void findBySurname(Pacient[] array)
 {
	 Scanner s1 = new Scanner(System.in);
	 System.out.println("Введите фамилию пациента для поиска");
	 String sf = null;
	 boolean find = true;
	 if(s1.hasNext())
		{
	       	sf = s1.next();
	    	sf = sf.toUpperCase();
	    }
	 for (int i = 0; i < array.length; i++) 
     {
        if (sf.equals(array[i].getSurname()))
            {
               printFullline(array[i]);
               find = false;
            }
     }
     if (find) System.out.println("Совпадений не найдено");
     
 }
 // метод производит поиск в массиве по значению "возраст" и выводит найденные объекты на консоль
public static void findByAge(Pacient[] array)
{
	Scanner s1 = new Scanner(System.in);
	 System.out.println("Введите возраст пациента для поиска");
	 int af;
	 boolean find = true;
	 if(s1.hasNextInt())
		{
	       	af = s1.nextInt();
	       	for (int i = 0; i < array.length; i++) 
	        {
	           if (af == array[i].getAge())
	               {
	                  printFullline(array[i]);
	                  find = false;
	               }
	        }
		}
	 else 
	    {
		 String nf = s1.next();
		 System.out.println("Совпадений с " + nf + " не найдено");
		 find = false;
	    }
     if (find) System.out.println("Совпадений не найдено");
     
}
// Метод выводит на консоль объект Pacient
public static void printFullline(Pacient pacient)
{
	boolean d = pacient.isVaccina();
	char ssex = pacient.getSex();
	String vac = "";
	String pol;
	if (d == false)
		vac = "не ";
	if (ssex == 'M')
		 pol = "Мужчина";
	else 
		 pol = "Женщина";
		  
		 System.out.println("Пациент " +pacient.getName() +" "+ pacient.getSurname()+" "+pacient.getPatname()
				 +"\nВозраст = \""+pacient.getAge() + "\" " + pol + "\nНомер амб.карты = \""+pacient.getCard() +
				 "\"\nВакцинация " + vac + "проводилась");
}

}