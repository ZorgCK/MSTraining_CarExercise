package one.microstream.controller;

import java.util.List;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import one.microstream.domain.Brand;


@Controller("/brands")
public class BrandController
{
	@Get
	public List<Brand> getBrands()
	{
		return null;
	}
	
	@Post(value = "/insert")
	public HttpResponse<Brand> insertBrand(Brand dto)
	{
		return null;
	}
}
