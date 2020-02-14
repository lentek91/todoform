package pl.github.lentek.lang;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LangService {

  private final LangRepository repository;

  public List<Lang> findAll() {
    return repository.findAll();
  }
}
