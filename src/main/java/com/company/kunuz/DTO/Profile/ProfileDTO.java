package com.company.kunuz.DTO.Profile;

import com.company.kunuz.Enums.ProfileRole;
import com.company.kunuz.Enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private ProfileStatus status;
    private ProfileRole role;
    private Integer photo_id;
    private Boolean visible;
    private LocalDateTime created_date;
    private String jwt;
}
