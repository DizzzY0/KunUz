package com.company.kunuz.Controller;

import com.company.kunuz.DTO.Region.RegionCreateDTO;
import com.company.kunuz.DTO.Region.RegionDTO;
import com.company.kunuz.Enums.Language;
import com.company.kunuz.Service.RegionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    RegionService regionService;

    @PostMapping("/create")
    public ResponseEntity<RegionDTO> create(@Valid @RequestBody RegionCreateDTO regionCreateDTO) {
        RegionDTO response = regionService.create(regionCreateDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegionDTO>> getAll() {
        List<RegionDTO> response = regionService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/lang")
    public ResponseEntity<List<RegionDTO>> getAllByLang(
            @RequestHeader(value = "Accept-Language", defaultValue = "uz") Language lang) {
        List<RegionDTO> regionDTOList = regionService.getAllByLang2(lang);
        return ResponseEntity.ok().body(regionDTOList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateRegion(@PathVariable("id") Integer id,
                                                @Valid @RequestBody RegionCreateDTO dto) {
        Boolean result = regionService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteRegion(@PathVariable("id") Integer id) {
        Boolean result = regionService.delete(id);
        return ResponseEntity.ok().body(result);
    }


}
