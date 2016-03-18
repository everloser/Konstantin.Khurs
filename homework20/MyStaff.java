package homework20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Типизированный класс, позволяющий хранить и работать с древовидной структурой
 * директор-менеджеры-рабочие где Т - это объект персонала
 */
public class MyStaff<T> implements Iterator<T>
	{

		private Map<T, List<T>> manager = new HashMap<>();
		private T director;
		private int counter = -1;

		@Override
		public int hashCode()
			{
				final int prime = 31;
				int result = 1;
				result = prime * result + ((director == null) ? 0 : director.hashCode());
				result = prime * result + ((manager == null) ? 0 : manager.hashCode());
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
				MyStaff other = (MyStaff) obj;
				if (director == null)
					{
						if (other.director != null)
							return false;
					} else if (!director.equals(other.director))
					return false;
				if (manager == null)
					{
						if (other.manager != null)
							return false;
					} else if (!manager.equals(other.manager))
					return false;
				return true;
			}

		public T getDirector()
			{
				return director;
			}

		/**
		 * метод устанавливает нового директора, если имелись менеджеры и
		 * рабочие, они увольняются
		 * 
		 * @param director
		 *            - объект персонала
		 */
		public void setDirector(T director)
			{
				this.director = director;
				manager.clear();

			}

		public Map<T, List<T>> getManager()
			{
				return manager;
			}

		/**
		 * метод увольняет директора, вместе с ним увольняются менеджеры и
		 * рабочие
		 */
		public void fireDirector()
			{
				this.director = null;
				manager.clear();

			}

		/**
		 * метод устанавливает нового менеджера
		 * 
		 * @param value
		 *            - объект персонала
		 */
		public void setNewManager(T value)
			{

				manager.put(value, new ArrayList<>());
			}

		/**
		 * метод увольняет менеджера, вместе с ним увольняются его рабочие
		 * 
		 * @param value
		 *            - объект персонала
		 */
		public void fireManager(T value)
			{
				manager.remove(value);
			}

		/**
		 * метод добавляет рабочего в команду определенного менеджера
		 * 
		 * @param manager
		 *            - указывается менеджер к которому приходит рабочий
		 * @param employee
		 *            - объект персонала
		 */
		public void addNewEmployee(T manager, T employee)

			{
				this.manager.get(manager).add(employee);

			}

		/**
		 * метод убирает рабочего из команды определенного менеджера
		 * 
		 * @param manager
		 *            - указывается менеджер от которого уходит рабочий
		 * @param employee
		 *            - объект персонала, который уходит
		 */
		public void fireEmployee(T manager, T employee)

			{
				this.manager.get(manager).remove(employee);
			}

		/**
		 * метод передает рабочего от одного менеджера другому
		 * 
		 * @param manager1
		 *            - менеджер от которого уходит рабочий
		 * @param employee
		 *            - рабочий который переводится
		 * @param manager2
		 *            - менеджер которому передается рабочий
		 */
		public void changeEmployee(T manager1, T employee, T manager2)

			{
				this.manager.get(manager1).remove(employee);
				this.manager.get(manager2).add(employee);

			}

		@Override
		public boolean hasNext()
			{
				int a = 0;
				for (Map.Entry<T, List<T>> entry : manager.entrySet())
					a += entry.getValue().size();
				if (a > counter + 1)
					return true;
				else
					return false;
			}

		@Override
		public T next()
			{
				counter++;
				// вместо Iteratora в данном случае лучше было бы создать
				// отдельный метод,
				// который бы конвертил MyStaff в List<T>, чуть ниже я его
				// закомментченым написал
				// а простой лист уже просто перебирать, или фором или
				// библиотечным итератором
				// в данном случае выходит много рассчетов каждый проход next...
				List<T> all = new ArrayList<>();
				for (Map.Entry<T, List<T>> entry : manager.entrySet())
					all.addAll(entry.getValue());
				return all.get(counter);

			}

	}

// List<T> all = new ArrayList<>();
// for (Map.Entry<T, List<T>> entry: manager.entrySet())
// {
// all.add(entry.getKey());
// all.addAll(entry.getValue());
// all.add(director);
// }
