package pl.rengreen.mylinks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.rengreen.mylinks.model.Link;
import pl.rengreen.mylinks.repository.LinkRepository;

@Service
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private LinkRepository linkRepository;

    public DataLoader(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        linkRepository.save(new Link("Spring Initializr","https://start.spring.io/","spring img","Java"));
        linkRepository.save(new Link("Google Java Style Guide","https://google.github.io/styleguide/javaguide.html","guide img","Java"));
        linkRepository.save(new Link("Virus Total","https://www.virustotal.com/#/home/upload","virus img","Security"));
        linkRepository.save(new Link("empty","empty","empty","empty"));
        logger.info("Inserting initial data into DATABASE.");
    }
}
