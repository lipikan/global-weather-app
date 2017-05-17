# global-weather-app

The global-weather-app has two mule projects:
1) weather-raml-exercise: This application has two REST API services:
1st service:
```
Get Cities: This service lists down all the cities in a given country
URI Endpoint:http://host:port/globalweather/v1/cities?country=name-of-the-country
Example:
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
2nd Service:

```

Get Weather: This service gets the weather report of the city in a country
URI Endpoint: http://host:port/globalweather/v1/weather?country=name-of-country&city=name-of-city

Example:
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

The build.sh file will build the docker container and also run the docker container and use the mock service container network.
To Run the build.sh file:
First provide permission:
$ chmod +x build.sh
Run the script:
$ ./build.sh
That should bring the weather app up.
```
Challenges:



