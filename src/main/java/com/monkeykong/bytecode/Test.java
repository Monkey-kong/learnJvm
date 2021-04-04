package com.monkeykong.bytecode;

import com.google.common.base.Charsets;

/**
 * @author alvin
 * @date 2020-11-22 20:45
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(HexStringToString("3c696e69743e"));
    }

    /**
     * 十六进制转UTF-8字符串
     * @param hexString
     * @return
     */
    private static String HexStringToString(String hexString) {
        byte[] bytes = new byte[hexString.length()/2];
        String tmpBstr;
        for (int i = 0; i < hexString.length()/2; i++) {
            tmpBstr = hexString.substring(i*2, i*2+2);
            bytes[i] = Byte.parseByte(tmpBstr, 16);
        }
        return new String(bytes, Charsets.UTF_8);
    }
}
