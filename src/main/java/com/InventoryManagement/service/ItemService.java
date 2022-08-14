package com.InventoryManagement.service;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.InventoryManagement.beans.Category;
import com.InventoryManagement.beans.Item;
import com.InventoryManagement.beans.Store;

import com.InventoryManagement.data.ItemRepo;
import com.InventoryManagement.dto.ItemRequest;


//provides layer of abstraction between controller and repo

//controllers will take in request information
//services will house business logic 

@Service
public class ItemService {
	
	private static final int DEFAULT_PAGE_SIZE = 10;
	
	@Autowired
	private ItemRepo repo;
	
	public List<Item> findItemByStoreId(int storeId)
	{
		return repo.findByStoreId(storeId);
	} 
	
	
	public List<Item> findItemByStoreName(String name)
	{
		return repo.findByStoreName(name);
	} 
	
	
	//delegation pattern - provides a layer between two components for more control
	public Long count() 
	{
		return repo.count();
	}
	
	
	public List<Item> findAll(int page) 
	{
		return repo.findAll(PageRequest.of(page, DEFAULT_PAGE_SIZE)).toList();
	}
	

	public Iterable<Item> findAllNoPage() 
	{
		return   repo.findAll();
	}
	

	public Item insertItem(ItemRequest newItem) 
	{
		Item item = new Item();
		item.setId(Integer.parseInt(newItem.getId()));
		item.setName(newItem.getName());
		item.setPrice(newItem.getPrice());
		item.setStore(new Store(Integer.parseInt(newItem.getStoreId())));
		item.setCategory(new Category(Integer.parseInt(newItem.getCategoryId())));
		return repo.save(item);
	}
	
	public void delete(int id) 
	{
		repo.deleteById(id);
	}


	public void save(Item item) {
		// TODO Auto-generated method stub
		repo.save(item);
	}
	
	//TODO need to add update and delete methods that preauthenticate
	//@Transactional(propagation = Propagation.REQUIRED) // use an existing transaction (if none, creates one)
	//@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // security at the method level
}
