package main_and_communication_with_user;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "text_statistics", description = "The program to correct the data accidentally entered in the wrong columns by an error in the manufacturer's software.\n" +
        "Refers to Sanwa PC Link 7.", version = "v1.0")
public class PicoTerm implements Runnable {
    @CommandLine.Parameters(arity = "1..*", paramLabel = "FILE", description = "Input path to file(s) to process. D")
    private String[] inputParametersArgs;

    @Option(names = {"-t", "--new-file"}, description = "Input is a text (or texts)")
    private boolean inputIsATextFlag;

    @Option(names = {"-f", "--file"}, description = "Input is a file (or files)")
    private boolean inputIsAFileFlag;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequestedFlag;


    @Override
    public void run(){

    }
}