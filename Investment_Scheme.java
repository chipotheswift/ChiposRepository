import java.util.*;

public class Investment_Scheme {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        double[][] table = {
                {1.05, 1.06, 1.07, 1.08, 1.09, 1.10},
                {1.1025, 1.1236, 1.1449, 1.1664, 1.1881, 1.21},
                {1.1576250, 1.1910160, 1.2250430, 1.2597120, 1.2950290, 1.331},
                {1.2155063, 1.2624770, 1.3107960, 1.3604890, 1.4115816, 1.4641},
                {1.2762816, 1.3382256, 1.4025517, 1.4693281, 1.5386240, 1.61051},
                {1.3400956, 1.4185191, 1.5007304, 1.5868743, 1.6771001, 1.771561},
                {1.4071004, 1.5036303, 1.6057815, 1.7138243, 1.8280391, 1.9487171},
                {1.4774554, 1.5938481, 1.7181862, 1.8509302, 1.9925626, 2.1435888},
                {1.5513282, 1.6894790, 1.8384592, 1.9990046, 2.1718933, 2.3579477},
                {1.6288946, 1.7908477, 1.9671514, 2.1589250, 2.3673637, 2.5937425}
        };

        final int NUM_CLIENT = 5; 

        
        String[] clientNames = new String[NUM_CLIENT];
        int[] amountsInvested = new int[NUM_CLIENT];
        int[] interestRates = new int[NUM_CLIENT];
        int[] investmentTerms = new int[NUM_CLIENT];

       for (int i = 0; i < NUM_CLIENT; i++) {
    System.out.print("Input client's name: ");
    clientNames[i] = scnr.nextLine();

    while (true) {
        System.out.print("Input amount to be invested ($100 - $10,000): ");
        amountsInvested[i] = scnr.nextInt();

        if (amountsInvested[i] >= 100 && amountsInvested[i] <= 10000) {
            break; 
        } else {
            System.out.println("Invalid amount. Please enter a value between $100 and $10,000.");
        }

        scnr.nextLine(); 
    }

    while (true) {
        System.out.print("Input interest rate (5 - 10 percent): ");
        interestRates[i] = scnr.nextInt();

        if (interestRates[i] >= 5 && interestRates[i] <= 10) {
            break; 
        } else {
            System.out.println("Invalid interest rate. Please enter a value between 5 and 10.");
        }

        scnr.nextLine();
    }

    while (true) {
        System.out.print("Input investment term (1 - 10 yrs): ");
        investmentTerms[i] = scnr.nextInt();

        if (investmentTerms[i] >= 1 && investmentTerms[i] <= 10) {
            break; 
        } else {
            System.out.println("Invalid investment term. Please enter a value between 1 and 10.");
        }

        scnr.nextLine(); 

        }
     scnr.nextLine(); 
}
        
         for ( int i = 0; i < NUM_CLIENT; i++) {
            System.out.print("Client Name: " + clientNames[i] +"        ");

            int row = interestRates[i] - 5;
            int col = investmentTerms[i] - 1;
            double compoundValue = amountsInvested[i] * table[col][row];
            double interest = compoundValue - amountsInvested[i];
        
            System.out.print("Compound Value: $" + String.format("%.2f", compoundValue));
            System.out.print("   Interest: $" + String.format("%.2f%n", interest));
}
    }
}

       
