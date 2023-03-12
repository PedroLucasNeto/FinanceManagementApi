package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financemanagement.model.Entry;
import com.financemanagement.repository.EntryRepository;

@Service
public class EntryService {


	@Autowired
	EntryRepository entryRepository;

	public boolean createEntry(Entry entry) {

		if (entry != null) {
			entryRepository.save(entry);
			return true;
		}
		return false;
	}

	public void deleteEntry(Long id) throws Exception {
		Entry deleteEntry = entryRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an Entry with this ID: " + id));
		entryRepository.delete(deleteEntry);
	}

	public Entry updateEntry(Long id, Entry entry) throws Exception {
		Entry updatedEntry = entryRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an Entry with this ID: " + id));
		updatedEntry.setClient(entry.getClient());
		updatedEntry.setDescription(entry.getDescription());
		updatedEntry.setEntryDate(entry.getEntryDate());
		updatedEntry.setEntryType(entry.getEntryType());
		updatedEntry.setPaymentDate(entry.getPaymentDate());
		updatedEntry.setPrice(entry.getPrice());
		entryRepository.save(updatedEntry);
		return updatedEntry;
	}

	public Iterable<Entry> listEntrys() {
		Iterable<Entry> listEntrys = entryRepository.findAll();
		return listEntrys;
	}

	public Iterable<Entry> findByClientName(String clientName) {
		Iterable<Entry> entrys = entryRepository.findByClientName();
		return entrys;
	}

	public Entry findById(Long id) throws Exception {
		Entry entry = entryRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an Entry with this ID: " + id));
		return entry;
	}
	
}
