package seedu.address.model.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.commons.util.DateTimeUtil;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Transaction;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        Transaction transaction1 = new Transaction(
                "Buy raw materials", -100, "ABC Company",
                LocalDate.parse("2023-10-10", DateTimeUtil.DEFAULT_DATE_PARSER));
        Transaction transaction2 = new Transaction(
                "Invest", -1000, "Rich Company",
                LocalDate.parse("2024-03-29", DateTimeUtil.DEFAULT_DATE_PARSER));
        Transaction transaction3 = new Transaction(
                "Sell product", 200, "ABC Company",
                LocalDate.parse("2023-11-11", DateTimeUtil.DEFAULT_DATE_PARSER));
        Person[] people = new Person[]{
            new Person(new Name("Alex Yeoh"),
                        new Company("Tech Innovations Pte Ltd"),
                        new Phone("87438807"),
                        new Email("alexyeoh@example.com"),
                        new Address("Blk 30 Geylang Street 29, #06-40"),
                        getTagSet("friends"),
                        List.of(transaction1)),
            new Person(new Name("Bernice Yu"),
                        new Company("Global Solutions Inc."),
                        new Phone("99272758"),
                        new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        getTagSet("colleagues", "friends"),
                        List.of(transaction2)),
            new Person(new Name("Charlotte Oliveiro"),
                        new Company("Creative Designs Co."),
                        new Phone("93210283"),
                        new Email("charlotte@example.com"),
                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        getTagSet("neighbours"),
                        List.of(transaction3)),
            new Person(new Name("David Li"),
                        new Company("Finance Experts Ltd."),
                        new Phone("91031282"),
                        new Email("lidavid@example.com"),
                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        getTagSet("family"),
                        List.of(transaction1, transaction2)),
            new Person(new Name("Irfan Ibrahim"),
                        new Company("Educational Systems Pte Ltd"),
                        new Phone("92492021"),
                        new Email("irfan@example.com"),
                        new Address("Blk 47 Tampines Street 20, #17-35"),
                        getTagSet("classmates"),
                        List.of(transaction2, transaction3)),
            new Person(new Name("Roy Balakrishnan"),
                        new Company("Innovative Solutions Group"),
                        new Phone("92624417"),
                        new Email("royb@example.com"),
                        new Address("Blk 45 Aljunied Street 85, #11-31"),
                        getTagSet("colleagues"),
                        List.of(transaction1, transaction2, transaction3))
        };

        return people;
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a list containing list of transactions given.
     */
    public static List<Transaction> getTransactionList(Transaction... transactions) {
        return Arrays.stream(transactions)
                .collect(Collectors.toList());
    }

}
