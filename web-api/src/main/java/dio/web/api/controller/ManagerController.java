package dio.web.api.controller;

import dio.web.api.model.Manager;
import dio.web.api.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/managers/users")
@RestController
public class ManagerController {
    @Autowired
    private ManagerRepository repository;
    @GetMapping()
    public List<Manager> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{manager}")

    public Manager getOne(@PathVariable("manager") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")

    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PostMapping()

    public void postUser(@RequestBody Manager manager){
        repository.save(manager);
    }

    @PutMapping()

    public void putUser(@RequestBody Manager manager){
        repository.save(manager);
    }
}
