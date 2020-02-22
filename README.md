# java-labs
This repo is a collection of some good quality coding, architectural assignments.


n continuation to the Assignment 1, this assignment is focused on creating a High Availability Service similar to what we create on AWS. 

In last assignment we created 2 services. 
Service 1 : A rest api producing events together with some data.
Service 2: A Consumer eating the above generated messages.

For this Assignment following changes are expected: 
Service 1:
Create multiple instances of Service 1 that too behind a load balancer. Both the instances of Service 1 will be producers in our case and must be running on independent docker containers.

We will do something similar for Service 1: 
https://images.app.goo.gl/9muATxiyxTmdoZZD7 
1. In the above image, replace node.js with spring boot application. 
2. You are free to keep any port number. 
Once done with above, we will try persisting in Service 1. Now, whatever data we were receiving in apis, should be stored in a DB. It has to a relational DB. You are free to use any DB. Choice is yours. 

Store the Object received in API to the DB and then push the data to rabbit as message.  

Service 2:

Also create multiple instances of Service 2 running on Docker Containers. Both of these instances should be registered to rabbit mq the way it was on your local when your were running producer and consumer.

Once you have achieved the above. It's time to change service 2. Every message we receive in service 2 has to be stored in a NOSQL DB. Again, you are free to use any NoSQL DB. 
