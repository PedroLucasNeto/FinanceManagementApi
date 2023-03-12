package com.financemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanagement.model.Entry;
import com.financemanagement.service.EntryService;

@RestController
@RequestMapping("/entry")
public class EntryController {

	@Autowired
	EntryService entryService;

	@PostMapping
	ResponseEntity<Entry> createEntry(@RequestBody Entry entry) {
		boolean success = entryService.createEntry(entry);
		if (success) {
			return new ResponseEntity<Entry>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Entry>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping 
	ResponseEntity<Entry> deleteEntry(@PathVariable Long id) throws Exception {
		entryService.deleteEntry(id);
			return new ResponseEntity<Entry>(HttpStatus.OK);
	}

	@PutMapping("/{id}") 
	ResponseEntity<Entry> updateEntry(@PathVariable Long id, @RequestBody Entry entry) throws Exception {
		entryService.updateEntry(id, entry);
		return new ResponseEntity<Entry>(HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <Iterable<Entry>> listEntrys(){
		Iterable<Entry> listEntrys = entryService.listEntrys();
		return new ResponseEntity<Iterable<Entry>>(listEntrys, HttpStatus.OK);
	}
	
	@GetMapping("/{clientName}")
	ResponseEntity<Iterable<Entry>> getEntryByClientName(@PathVariable String clientName){
		List<Entry> entrys = (List<Entry>) entryService.findByClientName(clientName);
		if (entrys.isEmpty()) {
			return new ResponseEntity<Iterable<Entry>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Entry>>(entrys, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<Entry> getEntryById(@PathVariable Long id) throws Exception{
		Entry entry = entryService.findById(id);
		if (entry.equals(null)) {
			return new ResponseEntity<Entry>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Entry>(entry, HttpStatus.OK);
	}
}