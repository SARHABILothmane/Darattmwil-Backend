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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
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

import com.DarAttamwil.Entity.Actualiter;
import com.DarAttamwil.Entity.Administrateur;
import com.DarAttamwil.Entity.ImageModel;
import com.DarAttamwil.Services.IserviceActualiter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ActualiterController {
@Autowired private IserviceActualiter serviceActualiter;
@Autowired private  ServletContext context;

//ajouter 
@PostMapping("/actualites")
@ResponseBody
public void addActualiter(@RequestPart(value = "imageFile"  , required=false) MultipartFile file ,@RequestParam("actualiter") String actualiter) throws IOException {
	Actualiter actualite = new ObjectMapper().readValue(actualiter, Actualiter.class);
//	System.out.println("Original Image Byte Size - " + file.getBytes().length);
//	Actualiter a = new Actualiter();
//	Actualiter img = new Actualiter(file.getOriginalFilename(), file.getContentType(),
//			compressZLib(file.getBytes()));

	if (file != null) {
	actualite.setName(file.getOriginalFilename());
	actualite.setType(file.getContentType());
	actualite.setPicByte(compressZLib(file.getBytes()));
	Actualiter a = 	serviceActualiter.addModifierActualiter(actualite);
//	return ResponseEntity.status(HttpStatus.OK);
//    if(a!=null) {
//  		return new ResponseEntity<>("File and actualiter is uploaded successfully", HttpStatus.OK);
//
//    }else {
//  		return new ResponseEntity<>("File is not uploaded", HttpStatus.BAD_REQUEST);   
//     }
    //
	 }else {
		    Actualiter ac = serviceActualiter.addModifierActualiter(actualite);
//		    return ResponseEntity.status(HttpStatus.OK);
//	        	if(ac!=null) {
//	        		return new ResponseEntity<>(json.toString(),"user is post successfully", HttpStatus.OK);
//	        	
//	    
//	            }else {
//	          		return new ResponseEntity<>("user is not post", HttpStatus.BAD_REQUEST);
//	             }	
	        }
}
//	return ResponseEntity.status(HttpStatus.OK);

//@PostMapping("/actualites")
//public void addActualiter(@RequestBody Actualiter a) {
//	serviceActualiter.addModifierActualiter(a);
//}
////modifier 
//@SuppressWarnings("unused")
@PatchMapping("/actualites/{id}")
@ResponseBody
public Actualiter modifierActualiter(@RequestPart(value = "imageFile"  , required =false) MultipartFile file ,@RequestParam("actualiter") String actualiter ,@PathVariable("id") int id) throws IOException {
	Actualiter actualite = new ObjectMapper().readValue(actualiter, Actualiter.class);
//	System.out.println("Original Image Byte Size - " + file.getBytes().length);
	if (file != null) {
		actualite.setId(id);
		actualite.setName(file.getOriginalFilename());
		actualite.setType(file.getContentType());
		actualite.setPicByte(compressZLib(file.getBytes()));
		serviceActualiter.addModifierActualiter(actualite);

	}else {
		actualite.setId(id);
		serviceActualiter.addModifierActualiter(actualite);
	}

	
//	return ResponseEntity.status(HttpStatus.OK);
	return actualite;
}
//@PutMapping("/actualites/{id}")
//public Actualiter addModifierStatut(@RequestBody Actualiter a , @PathVariable("id") int id) {
//	a.setId(id);
//	serviceActualiter.addModifierActualiter(a);
//	return a;
//}
//select all actualiter
@GetMapping("actualite/actualites")
public List<Actualiter> selectAllActualite(){
	List<Actualiter> table = new ArrayList<Actualiter>();
	final List<Actualiter> retrievedImage = serviceActualiter.selectAllActualiters();
	byte[] picBytee=null;

	for (int i = 0 ; i<retrievedImage.size();i++) {

		int id = retrievedImage.get(i).getId();
		String dicription = retrievedImage.get(i).getDiscription();
		String title = retrievedImage.get(i).getTitle();
		String name  = retrievedImage.get(i).getName();
		String type  = retrievedImage.get(i).getType();
		
		if(retrievedImage.get(i).getPicByte() != null ) {
			 picBytee = decompressZLib(retrievedImage.get(i).getPicByte());		
		}
		else {
			picBytee = null;
		}
		
//		byte[] picByte = decompressZLib(retrievedImage.get(i).getPicByte());
	
		Administrateur admin = retrievedImage.get(i).getAdmin();
		Date createdAt = retrievedImage.get(i).getCreatedAt();
		Date updatedAt = retrievedImage.get(i).getUpdatedAt();
		Actualiter img = new Actualiter(id, title,dicription,name,type,picBytee,admin,createdAt,updatedAt);
		   table.add(img);	  
	}
	return table;
//	return serviceActualiter.selectAllActualiters();
}
//select actualiter by id 
@GetMapping("/actualites/{id}")
public Actualiter selectByIdActualiter(@PathVariable("id") int id)  throws IOException {
		final Optional<Actualiter> retrievedImage = serviceActualiter.selectByIdActualiter(id);
		Actualiter img = new Actualiter(retrievedImage.get().getId(), retrievedImage.get().getTitle(), retrievedImage.get().getDiscription(), retrievedImage.get().getName(), retrievedImage.get().getType(), decompressZLib(retrievedImage.get().getPicByte()), retrievedImage.get().getAdmin(),retrievedImage.get().getCreatedAt(),retrievedImage.get().getUpdatedAt());
		return img;

//	Optional<Actualiter> actualite = serviceActualiter.selectByIdActualiter(id);
//	if (!actualite.isPresent()) {
//		return null;
//	}
//	return actualite.get();
}
////suprimer actualite by id
@DeleteMapping("/actualites/{id}")
public void deletActualite(@PathVariable("id") int id) {
	serviceActualiter.deletActualiter(id);
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
