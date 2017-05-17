# global-weather-app

The global-weather-app has two mule projects:
1) weather-raml-exercise: This application has two REST API services:
1st service: Get Cities
```
This service lists down all the cities in a given country as parameter

URI Endpoint:http://host:port/globalweather/v1/cities?country={name-of-the-country}
```
Example:
```
URI: http://127.0.0.1:8081/globalweather/v1/cities?country=Fiji

Response:
{
  "result": {
    "table": [
      {
        "country": "Fiji",
        "city": "Nandi"
      },
      {
        "country": "Fiji",
        "city": "Nausori"
      },
      {
        "country": "Fiji",
        "city": "Lakemba"
      },
      {
        "country": "Fiji",
        "city": "Rotuma"
      }
    ]
  }
}

```
2nd Service: Get Weather

```
This service gets the weather report of the city in a country taking city and country as parameters.

URI Endpoint: http://host:port/globalweather/v1/weather?country={name-of-country}&city={name-of-city}
```
Example:
```
URI: http://127.0.0.1:8081/globalweather/v1/weather?country=India&city=Mumbai

Response:
{
  "data": {
    "country": "Mumbai",
    "city": "India",
    "temprature": "35",
    "unit": "Celsius"
  }
}
```
Alternative way to access the API's
```
It can be also accessed through the MULE API KIT Console:
http://127.0.0.1:8081/console/
The Endpoint list all the API's and its usage which can also be used to test the Application.
```

2) mock-weather-app: This a mock webservice to get weather report for a city in a country.

To Run the Apps:
There are two docker folders:
1) DockerMockService
```
The Folder consist of the below:
DockerMockSercice
|____mock-weather-app.zip
|____mule-ee-distribution-standalone-3.8.0.tar.gz
|____Dockerfile
|____build.sh

The build.sh file will build the docker container and also run the docker container.
To Run the build.sh file:
First provide permission:
$ chmod +x build.sh
Run the script:
$ ./build.sh
That should bring the mock service up on port 63081.

```
2) DockerGlobalWeather
```
The Folder consist of the below:
DockerGlobalWeather
|____weather-raml-exercise.zip
|____mule-ee-distribution-standalone-3.8.0.tar.gz
|____Dockerfile
|____build.sh

The build.sh file will build the docker container and also run the docker container and use the mock service 
container network.
To Run the build.sh file:
First provide permission:
$ chmod +x build.sh
Run the script:
$ ./build.sh
That should bring the weather app up.
```
Challenges:
There were a couple of challenges I faced while doing this project:
1) Data transformation of the web service GetCitiesByCountry
```
The Response GetCitiesByCountryResponse was a String intead of XML object, which was difficult to parse. 
To overcome it :
I wrote a groovy script to convert the string to a DOM object and then used 
MULE's DOMTOXML transformer to make it a proper XML. 
And Finally tranforming the XML to JSON as per my API's response.

Alternative:
Could have been also parsed through dataweave if I would have investigate more.
```
2) Dockerising the actual service and the mock service
```
Since the GetWeather webservice was not working, I had to write a simple mock service 
and call the service in my weather-raml-exercise instead of actual service.

The Problem was how to deploy bot the application in a docker container:

I tried deploying both the apps in one docker container but could not control the order of deployment, 
which cause the weather-raml-exercise app to Fail because it was dependent on "mock-weather-app".
And the container was first deploying weather-raml-exercise and then "mock-weather-app" 
later which caused Connection Refused error becuause it could not find the mock web service.

To overcome it:
I decided to deploy the mock service in a separate docker container.

and then deploy the weather-raml-exercise in separate container but to share the 
network of the mock container so that it can access the mock web service.

To achieve it I used the following docker command:
docker run --network container:muleMock -it --name muleService mule-container

```
Improvements:
```
1) Could have imporoved the Exception Handling of the project by defining a global exception strategy 
   and using it in all the flows.
2) If time permitted could have added unit test cases to app.
3) Made the mock webservice an exact replica of the actual webservice, which will reduce changes 
   to the app when the actual webservice is up and running.
```

I really enjoyed doing this exercis and learnt a lot about docker.
