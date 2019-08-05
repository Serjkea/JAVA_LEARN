import java.util.Scanner;


public class GuessNumber {

	public static void main(String[] args) {
        int max_num;
        int max_rnd;
        int usr_num;
        int i;
        double rnd_num;
		Scanner in = new Scanner(System.in);
		System.out.println("Input maximum number");
        max_num = in.nextInt();
		System.out.println("Input maximum rounds");
		max_rnd = in.nextInt();
		rnd_num = Math.random();
		System.out.println(rnd_num);
        for (i=1; i < max_rnd; i++) {
    		System.out.println("The round " + i);
    		System.out.println("Enter a number");
    		usr_num = in.nextInt();
    		if (usr_num == rnd_num) {
    			System.out.println("You win! Number is " + rnd_num );
    			break;
    		} else if (usr_num < rnd_num) System.out.println("Number > " + usr_num );
		      else if (usr_num > rnd_num) System.out.println("Number < " + usr_num );
        }
        if (i == max_rnd) System.out.println("You lose! Number is " + rnd_num );
	}

}
