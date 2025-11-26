package ie.trk.springboot.myfirstapp.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class ToDoControllerJPA {

    private final ToDoService toDoService;
    private final ToDoRepository toDoRepository;

    @Value("${spring.mvc.format.date}")
    private String dateFormat;

    public ToDoControllerJPA(ToDoService toDoService, ToDoRepository toDoRepository) {
        super();
        this.toDoService = toDoService;
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/")
    public String showListToDoPage(ModelMap model) {

        List<ToDo> todos = toDoRepository.findByUsername(getUsername());
        model.put("todos", todos);
        return "listTodos";
    }

    @GetMapping("/new/add/")
    public String showAddToDoPage(ModelMap model) {
        ToDo toDo = new ToDo(0, null, null, null, false);
        model.put("toDo", toDo);
        model.put("dateFormat", dateFormat);
        return "addTodo";
    }

    @PostMapping("/new/add/")
    public String saveToDo(ModelMap model, @Valid ToDo toDo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        toDo.setUsername(getUsername());
        toDoRepository.save(toDo);
        return "redirect:/todos/";
    }

    @GetMapping("/{id}/delete/")
    public String deleteToDo(@PathVariable int id) {
        toDoRepository.deleteById(id);
        return "redirect:/todos/";
    }

    @GetMapping("{id}/update/")
    public String showUpdateToDoPage(@PathVariable int id, ModelMap model) {
        Optional<ToDo> optionalDbToDo = toDoRepository.findById(id);
        if (optionalDbToDo.isEmpty()) {
            return "redirect:/todos/";
        }
        model.put("toDo", optionalDbToDo.get());
        model.put("dateFormat", dateFormat);
        return "addTodo";
    }

    @PostMapping("{id}/update/")
    public String updateToDo(@PathVariable int id, ModelMap model, @Valid ToDo toDo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        System.out.println(String.format("Id: %d", id));

        Optional<ToDo> optionalDbToDo = toDoRepository.findById(id);
        System.out.println(optionalDbToDo);
        if (optionalDbToDo.isPresent()) {
            ToDo dbToDo = optionalDbToDo.get();
            dbToDo.setDescription(toDo.getDescription());
            dbToDo.setTargetDate(toDo.getTargetDate());
            toDoRepository.save(dbToDo);
        }
        return "redirect:/todos/";
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
