package com.calculator;

import java.util.Scanner;

public class Calculator
{
	public static int add(int a, int b)
	{
		return a + b;
	}
	public static int subtract(int a, int b)
	{
		return a - b;
	}
	public static long multiply(int a, int b)
	{
		return a * b;
	}
	public static double divide(int a, int b)
	{
		return a / b;
	}

	public static void main(String[] args){
		String[][] oper={{"Addition","+"},{"Subtraction","-"},{"Multiplication","*"},{"Division","/"}};
		Scanner reader=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("1) Addition");
			System.out.println("2) Subtraction");
			System.out.println("3) Multiplication");
			System.out.println("4) Division");
			System.out.println("5) Exit\n");
			System.out.print("Enter choice: ");
			int ch=reader.nextInt();
			if(ch<1 || ch>5)
			{
				System.out.println();
			}
			else if(ch==5)
			{
				flag=false;
			}
			else
			{
				System.out.println(oper[ch-1][0]);
				System.out.print("a = ");
				int a = reader.nextInt();
				System.out.print("b = ");
				int b = reader.nextInt();
				if(ch==1)
				{
					System.out.println("a+b = "+add(a,b));
				}
				else if(ch==2)
				{
					System.out.println("a-b = "+subtract(a,b));
				}
				else if(ch==3)
				{
					System.out.println("a*b = "+multiply(a,b));
				}
				else
				{
					try
					{
						System.out.println("a/b = "+divide(a,b));
					}
					catch(ArithmeticException e)
					{
						System.out.println("Cannot divide by zero.");
					}
				}
				System.out.println("");
			}
		}
	}

}
