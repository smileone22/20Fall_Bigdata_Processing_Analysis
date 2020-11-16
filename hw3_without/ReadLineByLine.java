/*Wordcount without using MapReduce framework
This is a WordCount-based problem - the goal is to find the number of lines 
containing a specific search term. 
Write a Java (or Python or C/C++) program, without using Hadoop MapReduce, that:
a. Searches for all of the following strings in the input file 
	containing tweet data (you can provide the search terms as parameters,
	 or hardcode them): hackathon, Dec, Chicago, Java
	 
b. Accepts a small input file to be searched containing lines of the form: 
Date,Time;Name,Tweet Here is the exact data to type or copy-paste into your input file:

28-Dec-18,7:00PM;#NYCHadoop,Hadoop-NYC Strata/Hadoop World Meetup at Google NYC 
09-Dec-18,6:00PM;#Hackatopia,Tribeca Film Hackathon: Code As A New Language For Content Creators Hackathon 
31-Dec-18,3:00PM;#Hackatopia,Designers, Developers, Doers, don't miss this upcoming Chicago hackathon

c. Your code will search for all of the search strings in the input file 
and output the number of lines that contained each search string 
(not the number of occurrences of a search string). 
The matching is not case sensitive, 
i.e. if searching for the search string hackathon, 
all of the following are a match: hackathon, Hackathon, hACKathon 
(and any other combination of upper and lower case characters).
d. Your code should output the number of lines that contained each search string. 
Using the input data above, the resulting counts will be:
           Chicago 1
           Dec 3
           Java 0
           hackathon 2
e. Upload homework to NYU Classes. To receive full credit, 
please hand in all of the following items on or before the due date: 
- Your program, your input file, and job output.
- Evidence that the program ran successfully - screenshots
*/



import java.io.*;  
import java.util.*;

public class ReadLineByLine {  
	public static void main(String args[]){  
		Map<String, Integer> output = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
 			output.put("Chicago",0);
 			output.put("Dec",0);
 			output.put("Java",0);
 			output.put("hackathon",0);

		try {  
			FileInputStream file=new FileInputStream("hw3input.txt");       
			Scanner sc=new Scanner(file);  

 			
 			

			while(sc.hasNextLine()) {  
				String thisline= sc.nextLine();
				String[] words = thisline.split(" |-|,|;");
				for (int i=0; i<words.length;i++){
					if (output.containsKey(words[i])){   
						int n =output.get(words[i]);      
      					output.put(words[i],++n);
    				}
				}
			} 
			sc.close();     
		}  
		catch(IOException e) {  
			e.printStackTrace();  
		}  

		//printout the output 
		for(Map.Entry<String, Integer> entry : output.entrySet()){
    		System.out.println(entry.getKey()+" "+entry.getValue());
		} 
	}
}  