package com.jlp.utils;

import java.io.*;
import java.util.UUID;

public class HeadImgTools {
    static String path = System.getProperty("user.dir");
    static String pathname = path + File.pathSeparator + "headImg";

    public static String getHeadImg(String src) {
        File file = new File(pathname + File.pathSeparator + src);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            return new String(bis.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String saveHeadImg(String jpeg) {
        BufferedOutputStream bufferedOutputStream = null;

        String s = UUID.randomUUID().toString(); //头像的名称
        try {
            File dir = new File(pathname);
            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("创建目录");
                boolean mkdirs = dir.mkdirs();
                if (!mkdirs) return null;
            }
            File file = new File(pathname + File.pathSeparator + s);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            System.out.println(file.getPath());
            bufferedOutputStream.write(jpeg.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }
}
