package pl.xayan.tau4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xayan.tau4.domain.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
