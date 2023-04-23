package com.harman.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.harman.entity.Employee;
import com.harman.util.HibernateConfig;


public class EmpDaoImpl implements EmpDao{

	public EmpDaoImpl() {
		//default constructor	
	}
	@Override
	public void saveEmp(Employee user) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateEmp(Employee user) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmp(int id) {

		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Employee user = session.get(Employee.class, id);
			if (user != null) {
				session.delete(user);
				System.out.println("Employee is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmp(int id) {

		Transaction transaction = null;
		Employee user = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(Employee.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmp() {

		Transaction transaction = null;
		List<Employee> listOfUser = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object

			listOfUser = session.createQuery("from Employee").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}
}
