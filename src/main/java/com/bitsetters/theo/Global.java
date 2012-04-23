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
        env.put("if", new ProcIf());
        env.put(">", new ProcGreater());
        env.put(">=", new ProcGreaterEq());
        env.put("<", new ProcLess());
        env.put("<=", new ProcLessEq());
        Procedure eq = new ProcEq();
        env.put("eq?", eq);
        env.put("=", eq);
        env.put("not", new ProcNot());
        return env;
    }

    public interface Procedure {
        public abstract Object execute(String[] objs);
    }

    public static class ProcIf implements  Procedure {
        public Object execute(String[] objs) {
            boolean condition = Boolean.parseBoolean(objs[0]);
            if(condition)
                return objs[1];
            else
                return objs[2];
        }
    }

    public static class ProcEq implements Procedure {
        public Object execute(String[] objs) {
            long val1 = Long.parseLong(objs[0]);
            long val2 = Long.parseLong(objs[1]);
            return (val1 == val2);
        }
    }

    public static class ProcNot implements Procedure {
        public Object execute(String[] objs) {
            boolean val1 = Boolean.parseBoolean(objs[0]);
            return !val1;
        }
    }

    public static class ProcGreater implements Procedure {
        public Object execute(String[] objs) {
            long val1 = Long.parseLong(objs[0]);
            long val2 = Long.parseLong(objs[1]);
            return (val1 > val2);
        }
    }

    public static class ProcGreaterEq implements Procedure {
        public Object execute(String[] objs) {
            long val1 = Long.parseLong(objs[0]);
            long val2 = Long.parseLong(objs[1]);
            return (val1 >= val2);
        }
    }

    public static class ProcLessEq implements Procedure {
        public Object execute(String[] objs) {
            long val1 = Long.parseLong(objs[0]);
            long val2 = Long.parseLong(objs[1]);
            return (val1 <= val2);
        }
    }

    public static class ProcLess implements Procedure {
        public Object execute(String[] objs) {
            long val1 = Long.parseLong(objs[0]);
            long val2 = Long.parseLong(objs[1]);
            return (val1 < val2);
        }
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
