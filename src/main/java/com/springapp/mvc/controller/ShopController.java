package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Shop;
import com.springapp.mvc.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopController {

	@Autowired
	private IShopService shopService;

	@RequestMapping("")
	public String help() {
		return "/all - list of all shops\n" +
				"/{id} - show specific shop\n" +
				"/add - add shop\n" +
				"/update/{id} - update specific shop" +
				"/delete/{id} - delete specific shop" +
				"/sort/{field} - sort by specific field" +
				"/filter/{field}={value} - filter by specific field value" +
				"/search/{field}={value}";
	}

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/all")
	public List<Shop> getAll(@RequestParam(value ="page") int page, @RequestParam(value = "amount") int amount) {
        //
        return shopService.getAll(page, amount, "id");
	}

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/{id}")
	public Shop getShop(@PathVariable("id") Long id) {
        //
		return shopService.getShop(id);
	}

	@RequestMapping(
			method = RequestMethod.POST,
			value = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Shop addPerson(@RequestBody Shop shop) {
		//
        return shopService.addShop(shop);
	}

	@RequestMapping(
			method = RequestMethod.PATCH,
			value = "/update/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public Shop updatePerson(@PathVariable("id") Long id, @RequestBody Shop shop) {
        Shop dbShop = shopService.getShop(id);

        if(shop.getName() != null) dbShop.setName(shop.getName());
        if(shop.getAddress() != null) dbShop.setAddress(shop.getAddress());
        if(shop.getEmail() != null) dbShop.setEmail(shop.getEmail());
        if(shop.getPhoneNumber() != null) dbShop.setPhoneNumber(shop.getPhoneNumber());
        if(shop.getPassword() != null) dbShop.setPassword(shop.getPassword());

        return shopService.addShop(dbShop);
	}


	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteEmployee(@PathVariable("id") Long id) {
        //
		shopService.deleteShop(id);
		return "done";
	}

	@RequestMapping(value = "/sort/{field}",
			method = RequestMethod.GET)
	public List<Shop> sortBy(@PathVariable("field") String field, @RequestParam(value ="page") int page, @RequestParam(value = "amount") int amount) {
        return shopService.getAll(page, amount, field);
	}

	@RequestMapping(value = "/filter/{field}={value}",
			method = RequestMethod.GET)
	public List<Shop> orderBy(@PathVariable("field") String field, @PathVariable("value") String value) {
        System.out.println(field + " " + value);
        return shopService.findBy(field, value);
	}

	@RequestMapping(value = "/search/{name}",
			method = RequestMethod.GET)
	public List<Shop> search(@PathVariable("name") String name) {

        return shopService.findBy("name", name);
	}

	@RequestMapping(value = "/pagable/{amount}",
			method = RequestMethod.GET)
	public String pagable(@PathVariable("amount") int amount) {

		return "paged";
	}
}