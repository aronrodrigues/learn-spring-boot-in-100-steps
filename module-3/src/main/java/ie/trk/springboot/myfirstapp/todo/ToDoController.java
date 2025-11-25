package ie.trk.springboot.myfirstapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    @Value("${spring.mvc.format.date}")
    private String dateFormat;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String showListToDoPage(ModelMap model) {
        List<ToDo> todos = toDoService.findByUsername("aron");
        model.put("todos", todos);
        /*
        model.put(
            "todos", 
            todos.stream().map(
                t -> Map.of(
                    "id", t.getId(), 
                    "description", t.getDescription()
                )
            ).collect(Collectors.toList()));
         */
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
        String username = model.get("name").toString();
        toDoService.createToDo(username, toDo.getDescription());
        return "redirect:/todos/";
    }

    @GetMapping("/{id}/delete/")
    public String deleteToDo(@PathVariable long id) {
        toDoService.deleteToDo(id);
        return "redirect:/todos/";
    }

    @GetMapping("{id}/update/")
    public String showUpdateToDoPage(@PathVariable long id, ModelMap model) {
        ToDo toDo = toDoService.findById(id);
        if (toDo == null) {
            return "redirect:/todos/";
        }
        model.put("toDo", toDo);
        model.put("dateFormat", dateFormat);
        System.out.println(toDo);
        return "addTodo";
    }

    @PostMapping("{id}/update/")
    public String updateToDo(@PathVariable long id, ModelMap model, @Valid ToDo toDo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        ToDo dbToDo = toDoService.findById(id);
        dbToDo.setDescription(toDo.getDescription());
        dbToDo.setTargetDate(toDo.getTargetDate());
        return "redirect:/todos/";
    }
}
