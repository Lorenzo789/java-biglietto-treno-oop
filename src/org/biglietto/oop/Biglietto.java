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
	
	public Biglietto(int kmToDo, int userAge, String flexible) throws Exception {
		
		setKmToDo(kmToDo);
		setUserAge(userAge);
//		todayDate = LocalDate.now();
		setTodayDate(LocalDate.now());
		setFlexible(flexible);
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

		}
		if (userAge <= 18) {
			
			price -= price / 100 * getDiscountUnder().floatValue();
			
		}
		if (flexible) {
			
			price += price * 0.1f;
			
		}
		return price;
	}
	
	public LocalDate getExpiringDate() {
		if(flexible) {
			
			return this.todayDate.plusDays(FLEXIBLE_DATE);
		}
		return this.todayDate.plusDays(NORMAL_DATE);
	}
	
	public LocalDate getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(LocalDate todayDate) {
		this.todayDate = todayDate;
	}

	public boolean isFlexible() {
		return flexible;
	}

	public void setFlexible(String flexible) throws Exception {
		if(flexible.equals("y")) {
			this.flexible = true;
		} else if (flexible.equals("n")) {
			this.flexible = false;
		} else {
			throw new Exception("Please insert y for yes or n for no");
		}
	}

	public static int getNormalDate() {
		return NORMAL_DATE;
	}

	public static int getFlexibleDate() {
		return FLEXIBLE_DATE;
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
		+ "\nFlexible expiring date: " + isFlexible()
		+"\nExpiring Date: " + getExpiringDate()
		+ "\nPrice: " + calculatePrice();
		
	}
	
}
