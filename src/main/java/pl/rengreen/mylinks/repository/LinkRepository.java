package pl.rengreen.mylinks.repository;

import org.springframework.data.repository.CrudRepository;
import pl.rengreen.mylinks.model.Link;

public interface LinkRepository extends CrudRepository <Link, Long> {

}
