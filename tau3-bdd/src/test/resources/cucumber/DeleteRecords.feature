Feature: Delete records
    Scenario: Delete an existing record
        Given repository is filled with data
            | Title                    | Feed URL                                     |
            | xkcd.com                 | https://xkcd.com/rss.xml                     |
            | The Independent - World  | https://www.independent.co.uk/news/world/rss |
            | The Independent - Travel | https://www.independent.co.uk/travel/rss     |
        When I delete a record with ID 1
        Then record with ID 1 is deleted
            And repository contains 2 elements
            And no exception was thrown

    Scenario: Delete a nonexistent record
        Given repository is filled with data
            | Title                    | Feed URL                                     |
            | xkcd.com                 | https://xkcd.com/rss.xml                     |
            | The Independent - World  | https://www.independent.co.uk/news/world/rss |
            | The Independent - Travel | https://www.independent.co.uk/travel/rss     |
        When I delete a record with ID 10
        Then exception "EntityNotFoundException" is thrown
            And repository contains 3 elements

    Scenario: All records are deleted
        Given repository is filled with data
            | Title                    | Feed URL                                     |
            | xkcd.com                 | https://xkcd.com/rss.xml                     |
            | The Independent - World  | https://www.independent.co.uk/news/world/rss |
        When I delete a record with ID 1
            And  I delete a record with ID 2
        Then repository contains 0 elements
            And no exception was thrown