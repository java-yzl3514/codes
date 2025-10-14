package com.ba.yzl3514.system;

import java.util.Map;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class SystemDriver {

    public static void main(String[] args) {

        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
        }

    }
}
