package homework4;

public class Pacient

{   
	  public static final char M = 'M';
	  public static final char W = 'F';
	  public static final boolean Y = true;
	  public static final boolean N = false;
	  private String name;
	  private String surname;
	  private String patname;	  
	  private int age;
	  private long card;
	  private boolean vaccina;
	  private char sex;
	  
	  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatname() {
		return patname;
	}
	public void setPatname(String patname) {
		this.patname = patname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getCard() {
		return card;
	}
	public void setCard(long card) {
		this.card = card;
	}
	public boolean isVaccina() {
		return vaccina;
	}
	public void setVaccina(boolean vaccina) {
		this.vaccina = vaccina;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	
}
