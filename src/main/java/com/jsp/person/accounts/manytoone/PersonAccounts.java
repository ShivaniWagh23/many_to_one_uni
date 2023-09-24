package com.jsp.person.accounts.manytoone;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonAccounts {
public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	Person person= new Person();
	person.setName("shardul Warishe");
	person.setEmail("shardul@mail.com");
	person.setCno(8495672685l);
    person.setGender("male");	
    
    Accounts account1=new Accounts();
    account1.setAccno(856210002354l);
    account1.setBank_name("SBI");
    account1.setIfsc_code("SBI588BVF87");
    
    Accounts account2=new Accounts();
    account2.setAccno(46210002354l);
    account2.setBank_name("hdfc");
    account2.setIfsc_code("HDFC2541");
    
    Accounts account3=new Accounts();
    account3.setAccno(32210002354l);
    account3.setBank_name("Maharashtra");
    account3.setIfsc_code("MAHARASHTRA2541");
    
account1.setPerson(person);    
account2.setPerson(person);
account3.setPerson(person);


//    set a person with multiple accounts
    entityTransaction.begin();
    entityManager.persist(person);
    entityManager.persist(account1);
    entityManager.persist(account2);
    entityManager.persist(account3);
    entityTransaction.commit();
}
}
