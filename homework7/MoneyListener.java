package homework7;

public interface MoneyListener 
{
// в классе Money будет переопределен как добавляющий указанную сумму (int a) в текущий объект
public void addMoney(int a);
// в классе Money будет переопределен как выводящий строку предупреждения о попытке снятия денег
public void snyatie();

}
