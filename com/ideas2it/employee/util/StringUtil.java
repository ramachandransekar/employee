/**
 * <p>
 * This is the package for StringUtil class 
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Class StringUtil used for string validations
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */ 
public class StringUtil {

    /**
     * <p>
     * This Method is used to valid a pancard number
     * </p>
     *
     * @param panCard
     *
     * @return boolean
     */
    public static boolean isValidPanNumber(String panCard) {
        String validPanCard = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern pattern = Pattern.compile(validPanCard);
        Matcher matcher = pattern.matcher(panCard);
        return matcher.matches();
    }
 
    /**
     * <p>
     * This Method is used to valid a name
     * </p>
     *
     * @param name
     *
     * @return boolean
     */ 
    public static boolean isValidName(String name) {    	 
    	 return name.matches( "[a-z]*" );
     }
}