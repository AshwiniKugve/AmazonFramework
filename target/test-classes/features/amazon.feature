Feature: Amazon search

Scenario: search product
Given user opens amazon website
When user searches for "iphone"
Then search results should be displayed