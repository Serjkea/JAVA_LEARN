import java.util.*;
public class MoneyCalc {
	
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your money at month: ");
		double moneyAtMonth = in.nextDouble();
		
		System.out.println("How much money you need? ");
		double needMoney = in.nextDouble();
		
		int months = 0;
		double percent = 20.0;
		double realMoney = 0;
		
		while (needMoney > realMoney) {
			realMoney += moneyAtMonth * ((100.0 - percent) / 100.0);
			months++;
			System.out.println(months + " " + months/12 + " " + realMoney);
		}
		int n = 5;
		int k = 5;
		int y = 1;
		for (int i = 1; i <= k; i++) {
			y += y * (n - i + 1)/i;
		}
		
		System.out.println("You need to work " + months/12 + " years " + months % 12 + " months");
	}

}
