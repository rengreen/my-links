package pl.rengreen.mylinks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.rengreen.mylinks.model.Link;
import pl.rengreen.mylinks.repository.LinkRepository;

@Service
public class DataLoader implements CommandLineRunner {

    private LinkRepository linkRepository;

    public DataLoader(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        linkRepository.save(new Link("Spring Initializr","https://start.spring.io/","spring img","Java"));
    }
}
