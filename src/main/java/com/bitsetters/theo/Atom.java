package com.bitsetters.theo;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public abstract class Atom {

    public boolean isNil() {
        return false;
    }

    public abstract String toString();

    public boolean isa(Class c) {
        return (this.getClass() == c);
    }

}
