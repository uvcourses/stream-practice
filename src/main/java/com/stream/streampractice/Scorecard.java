package com.stream.streampractice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Scorecard {
        private String fullScorecard;
        private String team1;
        private String team2;
        private int team1Score;
        private int team2Score;
        private String tossWinner;
        private String tossChoice;
        private String winner;
        private String margin;
        private String manOfTheMatch;
        private String stadium;
        private String place;
}
