package com.weather;

import java.util.Random;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(endpointInterface = "com.weather.GlobalWeatherService",
serviceName = "globalweather")
public class GlobalWeatherServiceImpl implements GlobalWeatherService{
	@Resource
	private WebServiceContext context;

	@Override
	public WeatherResult getWeather(String CountryName, String CityName) {
		WeatherResult response = new WeatherResult();
		response.setCity(CityName);
		response.setCountry(CountryName);
		response.setTemprature(new Random().nextInt(40));
		response.setUnit("Celsius");
		return response;
	}

	

}
