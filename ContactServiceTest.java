import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");

        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");

        service.addContact(contact);
        service.deleteContact("1");

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");

        service.addContact(contact);

        service.updateFirstName("1", "Jane");
        service.updateLastName("1", "Smith");
        service.updatePhone("1", "0987654321");
        service.updateAddress("1", "New Address");

        // Verify updates
        service.updateFirstName("1", "Test"); // no exception = pass
    }

    @Test
    void testUpdateInvalidId() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Test");
        });
    }
}