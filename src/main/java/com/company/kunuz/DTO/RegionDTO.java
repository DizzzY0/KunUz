package com.company.kunuz.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter

public class RegionDTO {
    private Integer id;
    private String name_uz;
    private String name_ru;
    private String name_en;
    private boolean visible;
    private LocalDateTime createdDate;
}