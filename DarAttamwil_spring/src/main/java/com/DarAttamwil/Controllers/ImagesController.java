package com.DarAttamwil.Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DarAttamwil.Entity.Actualiter;
import com.DarAttamwil.Entity.ImageModel;
import com.DarAttamwil.Services.IserviceActualiter;
import com.DarAttamwil.Services.IserviceImages;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ImagesController {
@Autowired private IserviceImages serviceImage;
@Autowired private IserviceActualiter serviceActualiter;
@PostMapping("/images")
public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
//	Actualiter actualite = new ObjectMapper().readValue(actualiter, Actualiter.class);
	
//	Actualiter a = serviceActualiter.selectByIdActualiter(id).get();
	
//	ImageModel m = new ImageModel();
//	int a = m.getActualite().getId();
	System.out.println("Original Image Byte Size - " + file.getBytes().length);
//	Actualiter a = new Actualiter();
	ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
			compressZLib(file.getBytes()));
	serviceImage.uplaodImage(img);
	return ResponseEntity.status(HttpStatus.OK);
}
//modifier image

@PutMapping("/images/{id}")
public BodyBuilder updateImage(@PathVariable("id") Long id,@RequestParam("imageFile") MultipartFile file) throws IOException {
//	Actualiter a = serviceActualiter.selectByIdActualiter(idActualite).get();
	System.out.println("Original Image Byte Size - " + file.getBytes().length);
	ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
			compressZLib(file.getBytes()));
	img.setId(id);
	serviceImage.uplaodImage(img);
	return ResponseEntity.status(HttpStatus.OK);
}

//suprimer image
@DeleteMapping("/images/{id}")
public void deletImage(@PathVariable("id") Long id) {
	serviceImage.deletImage(id);
}
@GetMapping(path = { "/images/name/{imageName}" })
public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {

	final Optional<ImageModel> retrievedImage = serviceImage.findByName(imageName);
	ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
			decompressZLib(retrievedImage.get().getPicByte()));
	return img;
}

//
//@GetMapping(path = { "/images/{idActualite}/{imageName}" })
//public ImageModel findByActualite(@PathVariable("idActualite") int idActualite ,@PathVariable("imageName") String imageName) throws IOException {
//
//	final Optional<ImageModel> retrievedImage = serviceImage.findByActualite(imageName,idActualite);
////	for (int i = 0 ; i<retrievedImage.size();i++) {
//	ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
//			decompressZLib(retrievedImage.get().getPicByte()));
//	return img;
////	ImageModel img = new ImageModel(((MultipartFile) retrievedImage).getName(), ((ImageModel) retrievedImage).getType(),
////			decompressZLib(((ImageModel) retrievedImage).getPicByte()));
////	return img;
//}
//getall
@GetMapping("/images")
public List<ImageModel> selectAllSimulation(){
		List<ImageModel> table = new ArrayList<ImageModel>();
		final List<ImageModel> retrievedImage = serviceImage.selectAllImage();
		for (int i = 0 ; i<retrievedImage.size();i++) {
			String a  = retrievedImage.get(i).getName();
			String b  = retrievedImage.get(i).getType();
			byte[] c = decompressZLib(retrievedImage.get(i).getPicByte());
			ImageModel img = new ImageModel(a, b,c);
			   table.add(img);
			   System.out.println(table);		  
		}
		return table;
}
//@GetMapping(path = { "/ge/images/{idActualite}" })
//public ImageModel findByAc(@PathVariable("idActualite") int idActualite) throws IOException {
//	final Optional<ImageModel> retrievedImage = serviceImage.findBytest(idActualite);
//	ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
//			decompressZLib(retrievedImage.get().getPicByte()));
//	return img;
//}
//
//@GetMapping(path = { "/get/images/{idActualite}" })
//public List<ImageModel> findIdByActualite(@PathVariable("idActualite") int idActualite) throws IOException {
//	List<ImageModel> table = new ArrayList<ImageModel>();
//
//	final List<ImageModel> retrievedImage = serviceImage.findByIdActualite(idActualite);
//	for (int i = 0 ; i<retrievedImage.size();i++) {
//		String a  = retrievedImage.get(i).getName();
//		String b  = retrievedImage.get(i).getType();
//		byte[] c = decompressZLib(retrievedImage.get(i).getPicByte());
//		ImageModel img = new ImageModel(a, b,c);
//		   table.add(img);
//		   System.out.println(table);
//		  
//	}
//	return table;
//	
//	
////	ImageModel m = new ImageModel();
////	String a  = retrievedImage.get(idActualite).getName();
////	String b  = retrievedImage.get(idActualite).getType();
////	byte[] c = decompressZLib(retrievedImage.get(idActualite).getPicByte());
//	
//
////	ImageModel img = new ImageModel(a, b,c);
//	
//
//}

// compress the image bytes before storing it in the database
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

// uncompress the image bytes before returning it to the angular application
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
