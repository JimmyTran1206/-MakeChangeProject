package makechange;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// Assumption: the users enter correct data type and format. User enter the number in dollars, not cent.

		// User Story #1
		System.out.print("Enter the price of the product: $");
		double amount = kb.nextDouble();

		// User Story #2
		System.out.print("Enter the amount tendered by the customer: $");
		double tendered = kb.nextDouble();

		// User Story #3
		if (tendered < amount) {
			System.out.printf("Amount: $%.2f, Tendered: $%.2f, Result: Not enough money.", amount, tendered);
		}
		if (tendered == amount) {
			System.out.printf("Amount: $%.2f, Tendered: $%.2f, Result: Right at the amount, no change.", amount, tendered);
		}

		// User Story #4
		int $20bills=0,$10bills=0,$5bills=0,$1bills=0,$25c=0, $10c=0,$05c=0,$01c=0;
		int tenderedInCents=0, amountInCents=0, remaining=0;
		String output="";
		if (tendered>amount) {
			tenderedInCents=(int) (tendered*100);
			amountInCents= (int) (amount*100);
			
			$20bills = (tenderedInCents-amountInCents)/2000;
			remaining= (tenderedInCents-amountInCents)%2000;
			
			$10bills=remaining/1000;
			remaining %=1000;
			
			$5bills=remaining/500;
			remaining %=500;
			
			$1bills=remaining/100;
			remaining %=100;
			
			$25c=remaining/25;
			remaining %=25;
			
			$10c=remaining/10;
			remaining %=10;
			
			$05c=remaining/5;
			remaining %=5;
			
			$01c=remaining;
			
			output= String.format("Amount: $%.2f, Tendered: $%.2f, Result:",amount,tendered);
			
			if($20bills>0) {
				if($20bills==1) {
					output += " " +$20bills+" twenty-dollar bill,";
				}else {
					output += " " +$20bills+" twenty-dollar bills,";
				}			
			}
			
			if($10bills>0) {
				if($10bills==1) {
					output += " " +$10bills+" ten-dollar bill,";
				}else {
					output += " " +$10bills+" ten-dollar bills,";
				}			
			}
			
			if($5bills>0) {
				if($5bills==1) {
					output += " " +$5bills+" five-dollar bill,";
				}else {
					output += " " +$5bills+" five-dollar bills,";
				}			
			}
			
			if($1bills>0) {
				if($1bills==1) {
					output += " " +$1bills+" one-dollar bill,";
				}else {
					output += " " +$1bills+" one-dollar bills,";
				}			
			}
			
			if($25c>0) {
				if($25c==1) {
					output += " " +$25c+" quarter,";
				}else {
					output += " " +$25c+" quarters,";
				}			
			}
			
			if($10c>0) {
				if($10c==1) {
					output += " " +$10c+" dime,";
				}else {
					output += " " +$10c+" dimes,";
				}			
			}
			
			if($05c>0) {
				if($05c==1) {
					output += " " +$05c+" nickel,";
				}else {
					output += " " +$05c+" mickels,";
				}			
			}
			
			if($01c>0) {
				if($01c==1) {
					output += " " +$01c+" penny,";
				}else {
					output += " " +$01c+" pennies,";
				}			
			}
			
			// Replace the ending comma by period and output the result:
			StringBuilder outputWithPeriod= new StringBuilder(output);
			outputWithPeriod.setCharAt(output.length()-1, '.');
			System.out.println(outputWithPeriod);
		}
	}
}
