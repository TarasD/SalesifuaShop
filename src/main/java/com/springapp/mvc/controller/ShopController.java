package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Shop;
import com.springapp.mvc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/shop", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopController {

	@Autowired
	private ShopService shopService;

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
	public List<Shop> getAll() {

		return shopService.getAll();
	}

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/{id}")
	public Shop getShop(@PathVariable("id") Long id) {

		return shopService.getShop(id);
	}

	@RequestMapping(
			method = RequestMethod.POST,
			value = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String addPerson(@RequestBody Shop shop) {

		//return shopService.addShop(shop);

		return "added";
	}

	@RequestMapping(value = "/update/{id}",
			method = RequestMethod.PUT,
			headers="Accept=application/json")
	public Shop updatePerson(@PathVariable("id") Long id, @RequestBody Shop shop) {

		return shopService.updateShop(shop);
	}


	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteEmployee(@PathVariable("id") Long id) {

		shopService.deleteShop(id);
		return "done";
	}

	@RequestMapping(value = "/sort/{field}",
			method = RequestMethod.GET)
	public String sortBy(@PathVariable("field") String field) {

		return "sorted";
	}

	@RequestMapping(value = "/filter/{field}={value}",
			method = RequestMethod.GET)
	public String orderBy(@PathVariable("field") String field, @PathVariable("value") String value) {

		return "ordered";
	}

	@RequestMapping(value = "/search/{field}={value}",
			method = RequestMethod.GET)
	public String search(@PathVariable("field") String field, @PathVariable("value") String value) {

		return "searched";
	}

	@RequestMapping(value = "/pagable/{amount}",
			method = RequestMethod.GET)
	public String pagable(@PathVariable("amount") int amount) {

		return "paged";
	}
}