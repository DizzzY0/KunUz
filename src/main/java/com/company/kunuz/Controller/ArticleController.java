package com.company.kunuz.Controller;


import com.company.kunuz.DTO.Article.ArticleCreateDTO;
import com.company.kunuz.DTO.Article.ArticleDTO;
import com.company.kunuz.Enums.ProfileRole;
import com.company.kunuz.Repository.ArticleRepository;
import com.company.kunuz.Repository.ArticleTypeRepository;
import com.company.kunuz.Service.ArticleService;
import com.company.kunuz.Util.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


//    @PostMapping("/create")
//    public ResponseEntity<ArticleDTO> createArticle(@Valid ArticleCreateDTO article,
//                                                    @RequestHeader("Authorization") String token) {
//        SecurityUtil.getJwtDTO(token, ProfileRole.ROLE_PUBLISH);
//        ArticleDTO response = articleService.create(article);
//        return ResponseEntity.ok().body(response);
//    }
}
