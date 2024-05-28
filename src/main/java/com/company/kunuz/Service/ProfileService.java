package com.company.kunuz.Service;

import com.company.kunuz.DTO.Profile.ProfileCreateDTO;
import com.company.kunuz.DTO.Profile.ProfileDTO;
import com.company.kunuz.Entity.ProfileEntity;
import com.company.kunuz.Exception.AppBadException;
import com.company.kunuz.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDTO create(ProfileCreateDTO dto) {
        ProfileEntity entity = new ProfileEntity();


        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());
//        entity.setPhotoId(dto.getPhoto_id());

        profileRepository.save(entity);
        return toDTO(entity);
    }

    public ProfileDTO update(Integer id, ProfileCreateDTO dto) {



        ProfileEntity entity = new ProfileEntity();

        entity=get(id);

        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());



        profileRepository.save(entity);

        return toDTO(entity);
    }

    public Boolean delete(Integer id) {
        profileRepository.deleteById(id);
        return true;
    }

    public ProfileEntity get(Integer id) {
        return profileRepository.findById(id).orElseThrow(() -> {
            throw new AppBadException("Profile not found");
        });
    }


    public List<ProfileDTO> getAll() {
        Iterable<ProfileEntity> regions = profileRepository.findAll();
        List<ProfileDTO> list = new ArrayList<>();
        for (ProfileEntity region : regions) {
            list.add(toDTO(region));
        }
        return list;
    }


    public ProfileDTO toDTO(ProfileEntity entity) {
        ProfileDTO dto = new ProfileDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setVisible(entity.getVisible());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        dto.setCreated_date(entity.getCreatedDate());
        dto.setPhoto_id(entity.getPhotoId());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
