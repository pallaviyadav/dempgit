package org.numtrackshared;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MusicMapper extends Mapper<Object, Text, Text, Text>{
	
	
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException
	{
	   String line=value.toString();
	   String token[]=line.split(" ");
	   
	   String trackid=token[1];
	   String share=token[2];
	   
	   context.write(new Text(trackid), new Text(share));
	}

}
