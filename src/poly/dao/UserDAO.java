package poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.common.JpaUtils;
import poly.model.User;

public class UserDAO extends AbstractEntityDAO<User> {
	public UserDAO() {
		super(User.class);
	}

	public void changePassword(String username, String oldPassword, String newPassword) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();

		String jpql = "select u from User u where u.id =:username and u.password=:password";
		try {
			trans.begin();
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("password", oldPassword);
			User user = new User();
			user = query.getSingleResult();
			if (user == null) {
				throw new Exception("Current password or username are incorrect!");
			}
			user.setPassword(newPassword);
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public User findByUserEmail(String username, String email) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select u from User u where u.id = :username and u.email = :email";
		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("email", email);

			return query.getSingleResult();
		} finally {
			em.close();
		}
	}

	public boolean checkLoginTrue(String id, String password) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "select u from User u where u.id = :id and u.password = :password";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		try {
			User u = query.getSingleResult();
			if (u.getId().equals(id) && u.getPassword().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
