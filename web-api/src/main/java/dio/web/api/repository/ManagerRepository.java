package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Manager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagerRepository {
    public void save(Manager manager){
        if(manager.getLogin() == null) throw new CampoObrigatorioException("Login");
        if(manager.getPassword() == null) throw new CampoObrigatorioException("Password");

        if(manager.getId()==null)
            System.out.println("SAVE - Recebendo o manager na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o manager na camada de repositório");

        System.out.println(manager);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um manager", id));
        System.out.println(id);
    }

    public List<Manager> findAll(){
        System.out.println("LIST - Listando os managers do sistema");
        List<Manager> managers = new ArrayList<>();
        managers.add(new Manager("Brunnao","brunnao123"));
        managers.add(new Manager("Palomao","Palomao123"));
        return managers;
    }
    public Manager findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new Manager("Brunnao","brunnao123");
    }
    public Manager findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));
        return new Manager("Brunnao","brunnao123");
    }
}