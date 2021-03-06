/*Your program:
b. Accepts the same small input file you used in step 1 and searches it for the search strings.

c. Has Mapper code that will search the input file line by line to find matches. 
The matching is not case sensitive (same as before).
The mapper code should not do any summing or buffering (no storing data in a map or array). 
The summing must happen in the reducer code.

d. You are required to use a Reducer. 
The Reducer code will input the key-value pairs generated by the map phase 
and output the number of lines that contained each search string. 
Using the input file, the resulting counts will be:
            Chicago 1
            Dec 3
            Java 0
            hackathon 2

Think about the example covered in the book where temperatures (values) were sorted by year (the key). 
These key-value pairs are guaranteed to arrive at the reducer(s) sorted by key. 
The reducer can iterate through the values associated with a given key and process them. 
In the MaxTemperature example, that processing was to select the max temperature by iterating through the values. 
Think about what a reducer should do for a WordCount algorithm to be efficient in a distributed system 
- write your algorithm so the summing happens in the reducer.
*/

import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.lang.*;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

		int sumvalue = 0; 
		for (IntWritable value : values) {
			sumvalue = Integer.sum(sumvalue, value.get()); 
		}
		context.write(key, new IntWritable(sumvalue)); 
	}
}