package com.nirvana.travel.bigdata.mr.wc;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2020/10/27
 */
public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

   private IntWritable result = new IntWritable();

  @Override
  protected void reduce(Text key, Iterable<IntWritable> values, Context context)
    throws IOException, InterruptedException {

    int sum = 0;
    for (IntWritable val : values) {
      sum += val.get();
    }
    result.set(sum);
    context.write(key, result);
  }
}