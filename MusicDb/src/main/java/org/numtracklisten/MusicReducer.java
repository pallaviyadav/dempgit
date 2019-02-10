package org.numtracklisten;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MusicReducer extends Reducer<Text, Text, Text, Text>{
	 int share=0,radio=0,total=0;
	public void reduce(Text key,Iterable<Text> value,Context context) throws IOException, InterruptedException
	{
	
		for(Text val:value)
		{
		
			String line=val.toString();
			String token[]=line.split(" ");
			share=Integer.parseInt(token[0]);
			radio=Integer.parseInt(token[1]);
			
			total=share+radio;
		}
		
		context.write(key, new Text(String.valueOf(total)));
	}

}
