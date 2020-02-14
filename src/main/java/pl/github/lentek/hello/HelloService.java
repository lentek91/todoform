package pl.github.lentek.hello;

import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.github.lentek.lang.Lang;
import pl.github.lentek.lang.LangRepository;

@Service
public class HelloService {

  public static final String FALLBACK_NAME = "World";
  public static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");

  private final LangRepository langRepository;

  public HelloService(LangRepository langRepository) {
    this.langRepository = langRepository;
  }

  public String prepareGreeting(String name, Integer langId) {
    langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());
    Lang lang = langRepository.findById(langId).orElse(FALLBACK_LANG);
    return lang.getWelcomeMessage() + " " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";
  }
}
