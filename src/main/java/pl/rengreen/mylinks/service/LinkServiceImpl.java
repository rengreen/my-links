package pl.rengreen.mylinks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rengreen.mylinks.model.Link;
import pl.rengreen.mylinks.repository.LinkRepository;

import java.util.List;

@Service
public class LinkServiceImpl {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    public Link getLinkById(Long id) {
        return linkRepository.getOne(id);
    }

    public void addLink(Link link){
        linkRepository.save(link);
    }

    public void updateLink(Long id,Link link){
        linkRepository.save(link);
    }

    public void deleteLink(Long id) {
        linkRepository.deleteById(id);
    }
}
