package org.numlistener;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.*;

public class MusicReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	int sum=0;
	IntWritable result=new IntWritable();
	
	
	
	public void reduce(Iterable<Text> key,IntWritable value,Context context) throws IOException, InterruptedException
	
	{
		
	  for(Text key1:key)
	  {
		  String line=key1.toString();
		  Set<String> s=new HashSet();
		  s.add(line);
		  
		 java.util.Iterator<String> itr= s.iterator();
		 
		 while(itr.hasNext())
		 {
			
			 String ele=itr.next();
			 context.write(new Text(ele), value);
		 }
		  
		  
	  }
		 
		  
			
	}

}
