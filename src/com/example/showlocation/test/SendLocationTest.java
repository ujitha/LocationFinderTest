package com.example.showlocation.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.example.showlocation.FriendsList;
import com.example.showlocation.SMShandler;
import com.jayway.android.robotium.solo.Solo;

public class SendLocationTest extends
		ActivityInstrumentationTestCase2<SMShandler> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public SendLocationTest() {
		super("com.example.showlocation", SMShandler.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	public void testSearch() {

		solo.assertCurrentActivity("Check on SMShandler activity",
				SMShandler.class);
		Assert.assertTrue(solo.searchText(""));
		solo.clickOnButton("Search");
		// check whether clicking search button will start the FriendList
		// activity
		solo.assertCurrentActivity("Expected Friend List activity",
				FriendsList.class);
		solo.clickOnMenuItem("Ujitha");
		// check whether after clicking "Ujitha" menu item in Friend List it
		// will start the SMShandler activity
		solo.assertCurrentActivity("Expected SMShandler activity",
				SMShandler.class);
		// check whether the Ujitha's phone number will appear in the Edit text
		// box in SMShandler

		Assert.assertTrue(solo.searchEditText("0718948256"));
	}
}
