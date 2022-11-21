package org.biglietto.oop;

import java.math.BigDecimal;

public class Biglietto {

	private int kmToDo;
	private int userAge;
	private static final float PRICE_KM = .21f;
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

	public void calculatePrice() {
		
		float price = kmToDo * PRICE_KM;
		
	}
	

	public BigDecimal calculateDiscount() {
		
		float priceWithoutDiscount = kmToDo * PRICE_KM;
		BigDecimal operator = new BigDecimal(100);
		
		if(userAge >= 65) {
			
			
//			priceWithoutDiscount -= priceWithoutDiscount / 100 * DISCOUNT_OVER;
			
			System.out.println(DISCOUNT_OVER.multiply(operator));
		}
		return DISCOUNT_OVER.multiply(operator);
		
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
		+ "\nFinal Price: " + calculateDiscount();
		
	}
	
}
