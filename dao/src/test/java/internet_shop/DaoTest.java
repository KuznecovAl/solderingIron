package internet_shop;

import org.junit.Assert;

import java.sql.SQLException;
import java.time.LocalDate;


public class DaoTest  {

    private UserDao userDao = UserDaoImpl.getInstance();

    @org.junit.Test
    public void DaoUserTest () throws SQLException {

        int beforeSave = userDao.getAll().size();
        User newUser = userDao.save(new User("Alex", "1qaz2wsx", "Alexandr", "Kuznecov",
                "0", "xxXXxX@mail.ru", "+375297515313", "Минск", "Германовская",
                "17", "107", "002034", "ruRU", "reg", LocalDate.parse("2018-01-01")));
        int afterSave = userDao.getAll().size();
        Assert.assertNotSame(beforeSave, afterSave);

        newUser.setEmail("1234@mail.ru");
        userDao.update(newUser);

        User updatedUser = userDao.get(newUser.getId());
        Assert.assertEquals("Метод update не корректен", "1234@mail.ru", updatedUser.getEmail());

        userDao.delete(newUser.getId());

        afterSave = userDao.getAll().size();
        Assert.assertEquals(beforeSave, afterSave);



    }


}
