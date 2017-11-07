# SafeTrack

# Inspiration
Given the high volume of requests the first responders receive, there is a need to manage resources and personnel more effectively by providing an intelligent insight into the areas where they are needed the most. There is a need to reduce the uncertainty and guesswork in the command center to make more informed decisions instantly. High volumes of requests are received at the center and there can be wait times to respond to an emergency.

# Technologies Used
Pebble
Dragonboard 410c
AWS RDS
Twilio API
NodeJS
AJAX
GoogleAPI
C

# What it does?
The user has a pebble watch and he can send an emergency message in form of a keyword to the server. The server receives the location coordinates of the user. Depending upon the state of emergency appropriate unit(medical, police, fire fighters) are alerted and they are dispatched to the location. The alert is also sent to the relative of the user, whose details are stored in a database.

# How we built?
A new API is created for Pebble Watches. This API takes the voice message sent by the user on his watch and sends the location coordinates and message to the server. The location information is fetched using google Places API. NodeJS server is hosted locally on laptop and on Dragonboard 410c for parsing data from one server to another NodeJS server. AWS RDS is used for storing the emergency contact information. This contact information can be stored in RDS using Apache server running locally on our laptop.

# Flow of the Project
The user sends the voice message via pebble watch to the node js server. The user location is fetched by google places api i.e latitude and longitude. This is used to generate the exact location of the user and to find the nearest center capable of dealing with the emergency(fire dept, hospital,police) which is sent to node js server for processing. Javascript is used to parse data to get the address of user and type of emergency. This information is forwarded to all emergency contact information stored in RDS. In this way the emergency contacts are also alerted via text messages on their cell phones.

# Challenges we ran into
Converting the voice emergency input recorded in Pebble to text.
Sending the data from pebble to NodeJS server
Connecting AWS RDS server to NodeJS server.
Configuring and using TwilioAPI for sending emergency message
Installing, configuring OS, Node js server and dependencies associated with dragon board
Configuring Dragonboard 410c
Accomplishments that we're proud of
Designing a public safety application on an affordable pebble watch and have a working application ready within just 2 days.

# What we learned
We learned developing a pebble application and designing an application which runs on a distributed system

# What's next for SafeTrack
The future scope is wide for this application: 1.We can have the emergency signal sent by touch of a button for speech impaired users. 2.By taking the location we can send an alert to the police which is in the 5000mts radius of user.

# Built With
Pebble
Dragonboard 410c
AWS RDS
Twilio API
NodeJS
AJAX
GoogleAPI
C
