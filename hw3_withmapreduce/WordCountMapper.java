/*Your program:
a. Searches for all of the following strings in the input file 
containing tweet data (you can provide the search terms as parameters, or
hardcode them): hackathon, Dec, Chicago, Java

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


e. Upload homework to NYU Classes. 
To receive full credit, please hand in all of the following items: 
- Your program, your input file, and job output.
- Evidence that the program ran successfully - screenshots

Think about the example covered in the book where temperatures (values) were sorted by year (the key). 
These key-value pairs are guaranteed to arrive at the reducer(s) sorted by key. 
The reducer can iterate through the values associated with a given key and process them. 
In the MaxTemperature example, that processing was to select the max temperature by iterating through the values. 
Think about what a reducer should do for a WordCount algorithm to be efficient in a distributed system 
- write your algorithm so the summing happens in the reducer.
*/



import java.io.*;  
import java.util.*;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable> {
	private static final int MISSING = 9999;
	
	@Override
	public void map(LongWritable key, Text value, Context context) 
		throws IOException, InterruptedException {


2539,Clean & quiet apt home by the park,2787,John,Brooklyn,Kensington,40.64749,-73.97237,Private room,149,1,9,2018-10-19,0.21,6,365
//09-Dec-18,6:00PM;#Hackatopia,Tribeca Film Hackathon: Code As A New Language For Content Creators Hackathon

	String line = value.toString();
	
	//Date,Time;Name,Tweet
	// String nameandtweet= line.substring(18,);
	// String [] info = nameandtweet.split(',',2)

	// String date = line.substring(,9);
	// String time = line.substring(10,16);

	// String name = info[0];
	// String tweet = info [1];
	List<String> mlist = Arrays.asList("Chicago", "Dec", "Java","hackathon");
	if (line.toLowerCase().contains(mlist.get(0).toLowerCase())){
		context.write(new Text(mlist.get(0)), new IntWritable(1));
	}
	if (line.toLowerCase().contains(mlist.get(1).toLowerCase())){
		context.write(new Text(mlist.get(1)), new IntWritable(1));
	}
	if (line.toLowerCase().contains(mlist.get(2).toLowerCase())){
		context.write(new Text(mlist.get(2)), new IntWritable(1));
	}
	if (line.toLowerCase().contains(mlist.get(3).toLowerCase())){
		context.write(new Text(mlist.get(3)), new IntWritable(1));
	}			
	
	
	}
}