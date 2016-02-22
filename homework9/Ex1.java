package homework9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program demonstrates
 * Создайте массив объектов класса Студент, заполнение данных должно быть из консоли,
 * день рождения должен вводиться в виде строки (любой формат), затем конвертироваться в Date
 * и записываться в объект Студент. Ваша задача найти средний возраст всех студентов.
 * Результат вывести в следующем виде: 50 лет 3 месяца.
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
// делаем массив студентов
	     Student[] studArray = makeStudArray(3);
		 long all = 0;
// переводим даты в long суммируем и делим на количество студентов,
// далее эту среднюю long переводим в дату 
		 for (Student e : studArray)
			 {
				 all += e.getbDay().getTime();
			 }
		 all = all/studArray.length;
		 Date srd = new Date(all);
// делаем два календаря (на сейчас и на среднюю дату рождения)
// отнимаем года и месяцы
		 GregorianCalendar today = new GregorianCalendar();
		 GregorianCalendar sred = new GregorianCalendar();
		 sred.setTime(srd);
		 int month, year;
		if (today.get(GregorianCalendar.MONTH)<sred.get(GregorianCalendar.MONTH))
			 {
			  month = today.get(GregorianCalendar.MONTH)-sred.get(GregorianCalendar.MONTH)+12;
			  sred.add(GregorianCalendar.YEAR, 1);
			  year = today.get(GregorianCalendar.YEAR)-sred.get(GregorianCalendar.YEAR);
			 }
		else 
			{
				month = today.get(GregorianCalendar.MONTH)-sred.get(GregorianCalendar.MONTH);
				year = today.get(GregorianCalendar.YEAR)-sred.get(GregorianCalendar.YEAR);
			}
		 
		 for (Student e : studArray)
	         {
	   // мое отформатированное представление вывода
	           System.out.printf("Студент = %1$-10s %2$-10s, д.р %3$te %3$tB %3$tY%n", e.getName(),
			   e.getSurName(), e.getbDay());
	         }
		 System.out.println("Средний возраст студентов " + year + " лет и " + month + " месяцев");
   }

   
   
private static Student[] makeStudArray(int st)
	{
		Student[] array = new Student[st];
		 Scanner s1 = new Scanner(System.in);
		 boolean d = true;
		 for (int i = 0; i<array.length; i++)
			{
				Date myDate = null;
				String s = null;
				String sN = null;
			    System.out.println("Введите имя "+ (i+1) +"-ого студента");
				    if(s1.hasNext())
					{
				       	s = s1.next();
				    	s = s.toUpperCase();
				    	
					}
				
		 			System.out.println("Введите фамилию "+ (i+1) +"-ого студента");
				    if(s1.hasNext())
					{
						sN = s1.next();
				    	sN = sN.toUpperCase();
				    	
					}
				
		 		do
		 		 {
		 			System.out.println("Введите дату рождения "+ (i+1) +"-ого студента, в виде дд.мм.гг");
		 			String sd = s1.next();
		 			Pattern p = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{2}$");
		 		    Matcher m = p.matcher(sd);
		 		    if(m.find())
					{
				    	d = true;
				    	SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yy");
				    	
						try {
							formats.setLenient(false);
							myDate = formats.parse(sd);
						} catch (ParseException e) {
							d = false;
							System.out.println("Вы ввели некорректную дату");
						}
				   	}
				    else 
					{
					 System.out.println("Допустимо вводить строку формата дд.мм.гг, вы ввели - \"" + sd+"\"");
					 d = false; 
					}
		 		 }
		 		 while (d==false);
		 		array[i] = new Student(s, sN, myDate);
		 	}		
		 return array;
	   }
}

   
   
   
 
 