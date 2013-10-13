package com.example.showlocation.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.showlocation.AddFriend;
import com.example.showlocation.FriendsList;
import com.example.showlocation.FriendsSettings;
import com.jayway.android.robotium.solo.Solo;

public class FriendsSettingsTest extends ActivityInstrumentationTestCase2<FriendsSettings> {

	private Solo solo;
	@SuppressWarnings("deprecation")
	public FriendsSettingsTest() {
		super("com.example.showlocation",FriendsSettings.class);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}
	
	//Check whether the clicking Search Friends will starts the Friend List activity
	public void testSearchFriend()
	{
		solo.assertCurrentActivity("Check on FriendsSetting activity",FriendsSettings.class);
		solo.clickOnMenuItem("Search Friends");
		solo.assertCurrentActivity("Expected FriendList activity",FriendsList.class);
		solo.goBack();
		solo.assertCurrentActivity("Expected FriendsSetting activity",FriendsSettings.class);
	}
	
	//check whether the clicing Add new Friend will statr Add friend activity
	public void testAddnewFriend()
	{
		solo.assertCurrentActivity("Check on FriendsSetting activity",FriendsSettings.class);
		solo.clickOnMenuItem("Add new Friend");
		solo.assertCurrentActivity("Expected Add Friend activity",AddFriend.class);
		solo.goBack();
		solo.assertCurrentActivity("Expected FriendsSetting activity",FriendsSettings.class);
	}
	
	//Check whether the clicking Edit Friends will starts the Friend List activity
	public void testEditFriend()
	{
		solo.assertCurrentActivity("Check on FriendsSetting activity",FriendsSettings.class);
		solo.clickOnMenuItem("Edit Friend");
		solo.assertCurrentActivity("Expected FriendList activity",FriendsList.class);
		solo.goBack();
		solo.assertCurrentActivity("Expected FriendsSetting activity",FriendsSettings.class);
	}
	
	//Check whether the clicking Delete Friends will starts the Friend List activity
	public void testDeleteFriend()
	{
		solo.assertCurrentActivity("Check on FriendsSetting activity",FriendsSettings.class);
		solo.clickOnMenuItem("Delete Friend");
		solo.assertCurrentActivity("Expected FriendList activity",FriendsList.class);
		solo.goBack();
		solo.assertCurrentActivity("Expected FriendsSetting activity",FriendsSettings.class);
		
	}
}
