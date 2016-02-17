package homework7;

// Просто класс, вызов метода doIt() которого, выполняет указанный метод интерфейса для текущего объекта Money
public class ProstoClass
{
private MoneyListener listener2;
	
	
	public void setListener(MoneyListener listener)
	{
		listener2 = listener;
	}
	
	public void doIt()
	{
		if (listener2 != null)
		{
		listener2.snyatie();
		}
	}
	
	
}
