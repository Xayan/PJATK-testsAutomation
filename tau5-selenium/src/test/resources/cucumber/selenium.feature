Feature: Website

    Scenario: Invalid sign in
        Given I am on the website
        And email is dsfdsgdsfds@fdsfds.com
        And password is invalid_password
        When I sign in
        Then there is an error

    Scenario: Sign in
        Given I am on the website
        And email is dsfdsgdsfds@fdsfds.com
        And password is password
        When I sign in
        Then I am logged in

    Scenario: Invalid register
        Given I am on the website
        When I sign up without data
        Then there is an error

    Scenario Outline: Register
        Given browser resolution is <width> x <height>
            And I am on the website
        When I sign up
        Then I am logged in

        Examples:
            | width | height |
            | 1280  | 720    |
            | 800   | 600    |
            | 400   | 800    |