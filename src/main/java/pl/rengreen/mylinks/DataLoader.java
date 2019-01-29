package pl.rengreen.mylinks;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.rengreen.mylinks.model.Link;
import pl.rengreen.mylinks.repository.LinkRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private LinkRepository linkRepository;

    public DataLoader(LinkRepository linkRepository) throws FileNotFoundException, IOException, ParseException {
        this.linkRepository = linkRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        String fileName = "src/main/resources/json/start-data.json";
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(fileName));

        for (int i = 0; i < jsonArray.size(); ++i) {
            Object object = jsonArray.get(i);
            JSONObject jsonObject = (JSONObject) object;

            String name = (String) jsonObject.get("name");
            String linkUrl = (String) jsonObject.get("linkUrl");
            String imageUrl = (String) jsonObject.get("imageUrl");
            String category = (String) jsonObject.get("category");

            linkRepository.save(new Link(name, linkUrl, imageUrl, category));
        }

        /*
        linkRepository.save(new Link("Spring Initializr", "https://start.spring.io/", "spring img", "Java"));
        linkRepository.save(new Link("Google Java Style Guide", "https://google.github.io/styleguide/javaguide.html", "guide img", "Java"));
        linkRepository.save(new Link("Virus Total", "https://www.virustotal.com/#/home/upload", "virus img", "Security"));
        linkRepository.save(new Link("empty", "empty", "empty", "empty"));
        */

        logger.info("Initial data inserted to DATABASE.");
    }
}
