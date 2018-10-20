package com.pmt.pcommon.constants;

import java.math.BigDecimal;
import java.util.Date;

public class PMTConstants {
	
	public static final class Directory{
		
		//private static final String UPLOADED_FOLDER = "C:\\Projects\\ITR\\Attachments\\";
		private static final String UPLOADED_FOLDER = "/doc/itr/";
		public static String getUploadedFolder() {
			return UPLOADED_FOLDER;
		}
	}
	
	/** Action Type */
	public static final class Actiontype {

		public static final String ACTION_TYPE_SEARCH                   = "search";
		public static final String ACTION_TYPE_ENTRY                    = "entry";
		public static final String ACTION_TYPE_UPDATE                   = "update";
		public static final String ACTION_TYPE_DELETE                   = "delete";
		public static final String ACTION_TYPE_UPLOAD                   = "upload";
		public static final String ACTION_TYPE_DOWNLOAD                 = "download";
		public static final String ACTION_TYPE_RESET                    = "reset";
		public static final String ACTION_TYPE_CANCEL                   = "cancel";
	}
	
    /** IsChecked */
    public static final class IsChecked {

        public static final String ON                  					= "on";
    }
	
	/* context value */
    public static final String KEY_USER_CONTEXT                             = "UserContext";
    
    /* default date format */
    public static final String DB_DATE_FORMAT_YMD 							= "yyyyMMdd";
    public static final String DB_DATE_FORMAT_YM 							= "yyyyMM";
    public static final String DB_DATE_FORMAT_HM 							= "HHmm";
    public static final String DB_DATE_FORMAT_HMS						    = "HHmmss";
    public static final String DB_DATE_FORMAT_MS						    = "mmss";
    
    /* Screen Date Format */
    public static final String SCREEN_DATE_FORMAT_YM                        = "yyyy/MM";
    public static final String SCREEN_DATE_FORMAT_YMD                       = "yyyy/MM/dd";
    public static final String SCREEN_DATE_FORMAT_HM                        = "HH:mm";
    public static final String SCREEN_DATE_FORMAT_DMY 					    = "dd-MMM-yyyy";
    public static final String SCREEN_DATE_FORMAT_DDMY 					    = "dd/MM/yyyy";
    public static final String SCREEN_DATE_FORMAT_DDMMYYYY				    = "ddMMyyyy";
    
    /* Print Date Format */
    public static final String PRINT_DATE_FORMAT_DMY        			    = "dd/MM/yyyy";
    
    
    /* Name Organisation separator  for user*/
    public static final String separator        			    = " \\ ";
    
    
    /* Calendar Date Format */
    public static final String CALENDAR_DATE_FORMAT_YM                      = "yyyy-MM";
    public static final String CALENDAR_DATE_FORMAT_YMD                     = "yyyy-MM-dd";
    public static final String CALENDAR_DATE_FORMAT_YY                      = "yy";
    
    /* Calendar Flag */
    public static final String CALENDAR_RETRIEVE_FLG                        = "RETRIEVE";
    public static final String CALENDAR_PREVIOUS_FLG                        = "PREVIOUS";
    public static final String CALENDAR_NEXT_FLG                            = "NEXT";
    
    /* DB MAX & MIN Date Value */
    public static final String DB_DATE_YMD_MIN 								= "19000101";
    public static final String DB_DATE_YMD_MAX 						        = "29991231";
    
    /* default dateTime format */
    public static final String DEFAULT_SIMPLEDATE_FORMAT 					= "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_SIMPLEDATE_DB_FORMAT 			    = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_SIMPLEDATE_FORMAT_DMY 			    = "dd-MM-yyyy HH:mm:ss";
    public static final String DEFAULT_SIMPLETIME_FORMAT 				  	= "mm:ss";
    public static final String BREAK_LINE			                     	= "<br/>";

    /* entity default value */
    public static final String ENTITY_DEFAULT_CHAR_SPACE 					= " "; 
    public static final String ENTITY_DEFAULT_CHAR_ZERO 					= "0";
    public static final String ENTITY_DEFAULT_DATE_SPACE 					= " ";  
    public static final BigDecimal ENTITY_DEFAULT_BIGDECIMAL_ZERO  			= new BigDecimal("0");
    public static final int ENTITY_DEFAULT_INT_ZERO 						= 0;
    public static final long ENTITY_DEFAULT_LONG_ZERO 						= 0;
    public static final String ENTITY_DEFAULT_MODEL_CD 						= "999999";
    public static final Date ENTITY_DEFAULT_DATE_SYSTEM_DATE				= new Date();
	
    /* criteria condition */
    public static final String CRITERIA_CONDITION_PERCENT 					= "%";
    
	
	/******************************************************/
	/* Character                                          */
	/******************************************************/
    public static final double CHAR_ZERO_DOUBLE  									= 0.0;
	public static final double CHAR_ONE_DOUBLE   									= 1.0;
	public static final double CHAR_TWO_DOUBLE   									= 2.0;
    public static final double CHAR_THREE_DOUBLE                                   =  3.0;
    public static final double CHAR_FOUR_DOUBLE                                    = 4.0;
    public static final double CHAR_FIVE_DOUBLE                                    = 5.0;
    public static final double CHAR_SIX_DOUBLE                                     = 6.0;
    public static final double CHAR_SEVEN_DOUBLE                                   = 7.0;
    public static final double CHAR_EIGHT_DOUBLE                                   = 8.0;
	public static final double CHAR_NINE_DOUBLE   									= 9.0;
	public static final double CHAR_TEN_DOUBLE   									= 10.0;
	public static final double CHAR_ELEVEN_DOUBLE   							    = 11.0;
	public static final double CHAR_TWELVE_DOUBLE                                  = 12.0;
	public static final double CHAR_THIRTEEN_DOUBLE   							    = 13.0;
	public static final double CHAR_FORTEEN_DOUBLE   							    = 14.0;
	public static final double CHAR_FIFTEEEN_DOUBLE   							    = 15.0;
	public static final double CHAR_SIXTEEEN_DOUBLE   							    = 16.0;
	public static final double CHAR_SEVENTEEEN_DOUBLE   							    = 17.0;
    
    
	public static final String CHAR_ZERO  									= "0";
	public static final String CHAR_ONE   									= "1";
	public static final String CHAR_TWO   									= "2";
    public static final String CHAR_THREE                                   = "3";
    public static final String CHAR_FOUR                                    = "4";
    public static final String CHAR_FIVE                                    = "5";
    public static final String CHAR_SIX                                     = "6";
    public static final String CHAR_SEVEN                                   = "7";
    public static final String CHAR_EIGHT                                   = "8";
	public static final String CHAR_NINE   									= "9";
	public static final String CHAR_TEN   									= "10";
	public static final String CHAR_ELEVEN   							    = "11";
	public static final String CHAR_TWELVE                                  = "12";
	public static final String CHAR_THIRTEEN   							    = "13";
	public static final String CHAR_FORTEEN   							    = "14";
	public static final String CHAR_FIFTEEEN   							    = "15";
	public static final String CHAR_SEVENTEEEN   							= "17";
	public static final String CHAR_EIGHTTEEEN   							= "18";
	public static final String CHAR_TWENTY_ONE   							= "21";
	public static final String CHAR_TWENTY_TWO   							= "22";
	public static final String CHAR_TWENTY_THREE   							= "23";
	public static final String CHAR_TWENTY_FOUR   							= "24";
	public static final String CHAR_TWENTY_FIVE   							= "25";
	public static final String CHAR_TWENTY_SIX   							= "26";
	public static final String CHAR_TWENTY_SEVEN   							= "27";
	public static final String CHAR_TWENTY_EIGHT   							= "28";
	public static final String CHAR_TWENTY_NINE   							= "29";
	public static final String CHAR_THIRTY   							    = "30";
	public static final String CHAR_THIRTY_ONE                              = "31";
	public static final String CHAR_THIRTY_TWO                              = "32";
	public static final String CHAR_THIRTY_THREE                            = "33";
	public static final String CHAR_THIRTY_FOUR                             = "34";
	public static final String CHAR_THIRTY_FIVE                             = "35";
	public static final String CHAR_SIXTY  							        = "60";
	public static final String CHAR_NINETY_NINE 							= "99";
	public static final String CHAR_BLANK 									= "";
	public static final String CHAR_COMMA 									= ",";
	public static final String CHAR_SPACE 							        = " ";
	public static final String CHAR_BAR   									= "-";
	public static final String CHAR_UNDERSCORE 								= "_";
	public static final String CHAR_ASTERISK							    = "*";
	public static final String CHAR_BOM										= "01";
	public static final String CHAR_NEGATIVE_ONE							= "-1";
	public static final String CHAR_HUNDRED									= "100";
	public static final String CHAR_TWO_HUNDRED_FIFTY						= "250";
	public static final String CHAR_VERTICAL						        = "|";
	public static final String CHAR_DOT						                = ".";
	public static final String CHAR_ZERO_ROUND2				                = "0.00";
	public static final String MONTH_JAN				                    = "01";
	public static final String MONTH_FEB				                    = "02";
	public static final String MONTH_MAR				                    = "03";
	public static final String MONTH_APR				                    = "04";
	public static final String MONTH_MAY				                    = "05";
	public static final String MONTH_JUN				                    = "06";
	public static final String MONTH_JUL				                    = "07";
	public static final String MONTH_AUG				                    = "08";
	public static final String MONTH_SEP				                    = "09";
	public static final String MONTH_OCT				                    = "10";
	public static final String MONTH_NOV				                    = "11";
	public static final String MONTH_DEC				                    = "12";
	
	/******************************************************/
	/* Integer                                            */
	/******************************************************/
	public static final Integer INTEGER_ZERO 								= 0;
	public static final Integer INTEGER_ONE  								= 1;
	public static final Integer INTEGER_TWO  								= 2;
	public static final Integer INTEGER_THREE  								= 3;
	public static final Integer INTEGER_FOUR  								= 4;
	public static final Integer INTEGER_FIVE  								= 5;
	public static final Integer INTEGER_SIX  								= 6;
	public static final Integer INTEGER_SEVEN  								= 7;
	public static final Integer INTEGER_EIGHT  								= 8;
	public static final Integer INTEGER_NINE  								= 9;
	public static final Integer INTEGER_TEN  								= 10;
	public static final Integer INTEGER_ELEVEN                              = 11;
	public static final Integer INTEGER_TWELVE                              = 12;
	public static final Integer INTEGER_THIRTEEN                            = 13;
	public static final Integer INTEGER_SEVENTEEN                           = 17;
	public static final Integer INTEGER_TWENTY_ONE                          = 21;
	public static final Integer INTEGER_THIRTY_ONE                          = 31;
	public static final Integer INTEGER_NEGATIVE_ONE  						= -1;
	public static final Integer INTEGER_NEGATIVE_TWO  						= -2;
	public static final Integer INTEGER_NEGATIVE_THREE  					= -3;
	public static final Integer INTEGER_HUNDRED								= 100;
	public static final Integer UNIT_HUNDRED_TWENTY_FOUR  					= 1024;
	public static final BigDecimal BIGDECIMAL_ZERO  						= new BigDecimal("0");
	public static final BigDecimal BIGDECIMAL_ONE     						= new BigDecimal("1");
	public static final BigDecimal BIGDECIMAL_ONE_ROUND2    				= new BigDecimal("1.00");
	public static final BigDecimal BIGDECIMAL_ZERO_ROUND1  					= new BigDecimal("0.0");
	public static final BigDecimal BIGDECIMAL_ZERO_ROUND2  					= new BigDecimal("0.00");
	public static final BigDecimal BIGDECIMAL_ZERO_ROUND3  					= new BigDecimal("0.000");
	public static final BigDecimal BIGDECIMAL_ZERO_ROUND4  					= new BigDecimal("0.0000");
	public static final BigDecimal BIGDECIMAL_ONE_PERSENT  					= new BigDecimal("0.01");
	public static final BigDecimal BIGDECIMAL_HUNDRED_ROUND0  				= new BigDecimal("100");
	public static final BigDecimal BIGDECIMAL_HUNDRED_ROUND1  				= new BigDecimal("100.0");
	public static final BigDecimal BIGDECIMAL_HUNDRED_ROUND2  				= new BigDecimal("100.00");
	public static final BigDecimal BIGDECIMAL_COMPARE_ROUND2                = new BigDecimal("999.00");
    public static final BigDecimal BIGDECIMAL_THOUSAND_ROUND1               = new BigDecimal("1000.0");
    public static final BigDecimal BIGDECIMAL_MILLION_ROUND3                = new BigDecimal("1000000.000");
    public static final BigDecimal BIGDECIMAL_BILLION_ROUND3                = new BigDecimal("1000000000.000");
    public static final BigDecimal BIGDECIMAL_FOUR_LAKHS	                = new BigDecimal("400000.00");

    /* select status */
    public static final String SELECT_STATUS_YES 							= "1";
    public static final String SELECT_STATUS_NO 							= "0";
    
	public static final String BACKSLASH_N_SEPERATOR                     	= "\n";
	
	public static final String SYSTEM_DATE_FORMAT	 					    = "yyyy-MM-dd";
	 
	public static final String INTERFACE_TO_LOTUS = "0";
	public static final String INFRA_FOLLOWING_USER_ID 		= "I1";
}
