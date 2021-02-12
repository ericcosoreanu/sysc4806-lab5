import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressBook", path = "addressBook")
public interface AddressBookRepository extends Repository {
}
