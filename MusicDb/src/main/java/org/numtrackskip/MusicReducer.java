package org.numtrackskip;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MusicReducer extends Reducer<Text, Text, Text, Text>{
	int count=0;
	public void reduce(Text key,Iterable<Text> value,Context context) throws IOException, InterruptedException
	{
	
		for(Text val:value)
		{
		String line=val.toString();
		String token[]=line.split(" ");
		String trackid=token[0];
		String rd=token[1];
		int radio=Integer.parseInt(rd);
		if(radio==0)
		{
		
			count++;
			
		}
		String c=String.valueOf(count);
		String word=trackid=" "+c;
		context.write(key, new Text(word));
		
		}
	}

}
