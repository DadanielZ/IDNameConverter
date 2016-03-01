package com.da.zhou.mapr;

/**
 * Created by dataguise on 2/29/2016.
 */

import com.mapr.fs.clicommands.MapRCliCommands;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class IDNameConverter {
    MapRCliCommands cmds = new MapRCliCommands();

    public static void main(String[] args ) throws IOException, URISyntaxException{
        Configuration conf = new Configuration();
        //conf.set("fs.defaultFS.name","hdfs://192.168.6.131:8020");
        //Path p=new Path("hdfs:/192.168.6.131:8020/test0");
        FileSystem fileSystem = FileSystem.get(URI.create("maprfs://192.168.6.148"),conf);
        if(fileSystem instanceof DistributedFileSystem) {
            System.out.println("HDFS is the underlying filesystem");
        }
        else {
            System.out.println("Other type of file system "+fileSystem.getClass());
        }
    }

}
