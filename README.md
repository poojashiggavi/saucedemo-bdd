# saucedemo-bdd

1. Test Design Document

Framework : Java + selenium + Cucumber + POM
Tools : Maven, Testng, Extent reports
Test types: Positive, negative
resusability : POM, constants

Bug : Checkout proceeds without entering Firstname, lastname, and Postalcode
expected result : An error message should be thrown "Error : Firstname is required"
actual result : user is allowed proceed to checkout step

steps to reproduce
login to saucedemo application
add product to cart 
click on checkout 
fill the date with space or keep it blank
click on continue button 


