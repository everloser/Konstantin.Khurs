package homework14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This program demonstrates
 * парсинг test.json файла, с помощью парсера библиотеки jackson.
 * создание export.json файла.
 * @version
 * @author
 */
public class Ex1
	{

		public static void main(String[] args)
		{
			ObjectMapper mapper = new ObjectMapper();
			Root user = new Root();
	          try
	        	{
	        		BufferedReader reader = new BufferedReader(new FileReader("homework14/test.json"));
	        		user = (Root) mapper.readValue(reader, Root.class);
	            }
	          catch (IOException ex)
	        	  {System.out.println("Error = " + ex.getMessage());}
			
	          System.out.println(user.toString());
	          
	          try
				{
					mapper.writerWithDefaultPrettyPrinter().writeValue(new File("homework14/export.json"), user);
					System.out.println("json created!");
				}
	          catch (JsonGenerationException e)
				{
					System.out.println("JsonGenerationException " + e.getMessage());
				}
	          catch (JsonMappingException e)
				{
					System.out.println("JsonMappingException " + e.getMessage());
				}
	          catch (IOException e)
				{
					System.out.println("IOException " + e.getMessage());
				}
	          
			
		}

	}
