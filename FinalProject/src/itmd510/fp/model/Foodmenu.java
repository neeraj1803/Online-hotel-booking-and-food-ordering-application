package itmd510.fp.model;

public class Foodmenu 
{

	private String Food;
	private String Rate;
	
	public Foodmenu(String Food, String Rate) 
	{
		
		this.Food = Food;
		this.Rate = Rate;
	}

	public String getFood() {
		return Food;
	}

	public void setFood(String food) {
		Food = food;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}
	
	
	
	
}
