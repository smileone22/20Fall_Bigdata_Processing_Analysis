
import java.io.*;  
import java.util.*;
class Try{
public static void main(String[] args){
	String line = "2539,Clean & quiet apt home by the park,2787,John,Brooklyn,Kensington,40.64749,-73.97237,Private room,149,1,9,2018-10-19,0.21,6,365";
	int lat_i= line.indexOf(",40.");
	System.out.println(lat_i);
	String sub_line= line.substring(0,lat_i);
	System.out.println(sub_line);

	int last_i = sub_line.lastIndexOf(",");
	String hood= sub_line.substring(last_i+1,sub_line.length());

	String subsub_line= sub_line.substring(0,last_i);
	last_i=subsub_line.lastIndexOf(",");
	String group= subsub_line.substring(last_i+1,subsub_line.length());

	System.out.println(group + " " + hood);
	//String group= 
	// if (!line.startsWith("id")) {
	// String[] lines = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
	// System.out.println(lines[0]);
	//System.out.println(lines[5]);
	//}
}
}