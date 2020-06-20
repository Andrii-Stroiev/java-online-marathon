import java.util.*;

public class AddressBook implements Iterable<String> {
    private NameAddressPair[] addressBook;
    private static int counter = 0;


    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if (counter == (addressBook.length - 1)) {
            NameAddressPair[] nameAddressPair = addressBook;
            addressBook = new NameAddressPair[addressBook.length * 2];
            for (int i = 0; i < nameAddressPair.length; i++) {
                addressBook[i] = nameAddressPair[i];
            }
        }
        AddressBook.NameAddressPair.Person person = new AddressBook.NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < addressBook.length; i++) {

            if (addressBook[i] != null && addressBook[i].person.equals(person)) return false;
        }
        addressBook[counter] = (new NameAddressPair(person, address));
        counter++;
        return true;
    }

    public String read(String firstName, String lastName) {
        AddressBook.NameAddressPair.Person person = new AddressBook.NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < addressBook.length; i++) {

            if (addressBook[i] != null && addressBook[i].person.equals(person)) {
                return addressBook[i].address;
            }
        }
        return null;
    }


    public boolean update(String firstName, String lastName, String address) {
        AddressBook.NameAddressPair.Person person = new AddressBook.NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < addressBook.length; i++) {

            if (addressBook[i] != null && addressBook[i].person.equals(person)) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        AddressBook.NameAddressPair.Person person = new AddressBook.NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < addressBook.length; i++) {
            if (addressBook[i] != null && addressBook[i].person.equals(person)) {
                int numberOfElements = addressBook.length;
                for (int j = i; j < numberOfElements -1 ; j++) {
                    addressBook[j] = addressBook[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    public int size() {
        int numberOfElements = 0;
        for (int i = 0; i < addressBook.length; i++) {
            if (addressBook[i] != null) {
                numberOfElements++;
            }
        }
        return numberOfElements;
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                Arrays.sort(addressBook,0,size(), new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if (o1 != null && o2 == null) {
                            return -1;
                        }
                        if (o1 == null && o2 != null) {
                            return 1;
                        }
                        if (o1 == null && o2 == null) {
                            return 0;
                        } else return o1.person.toString().compareTo(o2.person.toString());
                    }
                });
                break;
            case DESC:
                Arrays.sort(addressBook, 0,size(), Collections.reverseOrder(new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if (o1 != null && o2 == null) {
                            return -1;
                        }
                        if (o1 == null && o2 != null) {
                            return 1;
                        }
                        if (o1 == null && o2 == null) {
                            return 0;
                        } else return o1.person.toString().compareTo(o2.person.toString());
                    }
                }));
                break;
        }

    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return new AddressBookIterator().hasNext();
            }

            @Override
            public String next() {
                return new AddressBookIterator().next();
            }
        };
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        public boolean hasNext() {
            if (addressBook.length > counter) {
                return true;
            } else return false;
        }

        public String next() {

            return addressBook[counter++].toString();
        }


    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }


        @Override
        public String toString() {
            return person.toString() + ", Address: " + address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public String toString() {
                return
                        "First name: " + firstName + ", " +
                                "Last name: " + lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o.getClass() != Person.class) return false;

                Person person = (Person) o;

                if (!firstName.equals(person.firstName)) return false;
                return lastName.equals(person.lastName);
            }

            @Override
            public int hashCode() {
                int result = firstName.hashCode();
                result = 31 * result + lastName.hashCode();
                return result;
            }
        }
    }

    @Override
    public String toString() {
        return "{ " + Arrays.toString(addressBook) +
                " }";
    }
}

enum SortOrder {
    ASC,
    DESC
}
