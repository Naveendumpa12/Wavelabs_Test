package com.network.wavelabstest;
import java.util.Scanner;
public class NetworkApplicatin 
{
	public static void main(String[] args) 
	{
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println("Me as a Network Engineer,gave the values of Time as follows...");
        System.out.println("times[]= (ui={2, 1, 1}, vi={2, 3, 1}, wi={3, 4, 1})");       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Nodes          : ");
        int n = sc.nextInt();
        System.out.println("Enter the the Starting Node Number : ");
        int k = sc.nextInt();
        Network engineer = new Network();
        int minTime = engineer.networkDelayTime(times, n, k);
        System.err.println("Minimum time to reach all nodes: " + minTime);
    }
}
