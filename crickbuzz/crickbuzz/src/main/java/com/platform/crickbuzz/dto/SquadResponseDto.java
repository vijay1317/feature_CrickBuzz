package com.platform.crickbuzz.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SquadResponseDto {
    private int player_id;
    private String description;
}
