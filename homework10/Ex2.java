package homework10;

/**
 * This program demonstrates
 * Создать класс City (город) с внутренним классом, с помощью объектов которого
 * можно хранить информацию о проспектах, улицах, площадях.
 * Внутренний класс в задании должен быть один для площадей, один для улиц и тд.
 * Просто с переменной String, которая сможет хранит и названия улиц и названия площадей.
 * Т.e. класс City содержит несколько переменных с типом внутреннего класса
 * в которых записано название улицы проспекта и тд.
 * @version
 * @author
 */
public class Ex2
	{

		public static void main(String[] args)
			{
				City m = new CityMinsk();
				System.out.println(m.toString());
			}

	}