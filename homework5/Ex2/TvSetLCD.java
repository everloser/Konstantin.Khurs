package homework5.Ex2;

public class TvSetLCD extends TvSet {

	private int reactTime;

	public TvSetLCD(String producer, int diagonal, int hz, int reactTime) {
		super(producer, diagonal, hz);
		this.reactTime = reactTime;
	}

	public int getReactTime() {
		return reactTime;
	}

	public void setReactTime(int reactTime) {
		this.reactTime = reactTime;
	}

	
	
}
