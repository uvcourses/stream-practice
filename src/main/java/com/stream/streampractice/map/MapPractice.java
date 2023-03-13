package com.stream.streampractice.map;

import com.opencsv.exceptions.CsvValidationException;
import com.stream.streampractice.PlayerDetails;
import com.stream.streampractice.Scorecard;
import com.stream.streampractice.StreamPracticeApplication;
import com.stream.streampractice.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapPractice {
    public static void main(String[] args) throws CsvValidationException {
        List<Scorecard> scorecards = Utility.getScoreCard();
        final Logger logger = LoggerFactory.getLogger(StreamPracticeApplication.class);

        //  scorecards.stream().peek(arg -> logger.info(arg.getManOfTheMatch())).forEach(score -> logger.info(score.getManOfTheMatch()));
        //  scorecards.stream().map(scorecard -> Scorecard.builder().manOfTheMatch(scorecard.getManOfTheMatch()).stadium(scorecard.getStadium()).build()).collect(Collectors.toList()).stream().forEach(scorecard -> logger.info("Player :: {} Stadium :: {}", scorecard.getManOfTheMatch(), scorecard.getStadium()));
     /*   scorecards.stream()
				.filter(scorecard -> scorecard.getStadium().equalsIgnoreCase("Rajiv Gandhi International Stadium"))
				.map(scorecard -> {return scorecard.getManOfTheMatch().toUpperCase();}).collect(Collectors.toList())
				.forEach(s -> logger.info("PLAYER NAME {}",s)); */
        logger.info("Player Name     ::::: Team1 ::::: Team2 :::::: Stadium");
        logger.info("-----------------------------------------------------------");
        scorecards.stream().filter(scorecard -> scorecard.getManOfTheMatch()!=null)
                .map(scorecard -> {
                    return PlayerDetails.builder()
                            .manOfTheMatch(scorecard.getManOfTheMatch())
                            .stadium(scorecard.getStadium())
                            .team1(scorecard.getTeam1())
                            .team2(scorecard.getTeam2()).build();
                }).collect(Collectors.toList()).stream().forEach(player->logger.info("{} :: {} :: {} :: {}",player.getManOfTheMatch(),player.getTeam1(),player.getTeam2(),player.getStadium()));

      Optional<Integer> result=  scorecards.stream().map(Scorecard::getTeam1Score).reduce((integer, integer2) -> integer+integer2);
        if(result.isPresent()){
            logger.info("Total Score :::: {} ",result);
        }

        Integer result1=scorecards.stream().map(Scorecard::getTeam1Score).reduce(0,(integer, integer2) -> integer+integer2);
        logger.info("Total Score :::: {} ",result1);
    }
}
