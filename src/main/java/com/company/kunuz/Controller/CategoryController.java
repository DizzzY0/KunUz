package com.company.kunuz.Controller;


import com.company.kunuz.DTO.Category.CategoryCreateDTO;
import com.company.kunuz.DTO.Category.CategoryDTO;
import com.company.kunuz.Enums.Language;
import com.company.kunuz.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/adm/create")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryCreateDTO categoryCreateDTO) {
        CategoryDTO response = categoryService.create(categoryCreateDTO);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/adm/all")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<CategoryDTO> response = categoryService.getAll();
        return ResponseEntity.ok().body(response);
    }



    @GetMapping("/lang")
    public ResponseEntity<List<CategoryDTO>> getAllByLang(
            @RequestHeader(value = "Accept-Language", defaultValue = "uz") Language lang) {
        List<CategoryDTO> regionDTOList = categoryService.getAllByLang2(lang);
        return ResponseEntity.ok().body(regionDTOList);
    }



    @PutMapping("/adm/update/{id}")
    public ResponseEntity<Boolean> updateRegion(@PathVariable("id") Integer id,
                                                @Valid @RequestBody CategoryCreateDTO dto) {
        Boolean result = categoryService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/adm/delete/{id}")
    public ResponseEntity<Boolean> deleteRegion(@PathVariable("id") Integer id) {
        Boolean result = categoryService.delete(id);
        return ResponseEntity.ok().body(result);
    }
}
