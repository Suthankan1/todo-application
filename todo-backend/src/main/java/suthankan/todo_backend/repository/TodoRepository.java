package suthankan.todo_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suthankan.todo_backend.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
