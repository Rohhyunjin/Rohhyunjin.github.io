package ex;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		finder(a, b);
	}

	static void finder(int a, int b) {

		int prime[] = new int[b - a + 1];

		for (int i = 0; i + a <= b; i++)
			prime[i] = a + i;
		
		if (a == 1)
			prime[0] = -1;

		for (int i = 0; i < prime.length; i++) {
			for (int j = 2; j * j <= prime[i]; j++) {
				if (prime[i] % j == 0) {
					prime[i] = -1;
					break;
				}
			}
		}
		for (int i = 0; i < prime.length; i++) {
			if (prime[i] != -1)
				System.out.println(prime[i]);
		}

	}
}