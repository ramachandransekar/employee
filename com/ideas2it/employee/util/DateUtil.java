/**
 * <p>
 * This is the package for DateUtil class 
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.util;

import java.time.LocalDate;  
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <p>
 * Class DateUtil used for age validation
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */ 
public class DateUtil {

    /**
     * <p>
     * This findAgeFromDateOfBirth method is used for providing 
     * employee age by using date of birth of employee 
     * </p>
     *
     * @param dateOfBirth - employee date of birth
     *
     * @return age
     */     
    public static int findAgeFromDateOfBirth(LocalDate dateOfBirth) {         
        LocalDate currentDate = LocalDate.now();
	int age = Period.between(dateOfBirth, currentDate).getYears();
	return age;    
    }

    /**
     * <p>
     * This method is used to validate a date 
     * </p>
     *
     * @param date - employee dateOfBirth
     *
     * @return boolean
     */ 
    public static LocalDate convertStringToDate(String date) {
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, dateFormat);
        } catch(DateTimeParseException exception) {
            throw new DateTimeParseException("Invalid date! ", date, 0);
        }
    }

}