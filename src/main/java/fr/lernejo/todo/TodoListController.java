package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {
    private final List<Todo> list = new ArrayList<>();

    @PostMapping
    public void addTodo(@RequestBody Todo elt) {
        list.add(elt);
    }

    @GetMapping
    public Collection<Todo> getList() {
        return list;
    }
}
