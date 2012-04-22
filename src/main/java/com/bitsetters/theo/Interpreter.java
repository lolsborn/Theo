package com.bitsetters.theo;

import com.bitsetters.theo.Global.Procedure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 * <p/>
 * Based in part by
 * http://norvig.com/lispy.html
 */
public class Interpreter {

    HashMap<String, Object> env;
    Stack<String> stack = new Stack<String>();
    Global global = new Global();

    public Interpreter() {
        env = global.globalEnv();
    }

    public static void main(String[] args) {
    }

    public void eval(String code) throws Exception {
        LinkedList<String> tokens = tokenize(code);
        for(String token : tokens) {
            stack.push(token);
            if(token.equals(")")) {
                String[] op = popOperation();

                Long ret = (Long) call(op);
                stack.push(Long.toString(ret));
            }
        }
        System.out.println("RESULT: " + stack.pop());
    }

    public String[] popOperation() {
        LinkedList<String> tokens = new LinkedList<String>();
        String t = "";
        while(!stack.empty()) {
            t = stack.pop();
            tokens.addFirst(t);
            if(t.equals("("))
                break;
        }
        return tokens.toArray(new String[tokens.size()]);
    }

    public Object atom(String str) {
        Integer i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return str;
        }
        return i;
    }

    /**
     * Takes a
     * @param tokenList
     * @return
     */
    public Object call(String[] tokenList) throws InvalidProcedure {
        // Supports token lists with or without the parentheses
        int startPos = 0;
        if(tokenList[startPos].equals("(")) {
            startPos++;
        }

        String opString = tokenList[startPos];
        Procedure procedure = (Procedure) env.get(opString);
        if(procedure == null) {
            throw new InvalidProcedure(opString);
        }
        ArrayList<String> args = new ArrayList<String>();
        for(int i=startPos + 1; /* skip first element */ i<tokenList.length; i++) {
            if(tokenList[i].equals(")"))
                break;
            args.add(tokenList[i]);
        }
        String[] argArray = args.toArray(new String[args.size()]);
        return procedure.execute(argArray);
    }

    public LinkedList<String> tokenize(String str) {
        LinkedList<String> tokenList = new LinkedList<String>();
        String[] tokens = str.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").split(" ");
        // remove whitespace tokens
        for (String t : tokens) {
            if (t.trim().isEmpty())
                continue;
            tokenList.add(t);
        }
        return tokenList;
    }

}
