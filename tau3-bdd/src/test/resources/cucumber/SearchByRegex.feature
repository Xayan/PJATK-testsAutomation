Feature: Find records by regex
    Scenario Outline: Find some by regex
        Given repository is filled with data
            | Title                    | Feed URL                                     |
            | xkcd.com                 | https://xkcd.com/rss.xml                     |
            | The Independent - World  | https://www.independent.co.uk/news/world/rss |
            | The Independent - Travel | https://www.independent.co.uk/travel/rss     |
        When I search repository by regex <regex>
        Then result count is <count>
        Examples:
            | regex              | count |
            | ".*Independent.*"  |     2 |
            | ".+"               |     3 |
            | "nie ma"           |     0 |
