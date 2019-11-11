package pl.xayan.steps;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import pl.xayan.tau3.entity.Feed;
import pl.xayan.tau3.repository.FeedRepository;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MySteps {
    private FeedRepository feedRepository;

    private Exception exception;

    private List<Feed> resultSet;

    @BeforeStory
    public void beforeStory() {
        exception = null;
        resultSet = null;
    }

    @Given("repository is filled with data: $dataTable")
    public void repository_is_filled_with_data(ExamplesTable dataTable) {
        exception = null;
        feedRepository = new FeedRepository();

        for (Map<String, String> row : dataTable.getRows()) {
            Feed feed = new Feed();
            feed.setTitle(row.get("Title"));
            feed.setFeedUrl(row.get("Feed URL"));

            feedRepository.insert(feed);
        }
    }

    @When("I delete a record with ID $id")
    public void i_delete_a_record_with_ID(Integer id) {
        try {
            System.out.println(feedRepository.findById(id));
            feedRepository.delete(feedRepository.findById(id));
        } catch(Exception e) {
            this.exception = e;
        }
    }

    @Then("record with ID $id is deleted")
    public void record_with_ID_is_deleted(Integer id) {
        assertNull(feedRepository.findById(id));
    }

    @Then("repository contains $number elements")
    public void repository_contains_elements(Integer number) {
        assertEquals(number.intValue(), feedRepository.getCount());
    }

    @Then("exception $exceptionName is thrown")
    public void exception_is_thrown(String exceptionName) {
        assertNotNull(this.exception);
        assertEquals(exceptionName, this.exception.getClass().getSimpleName());
    }

    @Then("no exception was thrown")
    public void no_exception_was_thrown() {
        assertNull(this.exception);
    }

    @When("I search repository by regex $regex")
    public void i_search_repository_by_regex(String regex) {
        this.resultSet = feedRepository.findByTitleRegex(regex);
    }

    @Then("result count is $count")
    public void result_count_is(Integer count) {
        assertEquals(count.intValue(), this.resultSet.size());
    }
}
