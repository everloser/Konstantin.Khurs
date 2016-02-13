package homework5.Ex2;

public class TvSet extends BytTehnika

{

private int diagonal;
private int hz;
 public TvSet(String producer, int diagonal, int hz) {
	super(producer);
	this.diagonal = diagonal;
	this.hz = hz;
}
public int getDiagonal() {
	return diagonal;
}
public void setDiagonal(int diagonal) {
	this.diagonal = diagonal;
}
public int getHz() {
	return hz;
}
public void setHz(int hz) {
	this.hz = hz;
}
}
