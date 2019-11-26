package com.perrosmongodb.db;

import com.perrosmongodb.model.Perro;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;


public class DatabaseManager {

	
		public void addPerro(Perro perro) {
			MongoClient client = MongoClients.create();
			MongoDatabase myDb= client.getDatabase("veterinaria"); 	//genera la base de datos
			MongoCollection<Document>perrosCollection
													= myDb.getCollection("perros"); //select 
			
			//preparando los datos
			Document perroDoc = new Document("nombre",perro.getNombre()) //genera los documentos
					.append("edad",perro.getEdad())
					.append("color",perro.getColor())
					.append("raza",perro.getRaza())
					.append("peso",perro.getPeso())
					.append("esta vivo",perro.isEstaVivo());
			
			perrosCollection.insertOne(perroDoc); 	//inserta documentos ...create
			
			
			client.close(); //cierra el cliente
		}
		
		public List<Perro> getPerros(){
			MongoClient client = MongoClients.create();
			MongoDatabase myDb= client.getDatabase("veterinaria"); 	//genera la base de datos
			MongoCollection<Document>perrosCollection
													= myDb.getCollection("perros"); //select 
			
			//regresa los perros o atributos añadidos a la db que contega los documentos
			//sustitulle el result set
			List<Perro> listPerros = new ArrayList<>();
			
			MongoCursor<Document> iterator = perrosCollection.find().iterator();
			while(iterator.hasNext()) {
				Document doc= iterator.next();
				Perro perro = new Perro();
				
				perro.setNombre(doc.getString("nombre"));
				perro.setEdad(doc.getInteger("edad"));
				perro.setColor(doc.getString("color"));
				perro.setPeso(doc.getDouble("peso").floatValue());
				perro.setEstaVivo(doc.getBoolean("estaVivo"));
				perro.setRaza(doc.getString("raza"));
				
				listPerros.add(perro);
			}
			client.close();
			return listPerros;
			
		}
		
}
