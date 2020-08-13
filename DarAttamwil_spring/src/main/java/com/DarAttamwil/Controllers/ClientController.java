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
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.DarAttamwil.Entity.Administrateur;
import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Entity.Financements;
import com.DarAttamwil.Entity.Roles;
import com.DarAttamwil.Entity.Villes;
import com.DarAttamwil.Services.IserviceClient;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired private IserviceClient serviceClient;
	@Autowired private  ServletContext context;
//ajouter Client
@PostMapping(value = "/login/clients")
public void addClient(@RequestPart(value = "imageFile"  , required=false) MultipartFile file ,@RequestParam("client") String client) throws IOException {
 Clients clt = new ObjectMapper().readValue(client, Clients.class);
	if (file != null) {
		clt.setName(file.getOriginalFilename());
		clt.setType(file.getContentType());
		clt.setPicByte(compressZLib(file.getBytes()));
			serviceClient.addModifierClient(clt);
		}else {
			serviceClient.addModifierClient(clt);
		}
}

//selection tous les Clients
@GetMapping("/clients")
public List<Clients> selectAllClient(){
	List<Clients> table = new ArrayList<Clients>();
	final List<Clients> retrievedImage =  serviceClient.selectAllClient();
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
		String adresse = retrievedImage.get(i).getAdresse();
		int age = retrievedImage.get(i).getAge();
		String telephone = retrievedImage.get(i).getTelephone();
		String fonction = retrievedImage.get(i).getFonction();
		String typeDeBesion = retrievedImage.get(i).getTypeDeBesion();
		float revenueNet = retrievedImage.get(i).getRevenueNet();
		float autreRevenue = retrievedImage.get(i).getAutreRevenue();
		float chargeLocative = retrievedImage.get(i).getChargeLocative();
	    Roles role =  retrievedImage.get(i).getRole();
	    Villes ville = retrievedImage.get(i).getVille();
		Financements financement  = retrievedImage.get(i).getFinancement();
		
		if(retrievedImage.get(i).getPicByte() != null ) {
			 picBytee = decompressZLib(retrievedImage.get(i).getPicByte());		
		}
		else {
			picBytee = null;
		}
//		byte[] picByte = decompressZLib(retrievedImage.get(i).getPicByte());
      
		Clients img = new Clients(id, nom, prenom, role, email, password, name, type, picBytee, createdAt, updatedAt, adresse, age, telephone, fonction, typeDeBesion, revenueNet, 
				autreRevenue, chargeLocative, ville, financement);
		   table.add(img);	  
	}
	return table;
//	return serviceClient.selectAllClient();
}
//selectionner par id Client
@GetMapping("/clients/{id}")
public Clients selectByIdClient(@PathVariable("id") int id) throws IOException {
	final Optional<Clients> retrievedImage = serviceClient.selectByIdClient(id);
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
	String adresse = retrievedImage.get().getAdresse();
	int age = retrievedImage.get().getAge();
	String telephone = retrievedImage.get().getTelephone();
	String fonction = retrievedImage.get().getFonction();
	String typeDeBesion = retrievedImage.get().getTypeDeBesion();
	float revenueNet = retrievedImage.get().getRevenueNet();
	float autreRevenue = retrievedImage.get().getAutreRevenue();
	float chargeLocative = retrievedImage.get().getChargeLocative();
    Roles role =  retrievedImage.get().getRole();
    Villes ville = retrievedImage.get().getVille();
	Financements financement  = retrievedImage.get().getFinancement();
	
	if(retrievedImage.get().getPicByte() != null ) {
		 picBytee = decompressZLib(retrievedImage.get().getPicByte());		
	}
	else {
		picBytee = null;
	}
//	byte[] picByte = decompressZLib(retrievedImage.get(i).getPicByte());
  
	Clients img = new Clients(idC, nom, prenom, role, email, password, name, type, picBytee, createdAt, updatedAt, adresse, age, telephone, fonction, typeDeBesion, revenueNet, 
			autreRevenue, chargeLocative, ville, financement);
	   	  
return img;
	
//	return serviceClient.selectByIdClient(id).map(client ->{
//		return serviceClient.selectByIdClient(id).get();
//	}).orElseThrow(()-> new Error());
}
//modifier un client
@PatchMapping(value="/clients/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
@ResponseBody
public Clients updateClient(@RequestPart(value = "file" , required=false) MultipartFile file ,@RequestParam("user") String user,@PathVariable("id") int id) throws IOException,JsonParseException,JsonMappingException {
	Clients clt = new ObjectMapper().readValue(user, Clients.class);

    if (file!=null) {
    	clt.setId(id);
    	clt.setName(file.getOriginalFilename());
		clt.setType(file.getContentType());
		clt.setPicByte(compressZLib(file.getBytes()));
			serviceClient.addModifierClient(clt);

        }else {
        	clt.setId(id);
        	 serviceClient.addModifierClient(clt);	
        }
    return clt;
}
//suprimer Client by id
@DeleteMapping("/clients/{id}")
public void deletClient(@PathVariable("id") int id) {
	serviceClient.deletClient(id);
}
//recherche d'un client par nom ou prenom
@GetMapping("/clients/search")
public List<Clients> findClientByFnameOrLname(@RequestParam(value = "nom" , required=false) String nom 
		                                      , @RequestParam(value = "prenom" , required = false) String prenom){
	return serviceClient. findAllClientByNomAndPrenom(nom, prenom);
}
//selection tous les client par type
@GetMapping("/clients/type")
public  List<Clients> findAllClientByType(@RequestParam(value = "type" , required=false) String  type){
	return serviceClient.findAllClientByType(type);
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
