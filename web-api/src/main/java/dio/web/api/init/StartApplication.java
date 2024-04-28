package dio.web.api.init;

import dio.web.api.model.Manager;
import dio.web.api.model.User;
import dio.web.api.repository.ManagerRepository;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ManagerRepository managerRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Manager manager = managerRepository.findByUsername("admin");
        if(manager==null){
            manager = new Manager();
            manager.setLogin("ADMIN");
            manager.setPassword("master123");
            manager.getRoles().add("MANAGERS");
            managerRepository.save(manager);
        }
        User user = repository.findByUsername("user");
        if(user ==null){
            user = new User();
            user.setLogin("USER");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}
