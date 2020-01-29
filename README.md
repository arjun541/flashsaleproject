Flash Sales
This is a demo implementation for a possible flash sales in any ecommerce website

setup:
we are using the inmemory database h2 and all the customer and product and sale information are pre loaded.

you can change the server port and all other details in applocation.properties
This application contains two public facing APIs for registartion to a sale and purchase of a product in sale.


Idea
As per the problem statement, we have implemented a FlashSale framework with Consistency over Availability. The system is database-driven till flashsale actually starts. During the sale, read and write is driven by Redis cache. We have used pessimistic locking with timeout to correctly determine the available SKU from inventory and thereby changing the values. During sale, Database persistence is done only after the confirmation of purchase.

The flow

registartion includes checking whether a customer is valid and the choosed flashsale is open for registartions.
A flashsale holds only 1 product
Buyer can only register if the flashsale is not running or open for registartion
flashsale is started/stopped manually
Purchase limit per buyer per flashsale is 1
Payment is abstracted out and considered successful before purchase() API is invoked.
