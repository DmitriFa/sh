package hiber.service;

import hiber.config.AppConfig;
import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarDao carDao;

   @Transactional
  @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
     return userDao.listUsers();
   }
   @Transactional
   @Override
   public void add(Car car) {
      carDao.add(car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return carDao.listCars();
   }

}
