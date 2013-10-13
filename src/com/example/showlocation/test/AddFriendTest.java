package com.example.showlocation.test;

import com.example.showlocation.AddFriend;
import com.example.showlocation.FriendsList;
import com.example.showlocation.FriendsSettings;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class AddFriendTest extends
		ActivityInstrumentationTestCase2<FriendsSettings> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public AddFriendTest() {
		super("com.example.showlocation", FriendsSettings.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());

	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	// check whether Add new friend is added to the database and show in the
	// Friend List
	public void testAddFriend() {
		solo.assertCurrentActivity("Check on FriendsSetting activity",
				FriendsSettings.class);
		solo.clickOnMenuItem("Add new Friend");
		solo.assertCurrentActivity("Expected Add Friend activity",
				AddFriend.class);
		// Enter name Iroshan
		solo.enterText(0, "Iroshan");
		// Enter phone number
		solo.enterText(1, "0772839987");
		// Click Add button to add the new friend
		solo.clickOnButton("Add");
		// Check whether new friend is added to the database
		assertTrue(solo
				.waitForText("New friend contact is successfully added "));
		solo.goBack();
		solo.assertCurrentActivity("Expected FriendsSettings activity",
				FriendsSettings.class);
		solo.goBack();

	}
	
	//Check whether the new friend is shown in the Friends List
	public void testFriendShowinList()
	{
		solo.assertCurrentActivity("Check on FriendsSetting activity",FriendsSettings.class);
		solo.clickOnMenuItem("Search Friends");
		solo.assertCurrentActivity("Expected FriendList activity",FriendsList.class);
		assertTrue(solo.searchText("Iroshan"));
		solo.goBack();
	}

}
