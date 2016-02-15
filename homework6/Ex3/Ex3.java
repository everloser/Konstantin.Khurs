package homework6.Ex3;

import java.util.Scanner;
/**
 * This program demonstrates
 * Создать абстрактный класс "Фигура"  + классы, которые будут его реализовывать:
 * "Квадрат", "Прямоугольник", "Треугольник" и "Круг".
 * В абстрактном классе создать абстрактный метод "расчет площади".
 * В классах конкретных фигур у вас должны быть необходимые переменные и методы
 * для задания входных значений и необходимых расчетов (лучше сделать конструктор).
 * По итогу должна быть программа, где можно создать класс нужной фигуры,
 * задать параметры сторон, углов и рассчитать площадь этих фигур.
 * Заодно вспомните математику :)  и попробуете класс Math()
 * @version
 * @author
 */
public class Ex3
{
	public static void main(String[] args)
	{
		Shape fig = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Для нахождения площади");
		System.out.println("квадрата - нажмите \"0\"\nтреугольника - нажмите \"1\"\nпрямоугольника - "
				+ "нажмите \"2\"\nкруга - нажмите \"3\"");
		int a = sc.nextInt();
		
		if (a==0)
		{
			System.out.println("Введите сторону квадрата");
			int k = sc.nextInt();
			fig = new Square(k);
		}	
		
		else if (a==1)
		{
			System.out.println("Введите сторону a треугольника");
			int ta = sc.nextInt();
			System.out.println("Введите сторону b треугольника");
			int tb = sc.nextInt();
			System.out.println("Введите сторону c треугольника");
			int tc = sc.nextInt();
			fig = new Triangle(ta, tb, tc);
		}
		else if (a==2)
		{
			System.out.println("Введите сторону a прямоугольника");
			int pa = sc.nextInt();
			System.out.println("Введите сторону b прямоугольника");
			int pb = sc.nextInt();
			fig = new Rectangle(pa, pb);
		}
		else if (a==3)
		{
			System.out.println("Введите радиус r круга");
			int ra = sc.nextInt();
			fig = new Circle(ra);
		}	
		else System.exit(0);
		
		System.out.println("Площадь указанной фигуры: " + fig.findS());
		
	}

}
