package com.demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class App {
    public static void main(String[] args) throws IOException {

        FileChannel channel = new RandomAccessFile("/Users/ping/Desktop/data/data.txt", "rw").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(102400);
        CharBuffer charBuffer = CharBuffer.allocate(102400);

        Charset charset = Charset.forName("GBK");
        CharsetDecoder charsetDecoder = charset.newDecoder();

        int bufferRead = channel.read(buffer);
        
        StringBuilder builder = new StringBuilder("");
        while (bufferRead != -1) {
            // 转换读写模式
            buffer.flip();
            charsetDecoder.decode(buffer, charBuffer,true);

            while (charBuffer.hasRemaining()) {
                charBuffer.flip();
                char[] chars = new char[charBuffer.length()];
//                System.out.println(" 读出------- " + b);
                charBuffer.get(chars);

                builder.append(new String(chars));
            }
            // 重置
//            private int mark = -1;
//            private int position = 0;
//            private int limit;
//            private int capacity;
//            buffer.clear();
            // 将buffer中未读的数据移至buffer起始端
            buffer.compact();
            charBuffer.compact();
            bufferRead = channel.read(buffer);

        }
        System.out.println(builder.toString());
    }
}
