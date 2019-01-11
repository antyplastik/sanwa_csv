package main_and_communication_with_user;

import picocli.CommandLine;

public class Runner {

    public static void main(String[] args) {
        CommandLine.run(new PicoTerm(),args);
    }

}
