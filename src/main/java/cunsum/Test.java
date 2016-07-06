package cunsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random r = new Random();
		int num = r.nextInt(100);
		int guess;
		System.out.println(num);
		System.out.println("enter the number");
		InputStreamReader dis = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(dis);
		try {
			guess = getGuess(br);

			while (true){
				if(guess == num){
					System.out.println("you guess right");
					break;
				}else {
					System.out.println("guess error , continue");
					guess = getGuess(br);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}catch (NumberFormatException e){
			System.out.println("you just can enter the number");
		}
	}

	private static int getGuess(BufferedReader br) throws IOException {
		int guess;
//		guess = Integer.parseInt(br.readLine());
		guess = br.read();
		System.out.println("====guess is " + guess);
		return guess;
	}


}
