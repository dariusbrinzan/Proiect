package main;

import checker.Checker;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.Constants;
import xmas.AnnualChildren;
import xmas.Input;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        runTests();
        Checker.calculateScore();
    }

    private static void runTests() {
        for (int testNumber = 1; testNumber <= Constants.TESTS_NUMBER; ++testNumber) {
            runTest(testNumber);
        }
    }

    private static void runTest(final int testNumber) {
        ExclusionStrategy strategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipClass(final Class<?> clazz) {
                return false;
            }

            @Override
            public boolean shouldSkipField(final FieldAttributes field) {
                return field.getName().equals("niceScore");
            }
        };
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .addSerializationExclusionStrategy(strategy).create();
        String fileName = Constants.INPUT_PATH  + testNumber + Constants.FILE_EXTENSION;
        try {
            FileReader reader = new FileReader(fileName);
            Input input = gson.fromJson(reader, Input.class);
            reader.close();
            input.createMapGiftCategoriesSortedByGiftsPrice();
            AnnualChildren annualChildren = input.startSimulation();
            createOutputDir();
            File outputFile = new File(Constants.OUTPUT_PATH
                    + testNumber + Constants.FILE_EXTENSION);
            FileWriter writer = new FileWriter(outputFile);
            gson.toJson(annualChildren, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createOutputDir() throws Exception {
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            if (!outputDir.mkdirs()) {
                throw new Exception("[-] Couldn't create directory: /output");
            }
        }
    }
}
