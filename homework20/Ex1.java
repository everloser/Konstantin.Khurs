package homework20;

import java.util.List;
import java.util.Map;

/**
 * This program demonstrates
 * создать свою коллекцию, в виде иерархии сотрудников компании и добавить к ней свой итератор.
 * реализовать методы:
 * установить директора \ начальника(менеджера) \ рабочего(относятся к конкретному менеджеру)
 * удалить директора \ начальника(менеджера) \ рабочего(относятся к конкретному менеджеру)
 * при удалении директора убираются все, при удалении менеджера убираются соответствующие работники
 * переставлять рабочих от одного менеджера к другому
 * @author
 */
public class Ex1
	{

		public static void main(String[] args)
			{
				MyStaff<String> staff = new MyStaff<>();
				// установили директора
								staff.setDirector("director");
				// установили трех менеджеров
								staff.setNewManager("manager1");
								staff.setNewManager("manager2");
								staff.setNewManager("manager3");
				// добавили первому менеджеру четырех рабочих
								staff.addNewEmployee("manager1", "employee1");
								staff.addNewEmployee("manager1", "employee2");
								staff.addNewEmployee("manager1", "employee3");
								staff.addNewEmployee("manager1", "employee4");
				// добавили второму менеджеру двух рабочих
								staff.addNewEmployee("manager2", "employee5");
								staff.addNewEmployee("manager2", "employee6");
				// добавили третьему менеджеру трех рабочих
								staff.addNewEmployee("manager3", "employee7");
								staff.addNewEmployee("manager3", "employee8");
								staff.addNewEmployee("manager3", "employee9");
				// второго рабочего перекинули от первого менеджера второму
								staff.changeEmployee("manager1", "employee2", "manager2");
				// чтобы не было путаницы с параметрами, на все придуманные методы для MyStaff прописал Javadoc
								
				// Выводим на консоль менеджеров и рабочих:
								for (Map.Entry<String, List<String>> entry: staff.getManager().entrySet())
								    System.out.println(entry.getKey() + " = " + entry.getValue());
				// Итератор выводит только рабочих:
								while (staff.hasNext())
									System.out.println(staff.next());
			}

	}
