package com.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class AppWrite {
    public static void main(String[] args) throws IOException {


        byte[] b = {'1', '2'};
        byte[] a = {'3', '4'};

        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer buffer1 = ByteBuffer.allocate(10);

        String info = "test it";
//        buffer1.put(b);
        buffer.put(info.getBytes());

//        ByteBuffer[] buffers = {buffer, buffer1};

//        buffer.put(buffers);

        FileChannel channel = new FileOutputStream("/Users/ping/Desktop/data/data.txt").getChannel();

        buffer.flip();

        channel.write(buffer);

//        buffer.clear();

//        channel.close();

//        System.out.println(builder.toString());
    }
}
