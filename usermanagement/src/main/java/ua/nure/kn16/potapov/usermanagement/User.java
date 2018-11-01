package ua.nure.kn16.potapov.usermanagement;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String Name;
    private String Surname;
    private Date YearBirth;

    public User() {
        super();
    }

    public User(Long id, String Name, String Surname, Date YearBirth) {
        super();
        this.id = id;
        this.Name = Name;
        this.Surname = Surname;
        this.YearBirth = YearBirth;
    }

    public Date getYearBirth() {
        return YearBirth;
    }

    public void setYearBirth(Date YearBirth) {
        this.YearBirth = YearBirth;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(Name, user.Name) &&
                Objects.equals(Surname, user.Surname) &&
                Objects.equals(YearBirth, user.YearBirth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, Name, Surname, YearBirth);
    }

    public String FullName() {
        return (new StringBuilder(getName()).append(", ").append(getSurname())).toString();
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDate = calendar.get(Calendar.DATE);

        calendar.setTime(YearBirth);
        final int birthYear = calendar.get(Calendar.YEAR);
        final int birthMonth = calendar.get(Calendar.MONTH);
        final int birthDate = calendar.get(Calendar.DATE);

        int age = currentYear - birthYear;
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDate < birthDate)) {
            --age;
        }

        return age;
    }
}