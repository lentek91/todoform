package pl.github.lentek.lang;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LangController {

  private final LangService langService;

  @GetMapping("/langs")
  public ResponseEntity<List<Lang>> getAll() {
    return ResponseEntity.ok(langService.findAll());
  }
}
