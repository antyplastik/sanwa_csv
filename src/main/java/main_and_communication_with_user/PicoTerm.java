package main_and_communication_with_user;

import csv.CSVImpl;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@CommandLine.Command(name = "CSV Fixer for Sanwa PCLink", description = "The program to correct the data accidentally entered in the wrong columns by an error in the manufacturer's software.\n" +
        "Refers to Sanwa PC Link 7.", version = "v1.0")
public class PicoTerm implements Runnable {
    @CommandLine.Parameters(arity = "1..*", paramLabel = "FILE", description = "Input path to file(s) to process")
    private String[] inputParametersArgs;

    @Option(names = {"-s", "--save-file"}, description = "Save fixed text in the same file. By default, write to a new file")
    private boolean inputIsATextFlag;

    @Option(names = {"-d", "--new-dir"}, description = "Creating a new directory for processed files; as a parameter, enter the path to an existing or new directory")
    private String newDirPath;

    CSVImpl csv;

    @Override
    public void run(){

    }
}