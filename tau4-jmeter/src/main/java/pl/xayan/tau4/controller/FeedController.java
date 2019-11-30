package pl.xayan.tau4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.xayan.tau4.domain.Feed;
import pl.xayan.tau4.repository.FeedRepository;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedController {
    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("")
    public List<Feed> index() {
        return feedRepository.findAll();
    }

    @GetMapping("/{id}")
    public Feed getById(@PathVariable Integer id) {
        return feedRepository.findById(id).orElseThrow();
    }

    @PostMapping("")
    public Feed create(@Valid @RequestBody Feed feed) {
        return feedRepository.save(feed);
    }

    @PutMapping("/{id}")
    public Feed update(@PathVariable Integer id, @Valid @RequestBody Feed feed) {
        feedRepository.findById(id).orElseThrow();

        feed.setId(id);
        feedRepository.save(feed);

        return feed;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        feedRepository.delete(feedRepository.findById(id).orElseThrow());

        return true;
    }
}
