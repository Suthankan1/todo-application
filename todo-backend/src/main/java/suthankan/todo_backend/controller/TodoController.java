package suthankan.todo_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suthankan.todo_backend.model.Todo;
import suthankan.todo_backend.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping("/")
    public String hello(){
        return "This is my application da Pakki";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(service.getAllTodos() , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo){
        Todo newTodo = service.createTodo(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Todo todo = service.getTodoById(id);

        if(todo != null)
            return new ResponseEntity<>(todo, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        Todo todo = service.getTodoById(id);

        if(todo != null){
            service.deleteTodoById(id);
            return new ResponseEntity<>("Todo deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Invalid Operation", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        Todo updatedTodo = service.updateTodo(id, todo);

        if(updatedTodo != null){
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
