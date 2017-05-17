package com.weather;

import javax.jws.WebService;

@WebService
public interface GlobalWeatherService {

	WeatherResult getWeather(String CountryName, String CityName);
}
