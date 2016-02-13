package homework5.Ex2;

public class BytTehnika

{
 private boolean rozetka;
 private String producer;

public BytTehnika(String producer) {
	super();
	this.producer = producer;
}

public void switchOn()
   {
	rozetka = true;
   }

public boolean isRozetka() {
	return rozetka;
}

public void setRozetka(boolean rozetka) {
	this.rozetka = rozetka;
}

public String getProducer() {
	return producer;
}

public void setProducer(String producer) {
	this.producer = producer;
}


}

