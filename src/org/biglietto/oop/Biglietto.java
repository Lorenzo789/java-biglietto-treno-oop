package org.biglietto.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {

	private int kmToDo;
	private int userAge;
	private static final BigDecimal PRICE_KM = new BigDecimal(0.21);
	private static final BigDecimal DISCOUNT_OVER = new BigDecimal(40);
	private static final BigDecimal DISCOUNT_UNDER = new BigDecimal(20);
	private static final int NORMAL_DATE = 30;
	private static final int FLEXIBLE_DATE = 90;
	private LocalDate todayDate;
	private boolean flexible;
	
	public Biglietto(int kmToDo, int userAge) throws Exception {
		
		setKmToDo(kmToDo);
		setUserAge(userAge);
	}
	
	private boolean isValidKm(int kmToDo) throws Exception {
		return kmToDo > 0;
	}
	
	private boolean isValidAge(int userAge) {
		return userAge <= 100 && userAge > 0;
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

	public void setKmToDo(int kmToDo) throws Exception {
		
		if(!isValidKm(kmToDo)) {
			
			throw new Exception("the kilometers can't be 0");
		}
		this.kmToDo = kmToDo;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) throws Exception {
		
		if(!isValidAge(userAge)) {
			
			throw new Exception("negative age is not pemetted");
		}
		this.userAge = userAge;
	}
	
	@Override
	public String toString() {
		return "km to do: " + getKmToDo() 
		+ "\nUser age: " + getUserAge() 
		+ "\nPrice: " + calculatePrice();
		
	}
	
}
