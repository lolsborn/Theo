package com.bitsetters.theo;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven Osborn <osborn.steven@gmail.com>
 * @copyright 2012, Bitsetters LLC
 */
public class Cli {

    @Parameter(description = "Files")
    private List<String> files = new ArrayList<String>();

    @Parameter(names = "-help", description = "Print this screen.")
    private boolean help = false;

    private Interpreter i = new Interpreter();

    public static void main(String[] args) {
        Cli cli = new Cli();
        JCommander jc = new JCommander(cli, args);
        jc.setProgramName("theo");
        if(cli.help) {
            jc.usage();
        }
    }
}
