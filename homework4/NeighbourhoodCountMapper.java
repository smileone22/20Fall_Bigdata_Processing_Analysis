import java.io.*;  
import java.util.*;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NeighbourhoodCountMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable> {
	private static final int MISSING = 9999;
	
	@Override
	public void map(LongWritable key, Text value, Context context) 
		throws IOException, InterruptedException {
	
	String line = value.toString();

	int lat_i= line.indexOf(",40."); //use the latitude index to find neighbourhood group and neighbourhood

	if (!line.startsWith("id") && lat_i>0){
		String sub_line= line.substring(0,lat_i); 
		int last_i = sub_line.lastIndexOf(",");
		String hood= sub_line.substring(last_i+1,sub_line.length());  //neighborhood

		String subsub_line= sub_line.substring(0,last_i);
		last_i=subsub_line.lastIndexOf(",");
		String group= subsub_line.substring(last_i+1,subsub_line.length()); //neighborhood group 
		context.write(new Text(group+" "+hood), new IntWritable(1));
	}

	else {
		context.write(new Text("BAD_RECORD"),new IntWritable(1)); //includes the header so realistically badrecord-1 
	}

}
}