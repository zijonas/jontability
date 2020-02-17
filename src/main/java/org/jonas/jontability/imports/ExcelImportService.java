package org.jonas.jontability.imports;

import com.google.common.collect.Maps;
import org.jonas.jontability.business.impl.AccountService;
import org.jonas.jontability.business.impl.CategoryService;
import org.jonas.jontability.business.impl.PostService;
import org.jonas.jontability.dto.AccountDto;
import org.jonas.jontability.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ExcelImportService {
	Logger LOGGER = Logger.getLogger(ExcelImportService.class.getName());

	@Autowired
	AccountService accountService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;

	public boolean importFile(String url, int year) {
		return importFile(Path.of(url), year);
	}

	public boolean importFile(Path path, int year) {
		try {
			Map<String, List<PostDto>> importedData = ExcelImportParser.readLines(new FileReader(path.toFile()), year);

			Map<String, Integer> existingAccounts = Maps.newHashMap();
			accountService.getAll().ifPresent(i -> existingAccounts.putAll(i.stream().collect(Collectors.toMap(AccountDto::getName, AccountDto::getId))));

			for(Map.Entry<String, List<PostDto>> entry : importedData.entrySet()) {
				if(!existingAccounts.containsKey(entry.getKey())) {
					AccountDto acc = new AccountDto();
					acc.setName(entry.getKey());
					acc = accountService.persist(acc);
					existingAccounts.put(acc.getName(), acc.getId());
				}
				entry.getValue().forEach(i -> i.setAccountId(existingAccounts.get(entry.getKey())));
				entry.getValue().forEach(i -> postService.persist(i));
			}


		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			return false;
		}
		return true;
	}

}
