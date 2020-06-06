package subscriber.Service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import subscriber.model.ActionTable;


@Repository
public interface ReceiveActionMes extends CrudRepository<ActionTable, Integer> {
}
