package homework13;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPars extends DefaultHandler
	{
		ElementMy myEl = new ElementMy(); 
		String thisElement = "";
		List<ElementMy> myList = new ArrayList<>();
		 
	// метод возвращает коллекцию объектов ElementMy
		public List<ElementMy> getResult()
			{ 
		  return myList;
			}

		@Override
		public void startDocument() throws SAXException
			{
				System.out.println("Start parse XML...");				
			}

		@Override
		public void endDocument() throws SAXException
			{
				System.out.println("Stop parse XML..."); 
			}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
			{
				thisElement = qName;
			}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException
			{
				thisElement = "";
			}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException
			{
				if (thisElement.equals("age"))
					{ 
				    myEl = new ElementMy(); 
					myEl.setAge(Integer.valueOf(new String(ch, start, length))); 
				    } 
				if (thisElement.equals("id"))
					{ 
				     myEl.setiD(Long.valueOf(new String(ch, start, length))); 
				    } 
				if (thisElement.equals("isDegree"))
					{ 
				     myEl.setDegree(Boolean.valueOf(new String(ch, start, length))); 
				    } 
				if (thisElement.equals("name"))
					{ 
				     myEl.setName(new String(ch, start, length)); 
				    } 
				if (thisElement.equals("surname"))
					{ 
				     myEl.setSurname(new String(ch, start, length));
				     myList.add(myEl);
				    } 
				  
			}
	}
