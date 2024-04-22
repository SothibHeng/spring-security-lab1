package istad.co.basicspringsecurity.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleRestController {
@GetMapping
    public String getAllArticles() {
    return "Successfully get all articles";
  }

  @GetMapping("/read/{id}")
    public String readSingleArticle(@PathVariable int id) {
        return "Reading on article!" + id;
  }

  @PostMapping("/write")
    public String writeArticle() {
    return "Successfully writing an article!";
  }

  @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
    return "Successfully delete article with id = " + id;
  }
}
