package com.dealer.Service;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealer.CustomException.ProductNotFoundException;
import com.dealer.CustomException.RatingException;
import com.dealer.Dao.DealerDao;
import com.dealer.entity.Dealer;

@Service
public class DealerService {
	@Autowired
	DealerDao dd;
	public List<Dealer> saveall(List<Dealer> s) {
		return dd.saveall(s);
	}
	public String save(Dealer t) {
		return dd.save(t);
	}
	public Optional<Dealer> findbyid(int u) {
		return dd.findbyid(u);
	}
	public List<Dealer> findall() {
		return dd.findall();
		
	}
	public String deletebyid(int v) {
		return dd.deletebyid(v);
	}
	public List<Dealer> findAllRating(int rating) {
		return dd.findAllRating(rating);
	}
	public List<Dealer> findbyname(String nameStart,String nameEnd) {
		return dd.findbyname(nameStart, nameEnd);
	}
	public String ratingexception(Dealer d) throws RatingException {
		try {
		if(d.getRating()>=1 && d.getRating()<6) {
			dd.ratingexception(d);
		}
		else {
			throw new RatingException("Rating must be");
		}
		return "sucess";
		
		}
		catch(Exception e) {
			return "please Enter 1to 5";
		}
			
		}
	public List<Dealer> getbyname(String name) throws NameNotFoundException {
		if(dd.getbyname(name).isEmpty()) {
			throw new NameNotFoundException("There is no data in this name");
		}
		else {
			return dd.getbyname(name);
		}
	}

	public String findproduct(Dealer product) throws NullPointerException {
		if(product.getRating()==5 && product.getName()!=null) {
		 product.setRating(product.getRating()+2);
		 return dd.findproduct(product);
		}
		else {
			throw new NullPointerException("null value found")	;	 
		}
		
	}
	public List<Dealer> getByName(char a,char b) {
		return dd.getByName(a, b);
	}


}
