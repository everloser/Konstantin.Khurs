package homework5.Ex2;

public class VacCleaner extends BytTehnika

{
  private int vatt;
  private int nasadki;

public VacCleaner(String producer, int vatt, int nasadki) {
	super(producer);
	this.vatt = vatt;
	this.nasadki = nasadki;
}
public int getVatt() {
	return vatt;
}
public void setVatt(int vatt) {
	this.vatt = vatt;
}
public int getNasadki() {
	return nasadki;
}
public void setNasadki(int nasadki) {
	this.nasadki = nasadki;
}
}
