package pl.xayan.tau3.repository;


import pl.xayan.tau3.DI.AbstractRepository;
import pl.xayan.tau3.entity.Feed;

import java.util.List;
import java.util.stream.Collectors;

public class FeedRepository extends AbstractRepository<Feed> {
    public List<Feed> findByTitleRegex(String regex) {
        return this.entityList
                .stream()
                .filter((feed) -> feed.getTitle().matches(regex))
                .collect(Collectors.toList());
    }
}
