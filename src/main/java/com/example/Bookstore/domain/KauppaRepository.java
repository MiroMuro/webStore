package com.example.Bookstore.domain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface KauppaRepository extends CrudRepository<Kauppa, Long> {
	
	List<Kauppa> findByName(String name);
	
	
	
}
