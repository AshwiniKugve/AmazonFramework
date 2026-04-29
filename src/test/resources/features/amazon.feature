Feature: Amazon search

Scenario Outline: search product

Given user opens amazon website
When user searches for "<product>"
Then search results should be displayed

Examples:

| product |
| iphone |
| samsung |





