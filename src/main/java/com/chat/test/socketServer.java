package com.chat.test;

import java.net.ServerSocket;
import java.net.Socket;

public class socketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server=new ServerSocket(1024);
            System.out.println("服务已启动，等待客户端链接");
            Socket socket =   server.accept();
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println("有客户端链接ip "+ip+",端口 "+socket.getPort());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
