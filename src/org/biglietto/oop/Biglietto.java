package org.biglietto.oop;

import java.math.BigDecimal;

public class Biglietto {

	private int kmToDo;
	private int userAge;
	private static final BigDecimal PRICE_KM = new BigDecimal(0.21);
	private static final BigDecimal DISCOUNT_OVER = new BigDecimal(40);
	private static final BigDecimal DISCOUNT_UNDER = new BigDecimal(20);
	
	public Biglietto(int kmToDo, int userAge) throws Exception {
		
		isValidKm(kmToDo);
		isValidAge(userAge);
	}
	
	public void isValidKm(int kmToDo) throws Exception {
		
		if(kmToDo <= 0) {
			
			throw new Exception("the kilometers can't be 0");
			
		}
		
		this.kmToDo = kmToDo;
	}
	
	public void isValidAge(int userAge) throws Exception {
		
		if(userAge <= 0) {
			
			throw new Exception("negative age is not pemetted");
			
		}
		
		this.userAge = userAge;
	}

	public float calculatePrice() {
		return calculateDiscount();
	}
	

	private float calculateDiscount() {
		
		float price = getKmToDo() * getPriceKm().floatValue();
		
		if(userAge >= 65) {
			
			price -= price / 100 * getDiscountOver().floatValue();

		} else if (userAge <= 18) {
			
			price -= price / 100 * getDiscountUnder().floatValue();
			
		}
		return price;
	}
	
	
	
	public static BigDecimal getPriceKm() {
		return PRICE_KM;
	}

	public static BigDecimal getDiscountOver() {
		return DISCOUNT_OVER;
	}

	public static BigDecimal getDiscountUnder() {
		return DISCOUNT_UNDER;
	}

	public int getKmToDo() {
		return kmToDo;
	}

	public void setKmToDo(int kmToDo) {
		this.kmToDo = kmToDo;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	@Override
	public String toString() {
		return "km to do: " + getKmToDo() 
		+ "\nUser ager: " + getUserAge() 
		+ "\nPrice: " + calculatePrice();
		
	}
	
}
