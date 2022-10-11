package one.microstream.controller;

import java.util.List;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import one.microstream.domain.Car;


@Controller("/cars")
public class CarController
{
	@Get
	public List<Car> listCars()
	{
		return null;
	}
	
	@Get(value = "/bymodel")
	public List<Car> getCarsByModel(@Nullable @QueryValue String model)
	{
		return null;
	}
	
	@Get(value = "/bybrand")
	public List<Car> getCarsByBrand(@Nullable @QueryValue String brand)
	{
		return null;
	}
	
	@Delete
	public HttpResponse<String> clearCars()
	{
		return null;
	}
	
	@Post(value = "/insert")
	public Car insertCar(Car dto)
	{
		return null;
	}
}
