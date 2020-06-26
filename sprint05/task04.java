import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Person {
    private String firstName;
    private String lastName;
    private String idCode;


    private static Pattern patternName = Pattern.compile("[A-Z]{1}[a-z]{1,23}");
    private static Pattern patternCode = Pattern.compile("[0-9]{10}");

    public void setFirstName(String firstName) throws NameException {
        Matcher matcher = patternName.matcher(firstName);
        if (matcher.matches()) {
            this.firstName = firstName;
        } else
            throw new NameException("Incorrect value " + firstName + " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)");
    }

    public void setLastName(String lastName) throws NameException {
        Matcher matcher = patternName.matcher(lastName);
        if (matcher.matches()) {
            this.lastName = lastName;
        } else
            throw new NameException("Incorrect value " + lastName + " for lastName (should start from upper case and contains only alphabetic characters and symbols -, _)");
    }

    public void setIdCode(String idCode) throws CodeException {
        Matcher matcher = patternCode.matcher(idCode);
        if (matcher.matches()) {
            this.idCode = idCode;
        } else throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        String msg = "";
        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            msg = e.getMessage();
        } finally {
            try {
                person.setLastName(lastName);
            } catch (NameException e) {
                if (!msg.isEmpty()) {
                    msg += "; " + e.getMessage();
                } else msg = e.getMessage();
            } finally {
                try {
                    person.setIdCode(idCode);
                } catch (CodeException e) {
                    if (!msg.isEmpty()) {
                        msg += "; " + e.getMessage();
                    } else msg = e.getMessage();
                } finally {
                    if (!msg.isEmpty()) {
                        throw new IllegalArgumentException(msg);
                    }
                    return person;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        return idCode != null ? idCode.equals(person.idCode) : person.idCode == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (idCode != null ? idCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}

class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String message) {
        super(message);
    }
}
