package com.kronos.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 一定要记得close
 */
public class FileTest {
    @Test
    public void readTest() throws IOException {
        File file = new File("./1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String text;
        // readLine返回null时表示文件结尾
        while((text = br.readLine()) != null) {
            System.out.println(text);
        }
        br.close();
    }

    @Test
    public void writeTest() throws FileNotFoundException {
        File file = new File("./1.txt");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        String text = "abcd";
        pw.println(text);
        pw.close();
    }
}
