package com.DarAttamwil.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.DarAttamwil.Entity.Administrateur;
import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Entity.Financements;
import com.DarAttamwil.Entity.Roles;
import com.DarAttamwil.Entity.Villes;
import com.DarAttamwil.Services.IserviceAdmin;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {
@Autowired private IserviceAdmin serviceAdmin;
@Autowired private  ServletContext context;

//ajouter
@PostMapping(value="/login/admins", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
@ResponseBody
public void uploadFile(@RequestPart(value = "file" , required=false) MultipartFile file ,@RequestParam("user") String user) throws IOException,JsonParseException,JsonMappingException {
	Administrateur administrateur = new ObjectMapper().readValue(user, Administrateur.class);
	
    if (file!=null) {
    	administrateur.setName(file.getOriginalFilename());
    	administrateur.setType(file.getContentType());
    	administrateur.setPicByte(compressZLib(file.getBytes()));
    	serviceAdmin.addModifierAdmin(administrateur);

        }else {
        	 serviceAdmin.addModifierAdmin(administrateur);
  
        }
}
//modifier admin
@PatchMapping(value="/admins/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
@ResponseBody
public Administrateur updateUser(@RequestPart(value = "file" , required=false) MultipartFile file ,@RequestParam("user") String user,@PathVariable("id") int id) throws IOException,JsonParseException,JsonMappingException {
	Administrateur administrateur = new ObjectMapper().readValue(user, Administrateur.class);
	 if (file!=null) {
		 administrateur.setId(id);
		 administrateur.setName(file.getOriginalFilename());
		 administrateur.setType(file.getContentType());
		 administrateur.setPicByte(compressZLib(file.getBytes()));
    	Administrateur admin = serviceAdmin.addModifierAdmin(administrateur);

        }else {
        	administrateur.setId(id);
        	serviceAdmin.addModifierAdmin(administrateur);	    	
        }
	 return administrateur;
}

//selection tous les admin
@GetMapping("/admins")
public List<Administrateur> selectAllAdmin(){
//	return serviceAdmin.selectAllAdmin();
	List<Administrateur> table = new ArrayList<Administrateur>();
	final List<Administrateur> retrievedImage = serviceAdmin.selectAllAdmin();
	byte[] picBytee=null;

	for (int i = 0 ; i<retrievedImage.size();i++) {

		int id = retrievedImage.get(i).getId();
		String nom = retrievedImage.get(i).getNom();
		String prenom = retrievedImage.get(i).getPrenom();
		String email = retrievedImage.get(i).getEmail();
		String name = retrievedImage.get(i).getName();
		String password = retrievedImage.get(i).getPassword();
		String type = retrievedImage.get(i).getType();
		Date createdAt = retrievedImage.get(i).getCreatedAt();
		Date updatedAt = retrievedImage.get(i).getUpdatedAt();
	    Roles role =  retrievedImage.get(i).getRole();
		if(retrievedImage.get(i).getPicByte() != null ) {
			 picBytee = decompressZLib(retrievedImage.get(i).getPicByte());		
		}
		else {
			picBytee = null;
		}
	
		Administrateur img = new Administrateur(id, nom, prenom, role, email, password, name, type, picBytee, createdAt, updatedAt);
		   table.add(img);	  
	}
	return table;
}
////selectionner par id admin
@GetMapping("/admins/{id}")
public Administrateur selectByIdAdmin(@PathVariable("id") int id) throws IOException {
	final Optional<Administrateur> retrievedImage = serviceAdmin.selectByIdAdmin(id);
	byte[] picBytee=null;
	int idC = retrievedImage.get().getId();
	String nom = retrievedImage.get().getNom();
	String prenom = retrievedImage.get().getPrenom();
	String email = retrievedImage.get().getEmail();
	String name = retrievedImage.get().getName();
	String password = retrievedImage.get().getPassword();
	String type = retrievedImage.get().getType();
	Date createdAt = retrievedImage.get().getCreatedAt();
	Date updatedAt = retrievedImage.get().getUpdatedAt();
    Roles role =  retrievedImage.get().getRole();	
	if(retrievedImage.get().getPicByte() != null ) {
		 picBytee = decompressZLib(retrievedImage.get().getPicByte());		
	}
	else {
		picBytee = null;
	}
	Administrateur img = new Administrateur(id, nom, prenom, role, email, password, name, type, picBytee, createdAt, updatedAt);
	   return img;	  
	
//	if (!admin.isPresent()) {
//		return null;
//	}
//	return admin.get();
}


////suprimer admin by id
@DeleteMapping("/admins/{id}")
public void deletAdmin(@PathVariable("id") int id) {
	serviceAdmin.deletAdmin(id);
}
//recherche d'un admin par nom ou prenom
@GetMapping("/admins/search")
public List<Administrateur> findAdmintByFnameOrLname(@RequestParam(value = "nom" , required=false) String nom 
        , @RequestParam(value = "prenom" , required = false) String prenom){
	return serviceAdmin.findAdmintByFnameOrLname(nom, prenom);
}


//compress the image bytes before storing it in the database
public static byte[] compressZLib(byte[] data) {
	Deflater deflater = new Deflater();
	deflater.setInput(data);
	deflater.finish();

	ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	byte[] buffer = new byte[1024];
	while (!deflater.finished()) {
		int count = deflater.deflate(buffer);
		outputStream.write(buffer, 0, count);
	}
	try {
		outputStream.close();
	} catch (IOException e) {
	}
	System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

	return outputStream.toByteArray();
}

//uncompress the image bytes before returning it to the angular application
public static byte[] decompressZLib(byte[] data) {
	Inflater inflater = new Inflater();
	inflater.setInput(data);
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	byte[] buffer = new byte[1024];
	try {
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
	} catch (IOException ioe) {
	} catch (DataFormatException e) {
	}
	return outputStream.toByteArray();
}
}
