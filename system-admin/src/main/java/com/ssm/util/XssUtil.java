package com.ssm.util;

public class XssUtil {
    /**
     * Replace half-width characters that are prone to XSS vulnerabilities with full-width characters.
     * @param s the input string
     * @return the encoded string
     */
    public static String xssEncode(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '>':
                    sb.append('＞'); // Full-width greater than sign
                    break;
                case '<':
                    sb.append('＜'); // Full-width less than sign
                    break;
                case '\'':
                    sb.append('‘'); // Full-width single quote
                    break;
                case '\"':
                    sb.append('“'); // Full-width double quote
                    break;
                case '&':
                    sb.append('＆'); // Full-width ampersand
                    break;
                case '\\':
                    sb.append('＼'); // Full-width backslash
                    break;
                case '#':
                    sb.append('＃'); // Full-width hash sign
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }
}

