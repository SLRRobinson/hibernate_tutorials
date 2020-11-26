package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modell.Customer;

public class PersonController {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			Customer theCustomer = new Customer("Roy", "Robinson", "infos@gscs", "Eggematt 3,2544 Bettlach");
			Customer theCustomers = new Customer("Angela", "Robinson", "angela@gscs", "Eggematt 6,2544 Bettlach");
			session.beginTransaction();

			session.save(theCustomer);
			session.save(theCustomers);

			// Retrieve customer from database using primary key
			Customer myCustomer = session.get(Customer.class, theCustomer.getId());

			// Retrieving all Customer
			@SuppressWarnings("unchecked")
			List<Customer> cus = session.createQuery("from Customer").getResultList();

			// Retrieving Customer using lastName
			@SuppressWarnings("unchecked")
			List<Customer> cuss = session.createQuery("from Customer c where c.lastName='Robinson'").getResultList();

			// Retrieving Customer OR
			@SuppressWarnings("unchecked")
			List<Customer> customer = session
					.createQuery("from Customer c where c.lastName='Robinson'" + "OR c.firstName='Roy'")
					.getResultList();
			
			// Update a Customer
			int customerId=2;
			Customer upCustomer= session.get(Customer.class, customerId);
			
			// update first name to "Aaron"
			upCustomer.setFirstName("Aaron");
			
			int cusId=4;
			//delete customer
			//Customer delCustomer= session.get(Customer.class, cusId);
			//session.delete(delCustomer);
			
			// Another way of deleting
			session.createQuery("delete from Customer where id=4")
			.executeUpdate();

			// committing transaction
			session.getTransaction().commit();

			System.out.println(theCustomer.toString());
			System.out.println(myCustomer.toString());
			System.out.println(upCustomer.toString());

		} finally {
			factory.close();
		}

	}
}
