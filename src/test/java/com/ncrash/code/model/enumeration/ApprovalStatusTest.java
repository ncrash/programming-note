package com.ncrash.code.model.enumeration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * ApprovalStatus.java
 * 
 * @author ncrash
 * @since 2009. 12. 3.
 * @see ApprovalStatus
 */
public class ApprovalStatusTest {
	private String wait;
	private String deny;
	private String approval;
	
	@Before public void setup() {
		wait = "W";
		deny = "D";
		approval = "A";
	}
	
	@Test public void verifyWait() {
		assertEquals(wait, ApprovalStatus.Wait.value());
		assertEquals(ApprovalStatus.fromValue(wait), ApprovalStatus.Wait);
	}
	
	@Test public void verifyDeny() {
		assertEquals(deny, ApprovalStatus.Deny.value());
		assertEquals(ApprovalStatus.fromValue(deny), ApprovalStatus.Deny);
	}

	@Test public void verifyApproval() {
		assertEquals(approval, ApprovalStatus.Approval.value());
		assertEquals(ApprovalStatus.fromValue(approval), ApprovalStatus.Approval);
	}
}
