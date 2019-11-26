package com.perrosmongodb.db;

import com.perrosmongodb.model.Perro;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


public class DatabaseManager {

	
		public void addPerro(Perro perro) {
			MongoClient client = MongoClients.create();
			MongoDatabase myDb= client.getDatabase("veterinaria"); 	//genera la base de datos
			MongoCollection<Document>perrosCollection
													= myDb.getCollection("perros"); //select 
			
			Document perroDoc = new Document("nombre",perro.getNombre()) //genera los documentos
					.append("edad",perro.getEdad())
					.append("color",perro.getColor())
					.append("raza",perro.getRaza())
					.append("peso",perro.getPeso())
					.append("esta vivo",perro.isEstaVivo());
			
			perrosCollection.insertOne(perroDoc); 	//inserta documentos ...create
			
			
			client.close(); //cierra el cliente
		}
}
