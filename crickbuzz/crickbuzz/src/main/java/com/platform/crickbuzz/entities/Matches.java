package com.platform.crickbuzz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String team_1;
    private String team_2;

    private String date;
    private String venue;


}

// "team_1": "India",
//         9 "team_2": "Australia",
//         10 "date": "2023-07-12",
//         11 "venue": "Sydney Cricket Ground"