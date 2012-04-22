package com.bitsetters.theo;

import java.util.HashMap;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public class Global {


    public HashMap<String, Object> globalEnv() {
        HashMap<String, Object> env = new HashMap<String, Object>();
        env.put("+", new ProcAdd());
        env.put("-", new ProcSub());
        env.put("*", new ProcMul());
        env.put("/", new ProcDiv());
        return env;
    }

    public interface Procedure {
        public abstract Object execute(String[] objs);
    }

    public static class ProcAdd implements Procedure {
        public Object execute(String[] objs) {
            if (objs.length == 0) return (long) 0;
            long res = Long.parseLong(objs[0]);
            for (int i = 1; i < objs.length; i++) res += Long.parseLong(objs[i]);
            return res;
        }
    }

    public static class ProcSub implements Procedure {
        public Object execute(String[] objs) {
            if (objs.length == 0) return (long) 0;
            long res = Long.parseLong(objs[0]);
            for (int i = 1; i < objs.length; i++) res -= Long.parseLong(objs[i]);
            return res;
        }
    }

    public static class ProcMul implements Procedure {
        public Object execute(String[] objs) {
            if (objs.length == 0) return (long) 0;
            long res = Long.parseLong(objs[0]);
            for (int i = 1; i < objs.length; i++) res *= Long.parseLong(objs[i]);
            return res;
        }
    }

    public static class ProcDiv implements Procedure {
        public Object execute(String[] objs) {
            if (objs.length == 0) return (long) 0;
            long res = Long.parseLong(objs[0]);
            for (int i = 1; i < objs.length; i++) res /= Long.parseLong(objs[i]);
            return res;
        }
    }
}
