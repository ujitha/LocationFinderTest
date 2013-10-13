package com.example.showlocation.test;

import com.example.showlocation.FriendsSettings;
import com.example.showlocation.LocationList;
import com.example.showlocation.MapLocation;
import com.example.showlocation.Menu;
import com.example.showlocation.MovingmodeOption;
import com.example.showlocation.Myinfo;
import com.example.showlocation.RequestLocation;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class menuTest extends ActivityInstrumentationTestCase2<Menu> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public menuTest() {
		super("com.example.showlocation", Menu.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {

		solo.finishOpenedActivities();
		super.tearDown();
	}

	public void testShowLocation() {
		solo.assertCurrentActivity("Check on menu activity", Menu.class);
		solo.clickOnMenuItem("Show My Location");
		solo.assertCurrentActivity("Expected Map activity", MapLocation.class);
		solo.goBack();

	}

	public void testRequestLoacation() {
		solo.clickOnMenuItem("Request location");
		solo.assertCurrentActivity("Expected request location activity",
				RequestLocation.class);
		solo.goBack();
	}

	public void testMovingMode() {
		solo.clickOnMenuItem("Moving mode");
		solo.assertCurrentActivity("Expected Moving mode option activity",
				MovingmodeOption.class);
		solo.goBack();
	}

	public void testFriendSettings() {

		solo.clickOnMenuItem("Friends");
		solo.assertCurrentActivity("Expected friend settings acivity",
				FriendsSettings.class);
		solo.goBack();
	}
	
	public void testHistory()
	{
		solo.clickOnMenuItem("History");
		solo.assertCurrentActivity("Expected LocationList activity",LocationList.class);
		solo.goBack();
	}
	
	public void testMyinfo()
	{
		solo.clickOnMenuItem("My Info");
		solo.assertCurrentActivity("Expected Myinfo activity",Myinfo.class);
		solo.goBack();
		
	}

}
