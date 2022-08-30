/**
 * <p>
 * This is the base package for all the model classes
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.model;

import java.time.LocalDate;  

import com.ideas2it.employee.util.DateUtil;

/**
 * <p>
 * This employee class contains getter and setter methods for
 * all the employee variables
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */
public class Employee {
    
    public static String companyName = "Ideas2it";
    private String id;    
    private String name;    
    private LocalDate dateOfBirth;    
    private String email;    
    private long contactNumber;             
    private long alternateContactNumber;        
    private String address;    
    private int yearOfGraduation;    
    private String primaryLanguage;   
    private long aadharNumber;    
    private String pancardNumber;

    /**
     * <p>
     * This method used to get employee id
     * </p>
     * 
     * @return the employee id
     */	          
    public String getId() {
        return id;
    }

    /**
     * <p>
     * This method used to set employee id
     * </p>
     *
     * @param id - employee id
     *
     * @return void
     */		
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>
     * This method used to get employee name
     * </p>
     *
     * @return the employee name
     */		
    public String getName() {
        return name;
    }
 
    /**
     * <p>
     * This method used to set employee name
     * </p>
     *
     * @param name - employee name
     *
     * @return void 
     */		
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * <p>
     * This method used to get employee dateOfBirth
     * </p>
     *
     * @return the employee dateOfBirth
     */			
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * <p>
     * This method used to set employee dateOfBirth
     * </p>
     *
     * @param dateOfBirth - employee dateOfBirth
     *
     * @return void
     */		
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * <p>
     * This method used to get employee email
     * </p>
     *
     * @return the email 
     */	
    public String getEmail() {
       return email;  
    }

    /**
     * <p>
     * This method used to set employee email
     * </p>
     *
     * @param email - employee email
     *
     * @return void
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>
     * This method used to get employee contactNumber
     * </p>
     *
     * @return the employee contactNumber
     */		
    public long getContactNumber() {
        return contactNumber;
    }

    /**
     * <p>
     * This method used to set employee contactNumber
     * </p>
     *
     * @param contactNumber - employee contactNumber
     *
     * @return void
     */	
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * <p>
     * This method used to get employee alternateContactNumber
     * </p>
     *
     * @return the employee alternateContactNumber
     */		
    public long getAlternateContactNumber() {
        return alternateContactNumber;
    }

    /**
     * <p>
     * This method used to set employee alternateContactNumber
     * </p>
     *
     * @param alternateContactNumber - employee alternateContactNumber
     *
     * @return void
     */		
    public void setAlternateContactNumber(long alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    /**
     * <p>
     * This method used to get employee address
     * </p>
     *
     * @return the employee address
     */	
    public String getAddress() {
        return address;
    }

    /**
     * <p>
     * This method used to set employee address
     * </p>
     *
     * @param address - employee address
     *
     * @return void
     */		
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p>
     * This method used to get employee yearOfGraduation
     * </p>
     *
     * @return the employee yearOfGraduation
     */		
    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    /**
     * <p>
     * This method used to set employee yearOfGraduation
     * </p> 
     *
     * @param yearOfGraduation - employee yearOfGraduation
     *
     * @return void
     */	
    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    /**
     * <p>
     * This method used to get employee primaryLanguage
     * </p>
     *
     * @return the employee primaryLanguage
     */	
    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    /**
     * <p>
     * This method used to set employee primaryLanguage
     * </p>
     *
     * @param primaryLanguage - employee primaryLanguage
     *
     * @return void
     */			
    public void setPrimaryLanguage(String primaryLanguage) {
	this.primaryLanguage = primaryLanguage;
    }

    /**
     * <p>
     * This method used to get employee aadharNumber
     * </p>
     *
     * @return the employee aadharNumber
     */		
    public long getAadharNumber() {
	return aadharNumber;
    }

    /**
     * <p>
     * This method used to set employee aadharNumber
     * </p>
     *
     * @param aadharNumber - employee aadharNumber 
     *
     * @return void
     */		
    public void setAadharNumber(long aadharNumber) {
	this.aadharNumber = aadharNumber;
    }

    /**
     * <p>
     * This method used to get employee pancardNumber
     * </p>
     *
     * @return the employee pancardNumber
     */		
    public String getPancardNumber() {
	return pancardNumber;
    }

    /**
     * <p>
     * This method used to set employee pancardNumber
     * </p>
     *
     * @param pancardNumber - employee pancardNumber 
     *
     * @return void
     */		
    public void setPancardNumber(String pancardNumber) {
        this.pancardNumber = pancardNumber;
    }

    /**
     * <p>
     * This method used to get employee age by 
     * using employee date of birth
     * </p>
     *
     * @return the employee age
     */
    public int getAge() {                                     
        return DateUtil.findAgeFromDateOfBirth(dateOfBirth);
    }
 
    /**
     * <p>
     * Overriding the toString method  
     * </p>
     *
     * @return the employee details
     */
    @Override
    public String toString() {
        return (companyName + "\n" + getId() + "\n" + getName()
                + "\n" + "\n" + getEmail() + "\n" + getContactNumber() 
                + "\n" + getAlternateContactNumber() + " \n " + getAge()
                + "\n" + getAddress() + "\n" + getYearOfGraduation() + 
                "\n" + getPrimaryLanguage() + "\n" + getAadharNumber() 
                + "\n" + getPancardNumber());
    }    
}
