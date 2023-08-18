/*
* < Proj1_Part1>
* <Chipo Sekabanja >
*
* <The program takes in the item purchased as well as its amount and outputs what the monthly payment, 
total payment, and financing amount are given the rate of 0.3 and a period of 12months>
*/



import java.text.DecimalFormat;
import java.util.Scanner;

public class Smart_Purchase_Planner {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        final double FINANCE_RATE = 0.30;   
        final int NUM_MONTHS = 12;          
        
        
        System.out.print("Enter the item to be purchased: ");
        String item = scnr.nextLine();
        
        System.out.print("Enter the amount of the purchase: $");
        double purchasePrice = scnr.nextDouble();
        

        double monthlyPayment = ((purchasePrice * FINANCE_RATE) + purchasePrice) / NUM_MONTHS;
        double totalPayment = monthlyPayment * NUM_MONTHS;
        double financingAmnt = totalPayment - purchasePrice;
        

        System.out.printf("Your monthly payment is $%.2f%n" ,monthlyPayment);
        System.out.printf("Your total payment is $%.2f%n" ,totalPayment);
        System.out.printf("Amount paid in financing is $%.2f%n" ,financingAmnt);
    
    }
}
