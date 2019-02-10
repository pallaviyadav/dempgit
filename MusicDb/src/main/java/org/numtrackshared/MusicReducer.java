package org.numtrackshared;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MusicReducer extends Reducer<Text, Text, Text, Text> 
{
int sum=0,share=0;
	public void reduce(Text key, Iterable<Text> value,Context context) throws IOException, InterruptedException
	{
	
	
		for(Text val:value)
		{ 
			String val1=val.toString();
		   share=Integer.parseInt(val1);
		   sum=sum+share;
		
			
		}
		

		context.write(key, new Text(String.valueOf(sum)));
	}
}
