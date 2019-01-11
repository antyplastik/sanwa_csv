package processor;

import csv.CSVImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVtoProcessing implements Processor<CSVImpl> {

    private List<CSVImpl> csvFilesList = new ArrayList<>();

    @Override
    public void addToProcessing(CSVImpl toProcessing) {
        csvFilesList.add(toProcessing);
    }

    @Override
    public void toProcess() throws IOException {
        for(CSVImpl csv : csvFilesList){
            csv.read();
        }
    }

    @Override
    public List<CSVImpl> getFromProcessing() {
        return null;
    }
}
