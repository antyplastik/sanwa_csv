package csv;

import csv.io.FileCreator;
import csv.io.FileReader;
import csv.io.FileWriter;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class CSVImpl implements CSV<String> {

    private FileReader fr;
    private FileWriter fw;
    private FileCreator fc;

    public CSVImpl(String filePath, String fileName) throws IOException {
        fr = new FileReader(fileName,filePath);
        fw = new FileWriter(fileName,filePath);
        fc = new FileCreator(fileName, Paths.get(filePath));
    }

    @Override
    public String read() throws IOException {
        return fr.read();
    }

    @Override
    public void write(String toWrite) throws IOException {
        fw.write(toWrite);
    }

    public boolean createCsvFile() throws IOException {
        return fc.create();
    }

    public boolean deleteCsvFile(){
        return fc.destroy();
    }

    public boolean csvFileExist(){
        return fc.exists();
    }
}
