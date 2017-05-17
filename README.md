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
2) mock-weather-app: This a mock webservice to get weather report for a city in a country.
