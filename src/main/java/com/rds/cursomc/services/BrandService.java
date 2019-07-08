package com.rds.cursomc.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rds.cursomc.domain.Brand;
import com.rds.cursomc.dto.BrandDTO;
import com.rds.cursomc.repositories.BrandRepository;
import com.rds.cursomc.security.UserSS;
import com.rds.cursomc.services.exceptions.AuthorizationException;
import com.rds.cursomc.services.exceptions.DataIntegratyException;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repo;
	
	@Autowired
	private S3Service s3Service;

	@Autowired
	private ImageService imageService;

	@Value("${img.prefix.client.profile}")
	private String prefix;

	@Value("${img.profile.size}")
	private Integer size;

	public Brand find(Integer id) {
		Optional<Brand> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Brand.class.getName());
		}
		return null;
		
	}
	
	public Brand insert(Brand obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Brand update(Brand obj) {
		Brand newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegratyException("Não é possível excluir o fabricante que possui produtos!");
		}
	}
	
	public List<Brand> findAll(){
		return repo.findAll();
	}
	
	public Page<Brand> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Brand fromDTO(BrandDTO objDto) {
		
		return new Brand(objDto.getId(), objDto.getName(), objDto.getDescription());
	}
	
	private void updateData(Brand newObj, Brand obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);

		String fileName = prefix + user.getId() + ".jpg";

		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
	}
}