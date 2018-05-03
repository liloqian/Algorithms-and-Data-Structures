package com.leo.interview;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

/**
 * @Author: qian
 * @Description: YUV转成RGB
 * @Date: Created in 10:17 2018/3/12
 **/
public class YUV2RGB {
    /**
     * @Date: 2018/3/12
     *
     * */
    public static void yuv8btorgb(String yuvInPath, String rgbOutPath, int width, int height) throws IOException {
        // 获取输入数据内容
        File inFile = new File(yuvInPath);
        long size = inFile.length();
        boolean is8bit = width*height == size;
        if (!is8bit) {
            System.err.println("输入图片 "+yuvInPath+" 不是8位yuv");
            return;
        }

        FileInputStream fis = new FileInputStream(inFile);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int temp ;
        int out;
        for (int i = 0 ; i < height ;i++) {
            for (int j = 0 ; j < width ;j++) {
                temp = fis.read();
                out = temp;
                out |= (temp << 8);
                out |= (temp << 16);
                bi.setRGB(j, i, out);
            }
        }

        System.out.println("构建成功，正在保存图片...");

        ImageIO.write(bi,"jpg",new File(rgbOutPath));

        System.out.println("保存成功!");
    }

    public static void main(String[] args) throws IOException {
        yuv8btorgb("E:\\IDEA_workd_dir\\SwordOffer\\src\\com\\leo\\interview\\sobel.yuv","E:\\IDEA_workd_dir\\SwordOffer\\src\\com\\leo\\interview\\out_sobel.jpg",720,576);
    }
}
