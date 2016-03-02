package homework13.zapisuXML;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This program demonstrates
 * Создаем коллекцию объектов Student используя данные текстового файла StudArray.txt
 * Создаем XML документ students.xml с данными коллекции.
 * @version
 * @author
 */
public class Zapis
	{

		public static void main(String[] args)
			{
				File f = new File("homework13/zapisuXML/StudArray.txt");
				ArrayList<Student> list = new ArrayList<>();
				String longer = null;
				Date myDate = null;
				SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yy");
	// читаем текстовый файл
				try (FileReader reader = new FileReader(f))
					{
						char[] buffer = new char[(int) f.length()];
						reader.read(buffer);
						longer = new String(buffer);
						reader.close();
					} catch (IOException ex)
					{
						System.out.println(ex.getMessage());
					}
	// массив строк, где каждая строка - текстовая интерпритация объекта Student			
				String[] rows = longer.split("\\n");
					for (String e : rows)
					{
						String[] student = e.split("\\|");
						try
							{
								myDate = formats.parse(student[2]);
							} catch (ParseException er)
							{
							}
	// добавляем объект в коллекцию
						list.add(new Student(student[0], student[1], myDate));
						
					}

	// Выводим полученный список на консоль
					for(Student stud : list)
					{
						System.out.printf("Студент= %1$-10s %2$-10s д.р %3$te %3$tB %3$tY%n", stud.getName(),
								stud.getSurName(), stud.getbDay());
					}
				
	// создание XML файла:
	// создадем пустой XML документ с помощью DOM
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = null;
				try
					{
						builder = dbf.newDocumentBuilder();
					}
				catch (ParserConfigurationException e3)
					{System.out.println("ParserConfigurationException" + e3.getMessage());}
				Document document = builder.newDocument();
		        
	// добавляем в XML документ корневой элемент
		        Element rootElement = document.createElement("root");
		        document.appendChild(rootElement);

	// в корневой элемент добавим дочерние элементы
		        Element name = document.createElement("name");
		        name.appendChild(document.createTextNode("My Students File"));
		        rootElement.appendChild(name);
		        
		        
		        Element array = document.createElement("studentsarray");
		        rootElement.appendChild(array);
		        
	// цикл для добавления элементов нашего списка студентов
		        for(Student stud : list)
					{					
		        	Element student = document.createElement("student");
		        	array.appendChild(student);
		        
		        	Element sname = document.createElement("name");
		        	sname.appendChild(document.createTextNode(stud.getName()));
		        	student.appendChild(sname);

		        	Element surname = document.createElement("surname");
		        	surname.appendChild(document.createTextNode(stud.getSurName()));
		        	student.appendChild(surname);
		        
		        	Element date = document.createElement("date");
		        	date.appendChild(document.createTextNode(formats.format(stud.getbDay())));
		        	student.appendChild(date);
					}

	// создаем файл для записи, после чего с помощью метода трансформера transform записываем данные в файл
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = null;
				try
					{
						transformer = transformerFactory.newTransformer();
					} 
				catch (TransformerConfigurationException e2)
					{System.out.println("TransformerConfigurationException" + e2.getMessage());}
		        DOMSource source = new DOMSource(document);
		        StreamResult result = new StreamResult(new File("homework13/zapisuXML/students.xml"));
		        try
					{
						transformer.transform(source, result);
					}
		        catch (TransformerException e1)
					{System.out.println("TransformerException" + e1.getMessage());}
				
				
				
				
			}

	}
