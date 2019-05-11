package com.hdl.up_server;

import java.io.*;

public class PythonMain {

    public static void main(String[] args)throws IOException,InterruptedException{


        //python脚本的路径
        String executePath = "/Users/hdl/work/projects/movie/movie/spiders/main.py";

        String par = "start_urls=http://v.douyin.com/6LuF9E/";
        //执行命令Arr
        String[] cmdArr = new String[]{"python3",executePath,par};
        //参数分别为： 执行命令；执行此脚本的路径
        Process process = Runtime.getRuntime().exec(cmdArr,null,new File("/Users/hdl/work/projects/movie/movie/spiders/"));

        int i = process.waitFor();
//        System.out.println(i);


        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                process.getInputStream()))){
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
