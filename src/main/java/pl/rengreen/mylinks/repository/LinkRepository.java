package pl.rengreen.mylinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rengreen.mylinks.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
