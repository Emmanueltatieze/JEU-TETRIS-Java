
public class Temps {
	private int min;
	private int sec;
	
	public Temps(int t)
	{
		this.sec=(t%60000)/1000;
		this.min=(t/60000);
	}

	@Override
	public String toString() {
		if(min<10&&sec<10)
		return  "0"+ min + ":0"+ sec ;
		else if(min<10&&sec>=10)
			return  "0"+ min + ":"+ sec ;
		else if(min>=10&&sec<10)
			return   min + ":0"+ sec ;
		return  min + ":"+ sec ;
		
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}
	
	

}
