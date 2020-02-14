package pl.github.lentek.todo;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.servlet.annotation.WebServlet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@WebServlet(name = "Todo", urlPatterns = "/api/todos/*")
public class TodoCotroller {

  private final TodoService todoService;

  @PostMapping("/todos")
  public @ResponseBody
  ResponseEntity<Todo> addNew(@RequestBody Todo todo) {
    return ResponseEntity.ok(todoService.addNew(todo));
  }

  @PutMapping("/todos/{id}")
  public @ResponseBody
  ResponseEntity<Todo> change(@PathVariable("id") Integer id) {
    try {
      return ResponseEntity.ok(todoService.change(id));
    } catch (EntityNotFoundException ex) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/todos")
  public ResponseEntity<List<Todo>> getAll() {
    return ResponseEntity.ok(todoService.findAll());
  }

  @GetMapping("/todos/{id}")
  public ResponseEntity<Todo> getOne(@PathVariable("id") Integer id) {
    Todo todo = todoService.findOne(id);
    if (todo != null) {
      return ResponseEntity.ok(todoService.findOne(id));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
