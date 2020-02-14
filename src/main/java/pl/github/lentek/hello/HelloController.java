package pl.github.lentek.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final HelloService helloService;

  @GetMapping("/api")
  public ResponseEntity<String> prepareGreeting(@RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "lang", required = false) Integer lang) {
    return ResponseEntity.ok(helloService.prepareGreeting(name, lang));
  }
}
