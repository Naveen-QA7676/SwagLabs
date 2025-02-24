Feature: Login feature of SwagsLab

@Loginfeature
Scenario: Login functionality of SwagsLab website
Given open the url 
When Enter the username and password "<username>" "<password>" 
Then Click on the login button
Then verify the msg "<msg>"

Examples:
|username|password|msg|
|standard_user|secret_sauce|Swag Labs|
|locked_out_user|secret_sauce|Swag Labs|
|problem_user|secret_sauce|Swag Labs|
|performance_glitch_user|secret_sauce|Swag Labs|
|error_user|secret_sauce|Swag Labs|
|visual_user|secret_sauce|Swag Labs|
|visual_user|secret_sace|Epic sadface: Username and password do not match any user in this service|
|visual_wser|secret_sauce|Epic sadface: Username and password do not match any user in this service|



@AddtoCart
Scenario: Login functionality of SwagsLab website
Given open the url 
When Enter the username and password "<username>" "<password>" 
Then Click on the login button
Then verify the msg "<msg>"
Then click on two items add to cart
Then check counts in viewcart option "<count>"

Examples:
|username|password|msg|count|
|standard_user|secret_sauce|Swag Labs|2|

@orderTwoitems
Scenario: Login functionality of SwagsLab website
Given open the url 
When Enter the username and password "<username>" "<password>" 
Then Click on the login button
Then verify the msg "<msg>"
Then click on two items add to cart
Then check counts in viewcart option "<count>"
Then click on checkout option
Then enter the details "<firstname>" "<lastname>" "<postalcode>" 
Then click on continue button
Then verify the total amount
Then click on the finish button

Examples:
|username|password|msg|count|firstname|lastname|postalcode|
|standard_user|secret_sauce|Swag Labs|2|Naveen|Bogum|560040|


@Filterfuncationality 
Scenario: Filter functionality of SwagsLab website
Given open the url 
When Enter the username and password "<username>" "<password>" 
Then Click on the login button
Then verify the msg "<msg>"
Then get all the results 
Then get all the dropdowns from the dropdown
Then select the dropdown "<dropdown>" 
Then varify according to dropdown selected

Examples:
|username|password|msg|dropdown|
|standard_user|secret_sauce|Swag Labs|Name (Z to A)|












