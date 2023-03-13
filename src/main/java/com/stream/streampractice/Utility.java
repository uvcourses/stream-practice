package com.stream.streampractice;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utility {

   public static List<Scorecard> getScoreCard() throws CsvValidationException {
        List<Scorecard> scorecards = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("/Volumes/Learnings/Sourcecode/stream-practice/src/main/resources/ipl_dataset.csv"));
            CSVReader csvReader = new CSVReader(reader);
            String[] header = csvReader.readNext(); // Skip the first row (header)
            String[] line;
            while ((line = csvReader.readNext()) != null) {

                Scorecard scorecard = Scorecard.builder()
                        .fullScorecard(line[0])
                        .team1(line[1])
                        .team2(line[2])
                        .team1Score(Integer.parseInt(line[3]))
                        .team2Score(Integer.parseInt(line[4]))
                        .tossWinner(line[5])
                        .tossChoice(line[6])
                        .winner(line[7])
                        .margin(line[8])
                        .manOfTheMatch(line[9])
                        .stadium(line[10])
                        .place(line[11])
                        .build();


                scorecards.add(scorecard);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scorecards;
    }
}
