package homework13;

public class ElementMy
	{
private int age;
private long iD;
private boolean Degree;
private String name;
private String surname;
public int getAge()
	{
		return age;
	}
public void setAge(int age)
	{
		this.age = age;
	}
public long getiD()
	{
		return iD;
	}
public void setiD(long iD)
	{
		this.iD = iD;
	}
public boolean isDegree()
	{
		return Degree;
	}
public void setDegree(boolean degree)
	{
		Degree = degree;
	}
public String getName()
	{
		return name;
	}
public void setName(String name)
	{
		this.name = name;
	}
public String getSurname()
	{
		return surname;
	}
public void setSurname(String surname)
	{
		this.surname = surname;
	}
@Override
public String toString()
	{
		return "ElementMy [age=" + age + ", iD=" + iD + ", Degree=" + Degree + ", name=" + name + ", surname=" + surname
				+ "]";
	}
	}
