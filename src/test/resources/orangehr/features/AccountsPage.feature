Feature: Account Page Feature

Background:
Given user has already logged into application
|username|password|
|chandangupta1109@gmail.com|Entert@123|

@accounts
Scenario: Accounts page title
Given user is on Account page
When user gets the title of the page
Then page title should be "My account - My Store"

@accounts
Scenario: Account section count
Given user is on Account page
Then user gets accounts section
|Order history and details|
|My credit slips|
|My addresses|
|My personal information|
|My wishlists|
And accounts section count should be 5

