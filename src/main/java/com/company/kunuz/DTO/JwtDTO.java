package com.company.kunuz.DTO;

import com.company.kunuz.Enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtDTO {
    private Integer id;
    private String username;
    private ProfileRole role;

    public JwtDTO(Integer id, String username, ProfileRole role) {
        this.id = id;

        this.role = role;
    }

    public JwtDTO(Integer id) {
        this.id = id;
    }
}
