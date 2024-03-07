package com.dealer.Controller;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealer.CustomException.ProductNotFoundException;
import com.dealer.CustomException.RatingException;
import com.dealer.Service.DealerService;
import com.dealer.entity.Dealer;

@RestController
@RequestMapping(value="/Dealer")
public class DealerController {
	@Autowired
	DealerService ds;
	@PostMapping(value="/saveall")
	public List<Dealer> saveall(@RequestBody List<Dealer> s) {
		return ds.saveall(s);
	}
	@PostMapping(value="/save")
	public String save(@RequestBody Dealer t) {
		return ds.save(t);
	}
	@GetMapping(value="findbyid/{u}")
	public Optional<Dealer> findbyid(@PathVariable int u) {
		return ds.findbyid(u);
	}
	@GetMapping(value="/findall")
	public List<Dealer> findall() {
		return ds.findall();	
	}
	@DeleteMapping(value="/deletebyid/{v}")
	public String deletebyid(@PathVariable int v) {
		return ds.deletebyid(v);
}
	@GetMapping(value="/findAllRating/{rating}")
	public List<Dealer> findAllRating(@PathVariable int rating) throws RatingException {
		return ds.findAllRating(rating);
	}
	@GetMapping(value="/findbyname/{nameStart}/{nameEnd}")
	public List<Dealer> findbyname(@PathVariable String nameStart,@PathVariable String nameEnd) {
		return ds.findbyname(nameStart,nameEnd);
	}
    @PostMapping(value="/ratingexception")
    public String ratingexception(@RequestBody Dealer d) throws RatingException {
    	return ds.ratingexception(d);
    }
    @GetMapping(value="/getbyname/{name}")
    public List<Dealer> getbyname(@PathVariable String name) throws NameNotFoundException {
    	return ds.getbyname(name);
    }
    @PostMapping(value="/findproduct")
    public String findproduct(@RequestBody Dealer product) throws ProductNotFoundException {
		return ds.findproduct(product);
    }
    @GetMapping(value="/getbyname/{a}/{b}")
    public List<Dealer> getByName(char a,char b) {
		return ds.getByName(a, b);
	}
    	
    	
    }

    	


