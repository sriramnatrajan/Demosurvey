package com.biits.demosurvey.controller;

public class AppConfig {
	// Server user login url
	public static String URL_LOGIN = "http://139.59.21.138/demo/login.php";

	// Server user role retrive
	public static String URL_USER_RETRIVE = "http://139.59.21.138/demo/user_role_retrive.php";

	// Server register user to User Table
	public static String URL_USER_REGISTRATION = "http://139.59.21.138/demo/register_user.php";

	// Server retrive all user in the company
	public static String URL_All_USER = "http://139.59.21.138/demo/display_all_user.php?User_CompanyId=";


	// Server get single user Details
	public static String URL_USER_DETAILS = "http://139.59.21.138/demo/display_user.php";

	// Server get Assign user Role
	public static String URL_USER_ROLE_ASSIGN = "http://139.59.21.138/demo/user_role_assign.php";

	// Server get Company Project Lists
	public static String URL_COMPANY_PROJECT_LIST = "http://139.59.21.138/demo/retrive_companyProject.php";

	// Server get  Project Survey  Lists
	public static String URL_PROJECT_SURVEY_LIST = "http://139.59.21.138/demo/display_survey.php";

	// Server geting  Question List for Survey
	public static String URL_SURVEY_QUESTION_LIST = "http://139.59.21.138/demo/retrive_quetion_options.php";

	// Server to store  URL_ANSWER_RESPONSE List for Survey
	public static String URL_ANSWER_RESPONSE = "http://139.59.21.138/demo/store_answeroption.php";

	// Server to store  URL_PREASSESMENT List for Survey
	public static String URL_SURVEY_PREASSESMENT = "http://139.59.21.138/demo/retrive_preassesment_question.php";

	// Server register Responder to ResponderProfile Table
	public static String URL_RESPONDER_REGISTRATION = "http://139.59.21.138/demo/register_Respondent.php";

	// Server Update Responder to ResponderProfile Table
	public static String URL_RESPONDER_UPDATE = "http://139.59.21.138/demo/responder_update.php";

}
