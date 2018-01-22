package com.upgrad.evm;

import java.util.Scanner;
import java.io.File;

/** ElectionCount class provides methods ADD , FIND and COUNT */ 
public class ElectionCount {
	
	/** Voter Id is 6 digit number and range from 100000 - 999999. 
	 * candidate Id is 3 digit number and range from 100 - 999 
	 *  The array size = Max_Range - Min_Range + 1 */
	
	private static int[] arr1 = new int[900000];	
	private static final int MIN_VID_RANGE = 100000, MAX_VID_RANGE = 999999 ,MIN_CID_RANGE = 100, MAX_CID_RANGE = 999;
	
	/** The ADD() method adds the voter id and candidate id directly in a particular index */ 
	
	private void ADD(int voter_id, int candidate_id) {
		arr1[voter_id] = candidate_id;	
		}

	/** The FIND() method takes the voter id and returns candidate id for whom the vote was cast 
	 * it returns 0 if the voter id is not valid or not found*/ 
	
	public int FIND(int voter_id) {
		int candidate_id = 0;
		if(voter_id <=MAX_VID_RANGE && voter_id >= MIN_VID_RANGE){
			candidate_id = arr1[voter_id];
			}else {
				System.out.println("Invalid voter_id");
				}
			return  candidate_id;
    	}
	
	/** The COUNT() method takes the candidate id and returns total number of votes received by the candidate 
	 * if the candidate id not found it returns 0 votes */
	
    public int COUNT(int candidate_id) {
    	int votes = 0;
    	if(candidate_id <=MAX_CID_RANGE && candidate_id >= MIN_CID_RANGE) {
    		for(int s: arr1){
    	        if(s==candidate_id) {votes +=1;
    	        }
    		}
    		System.out.println("No.of votes received by Candidate Number"+"\t"+candidate_id+"\t"+"is"+"\t"+votes);
    	}else {
    			System.out.println("Invalid Candidate ID");
    			}
    	return votes;
		}
    
    
    	public static void main(String[] args)throws Exception {
    		String arr[]= null;
    		int i=0,j=0;
    		try { 
    			Scanner sc=new Scanner(System.in);
    			/** Reading the data from a file (relative path) and storing it */
    			Scanner scr=new Scanner(new File("src\\com\\upgrad\\evm\\data.txt"));
    			ElectionCount ec =new ElectionCount();
    			while(scr.hasNext()) {
    			String	s = scr.nextLine().trim();
    			arr=s.split("\t");
    			ec.ADD(Integer.parseInt(arr[j]),Integer.parseInt(arr[j+1]));
    			i++;
    			}
    			scr.close();
    			
    			/** Below is to select the Operation */
    			
    			char ch;
    	        do    
    	        {
    	            System.out.println("Select the Opertaion");
    	            System.out.println("1. ADD");
    	            System.out.println("2. FIND"); 
    	            System.out.println("3. COUNT"); 
    	              	 
    	            int choice = sc.nextInt();            
    	            switch (choice)
    	            { 
    	            case 1: 
    	                System.out.println("Voter ID and Candidate ID added Successfully");
    	                break;      
    	            case 2: 
    	                System.out.println("Enter Voter Id \n");
    	                System.out.println("Vote casted for Candidate ID "+ ec.FIND(sc.nextInt())); 
    	                break;                                   
    	            case 3 : 
    	            	System.out.println("Enter Candidate ID \n");
    	                ec.COUNT(sc.nextInt());
    	                break;
    	            default : 
    	                System.out.println("Wrong Entry \n ");
    	                break;   
    	            }
    	            System.out.println("\n Do you want to continue (Type y or n)\n");
    	            ch = sc.next().charAt(0);                        
    	        } 
    	        while (ch == 'Y'|| ch == 'y'); 
    	        sc.close();  
    		} 	 
    		
    		catch(Exception e) {
    			//e.printStackTrace();
    			System.out.println(e.getMessage());
    		}
    	}
    	
    	/** Worst Case time complexity 
    	 * 1.ADD : O(1) We are directly inserting in a particular index
    	 * 2.FIND : O(1) We are not doing any Key Comparisons
    	 * 3.COUNT : O(n) We have to traverse through entire array to find the no. votes for a particular candidate  */
    	
}



