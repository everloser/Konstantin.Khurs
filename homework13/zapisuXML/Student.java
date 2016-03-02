package homework13.zapisuXML;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Student
	{
private String name;
private String surName;
private Date bDay;

public Student(String name, String surName, Date bDay)
	{
		this.name = name;
		this.surName = surName;
		this.bDay = bDay;
	}
public String getName()
	{
		return name;
	}
public void setName(String name)
	{
		this.name = name;
	}
public String getSurName()
	{
		return surName;
	}
public void setSurName(String surName)
	{
		this.surName = surName;
	}
public Date getbDay()
	{
		return bDay;
	}
public void setbDay(Date bDay)
	{
		this.bDay = bDay;
	}
@Override
public String toString()
	{
		SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yy");
		String textDate = formats.format(bDay);
		return name + "|" + surName + "|" + textDate;
	}

	}