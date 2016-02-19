package homework8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program demonstrates
 * При помощи регулярных выражений проводим проверку строк на соответствие
 * 1 - автомобильному номеру РБ;
 * 2 - телефонному номеру РБ.
 * @version
 * @author
 */
public class Ex1
{
   public static void main(String[] args) 

   {
	   regExCarN("1713 OT-7");
	   regExTelN("+375n29 g8 63 (88)-22 ");
   }

   
   
   
 public static void regExCarN(String s)
   {
	   Pattern p = Pattern.compile("^\\d{4}\\s[A-Z]{2}-[1-7]$");
	   Matcher m = p.matcher(s);
	   if (m.find())
			System.out.println("Соответствует автомобильному номеру РБ");
	   else System.out.println("Не соответствует автомобильному номеру РБ");
   }
 
 public static void regExTelN(String s)
   {
	   s = s.replaceAll("[^+0-9]", "");
	   Pattern p = Pattern.compile("^\\+375(17|25|29|33|44)\\d{7}$");
	   Matcher m = p.matcher(s);
	   if (m.find())
			System.out.println("Номер " + s + " cоответствует телефонному номеру РБ");
	   else System.out.println("Номер " + s + " не соответствует телефонному номеру РБ");
   }
 
 }