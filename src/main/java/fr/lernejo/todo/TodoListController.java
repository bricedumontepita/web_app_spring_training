package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        /*ArrayList<Todo> todos = new ArrayList<>();
        Iterable<TodoEntity> todosRepository = this.todoRepository.findAll();
        for (TodoEntity elt: todosRepository) {
            Todo tmp = new Todo(elt.author, elt.message);
            todos.add(tmp);
        }
        return todos;*/
        return this.todoRepository.findAll();
    }
}

/*


private TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public void addTodo(@RequestBody Todo elt) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.message = elt.message();
        todoEntity.author = elt.author();
        this.todoRepository.save(todoEntity);
    }

    @GetMapping
    public Collection<Todo> getList() {
        ArrayList<Todo> todos = new ArrayList<>();
        Iterable<TodoEntity> todosRepository = this.todoRepository.findAll();
        for (TodoEntity elt: todosRepository) {
            Todo tmp = new Todo(elt.author, elt.message);
            todos.add(tmp);
        }
        return todos;
    }
 */
