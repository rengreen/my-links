package pl.rengreen.mylinks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rengreen.mylinks.model.Link;
import pl.rengreen.mylinks.service.LinkServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private LinkServiceImpl linkService;

    @GetMapping("/")
    public List<Link> getAllLinks() {
        return linkService.getAllLinks();
    }

    @GetMapping("/{id}")
    public Link getLinkById(@PathVariable Long id) {
        return linkService.getLinkById(id);
    }

    @PostMapping("/")
    public void addLink(@RequestBody Link link) {
        linkService.addLink(link);
    }

    @PutMapping("/{id}")
    public void updateLink(@PathVariable Long id, @RequestBody Link link) {
        linkService.updateLink(id, link);
    }

    @DeleteMapping("/{id}")
    public void deleteLink(@PathVariable Long id) {
        linkService.deleteLink(id);
    }
}
