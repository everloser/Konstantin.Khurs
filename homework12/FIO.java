package homework12;

public class FIO
	{
private String name;
private String surName;

public FIO(String name, String surName)
	{
		this.name = name;
		this.surName = surName;
		
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


@Override
public String toString()
	{
		return "Name= " + name + " " + surName + "\n";
	}
@Override
public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}
@Override
public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FIO other = (FIO) obj;
		if (name == null)
			{
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
			return false;
		if (surName == null)
			{
				if (other.surName != null)
					return false;
			} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

	}
