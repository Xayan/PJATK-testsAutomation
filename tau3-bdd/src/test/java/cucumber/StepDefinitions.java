package cucumber;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pl.xayan.tau.tau3.entity.Feed;
import pl.xayan.tau.tau3.repository.FeedRepository;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StepDefinitions {
    private FeedRepository feedRepository;

    private Exception exception;

    private List<Feed> resultSet;

    @Given("repository is filled with data")
    public void repository_is_filled_with_data(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        feedRepository = new FeedRepository();

        for (Map<String, String> row : list) {
            Feed feed = new Feed();
            feed.setTitle(row.get("Title"));
            feed.setFeedUrl(row.get("Feed URL"));

            feedRepository.insert(feed);
        }
    }

    @When("I delete a record with ID {int}")
    public void i_delete_a_record_with_ID(Integer id) {
        try {
            feedRepository.delete(feedRepository.findById(id));
        } catch(Exception e) {
            this.exception = e;
        }
    }

    @Then("record with ID {int} is deleted")
    public void record_with_ID_is_deleted(Integer id) {
        assertNull(feedRepository.findById(id));
    }

    @Then("repository contains {int} elements")
    public void repository_contains_elements(Integer number) {
        assertEquals(number.intValue(), feedRepository.getCount());
    }

    @Then("exception {string} is thrown")
    public void exception_is_thrown(String exceptionName) {
        assertNotNull(this.exception);
        assertEquals(exceptionName, this.exception.getClass().getSimpleName());
    }

    @Then("no exception was thrown")
    public void no_exception_was_thrown() {
        assertNull(this.exception);
    }

    @When("I search repository by regex {string}")
    public void i_search_repository_by_regex(String regex) {
        this.resultSet = feedRepository.findByTitleRegex(regex);
    }

    @Then("result count is {int}")
    public void result_count_is(Integer count) {
        assertEquals(count.intValue(), this.resultSet.size());
    }
}