package com.upgrad.evm;

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


/** ElectionCountUsingHashMap class provides methods ADD , FIND and COUNT */

public class ElectionCountUsingHashMap {
	
	/** Voter Id is 6 digit number and range from 100000 - 999999.
	 * candidate Id is 3 digit number and range from 100 - 999 .
	 *   HashMap is used to store Voter Id and Candidate Id*/
	
	private static final int MIN_VID_RANGE = 100000, MAX_VID_RANGE = 999999 ,MIN_CID_RANGE = 100, MAX_CID_RANGE = 999;
	
	static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	
	/** The ADD() method adds the voter id and candidate id */
	
	private void ADD(int voterid, int candidateid) {
		hm.put(voterid,candidateid) ;	
		}
	
	/** The FIND() method takes the voter id and returns candidate id for whom the vote was cast 
	 * it returns 0 if the voter id is not valid or not found*/ 
	
	public int FIND(int voterid) {
		int CandidateID = 0;
		if(voterid <=MAX_VID_RANGE && voterid >= MIN_VID_RANGE && (hm.get(voterid)!=null)){
		 CandidateID = hm.get(voterid);
		}
		else {
			System.out.println("Invalid VoterID\n");
		}
		return  CandidateID;
	}
	
	/** The COUNT() method takes the candidate id and returns total number of votes received by the candidate 
	 * if the candidate id not found it returns 0 votes */
	
	public void COUNT(int candidate_id) {
		int votes = 0;
		if(candidate_id <=MAX_CID_RANGE && candidate_id >= MIN_CID_RANGE) {
			 for(Map.Entry m:hm.entrySet()){ 
				  Object k = m.getValue();
				  if(k.equals(candidate_id)){
						votes+=1;
					}
				  }  
			 System.out.println("No.of votes received by Candidate Number"+"\t"+candidate_id+"\t"+"is"+"\t"+votes);
			 } else {
			System.out.println("No candidate with ID"+" "+candidate_id);
			}
		}
	
	
	public static void main(String[] args)throws Exception {
		String arr[]= null;
		int i = 0,j = 0;
		try { 
			Scanner sc=new Scanner(System.in);
			/** Reading the data from a file (relative path) and storing it */
			Scanner scr=new Scanner(new File("src\\com\\upgrad\\evm\\data.txt"));
			ElectionCountUsingHashMap ec =new ElectionCountUsingHashMap();
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
	                System.out.println("Voter Id and Candidate Id added Successfully ");
	                break;      
	            case 2: 
	                System.out.println("Enter Voter Id\n");
	                System.out.println("Vote casted to Candidate Id "+ ec.FIND(sc.nextInt())); 
	                break;                                   
	            case 3 : 
	            	System.out.println("Enter Candidate Id\n");
	                ec.COUNT(sc.nextInt());
	                break;
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }
	            System.out.println("\nDo you want to continue (Type y or n)\n");
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
	 * 1.ADD : O(1) in HashMap put() takes run time O(1) to insert a key,value pair
	 * 2.FIND : O(1) in HashMap get() takes run time O(1) to retrieve a key,value pair
	 * 3.COUNT : O(n) We have to traverse through entire HashMap to find the no. votes for a particular candidate  */
}