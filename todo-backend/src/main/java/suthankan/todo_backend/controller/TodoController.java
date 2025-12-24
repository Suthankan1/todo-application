package suthankan.todo_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suthankan.todo_backend.model.Todo;
import suthankan.todo_backend.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoService service;

    public ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(service.getAllTodos() , HttpStatus.OK);
    }
}
