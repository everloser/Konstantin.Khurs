package homework8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program demonstrates
 * С помощью регулярных выражений осуществить сжатие английского текста,
 * заменив каждую группу из двух или более рядом стоящих символов, на один символ,
 * за которым следует количество его вхождений в группу.
 * К примеру, строка hellowoooorld должна сжиматься в hel2owo4rld.
 * @version
 * @author
 */
public class Ex2
	{

		public static void main(String[] args)
			{
				regExDoubleCount("helllowoorldddddddd");

			}

		
		
		
		public static void regExDoubleCount(String s)
			   {
				   Matcher m;
				   Pattern p = Pattern.compile("([a-z])\\1");
					do
					{	
					    m = p.matcher(s);
						if (m.find())
					    {
					    	String group = m.group(1);
					    	int a = m.end(1);
					    	int b = 1;
					    	while (a<s.length() && group.toCharArray()[0] == s.charAt(a))
					    		{
					    			a++;
					    			b+=1;
					    		}
					     String gr = "["+group+"]{"+b+"}";
					     s = s.replaceFirst(gr, group + b);
					     }
					}
					while (m.find());
						System.out.println(s);
			   }
		
	}
