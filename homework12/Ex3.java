package homework12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This program demonstrates
 * Создать объект в котором храниться имя, фамилия и отчество.
 * Дальше создать 2 массива с данными типа этого обекта (ФИО).
 * В одном содержатся мужские ФИО, в другом женские.
 * Все массивы записать в HashMap с ключами "man",  "woman" соответсвенно.
 * Дальше пользователь вводит мужское или женское ФИО он хочет вывести
 * и в соответсвии с этим рандомно вытаскиваем значения из массива который хранится в HashMap.
 * Т. е. на экран дожно вывести рандомное ФИО из массива.
 * @version
 * @author
 */
public class Ex3
	{

		public static void main(String[] args)
			{
				
				// Создаем два массива с данными FIO
				ArrayList<FIO> male = new ArrayList<>();
				ArrayList<FIO> female = new ArrayList<>();
				male.add(new FIO("Tadewus", "Reitan"));
				male.add(new FIO("Tamas", "Wauzhecki"));
				male.add(new FIO("Jakub", "Jasinski"));
				male.add(new FIO("Stafan", "Grabouski"));
				male.add(new FIO("Jan", "Barscheuski"));
				male.add(new FIO("Kazimir", "Carnouski"));
				male.add(new FIO("Mihal", "Rukevic"));
				male.add(new FIO("Tamas", "Zan"));
				male.add(new FIO("Tadewus", "Reitan"));
				male.add(new FIO("Valenci", "Vankovic"));
				female.add(new FIO("Emilia", "Pliater"));
				female.add(new FIO("Kamila", "Marcinkewic"));
				female.add(new FIO("Magdalena", "Radziwil"));
				female.add(new FIO("Alaisa", "Pashkewic"));
				female.add(new FIO("Paluta", "Badunowa"));
				female.add(new FIO("Zosia", "Weras"));
				female.add(new FIO("Kanstancia", "Bujlo"));
				female.add(new FIO("Paulina", "Miadzelka"));
				female.add(new FIO("Wanda", "Liawickaja"));
				female.add(new FIO("Natalia", "Arsennewa"));
				
				//массивы записать в HashMap с ключами "man",  "woman" соответсвенно
				HashMap <String, ArrayList<FIO>> map = new HashMap <>();
				map.put("man", male);
				map.put("woman", female);
				
				
				Scanner scan = new Scanner(System.in);
			do
				{
				System.out.println("Enter keyword to print a name:\n\"man\" - for male name;\n\"woman\" - for female name;"
						+ "\nanother entry - to exit");
				String choise = scan.nextLine();
				choise = choise.toUpperCase();
				choise = choise.trim();
				switch (choise)
					{
						case "MAN":
						{
							System.out.println(map.get("man").get((int)((map.get("man").size())*Math.random())));
							break;
						}
						case "WOMAN":
						{
							System.out.println(map.get("woman").get((int)((map.get("woman").size())*Math.random())));
							break;
						}
						default :
							System.exit(0);
					}
				}
			while (true);
			}

	}
