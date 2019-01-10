package com.muji.zh.student.util;

import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * 文件读取工具类
 */
public class FileUtil {

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } 

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        } 

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流  
        FileInputStream fis = new FileInputStream(filePath);  
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];  
        // 用于保存实际读取的字节数  
        int hasRead = 0;  
        while ( (hasRead = fis.read(bbuf)) > 0 ) {  
            sb.append(new String(bbuf, 0, hasRead));  
        }  
        fis.close();  
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }


    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }



   public static void saveAsFileWriter(String content,String savefile) {

       File file = new File(savefile);
       if(!file.exists()){
           file.getParentFile().mkdirs();
       }
        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(savefile);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    //base64字符串转化成图片
    public static boolean GenerateImage(String path,String imgStr)
    {   //对字节数组字符串进行Base64解码并生成图片
        File file=new File(path);
        if (!file.exists())
        {
            System.out.println("创建失败");
            System.out.println("=======================================");
            file.mkdir();
        }
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imgFilePath = path;//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public static  void change(String path) throws IOException {
        File file = new File(path);		//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        for(File f:fs){					//遍历File[]数组
            if(!f.isDirectory()) {//若非目录(即文件)，则打印

                System.out.println(f);
                String fath = f.toString();
                byte[] bytes1 = FileUtil.readFileByBytes(fath);
                String image1 = Base64Util.encode(bytes1);
                String paths = fath + ".txt";
                FileUtil.saveAsFileWriter(image1, paths);
            }else {
                f.toString();
                FileUtil.change(f.toString());
            }
        }




    }

    public static void main(String[] args) throws IOException {
        String s="iVBORw0KGgoAAAANSUhEUgAAAHsAAAA8CAIAAADJ+FL8AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAADUElEQVR4nO1cwW6jMBCdsaGRctyVVj13D/2a7v//QLVSteccktizBycUzDgBYwYDfpcSahvzeB7PjA348+0DdgNEbI6J6HYAQIOrN7WiUU2sPxPa1Cx4uT6/0zuWKeMzoWEQETt6D5RvizqVCFSSVgqGw9d4/0k+sFwTC8sjog/Ju100Lo3CuDQK49KontqpUYYsB2OdOYrGpVFNDaFSgIjUfXDcvB3BsSLMQEUtUzA9hIXB8Zsr9vr6i4g+P/+C1i7ccIVytk3DLSfL55Ixp7X2/f3NWvv19e9yuQAAEb28vBhjFuzV3MAfv/8spXFjTF3XRHQ6nY7Ho9b6fD4bY7TWOc/A69B4/9pEpJSyxiBAVVXX65WIEFGpjU/mHcbnVpY3mJRSl/NZIR4OB2uttdYV8NJM6wV7F0sKyhgDiKAUEVlrnca11gt2SQALD+G6rm8uCpGTdpK5JGcs6as0JtvZ9D3QDUOi/CTwrtI26KF/bRUbdwwyRGFcGoVxaRTGpVEYl0ZhXBod77C9N6PtGrNlxoLNl63XF4zexyIXAbkubiZnEg3GqjTpJPHO7AKTNB6XKd6GVYnGI8YTJjp2yGwIfH684bowlRyMxhs7njCTF9rUukMwjO8hZZoCkboZPXPGKTRca616jx6oJeaURmFcGs937M8M5nKhiWTiRpFHnRC866JxaezrzasQ5nDOQqMmfm9t0yIFzq8I87nDfTYq/9xgwoiNkmhMEwG0o6S44GCUXSYAmkcmyPU93qoEE1IlfgIAp0juvNB+lcwh6T/Ea5xfGCLANVpywXGZID/+/UkBl24MMJ7tYBLuVvEO3bicqWHmefIry0Nb7L/as85pcz6Z9/nwNB556SEGI3YLQFStbB5834Gu2veUwNKmV0usCLiT0fmW6DWDfsVixwEAbOB8KK4eCAIC6qxlQmEc4OEomjhk08acawS7ykoQNBnUO4Axbi7Sd1H35g2I7VeZjrHfyhnVs6dGI86q8FF+VFNbw0yMO0vuYRrjmThhXDeCHxvrKo+8v94v5BoaftfUzWe5mRNhHe9PprJfHF2o/TL33TWAjErZZu8bqrrWj5k2ilVJif6re32Udc4niPYOQhUL488xkHT/q5UB5+o/hpszfrbTjY0AAAAASUVORK5CYII=";
        String path="D:\\2";
        FileUtil.GenerateImage(path,s);
    }




}
