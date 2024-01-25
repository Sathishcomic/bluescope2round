package bluescopeinterview;

import java.util.Scanner;

public class ReverseInteger {

	public static void main(String args[])
	{
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number:");
		num=sc.nextInt();

		System.out.print("reversed number: ");
		Reverse(num);
	}
	public static void Reverse(int num)
	{
		if (num < 10) {
			System.out.println(num);
			return;
		}
		else {
			System.out.print(num % 10);
			Reverse(num / 10);
		}
	}

}
