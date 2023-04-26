package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Partner;
import com.infotech.entities.Person;
import com.infotech.entities.Phone;
import com.infotech.entities.PhoneType;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest {
	
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			Person person1 = new Person();
			person1.setName("Mark Bingel");
			person1.setNickName("Mac");
			person1.setAddress("Alameda Street Los Angeles");
			person1.setCreatedOn(new Date());
			person1.setVersion(1);
			
			Phone phone1 = new Phone();
			phone1.setNumber("9073637380");
			phone1.setType(PhoneType.MOBILE);
			phone1.setPerson(person1);
			
			person1.getPhones().add(phone1);
			
			Person person2 = new Person();
			person2.setName("Sean Murphy");
			person2.setNickName("Sam");
			person2.setAddress("Bank of Canada,234 Wellington Street");
			person2.setCreatedOn(new Date());
			person2.setVersion(1);
			
			Phone phone2 = new Phone();
			phone2.setNumber("809865430");
			phone2.setType(PhoneType.MOBILE);
			phone2.setPerson(person2);
			
			Phone phone3 = new Phone();
			phone3.setNumber("022909742");
			phone3.setType(PhoneType.LAND_LINE);
			phone3.setPerson(person2);
			
			person2.getPhones().add(phone2);
			person2.getPhones().add(phone3);
			
			Partner partner = new Partner();
			partner.setName("Sean Murphy");
			partner.setVersion(1);
			
			session.save(person1);
			session.save(person2);
			session.save(partner);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
