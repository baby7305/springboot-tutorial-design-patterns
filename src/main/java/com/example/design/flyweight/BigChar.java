package com.example.design.flyweight;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    // 字符名字
    private char charname;
    // 大型字符对应的字符串(由'#' '.' '\n'组成)
    private String fontdata;

    // 构造函数
    public BigChar(char charname) {
        this.charname = charname;
        try {
            Resource res = new ClassPathResource("big" + charname + ".txt");
            // ① 指定文件资源对应的编码格式（UTF-8）
            EncodedResource encRes = new EncodedResource(res, "UTF-8");
            // ② 这样才能正确读取文件的内容，而不会出现乱码
            this.fontdata = FileCopyUtils.copyToString(encRes.getReader());
        } catch (IOException e) {
            this.fontdata = charname + "?";
            e.printStackTrace();
        }
    }

    // 显示大型字符
    public void print() {
        System.out.print(fontdata);
    }
}
