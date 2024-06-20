package com.company.kunuz.Controller;


import com.company.kunuz.DTO.Article.ArticleCreateDTO;
import com.company.kunuz.DTO.Article.ArticleDTO;
import com.company.kunuz.Enums.ArticleStatus;
import com.company.kunuz.Service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/moderator")
    public ResponseEntity<ArticleDTO> create(@Valid @RequestBody ArticleCreateDTO article) {
        return ResponseEntity.ok(articleService.create(article));
    }////CREATE


    @PreAuthorize("hasAnyRole('MODERATOR','PUBLISHER')")
    @PutMapping("/moderator/{id}")
    public ResponseEntity<ArticleDTO> update(@Valid @RequestBody ArticleCreateDTO createDto,
                                             @PathVariable("id") String id) {
        return ResponseEntity.ok(articleService.update(id, createDto));
    }


    @PreAuthorize("hasRole('MODERATOR')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        Boolean result = articleService.delete(id);
        return ResponseEntity.ok().body(result);
    }


    @PostMapping("/last/eight")
    public ResponseEntity<List<ArticleDTO>> last8Article(@RequestBody List<String> idList) {
        return ResponseEntity.ok(articleService.getLast8Article(idList));
    }


//    @PreAuthorize("hasRole('PUBLISHER')")
//    @PutMapping("/change_status/{id}")
//    public ResponseEntity<Boolean> changeStatus(@PathVariable("id") Integer id,
//                                                @RequestBody ArticleStatus status) {
//        Boolean result = articleService.changeStatus(id, status);
//        return ResponseEntity.ok().body(result);
//    }

}
