package pl.github.lentek.todo;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository repository;

  public Todo addNew(Todo todo) {
    todo.setDone(false);
    return repository.save(todo);
  }

  public Todo change(Integer id) {
    Todo todo = findOne(id);

    if (todo == null) {
      throw new EntityNotFoundException("Todo Not Found");
    }

    todo.setDone(!todo.getDone());

    return repository.save(todo);
  }

  public List<Todo> findAll() {
    return repository.findAll();
  }

  public Todo findOne(Integer id) {
    return repository.findById(id).orElse(null);
  }
}
