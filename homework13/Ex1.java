package homework13;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * This program demonstrates
 * разбор test.xml файла, с помощью парсера SAX. На выходе должна появиться коллекция List
 * с данными класса ElementMy
 * @version
 * @author
 */
public class Ex1
	{

		public static void main(String[] args)
			{
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			SAXParser parser = null;
				try
					{
				parser = factory.newSAXParser();
					}
				catch (ParserConfigurationException e1)
					{System.out.println("ParserConfigurationException" + e1.getMessage());}
				catch (SAXException e1)
					{System.out.println("SAXException" + e1.getMessage());} 
	// Создаем объект класса SAXPars extends DefaultHandler в котором
	// переопределены методы DefaultHandler'а для парсинга нашего файла		
				SAXPars saxp = new SAXPars(); 
				 
				try
					{
	// парсинг файла, используя переопределенные методы
			parser.parse(new File("homework13/test.xml"), saxp);
					}
				catch (SAXException e)
					{System.out.println("SAXException" + e.getMessage());}
				catch (IOException e)
					{System.out.println("IOException" + e.getMessage());}
	// Выводим в консоль содержимое коллекции List<ElementMy>
	// для этого вызываем метод getResult() возвращающий коллекцию,
	// полученную в результате парсинга
				for (ElementMy eee : saxp.getResult())
				{
					System.out.println(eee.toString());
				}
		}

	}
