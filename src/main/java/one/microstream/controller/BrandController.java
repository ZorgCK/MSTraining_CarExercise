package one.microstream.controller;

import java.util.List;
import java.util.Optional;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import one.microstream.domain.Brand;
import one.microstream.storage.DB;


@Controller("/brands")
public class BrandController
{
	@Get
	public List<Brand> getBrands()
	{
		return DB.root.getBrands();
	}
	
	@Post(value = "/insert")
	public HttpResponse<Brand> insertBrand(Brand dto)
	{
		
		Optional<Brand> optionalBrand =
			DB.root.getBrands().stream().filter(brand -> brand.getName().equalsIgnoreCase(dto.getName())).findFirst();
		
		if(!optionalBrand.isPresent())
		{
			Brand brand = new Brand();
			brand.setName(dto.getName());
			DB.root.getBrands().add(brand);
			DB.storageManager.store(DB.root.getBrands());
			
			return HttpResponse.ok(brand);
		}
		
		return HttpResponse.notAllowed();
	}
}
