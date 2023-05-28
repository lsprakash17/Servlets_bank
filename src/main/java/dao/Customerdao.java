package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class Customerdao
{
EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();

public void save(Customer customer)
{
entityTransaction.begin();
entityManager.persist(customer);
entityTransaction.commit();
}
public List<Customer> check(String Email)
{
	return entityManager.createQuery("select x from Customer x where email=?3").setParameter(3, Email).getResultList();
}

}
