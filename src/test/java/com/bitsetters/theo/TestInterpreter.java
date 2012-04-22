package com.bitsetters.theo;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public class TestInterpreter {

    Interpreter i = new Interpreter();

    @Test public void test_eval() throws Exception {
        String cmd = "(* 2 (+ 33 343 (+ 10 10) (+ 1 3) ))";
        i.eval(cmd);
    }

    @Test public void test_call() throws Exception {
        long ret = (Long) i.call(new String[] {"(", "+", "33", "343", ")"});
        Assert.assertEquals(376, ret);

        long ret2 = (Long) i.call(new String[] {"*", "3", "3", "3"});
        Assert.assertEquals(27, ret2);
    }

    @Test public void test_tokenizer() {
        LinkedList<String> foo = i.tokenize("(+ 33 343 (foo 51 4))");
        String[] expected = new String[] {"(", "+", "33", "343", "(", "foo", "51", "4", ")", ")"};
        Assert.assertEquals(expected.length, foo.size());
        for(int i=0; i<foo.size(); i++) {
            Assert.assertEquals(expected[i], foo.get(i));
        }
    }

    @Test public void test_ProcAdd() {
        long ret = (Long) new Global.ProcAdd().execute(new String[] {"11", "11", "40", "4", "1"});
        Assert.assertEquals(67, ret);

        ret = (Long) new Global.ProcAdd().execute(new String[] {});
        Assert.assertEquals(0, ret);
    }

    @Test public void test_ProcSub() {
        long ret = (Long) new Global.ProcSub().execute(new String[] {"100", "11", "40", "4", "1"});
        Assert.assertEquals(44, ret);

        ret = (Long) new Global.ProcSub().execute(new String[]{});
        Assert.assertEquals(0, ret);
    }

    @Test public void test_ProcMul() {
        long ret = (Long) new Global.ProcMul().execute(new String[] {"3", "3", "3"});
        Assert.assertEquals(27, ret);
    }

    @Test public void test_ProcDiv() {
        long ret = (Long) new Global.ProcDiv().execute(new String[]{"27", "3", "3"});
        Assert.assertEquals(3, ret);
    }

}
