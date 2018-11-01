package ua.nure.kn16.potapov.usermanagement;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import junit.framework.*;
import ua.nure.kn16.potapov.usermanagement.User;

class UserTest extends TestCase {
  
   public  long id = 1L;
      public  String Name = "Dmitriy";
      public  String Surname = "Potapov";

      private  int YearBirth = 1999;

      private static int today;

      private User user;

      @Before
      public void setUp() throws Exception {
          user = new User(id, Name, Surname, new Date());
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(new Date());
          today = calendar.get(Calendar.DATE);
      }


      @Test
      public void FullName() {
          User user = new User(id, Name, Surname, null);
          assertEquals("Dmitriy, Potapov", user.FullName());
      }

      @Test
      public void AgeTheSameDayOfBirthday() {
          Calendar calendar = Calendar.getInstance();
          calendar.set(YearBirth, Calendar.NOVEMBER, today);
          User user = new User(id, Name, Surname, calendar.getTime());
          assertEquals(19, user.getAge());
      }
      
      @Test
      public void AgeAfterBirthday() {
          Calendar calendar = Calendar.getInstance();
          calendar.set(YearBirth, Calendar.OCTOBER, 16);
          User user = new User(id, Name, Surname, calendar.getTime());
          assertEquals(19, user.getAge());
      }

      @Test
      public void AgeBeforeBirthday() {
          Calendar calendar = Calendar.getInstance();
          calendar.set(YearBirth, Calendar.NOVEMBER, 28);
          User user = new User(id, Name, Surname, calendar.getTime());
          assertEquals(18, user.getAge());
      }
    
  }