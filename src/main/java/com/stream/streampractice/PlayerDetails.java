package com.stream.streampractice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDetails {
    private String manOfTheMatch;
    private String stadium;
    private String place;
    private String team1;
    private String team2;
}
