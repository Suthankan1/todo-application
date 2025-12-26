package suthankan.todo_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import suthankan.todo_backend.model.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT p FROM Todo p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword , '%') ) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword , '%') ) ")
    List<Todo> serachTodo(String keyword);


    List<Todo> findByCompleted(boolean completed);
}
