package homework7;

public class Money implements MoneyListener
{
	// задаем поля класса
   private int s100;
   private int s50;
   private int s20;
   private ProstoClass prosto;

   // конструируем класс:
   public Money(int s100, int s50, int s20)
   {
      this.s100 = s100;
      this.s50 = s50;
      this.s20 = s20;
      prosto = new ProstoClass();
      prosto.setListener(this);
   }
// объявляем методы


// метод рассчитывает количество денег в объекте и выводит на печать
public void getMoney()
    
    {
	int b = 100*s100 + 50*s50 + 20*s20;
	System.out.println(" сумма " + b + " BYR\nВ том числе:\nКупюр [100] - " + s100 +
			" шт\nКупюр [50] - " + s50 + " шт\nКупюр [20] - " + s20 + " шт");
	}

// метод добавляет в объект указанную сумму, равномерно распределяя ее по разным купюрам
public void addMoney(int a)
 {
	a=a/10;
	while (a >= 2)
	   {
		if ((a>=17 && a != 20) || (a%2 == 0 && a>=10 && a<17))
		 {
			s100++;
			a-=10;
		 }
		if (a == 15)
		 {
			s100++;
			s50++;
			a-=15;
		 }
		if (a>=9 || a == 7 || a == 5)
		 {
			s50++;
			a-=5;
		 }
		if (a>=2)
		 {s20++;
		  a-=2;
		 }
	   }	
 }

 public int checkMoney()
    {
    int b = 100*s100 + 50*s50 + 20*s20;
    return b;
    }
 
 public void reset()
    {
	 s100 = s50 = s20 = 0;
    }


public int getS100() {
	return s100;
}


public void setS100(int s100) {
	this.s100 = s100;
}


public int getS50() {
	return s50;
}


public void setS50(int s50) {
	this.s50 = s50;
}


public int getS20() {
	return s20;
}


public void setS20(int s20) {
	this.s20 = s20;
}


@Override
public void snyatie()
{
	System.out.println("***********ПОПЫТКА СНЯТИЯ ДЕНЕГ*************");
	
}

public void doProsto()
{
	prosto.doIt();
}
 
}