/**
 * <p>
 * This is the package for CommonUtil class 
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.util;

import java.time.LocalDate;  
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Class CommonUtil used for common validations
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */  
public class CommonUtil {

    /**
     * <p>
     * This Method is used to validate aadharcard number 
     * of the employee 
     * </p>
     *
     * @param aadharNumber - employee aadhar number
     *
     * @return boolean
     */
    public static boolean isValidAadharNumber(long aadharNumber) {          
        String conversionAadhar = Long.toString(aadharNumber);
        String validPhoneNumber = "^\\d{12}$";
        Pattern pattern = Pattern.compile(validPhoneNumber);
        Matcher matcher = pattern.matcher(conversionAadhar);
        return matcher.matches();       
    } 

    /**
     * <p>
     * This Method is used to validate year of graduation
     * of the employee 
     * </p>
     *
     * @param graduation - employee year of graduation
     *
     * @return boolean
     */
    public static boolean isValidGraduation(int graduation) {
        String validGraduation = "^\\d{4}$";
        String conversionGraduation = Integer.toString(graduation);
        Pattern pattern = Pattern.compile(validGraduation);
        Matcher matcher = pattern.matcher(conversionGraduation);
        return matcher.matches();
    }
      
    /**
     * <p>
     * This Method is used to validate TrainingExperience 
     * </p>
     *
     * @param trainingExperience - employee training experience
     *
     * @return boolean
     */
    public static boolean isValidTrainingExperience(int trainingExperience) {
        String validTrainingExperience = "[1-99]{1,2}";
        String conversionTrainingExperience = Integer.toString(trainingExperience);
        Pattern pattern = Pattern.compile(validTrainingExperience); 
        Matcher matcher = pattern.matcher(conversionTrainingExperience);
        return matcher.matches();
    }

    /**
     * <p>
     * This Method is used to validate projectCount of the employee 
     * </p>
     *
     * @param projectCount - employee project count
     *
     * @return boolean
     */   
    public static boolean isValidProjectCount(int projectCount) {
        String validProjectCount = "[1-99]{1,2}";
        String conversionProjectCount = Integer.toString(projectCount);
        Pattern pattern = Pattern.compile(validProjectCount); 
        Matcher matcher = pattern.matcher(conversionProjectCount);
        return matcher.matches();
    }  

    /**
     * <p>
     * This Method is used to valid a mobile number
     * </p>
     *
     * @param contactNumber
     *
     * @return boolean
     */ 
    public static boolean isValidMobileNumber(long contactNumber) {                  
        String validPhoneNumber = "^\\d{10}$";
        String conversionContactNumber = Long.toString(contactNumber);
        Pattern pattern = Pattern.compile(validPhoneNumber);
        Matcher matcher = pattern.matcher(conversionContactNumber);
        return matcher.matches();    
    }     
}