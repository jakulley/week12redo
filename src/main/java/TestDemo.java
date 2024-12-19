import java.util.Random;


public class TestDemo {
	public int addPositive(int a, int b) {
		if (a>0 && b>0) {
			int sum = a + b;
			return sum;
		}else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	
	//returns true if a number is prime and false if a number is composite. The first if clause handles the special case of 1, which is NOT prime, but for number-theoretical reasons rather than by the traditional divisibility test.
	public boolean checkPrimeness(int a) {
		if (a == 1) {
			return false;
		}
		for (int d = 2; d <= a/2; d++) {
			if (a%d == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int randomNumberSquared() {
		int rand = getRandomInt();
		return rand*rand;
	}


	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}
}
