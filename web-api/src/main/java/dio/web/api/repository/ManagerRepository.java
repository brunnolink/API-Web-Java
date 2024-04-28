package dio.web.api.repository;


import dio.web.api.model.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @Query("SELECT e FROM Manager e JOIN FETCH e.roles WHERE e.login= (:login)")
    public Manager findByUsername(@Param("login") String login);
}