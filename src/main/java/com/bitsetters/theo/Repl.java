package com.bitsetters.theo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public class Repl {

    private static boolean exit = false;

    public static void main(String[] args) throws Exception {

        Interpreter i = new Interpreter();
        i.env.put("exit", new ProcExit());

        while (!exit) {
            System.out.print("> ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            i.eval(input);
        }

    }

    private static class ProcExit implements Global.Procedure {

        public Object execute(String[] objs) {
            exit = true;
            return new Nil();
        }
    }


}
