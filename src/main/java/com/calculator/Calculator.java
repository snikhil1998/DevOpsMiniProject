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
		double result;
		if (b == 0)
		{
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		else
		{
			result = Double.valueOf(a)/Double.valueOf(b);
		}
		return result;
	}
	public static double sqrt(int n)
    {
        return java.lang.Math.sqrt(n);
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
				System.out.print("a"+oper[ch-1][1]+"b = ");
				if(ch==1)
				{
					System.out.println(add(a,b)+"\n");
				}
				else if(ch==2)
				{
					System.out.println(subtract(a,b)+"\n");
				}
				else if(ch==3)
				{
					System.out.println(multiply(a,b)+"\n");
				}
				else
				{
					System.out.println(divide(a,b)+"\n");
				}
			}
		}
	}
}
