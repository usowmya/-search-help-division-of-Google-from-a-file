package sdcassignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class GoogleSearch {



	static ArrayList<String> my_ds = new ArrayList();
	static ArrayList<String> temp_ds_block = new ArrayList();
    static ArrayList<String> temp_prefix = new ArrayList();
    static ArrayList<String> c_prefix = new ArrayList();
    static ArrayList<String> r_prefix = new ArrayList();
	static ArrayList<String> prefix_arr = new ArrayList();
	static String[] a;
	
	static int pre_count = 0;
	static String result = new String();
	static int n = 0;
	
	
	
	public static boolean load() {
		/**This method is used to load all words in the given text file into an Array List.
		 * Path to folder is obtained from the user. */
		 boolean ret = true;
		 try {
			// all elements are removed so that previous data is lost when loaded
			my_ds.removeAll(my_ds);
			// string variable to hold data of each line when iterated through the file
			String output;
			// Obtaining user input for path to file containing list of words
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the path to the file:");
			String filePath = sc.nextLine();
			File fileWords = new File(filePath);
	    	StringBuilder stringBuilder = new StringBuilder();
	    	Scanner inputFile = new Scanner(fileWords);
	    	
			// loop until last word to add read lines as strings to array list
			while (inputFile.hasNext())
			{
				output = inputFile.nextLine();
				stringBuilder.append(output);
				my_ds.add(output);
			}
			
		 }
		catch (FileNotFoundException e) {
			// Exception handling when a file not found and provided path. Returns false.
			System.err.println("File not found. Exit and Retry.");
			ret = false;
		}
		catch (Exception e) {
			// General exception to catch unexpected errors. Returns false.
			System.err.println("Unexpected error! Try to load again!");
			ret = false;
		}
		if(ret) {
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean add(String word) {
		/**This method is used to add a word to existing ArrayList. Returns true if no error occurs. */
		
		// boolean variable to verify successful addition of input word to array list
		boolean ret = true;
		int ind = 0;
		try{
			// adds a given word to array list
			// creating another datablock from the existing arraylist for manipulation during binary search.
						temp_ds_block.addAll(my_ds);
						// bot variable represents the lower boundary of the arraylist and is dynamically changed as binary search is applied
						int bot = 0;
						// top variable represents the upper boundary of the arraylist and is dynamically changed as binary search is applied
						int top = temp_ds_block.size()-1;
						// n represents the middle index of the array list and is dynamically changed during binary search 
						n = (bot+top)/2;
						// looped until it breaks from inside
						while(true) {	
							// the middle idex calculated for even number of elements
							if(n%2==0) {
								n = (bot+top)/2;
								}
							// the middle index calculated for odd number of elements
							else if(n%2==1) {
								n = ((bot+top)/2)-1;
							}
							// the word before at middle index is stored as found_word
							String found_word = temp_ds_block.get(n);
							// if there is only one word between top and bottom boundaries which is not the required word, ret is made false
							if(top-bot==1) {
								ret = false;
								break;
							}
							// if the found word is lexicographically less than required word, bottom boundary is increased to above the current middle index
							else if(found_word.compareTo(word)<0){
								bot = n+1;
								System.out.println(bot);
							}
							// if the found word is lexicographically greated than required word, top boundary is reduced to above the current middle index
							else if(found_word.compareTo(word)>0){
								top = n + 1;
								System.out.println(top);
							}
							// if the found word is the required word, ret is made true
							else if(found_word.compareTo(word)==0){
								System.out.println("Found word:"+word);
								ret = true;
								break;
							}
						}
					my_ds.add(top-1,word);
			
			
		}
		catch (Exception e) {
			// General exception to catch any unexpected errors. Prints the error to console and returns false.
			System.err.println("Exception in add() function:"+e);
			return false;
		}
		if(ret) {
			return true;}
		else {
			return false;
		}
	}
	
	public static boolean remove(String word) {
		/**This method is used to remove a given word from the existing ArrayList. Returns true if no error occurs. */
		
		// boolean variable to verify successful removal of input word from Array list 
		boolean ret;
		try{
			// removes the given word from array list
			ret = my_ds.remove(word);
			// System.out.println(my_ds);
			
		}
		catch (Exception e) {
			// General exception to catch any unexpected errors. Prints the error to console and returns false.
			System.err.println("Exception in remove() function:" +e);
			return false;
		}
		if(ret) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean find(String word) {
		/**This method is used to find a given word in the list of words using a Binary search algorithm.
		 * If the word is found, the method returns true or else return false.*/
		
		 //boolean variable to verify successful removal of input word from Array list 
		boolean ret = true;	
		try {
			// creating another datablock from the existing arraylist for manipulation during binary search.
			temp_ds_block.addAll(my_ds);
			// bot variable represents the lower boundary of the arraylist and is dynamically changed as binary search is applied
			int bot = 0;
			// top variable represents the upper boundary of the arraylist and is dynamically changed as binary search is applied
			int top = temp_ds_block.size()-1;
			// n represents the middle index of the array list and is dynamically changed during binary search 
			n = (bot+top)/2;
			// looped until it breaks from inside
			while(true) {	
				// the middle index calculated for even number of elements
				if(n%2==0) {
					n = (bot+top)/2;
					}
				// the middle index calculated for odd number of elements
				else if(n%2==1) {
					n = ((bot+top)/2)-1;
				}
				// the word before at middle index is stored as found_word
				String found_word = temp_ds_block.get(n);
				// if there is only one word between top and bottom boundaries which is not the required word, ret is made false
				if(top-bot==1) {
					System.out.println("Word not found");
					ret = false;
					break;
				}
				// if the found word is lexicographically less than required word, bottom boundary is increased to above the current middle index
				else if(found_word.compareTo(word)<0){
					bot = n+1;
					System.out.println(bot);
				}
				// if the found word is lexicographically greated than required word, top boundary is reduced to above the current middle index
				else if(found_word.compareTo(word)>0){
					top = n + 1;
					System.out.println(top);
				}
				// if the found word is the required word, ret is made true
				else if(found_word.compareTo(word)==0){
					System.out.println("Found word:"+word);
					ret = true;
					break;
				}
			}
		}
		catch(Exception e){
			// General exception to catch any unexpected errors. Prints the error to console and returns false.
			System.err.println("Exception from find1():"+e);
			return false;
		}
		if(ret) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public static ArrayList search_for_prefix(String prefix){
		// creating another datablock from the existing arraylist for manipulation during binary search.
        temp_prefix.addAll(my_ds);
		int x = 0;
		while(x<1) {	
			int N = temp_prefix.size()-1;
			char to_find = prefix.charAt(x);
			// Checking for the first letter and iterating it back if the searched word is the place where am dividing for binary search
			if(to_find=='a'){
				int i_a =0;
				while(true) {
					if(temp_prefix.get(i_a).charAt(0)=='b') {
						break;
					}
					i_a++;
				}
				// divinding it for binary search and deleting the other half where there is no match
				temp_prefix.subList(i_a-1,N).clear();
				break;
			}
			// Checking for the first letter and iterating it back if the searched word is the place where am dividing for binary search
			else if(to_find=='z'){
				int i_z =N;
				while(true){
					if(temp_prefix.get(i_z).charAt(0)=='y'){
						break;
					}
					i_z--;
				}
				// divinding it for binary search and deleting the other half where there is no match
				temp_prefix.subList(0,i_z).clear();
				break;
			}
			else{
				int temp = (int) to_find + 1;
				char to_fd =(char) temp;
				String found_word = temp_prefix.get((N/2));
				char found_char = found_word.charAt(x);
				if(to_fd-found_char==1){
					//Iterate down
					int i_d =(N/2)-1;
					while(true){
						if((int)temp_prefix.get(i_d).charAt(0)==to_find-1){
							break;
						}
					i_d--;
					System.out.println("printing id:"+i_d);
					}
					//iterate up
					int i_up =(N/2)-1;
					while(true) {
						if((int)temp_prefix.get(i_up).charAt(0)==to_find+1) {
							break;
						}
						i_up++;
						System.out.println("printing iup:"+i_up);
					}
					// divinding it for binary search and deleting the other half where there is no match
					temp_prefix.subList(0,i_d).clear();
					temp_prefix.subList(i_up,temp_prefix.size()-1).clear();
				}
				// if the character found and the one which is yet to find is greater then deletes the first half
				else if(found_char<to_fd){
					temp_prefix.subList(0, N/2).clear();
					
				}
				// if the character found and the one which is yet to find is lesser then deletes the second half
				else if(found_char>=to_fd) {
					temp_prefix.subList(N/2, N).clear();
					
				}
				x++;
				}
			}
		
        return temp_prefix;
    }
	
	public static int Count_prefix(String prefix) {
        /** This method calls the search_for_prefix() method to get the reduced array list and then returns the count of number of 
         * words starting with entered prefix in the reduced arraylist*/
        
         // calling the search method
         c_prefix = search_for_prefix(prefix);
        // loop to find and count words starting with given prefix
         for(int i=0;i<c_prefix.size();i++) {
			if(c_prefix.get(i).startsWith(prefix)){
				pre_count++;
			}
		}
		
		return pre_count;
	}

	public static String[] Report_prefix(String prefix) {
        /** This method calls the search_for_prefix() method to get the reduced array list and then returns the string array of
         * words starting with entered prefix in the reduced array list*/
        
        // calling the search method
        r_prefix = search_for_prefix(prefix);
        // loop to find and return string array containing only the words with given prefix
        for(int i=0;i<r_prefix.size();i++) {
			if(r_prefix.get(i).startsWith(prefix)){
				pre_count++;
				if(pre_count<21) {
                    // the first twenty words starting with given prefix are added to a array list to be converted to string array
                    prefix_arr.add(r_prefix.get(i));
                    // converted to a string array to be returned 
					a = prefix_arr.toArray(new String[20]);
				}
			}
		}
		
		return a;
	}
	
}

