package com.dealer.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealer.entity.Dealer;


public interface DealerRepo extends JpaRepository<Dealer,Integer> {
	@Query(value="Select e from Dealer e where e.rating=:rating")
	public List<Dealer> findAllRating(@Param (value="rating") int rating);
	@Query("SELECT e.name FROM Dealer e WHERE e.name LIKE :nameStart AND e.name LIKE :nameEnd")
    List<Dealer> findbyname(@Param(value="nameStart") String nameStart, @Param(value="nameEnd") String nameEnd); 
	@Query(value="Select e from Dealer e where e.name=:name")
	public List<Dealer> getbyName(@Param (value="name") String name);
	@Query(value="Select e from Dealer e where e.product=:product")
	public List<Dealer> findproduct(@Param (value="product") String product);
	@Query(value="Select*from dealer where name like '?%' and name like '%?' ",nativeQuery=true)
	public List<Dealer> getByName(char a,char b);

	

}
