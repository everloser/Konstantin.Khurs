package homework17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * сделать загрузку XML и JSON (итоговые задание) и обработать их.
 * Загрузка будет в потоке загрузки данных, а парсинг в потоке обработки данных.
 * У вас должны получиться следующая последовательность:
 * - Загружаем XML - поток 1
 * - Обрабатываем XML - поток 2
 * - Загружаем JSON - поток 1
 * - Обрабатываем JSON - поток 2
 * Вместо wait() и notify() использовал java.util.concurrent.SynchronousQueue
 * с методами put() и take() передаваемый между потоками объект - файл
 * @author
 */
public class Ex1
{
	private static final String XMLURL = "http://kiparo.ru/t/salary.xml";
	private static final String JSONURL = "http://kiparo.ru/t/salary.json";
	private static Root root = null;
	private static File target;
	private static SynchronousQueue<File> sq = new SynchronousQueue<File>();
	
	 public static void main(String[] args)
		 {
			 System.out.println("Main поток в работе...");
			 Thread getFile  = new Thread(new Runnable()
			{
				
				@Override
				public void run()
					{
						try
						{
							System.out.println("Первый поток в работе...");							
							sq.put(download(XMLURL, "salary.xml"));
							System.out.println("1: Скачали и поместили в очередь xml файл...");
							System.out.println("1: Ожидаем освобождения очереди...");
							sq.put(download(JSONURL, "salary.json"));
							System.out.println("1: Скачали и поместили в очередь json файл...");
							System.out.println("Первый поток закончил работу...");
						}
						catch (InterruptedException e) {
							System.out.println( e.getMessage());
						}
						
					}
			});
		 getFile.start();
	     
		 Thread parseFile = new Thread(new Runnable()
			{
				
				@Override
				public void run()
					{
						try
						{
							System.out.println("Второй поток в работе...");
							target = sq.take();
							System.out.println("2: Забираем xml файл из очереди и парсим...");
							root = parseBySax(target);
							System.out.println("2: Вот данные из xml файла : [" + root.getName() + "...] и т.д.");
							target = sq.take();
							System.out.println("2: Забираем json файл из очереди и парсим...");
							root = parseByGson(target);
							System.out.println("2: Вот данные из xml файла : [" + root.getName() + "...] и т.д.");
							System.out.println("Второй поток закончил работу...");
						} 
						catch (InterruptedException e) {
							System.out.println( e.getMessage());
						}
						
					}
			});
		 parseFile.start();
		 System.out.println("Main поток закончил работу...");
	     }
	
	 public static File download(String string, String filez)
			{
				InputStream inpStrm = null;
				FileOutputStream otpStrm = null;
				File file = new File(filez);
				try
					{
						URL url = new URL(string);
						HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
						int responseCode = httpURLConnection.getResponseCode();
						if (responseCode == HttpURLConnection.HTTP_OK)
							{
								inpStrm = httpURLConnection.getInputStream();

								otpStrm = new FileOutputStream(file);
								int byteRead = -1;
								byte[] buffer = new byte[512];
								while ((byteRead = inpStrm.read(buffer)) != -1)
									{
										otpStrm.write(buffer, 0, byteRead);
									}
							} else
							{
								System.out.println("ERROR in connection = " + responseCode);
								
							}
					} catch (Exception e)
					{
						System.out.println("ERROR in connection = " + e.getMessage());
						
					} finally
					{
						if (inpStrm != null)
						{
						try
							{
								inpStrm.close();
							} catch (Exception e)
							{
								System.out.println("ERROR inputStream close = " + e.getMessage());
							}
						try
							{
								otpStrm.close();
							} catch (Exception e)
							{
								System.out.println("ERROR outputStream close = " + e.getMessage());
							}
						}
					}
				return file;
			}
	 
	  public static Root parseBySax(File salary)
	  {
		  SAXParserFactory factory = SAXParserFactory.newInstance();
		  SAXParser parser = null;
			try
				{
					parser = factory.newSAXParser();
				} catch (ParserConfigurationException e1)
				{
					System.out.println("ParserConfiguration error = " + e1.getMessage());
				} catch (SAXException e1)
				{
					System.out.println("SAX error = " + e1.getMessage());
				}
			// Создаем объект класса SAXPars extends DefaultHandler в котором
			// переопределены методы DefaultHandler'а для парсинга нашего файла
			SAXPars saxp = new SAXPars();

			try
				{
					// парсинг файла, используя переопределенные методы
					parser.parse(salary, saxp);
				} catch (SAXException e)
				{
					System.out.println("SAX error = " + e.getMessage());
				} catch (IOException e)
				{
					System.out.println("IO error = " + e.getMessage());
				}
			Root xmlSax = new Root();
			xmlSax = saxp.result();
		  
		  return xmlSax;
	  }
	  
	  public static Root parseByGson(File salary)
	  {
		  Root jsonGson = new Root();
		  try
				{
					FileReader rsalary = new FileReader(salary);
					BufferedReader reader = new BufferedReader(rsalary);
					Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();					
					jsonGson = gson.fromJson(reader, Root.class);
					reader.close();
					rsalary.close();
				} catch (Exception e)
				{
					System.out.println("GSON error = " + e.getMessage());
				}
		  return jsonGson;
	  }
}

class SAXPars extends DefaultHandler
{
	Root root = null;
	List<Employees> employeesList = new ArrayList<>();
	Employees employees = null;
	SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
	String thisElement = "";
	StringBuilder email = new StringBuilder();
	String[] emails = null;

	boolean checkemp = false;

	public Root result()
		{
			return root;
		}

	public void startDocument() throws SAXException
		{
			root = new Root();
			// System.out.println("Start parse XML...");
		}

	@Override
	public void endDocument() throws SAXException
		{
			root.setEmployees(employeesList);
			// System.out.println("Stop parse XML...");
		}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			thisElement = qName;
			if (thisElement.equals("employees"))
				{
					checkemp = true;
				}
		}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException
		{
			thisElement = "";
			if (qName.equals("/employees"))
				{
					checkemp = false;
				}
		}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException
		{
			if (thisElement.equals("name") && !checkemp)
				{
					root.setName(new String(ch, start, length));
				}
			if (thisElement.equals("location"))
				{
					root.setLocation(new String(ch, start, length));
				}
			if (thisElement.equals("baseSalary"))
				{
					root.setBaseSalary(Long.valueOf(new String(ch, start, length)));
				}
			if (thisElement.equals("id"))
				{
					employees = new Employees();
					employees.setId(Long.valueOf(new String(ch, start, length)));
				}
			if (thisElement.equals("name") && checkemp)
				{
					employees.setName(new String(ch, start, length));
				}
			if (thisElement.equals("degree"))
				{
					employees.setDegree(new String(ch, start, length));
				}
			if (thisElement.equals("dateOfBirth"))
				{
					try
						{
							employees.setDateOfBirth(formats.parse(new String(ch, start, length)));
						} catch (ParseException e)
						{
							System.out.println("Parse Date error = " + e.getMessage());
						}
				}
			if (thisElement.equals("yearEperience"))
				{
					employees.setYearEperience(Integer.valueOf(new String(ch, start, length)));
				}
			if (thisElement.equals("rate"))
				{
					employees.setRate(Double.valueOf(new String(ch, start, length)));
				}
			if (thisElement.equals("emails"))
				{

					email.append(new String(ch, start, length));
					email.append("|");
				}
			if (thisElement.equals("visible"))
				{
					email.deleteCharAt(email.length() - 1);
					emails = email.toString().split("\\|");
					employees.setEmails(emails);
					email = new StringBuilder();
					employees.setVisible(Boolean.valueOf(new String(ch, start, length)));
					employeesList.add(employees);

				}

		}

}