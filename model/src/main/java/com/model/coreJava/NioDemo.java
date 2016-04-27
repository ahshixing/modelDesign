package com.model.coreJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * 参考:http://blog.csdn.net/wuxianglong/article/details/6612246
 * Created by shixing on 2016/4/27.
 */
public class NioDemo {
    public static void main(String[] args) throws Exception {
        testIntBuffer();
        System.out.println();
        nioRead();
        nioWrite();
    }

    /**
     * 1. 从FileInputStream获取Channel
     * 2. 创建Buffer
     * 3. 将数据从Channel读取到Buffer中
     *
     * @throws Exception
     */
    private static void nioRead() throws Exception {
        FileInputStream fin = new FileInputStream("E:\\Github\\modelDesign\\model\\src\\main\\java\\com\\model\\coreJava\\nio.txt");
        // 获取通道
        FileChannel fc = fin.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 读取数据到缓冲区
        fc.read(buffer);
        buffer.flip();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.print(((char) b));
        }
        fin.close();
    }

    /**
     * 1. 从FileInputStream获取Channel
     * 2. 创建Buffer
     * 3. 将数据从Channel写入到Buffer中
     *
     * @throws Exception
     */
    private static void nioWrite() throws Exception {
        String[] s = new String[]{"2016", "04", "24"};
        FileOutputStream fos = new FileOutputStream("E:\\Github\\modelDesign\\model\\src\\main\\java\\com\\model\\coreJava\\nio.txt");
        // 获取通道
        FileChannel fc = fos.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < s.length; i++) {
            buffer.put(s[i].getBytes());
            System.out.print(s[i]);
        }
        buffer.flip();
        // 读取数据到缓冲区
        fc.write(buffer);
        fos.close();
    }

    private static void testIntBuffer() {
        // 分配新的int缓冲区，参数为缓冲区容量
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); ++i) {
            int j = 2 * (i + 1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            buffer.put(j);
        }
        // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        buffer.flip();

        // 查看在当前位置和限制位置之间是否有元素
        while (buffer.hasRemaining()) {
            // 读取此缓冲区当前位置的整数，然后当前位置递增
            int j = buffer.get();
            System.out.print(j + "  ");
        }
    }
}
