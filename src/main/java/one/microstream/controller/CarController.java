package one.microstream.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import one.microstream.domain.Brand;
import one.microstream.domain.Car;
import one.microstream.storage.DB;


@Controller("/cars")
public class CarController
{
	@Get
	public List<Car> listCars()
	{
		return DB.root.getCars();
	}
	
	@Get(value = "/{model}")
	public List<Car> getCarsByModel(@QueryValue("model") String model)
	{
		return DB.root.getCars().stream().filter(car -> car.getModel().equalsIgnoreCase(model)).collect(
			Collectors.toList());
	}
	
	@Get(value = "/bybrand/{brand}")
	public List<Car> getCarsByBrand(@QueryValue("brand") String brand)
	{
		return DB.root.getCars().stream().filter(car -> car.getBrand().getName().equalsIgnoreCase(brand)).collect(
			Collectors.toList());
	}
	
	@Delete
	public HttpResponse<String> clearCars()
	{
		DB.root.getCars().clear();
		DB.storageManager.store(DB.root.getCars());
		
		return HttpResponse.ok("Cars cleared successfully");
	}
	
	@Post(value = "/insert")
	public Car insertCar(Car dto)
	{
		Optional<Brand> optionalBrand = DB.root.getBrands().stream().filter(
			brand -> brand.getName().equalsIgnoreCase(dto.getBrand().getName())).findFirst();
		
		if(optionalBrand.isPresent())
		{
			Brand brand = optionalBrand.get();
			
			Car car = new Car();
			car.setBrand(brand);
			car.setModel(dto.getModel());
			
			DB.root.getCars().add(car);
			DB.storageManager.store(DB.root.getCars());
			
			return car;
		}
		
		return null;
	}
}
