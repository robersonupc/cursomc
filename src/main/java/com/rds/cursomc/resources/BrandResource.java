package com.rds.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rds.cursomc.domain.Brand;
import com.rds.cursomc.dto.BrandDTO;
import com.rds.cursomc.services.BrandService;

@RestController
@RequestMapping(value = "/brands")
public class BrandResource {
	
	@Autowired
	private BrandService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Brand> find(@PathVariable Integer id) {		
		Brand obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Brand> insert(@Valid @RequestBody BrandDTO objDto) {
		Brand obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody BrandDTO objDto, @PathVariable Integer id){
		Brand obj = service.fromDTO(objDto);
		obj.setId(id);		
		obj = service.update(obj);		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		
		service.delete(id);		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BrandDTO>> findAll() {
		List<Brand> list = service.findAll();
		List<BrandDTO> listDto = list.stream().map(obj -> new BrandDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<BrandDTO>> findPage(
			 @RequestParam(value = "page", defaultValue = "0") Integer page,
			 @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			 @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			 @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		Page<Brand> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<BrandDTO> listDto = list.map(obj -> new BrandDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/picture", method=RequestMethod.POST)
	public ResponseEntity<Brand> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}

}
