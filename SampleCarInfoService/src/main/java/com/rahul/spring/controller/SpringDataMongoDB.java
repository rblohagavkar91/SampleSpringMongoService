package com.rahul.spring.controller;
import java.net.UnknownHostException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.MongoClient;
import com.rahul.spring.pojo.CarDetails;

public class SpringDataMongoDB {

	public static final String DB_NAME = "sampledb";
	public static final String PERSON_COLLECTION = "samplecollection";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;

//	public static void main(String[] args) {
//		try {
//			MongoClient mongo = new MongoClient(
//					MONGO_HOST, MONGO_PORT);
//			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
//			CarDetails p = new CarDetails();
//			//p.setId(10);
//			p.setManufacturerName("Honda");
//			p.setManufacturingYear("2011");
//			p.setModel("cityZX ");
//			System.out.println("11111111111");
//			mongoOps.insert(p, PERSON_COLLECTION);
//			System.out.println("222222222");
//			
//			CarDetails p1 = mongoOps.findOne(new Query(Criteria.where("model").is("cityZX ")),
//					CarDetails.class, PERSON_COLLECTION);
//			CarDetails p1 = mongoOps.findOne(
//					new Query(Criteria.where("name").is("PankajKr")),
//					CarDetails.class, PERSON_COLLECTION);
//
//			System.out.println(p1.getManufacturerName());
//			
//			mongoOps.dropCollection(PERSON_COLLECTION);
//			mongo.close();
//		}
//		catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		catch (Exception ex){
//			ex.printStackTrace();
//		} 
//	}
	
	public boolean insertDetails(String registrationNumber,String model,String manufacturerName,String manufacturingYear)
	{
		boolean register = false;
		try {
			MongoClient mongo = new MongoClient(
					MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			CarDetails p = new CarDetails();
			p.setRegistrationNumber(registrationNumber);
			p.setManufacturerName(manufacturerName);
			p.setManufacturingYear(manufacturingYear);
			p.setModel(model);
			mongoOps.insert(p, PERSON_COLLECTION);
			mongo.close();
			register = true;
		} catch (UnknownHostException e) {
			register = false;
			e.printStackTrace();
		}
		catch (Exception ex){
			register = false;
			ex.printStackTrace();
		}
		return register;
	}

	public CarDetails searchDetails(String key)
	{
		CarDetails searchRes = null;
		try {
			MongoClient mongo = new MongoClient(
					MONGO_HOST, MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			searchRes = mongoOps.findOne(new Query(Criteria.where("registrationNumber").is(key)),
					CarDetails.class, PERSON_COLLECTION);
			System.out.println("Search Respone :"+searchRes);
			mongo.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return searchRes;
	}
}