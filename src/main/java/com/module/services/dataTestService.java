/**
 * 
 */
package com.module.services;

import java.util.Arrays;

/**
 * @author jeremy
 *
 */
public class dataTestService {

	/**
	 * 
	 */
	public dataTestService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// You roll a fair 6-sided dice iteratively until the sum of the dice rolls is greater than or equal to M.
		// Simulation approach
		
		int M = 10000;
		double[] allSums = new double[1000000];
		double[] allNumRolls = new double[1000000];
		int allSumsCount = 0;
		
		double meanSums = 0;
		double stDevSums = 0;
		double meanNumRolls = 0;
		double stDevRolls = 0;
		double[] histVari = {-9,-8,-7,-6,-5,-4,-3,-2,-1,stDevSums};
		
		while(  Math.sqrt(weka.core.Utils.variance(histVari)) > 0.000001  ) { // loop until variance of last 10 standard deviations of sums is less than 0.000001 (assumes that as # tests goes to infinity, values will converge)
			double compVal = Math.sqrt(weka.core.Utils.variance(histVari));
			System.out.println("double prev: "+histVari[9]+", prev: "+histVari[4]+", curr: "+histVari[0]+", compval: "+compVal);
			int[] diceRolls = new int[1000000];
			int i = 0;
			//ArrayList<Integer> diceRolls = new ArrayList<Integer>();
			int diceSum = 0;
			
			while(diceSum<=M) {
				int diceRoll = (int) (1+Math.round(Math.random()*5));
				diceRolls[i] = diceRoll;
				diceSum = diceSum + diceRoll;
				i++;
				//System.out.println("Test Number: "+allSumsCount+", diceRoll: "+diceRoll+", diceSum: "+diceSum+", i: "+i);
			}
			
			allSums[allSumsCount] = diceSum;
			allNumRolls[allSumsCount] = i+1;
			allSumsCount++;
			
			histVari[9] = histVari[8];
			histVari[8] = histVari[7];
			histVari[7] = histVari[6];
			histVari[6] = histVari[5];
			histVari[5] = histVari[4];
			histVari[4] = histVari[3];
			histVari[3] = histVari[2];
			histVari[2] = histVari[1];
			histVari[1] = histVari[0];
			histVari[0] = stDevSums;
			
			stDevSums = Math.sqrt(weka.core.Utils.variance(Arrays.copyOfRange(allSums,0,allSumsCount)));
		}
	    
		meanSums = weka.core.Utils.mean(Arrays.copyOfRange(allSums,0,allSumsCount));
		meanNumRolls = weka.core.Utils.mean(Arrays.copyOfRange(allNumRolls,0,allSumsCount));
		stDevRolls = Math.sqrt(weka.core.Utils.variance(Arrays.copyOfRange(allNumRolls,0,allSumsCount)));
		
		System.out.println("We ran the test : "+allSumsCount+" times.");
		System.out.println("Mean of sums minus M: "+(meanSums-M)+" when M="+M);
		System.out.println("Standard deviation of the sums minus M: "+stDevSums+" with M="+M);
		System.out.println("Mean of rolls: "+meanNumRolls+" when M="+M);
		System.out.println("Standard deviation of the rolls: "+stDevRolls+" with M="+M);
		
		
		System.out.println("Ok, we're done!");
		
	}

}
