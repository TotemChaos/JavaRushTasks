package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        try(
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[1]))
        )
        {
            byte[] buffer = new byte[bis.available()];
            bis.read(buffer);
            String s = new String(buffer, "UTF-8");
            buffer = s.getBytes("Windows-1251");
            bos.write(buffer);
        }
    }
}
