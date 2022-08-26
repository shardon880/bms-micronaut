package bms.micronaut.services;


import bms.micronaut.DAO.UserModelDAO;
import bms.micronaut.models.UserModel;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserService {

    @Inject
    UserModelDAO userModelDao;

    public String saveUser(UserModel user) throws Exception {
         userModelDao.saveUser(user);
        return "saved";
    }

}