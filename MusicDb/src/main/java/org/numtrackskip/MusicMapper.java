package org.numtrackskip;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MusicMapper extends Mapper<Object, Text, Text, Text>{
	
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException
	{
	
		String line=value.toString();
		String token[]=line.split(" ");
		
		String userid=token[0]; 
		String trackrd=token[1]+" "+token[3];
		
		
		context.write(new Text(userid) , new Text(trackrd));
	}

}
