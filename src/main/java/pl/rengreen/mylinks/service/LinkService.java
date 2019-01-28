package pl.rengreen.mylinks.service;

import pl.rengreen.mylinks.model.Link;

import java.util.List;

public interface LinkService {
    public abstract List<Link> getAllLinks();
    public abstract Link getLinkById(long id);
    public abstract void saveLink(Link link);
    public abstract void updateLink(Link link);
    public abstract void deleteLink(long id);
}



