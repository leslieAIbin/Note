package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class TCPClient {
    public static void main(String[] args) throws Exception{
        // 创建socket，并指定连接到是本机的端口号为65000的服务器socket
        Socket socket = new Socket("127.0.0.1", 65000);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        // 自定义输入字符串
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String inputString = sc.next();
        System.out.println("输入的字符串:"+inputString);

        /// 将要传递给server的字符串参数转换成byte数组，数组写入到输出流中
        // os.write(new String("hello world!").getBytes());
        os.write(inputString.getBytes());
        
        int ch = 0;
        byte[] buff = new byte[1024];
        // buff主要用来读取输入的内容，存成byte数组，ch主要用来获取读取数组的长度
        ch = is.read(buff); 
        // 将接受流的byte数组转换成字符串，这里是从服务端回发回来的字符串参数
        String content = new String(buff, 0 , ch);
        System.out.println(content);
        is.close();
        os.close();
        socket.close();
    }
}