package com.dealer.Dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dealer.Repo.DealerRepo;
import com.dealer.entity.Dealer;

@Repository
public class DealerDao {
	@Autowired
	DealerRepo dr;
	
	public List<Dealer> saveall(List<Dealer> s) {
		return dr.saveAll(s);
	}
	public String save(Dealer t) {
		dr.save(t);
		return "success";
	}
	public Optional<Dealer> findbyid(int u) {
		return dr.findById(u);
	}
	public List<Dealer> findall() {
		return dr.findAll();
		
	}
	public String deletebyid(int v) {
		 dr.deleteById(v);
		 return "deleted";
	}
	public List<Dealer> findAllRating(int rating) {
		return dr.findAllRating(rating);
	}
	public List<Dealer> findbyname(String nameStart,String nameEnd) {
		return dr.findbyname(nameStart, nameEnd);
	}
	public String ratingexception() {
		dr.findAll();
		return "exception"; 
					
	}
	public String ratingexception(Dealer d){
		 dr.save(d);
		 return "sucess";
	 
	}
	public List<Dealer> getbyname(String name) {
		return dr.getbyName(name);
	}
	public String findproduct(Dealer product) {
		 dr.save(product);
		 return "Sucess";
	}
	public List<Dealer> getByName(char a,char b) {
		return dr.getByName(a, b);
	}

	
}
