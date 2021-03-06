package com.taketicket.constant;

/**
 * 存放都是请求常量
 * 
 * @author Administrator
 * 
 */
public class NetConstant {

	public static int CLIENT_PORT = 6666;
	public static int SERVER_PORT = 8888;

	public static String SERVER_IP = "localhost";

	public static final int CALLER_LOGIN = 1;
	public static final int RESULT_CALLER_LOGIN = 2;

	public static final int TICKETDAO_QUERY_BY_BUSINESSID = 3;
	public static final int RESULT_TICKETDAO_QUERY_BY_BUSINESSID = 4;

	public static final int QUERY_BY_BUSINESS_ID = 5;
	public static final int RESULT_QUERY_BY_BUSINESS_ID = 6;

	public static final int TICKETDAO_QUERY_BY_BUSINESSID1 = 7;
	public static final int RESULT_TICKETDAO_QUERY_BY_BUSINESSID1 = 8;

	public static final int TICKETDAO_QUERY_ALL_BY_ISCALLED = 9;
	public static final int RESULT_TICKETDAO_QUERY_ALL_BY_ISCALLED = 10;

	public static final int TICKETDAO_UPDATE_BY_ID1 = 11;
	public static final int RESULT_TICKETDAO_UPDATE_BY_ID1 = 12;

	public static final int TICKETDAO_UPDATE_BY_ID3 = 13;
	public static final int RESULT_TICKETDAO_UPDATE_BY_ID3 = 14;

	public static final int INSERT_TICKET = 15;
	public static final int RESULT_INSERT_TICKET = 16;

	public static final int BUSINESSDAO_INSERT_BUSINESS = 17;
	public static final int RESULT_BUSINESSDAO_INSERT_BUSINESS = 18;

	public static final int BUSINESSDAO_UPDATE_BUSINESS_BY_CODE = 19;
	public static final int RESULT_BUSINESSDAO_UPDATE_BUSINESS_BY_CODE = 20;

	public static final int RESULT_BUSINESSDAO_UPDATE_BUSINESS_BY_NAME = 21;
	public static final int BUSINESSDAO_UPDATE_BUSINESS_BY_NAME = 22;

	public static final int RESULT_BUSINESSDAO_UPDATE_BUSINESS_BY_ID = 23;
	public static final int UPDATE_BUSINESSDAO_BUSINESS_BY_ID = 24;

	public static final int BUSINESSDAO_QUERY_BY_CODE = 25;
	public static final int RESULT_BUSINESSDAO_QUERY_BY_CODE = 26;

	public static final int BUSINESSDAO_QUERY_BY_NAME = 27;
	public static final int RESULT_BUSINESSDAO_QUERY_BY_NAME = 28;

	public static final int BUSINESSDAO_QUERY_ALL = 29;
	public static final int RESULT_BUSINESSDAO_QUERY_ALL = 30;

	public static final int CALLERDAO_INSERTCALLER = 31;
	public static final int RESULT_CALLERDAO_INSERTCALLER = 32;

	public static final int CALLERDAO_DELETECALLERBYACCOUNT = 33;
	public static final int RESULT_CALLERDAO_DELETECALLERBYACCOUNT = 34;

	public static final int CALLERDAO_UPDATE_PASSWORD_BY_ACCOUNT = 35;
	public static final int RESULT_CALLERDAO_UPDATE_PASSWORD_BY_ACCOUNT = 36;

	public static final int CALLERDAO_DELETE_CALLER_BY_NAME = 37;
	public static final int RESULT_CALLERDAO_DELETE_CALLER_BY_NAME = 38;

	public static final int CALLERDAO_QUERY_BY_NAME = 39;
	public static final int RESULT_CALLERDAO_QUERY_BY_NAME = 40;

	public static final int CALLERDAO_QUERY_BY_ACCOUNT = 41;
	public static final int RESULT_CALLERDAO_QUERY_BY_ACCOUNT = 42;

	public static final int CALLERDAO_QUERY_ALL = 43;
	public static final int RESULT_CALLERDAO_QUERY_ALL = 44;

	public static final int CALLERDAO_UPDATE_DISABLED_BY_ACCOUNT = 45;
	public static final int RESULT_CALLERDAO_UPDATE_DISABLED_BY_ACCOUNT = 46;

	public static final int MANAGERDAO_INSERT_MANAGER = 300;
	public static final int RESULT_MANAGERDAO_INSERT_MANAGER = 301;

	public static final int MANAGERDAO_DELETE_MANAGER_BY_ACCOUNT = 302;
	public static final int RESULT_MANAGERDAO_DELETE_MANAGER_BY_ACCOUNT = 303;

	public static final int MANAGERDAO_DELETE_MANAGER_BY_NAME = 304;
	public static final int RESULT_MANAGERDAO_DELETE_MANAGER_BY_NAME = 305;

	public static final int MANAGERDAO_UPDATE_PASSWORD_BY_ACCOUNT = 306;
	public static final int RESULT_MANAGERDAO_UPDATE_PASSWORD_BY_ACCOUNT = 307;

	public static final int MANAGERDAO_QUERY_BY_ACCOUNT = 308;
	public static final int RESULT_MANAGERDAO_QUERY_BY_ACCOUNT = 309;

	public static final int MANAGERDAO_QUERY_BY_NAME = 310;
	public static final int RESULT_MANAGERDAO_QUERY_BY_NAME = 311;

	public static final int MANAGERDAO_QUERY_ALL = 312;
	public static final int RESULT_MANAGERDAO_QUERY_ALL = 313;

	public static final int MANAGERDAO_UPDATE_DISABLED_BY_ACCOUNT = 314;
	public static final int RESULT_MANAGERDAO_UPDATE_DISABLED_BY_ACCOUNT = 315;

	public static final int TICKETDAO_INSERT_TICKET = 316;
	public static final int RESULT_TICKETDAO_INSERT_TICKET = 317;
	public static final int TICKETDAO_UPDATE_BY_ID = 318;
	public static final int RESULT_TICKETDAO_UPDATE_BY_ID = 319;

	public static final int TICKETDAO_QUERY_BY_DATE = 320;
	public static final int RESULT_TICKETDAO_QUERY_BY_DATE = 321;

	public static final int TICKETDAO_QUERY_BY_ID = 322;
	public static final int RESULT_TICKETDAO_QUERY_BY_ID = 323;

	public static final int TICKETDAO_QUERY_BY_BUSINESS_ID = 324;
	public static final int RESULT_TICKETDAO_QUERY_BY_BUSINESS_ID = 325;

	public static final int TICKETDAO_QUERY_ALL = 326;
	public static final int RESULT_TICKETDAO_QUERY_ALL = 327;

	public static final int TICKETDAO_QUERY_TICKETS_BY_BUSINESS_ID = 328;
	public static final int RESULT_TICKETDAO_QUERY_TICKETS_BY_BUSINESS_ID = 329;

	public static final int TICKETDAO_QUERY_LOG_BY_TICKETVO = 330;
	public static final int RESULT_TICKETDAO_QUERY_LOG_BY_TICKETVO = 331;

	public static final int TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO = 332;
	public static final int RESULT_TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO = 333;

	public static final int TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO1 = 334;
	public static final int RESULT_TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO1 = 335;

	public static final int TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO2 = 336;
	public static final int RESULT_TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO2 = 337;

	public static final int TICKETDAO_QUERY_DATA_BY_TICKETVO = 338;
	public static final int RESULT_TICKETDAO_QUERY_DATA_BY_TICKETVO = 339;

	public static final int TICKETDAO_QUERY_CHECK_BY_TICKETVO = 340;
	public static final int RESULT_TICKETDAO_QUERY_CHECK_BY_TICKETVO = 341;

	public static final int TICKETDAO_QUERY_SUCCESS_BY_TICKETVO = 342;
	public static final int RESULT_TICKETDAO_QUERY_SUCCESS_BY_TICKETVO = 343;

	public static final int WINDOWDAO_QUERY_BY_BUSINESS_NAME_FOR_BUSINESSVO = 344;
	public static final int RESULT_WINDOWDAO_QUERY_BY_BUSINESS_NAME_FOR_BUSINESSVO = 345;

	public static final int WINDOWDAO_QUERY_BY_NUM_FOR_BUSINESSVO = 346;
	public static final int RESULT_WINDOWDAO_QUERY_BY_NUM_FOR_BUSINESSVO = 347;

	public static final int WINDOWDAO_QUERY_ALL_FOR_BUSINESSVO = 348;
	public static final int RESULT_WINDOWDAO_QUERY_ALL_FOR_BUSINESSVO = 349;

	public static final int WINDOWDAO_QUERY_ALL = 350;
	public static final int RESULT_WINDOWDAO_QUERY_ALL = 351;

	public static final int WINDOWDAO_QUERY_WINDOW_BY_BUSINESSID = 352;
	public static final int RESULT_WINDOWDAO_QUERY_WINDOW_BY_BUSINESSID = 353;

	public static final int WINDOWDAO_QUERY_WINDOW_BY_NUM = 354;
	public static final int RESULT_WINDOWDAO_QUERY_WINDOW_BY_NUM = 355;

	public static final int WINDOWDAO_QUERY_WINDOW_BY_ID = 356;
	public static final int RESULT_WINDOWDAO_QUERY_WINDOW_BY_ID = 357;

	public static final int WINDOWDAO_UPDATE_DISABLED_BY_BUSINESSID = 358;
	public static final int RESULT_WINDOWDAO_UPDATE_DISABLED_BY_BUSINESSID = 359;

	public static final int WINDOWDAO_UPDATE_WINDOW_BY_ID = 360;
	public static final int RESULT_WINDOWDAO_UPDATE_WINDOW_BY_ID = 361;

	public static final int WINDOWDAO_INSERT_WINDOW = 362;
	public static final int RESULT_WINDOWDAO_INSERT_WINDOW = 363;

	public static final int WINDOWDAO_UPDATE_DISABLED_BY_NUM = 364;
	public static final int RESULT_WINDOWDAO_UPDATE_DISABLED_BY_NUM = 365;

	public static final int WINDOWDAO_UPDATE_DISABLED_BY_NUM1 = 366;
	public static final int RESULT_WINDOWDAO_UPDATE_DISABLED_BY_NUM1 = 367;

	public static final int WINDOWDAO_INSERT_WINDOW1 = 368;
	public static final int RESULT_WINDOWDAO_INSERT_WINDOW1 = 369;

	public static final int BUSINESSDAO_UPDATE_DISABLED_BY_CODE = 370;
	public static final int RESULT_BUSINESSDAO_UPDATE_DISABLED_BY_CODE = 371;

	public static final int BUSINESSDAO_UPDATE_DISABLED_BY_NAME = 372;
	public static final int RESULT_BUSINESSDAO_UPDATE_DISABLED_BY_NAME = 373;

	public static final int BUSINESSDAO_QUERY_BY_ID = 374;
	public static final int RESULT_BUSINESSDAO_QUERY_BY_ID = 375;

}
