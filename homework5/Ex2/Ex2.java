package homework5.Ex2;
/**
 * Создать иерархию классов, описывающих бытовую технику. Создать несколько объектов описанных классов,
 * часть из них включить в розетку. Иерархия должна иметь хотя бы три уровня.
 * @version
 * @author
 */
public class Ex2 {

	public static void main(String[] args)
	{
	TvSetLCD first = new TvSetLCD("Samsung", 32, 100, 5);
	TvSetLCD second = new TvSetLCD("LG", 40, 200, 6);
	TvSetLCD third = new TvSetLCD("Sharp", 22, 100, 10);
	first.switchOn();
	System.out.println(first.isRozetka());
	

	}

}
