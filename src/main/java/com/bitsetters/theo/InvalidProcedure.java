package com.bitsetters.theo;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public class InvalidProcedure extends Exception {
    String mistake;

    public InvalidProcedure(String err) {
        super(err);
        mistake = err;
    }
    public String getError() {
        return mistake;
    }
}