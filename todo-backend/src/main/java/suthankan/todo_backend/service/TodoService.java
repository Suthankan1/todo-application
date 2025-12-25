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

    public Todo createTodo(Todo todo) {
        return repo.save(todo);
    }

    public Todo getTodoById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteTodoById(Long id) {
        repo.deleteById(id);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = repo.findById(id).orElse(null);
        if (todo != null) {
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());

            return repo.save(todo);
        }
        else{
            return null;
        }
    }
}
