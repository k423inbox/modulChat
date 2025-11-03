package com.chat.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class socketClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",1024);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            System.out.println("请输入内容");
            Scanner scanner = new Scanner(System.in);
            new Thread(()->{
                while (true){
                    String input = scanner.nextLine();
                    printWriter.println(input);
                    printWriter.flush();
                }
            }).start();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            new Thread(()->{
                while (true){
                    try {
                        String readData = bufferedReader.readLine();
                        System.out.println("收到的消息为： "+readData);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
