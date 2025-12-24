package suthankan.todo_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suthankan.todo_backend.model.Todo;
import suthankan.todo_backend.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repo;


    public List<Todo> getAllTodos() {
        return repo.findAll();
    }
}
