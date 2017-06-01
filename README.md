# Twilio App

This project will make the use of web apis to retrieve and manipulate data depending on the program logic. In the future, this app will be able to send texts that have been translated to desired language.

# Program Architecture

1. Android Project
2. Java Sparks WebServer
3. Twilio API
4. Twilio issued Pohone number
5. Twilio Java SDK

# Why webserver?
You could make an HTTP request but you risk sercurity issues by storing your Twilio credentials inside your mobile app. The easiest way to circumvent this problem is to create a backend web server that implments Twilio REST API.


# You need:

1. IDE that runs java
2. ngrok 
3. Android Studios 

# Installation

1. cd into twiliobackend project and run TwilioBackend.java in your IDE. You should be able to see the homepage on localhost:4567
2. With ngrok installed globally in your terminal, type "ngrok http 4567". You see see two forwarding sessions web link for http and https. It should look something like "https://738402eb.ngrok.io"
3. Open android studios and open AdminActivity.java. Under onClick method, replace the ngrok web link to your currently given ngrok link.
4. Run android studios!

# Alex Lee, May 28, 2017

![Alt text](https://cloud.githubusercontent.com/assets/12318904/26539103/873f7858-43ff-11e7-8ac1-902d3824af4a.png)

![Alt text](https://cloud.githubusercontent.com/assets/12318904/26539105/87437264-43ff-11e7-8f77-987b78ed1477.png)

![Alt text](https://cloud.githubusercontent.com/assets/12318904/26539104/873fa8dc-43ff-11e7-90ef-b6081e319a12.png)

![Alt text](https://cloud.githubusercontent.com/assets/12318904/26539102/873f7768-43ff-11e7-9c5c-3893cfb2f80b.png)


