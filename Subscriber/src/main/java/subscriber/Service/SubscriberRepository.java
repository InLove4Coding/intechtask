package subscriber.Service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import subscriber.model.SubscriptionEntity;


@Repository
public interface SubscriberRepository extends CrudRepository<SubscriptionEntity, Long> {
}
