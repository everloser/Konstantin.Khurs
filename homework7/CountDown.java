package homework7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** класс в котором мы определили метод, описывающий действие на событие
 * используя библиотечный интерфейс ActionListener
 * В программе Ex1 при выборе функции снятия денег, будет установлен таймер, дающий 15 
 * секунд на ввод суммы для снятия
 * 
 * @author
 */
public class CountDown implements ActionListener
	{

	@Override
	public void actionPerformed(ActionEvent e)
		{
			System.out.println("Время истекло!!! Вы не указали сумму для снятия.\nРабота программы прекращается");
			System.exit(0);
		}

	}
