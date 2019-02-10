package org.numlistener;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MusicMapper extends Mapper<Object, Text, Text, IntWritable>{
	private IntWritable one=new IntWritable(1);
	
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException
	{
	
		String line=value.toString();
		String token[]=line.split(" ");
		
		String userid=token[0];
		//String trackid=token[1];
		
		context.write(new Text(userid), one);
	}

}
