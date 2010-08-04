package com.ncrash.code.uuid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.safehaus.uuid.UUIDGenerator;

/**
 * UUIDExampleTest.java
 * 
 * @author ncrash
 * @since 2010. 2. 11.
 * @see
 */
public class UUIDExampleTest {

	UUIDGenerator uuid_gen1; 
	UUIDGenerator uuid_gen2; 
	UUIDGenerator uuid_gen3; 
	
	@Before
	public void setUp() throws Exception {
		uuid_gen1 = UUIDGenerator.getInstance();
		uuid_gen2 = UUIDGenerator.getInstance();
		uuid_gen3 = UUIDGenerator.getInstance();
	}
	
	@Test
	public void uuidGeneratorExample() {
        assertTrue("uuid_gen1 == uuid_gen2 was not true",
                uuid_gen1 == uuid_gen2);
        assertTrue("uuid_gen2 == uuid_gen3 was not true",
                uuid_gen2 == uuid_gen3);
        assertTrue("uuid_gen1 == uuid_gen3 was not true",
                uuid_gen1 == uuid_gen3);	
	}
	
	@Test
	public void uuidGeneratorUniqueValues() {
		assertNotSame(uuid_gen1.generateTimeBasedUUID(), uuid_gen2.generateTimeBasedUUID());
		assertNotSame(uuid_gen2.generateTimeBasedUUID(), uuid_gen3.generateTimeBasedUUID());
		assertNotSame(uuid_gen3.generateTimeBasedUUID(), uuid_gen1.generateTimeBasedUUID());
	}
}
