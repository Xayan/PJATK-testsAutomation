package pl.xayan.tau.tau1.repository;

import junit.framework.TestCase;
import pl.xayan.tau.tau1.entity.Feed;

import java.util.List;

public class FeedRepositoryTest extends TestCase {

    private FeedRepository feedRepository;

    public void setUp() throws Exception {
        super.setUp();

        feedRepository = new FeedRepository();
    }

    public void testInsert()
    {
        assertEquals(0, feedRepository.getCount());

        Feed feed = new Feed();
        feed.setTitle("test");

        feedRepository.insert(feed);

        assertEquals(1, feed.getId());
        assertEquals(1, feedRepository.getCount());
        assertEquals(feed, feedRepository.getById(1));
    }

    public void testGetAll()
    {
        Feed[] feeds = new Feed[100];

        for(int i = 0; i < 100; i++) {
            Feed feed = new Feed();

            feedRepository.insert(feed);
            feeds[i] = feed;
        }

        assertEquals(feedRepository.getCount(), 100);

        List<Feed> feedList = feedRepository.getAll();

        for(int i = 0; i < feeds.length; i++) {
            assertTrue(feedList.contains(feeds[i]));
        }
    }

    public void testGetById()
    {
        Feed[] feeds = new Feed[100];

        for(int i = 0; i < 100; i++) {
            Feed feed = new Feed();

            feedRepository.insert(feed);
            feeds[i] = feed;
        }

        assertEquals(feeds[10], feedRepository.getById(feeds[10].getId()));
    }

    public void testUpdate()
    {
        assertEquals(0, feedRepository.getCount());

        Feed feed = new Feed();
        feed.setTitle("test");

        feedRepository.insert(feed);

        Feed newFeed = new Feed();
        feed.setTitle("another test");

        assertEquals(1, feed.getId());

        feedRepository.update(feed.getId(), newFeed);

        assertEquals(1, feedRepository.getCount());
        assertEquals(newFeed, feedRepository.getById(1));
    }

    public void testDelete()
    {
        Feed feed = new Feed();

        feedRepository.insert(feed);

        assertEquals(1, feedRepository.getCount());

        feedRepository.delete(feed);

        assertEquals(0, feedRepository.getCount());
    }
}