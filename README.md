Flash Sales
This is a demo implementation for a possible flash sales in any ecommerce website

setup:
we are using the inmemory database h2 and all the customer and product and sale information are pre loaded.

you can change the server port and all other details in application.properties
This application contains two public facing APIs for registartion to a sale and purchase of a product in sale.

we have two apis register and purchase 

registartion includes checking whether a customer is valid and the choosed flashsale is open for registartions.
A flashsale holds only 1 product
Buyer can only register if the flashsale is not running or open for registartion
flashsale is started/stopped manually
Purchase limit per buyer per flashsale is 1
Payment is abstracted out and considered successful before purchase() API is invoked.

all the database preload scripts in data.sql file



api endpoints :

to register : 
localhost:8999/register

sample request : {

    "customerId":"1",
    "flashSaleId":"1"
	
	
}


to purchase  :


localhost:8999/purchase


sample request : {

    "customerId":"1",
    "flashSaleId":"1"
	
	
}
