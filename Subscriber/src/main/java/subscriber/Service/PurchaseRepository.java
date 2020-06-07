package subscriber.Service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import subscriber.model.PurchaseEntity;


@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Long> {
}
