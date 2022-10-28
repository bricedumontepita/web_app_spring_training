package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {
    private TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public void addTodo(@RequestBody TodoEntity elt) {
        this.todoRepository.save(elt);
    }

    @GetMapping
    public Iterable<TodoEntity> getList() {
        return this.todoRepository.findAll();
    }
}
