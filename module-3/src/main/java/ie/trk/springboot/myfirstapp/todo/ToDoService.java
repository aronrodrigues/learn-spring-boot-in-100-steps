package ie.trk.springboot.myfirstapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private static final List<ToDo> todos = new ArrayList<>();
    private static int nextId = 0;


    static {
        todos.add(new ToDo(0, "aron", "Learn Docker", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(1, "aron", "Learn Cassandra", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(2, "aron", "Learn Kubernetes", LocalDate.now().plusYears(3), false));
        nextId = todos.get(todos.size() - 1).getId() + 1;
    }

    public List<ToDo> findByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }
    
    public ToDo findById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public ToDo createToDo(String username, String description) {
        ToDo todo = new ToDo(
            nextId++, 
            username, 
            description, 
            LocalDate.now().plusYears(1), 
            false);
        todos.add(todo);
        return todo;
    }

    public void deleteToDo(long id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
