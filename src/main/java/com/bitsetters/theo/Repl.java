package com.bitsetters.theo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public class Repl {

    public static void main(String[] args) throws Exception {
        Interpreter i = new Interpreter();

        while (true) {
            System.out.println(">");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            i.eval(input);
        }

    }

}
