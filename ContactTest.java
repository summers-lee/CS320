import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

	@Test
	void testFirstNameTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "ThisNameIsTooLong", "Doe", "1234567890", "123 Street");
	    });
	}
	
	@Test
	void testLastNameNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", null, "1234567890", "123 Street");
	    });
	}

	@Test
	void testLastNameTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "ThisNameIsTooLong", "1234567890", "123 Street");
	    });
	}
	
	@Test
	void testAddressNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "Doe", "1234567890", null);
	    });
	}

	@Test
	void testAddressTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "Doe", "1234567890",
	            "This address is definitely longer than thirty characters");
	    });
	}
	
	@Test
    void testValidContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Street");
        assertEquals("123", contact.getContactId());
    }

    @Test
    void testInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Street");
        });
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Street");
        });
    }

    @Test
    void testUpdateFields() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Street");

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Avenue");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Avenue", contact.getAddress());
    }
}