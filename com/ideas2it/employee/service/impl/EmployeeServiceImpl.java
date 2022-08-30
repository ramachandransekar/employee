/**
 * <p>
 * This is the package for EmployeeServiceImpl class
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.service.impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.ideas2it.employee.dao.EmployeeDAO;
import com.ideas2it.employee.dao.impl.EmployeeDAOImpl;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.util.CommonUtil;

/**
 * <p>
 * This class EmployeeServiceImpl implements EmployeeService
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDao = new EmployeeDAOImpl();

    private final static String EMPLOYEEPREFIX = "I";

    static int employeeIdCount = 100;

    /**
     * <p>
     * To add trainer detail
     * </p>
     *
     * @param name - name of the trainer
     * @param dateOfBirth - date of birth of the trainer
     * @param contactNumber - contactnumber of the trainer
     * @param alternateContactNumber - alternate contact number of the trainer
     * @param address - address of the trainer
     * @param graduation - graduation of the trainer
     * @param language - communication language of the trainer
     * @param aadharNumber - aadharnumber  of the trainer
     * @param panCard - panCard of the trainer
     * @param trainingExperience - training experience of the trainer
     * @param projectCount - project count of the trainer
     * @param projectName - project name of the trainer 
     *
     * @return void
     */
    public boolean addTrainer(String name, LocalDate dateOfBirth, 
                              long contactNumber, long alternateContactNumber, 
                              String address, int graduation, String language, 
                              long aadharNumber, String panCard,
                              int trainingExperience, int projectCount,
                              String projectName) throws SQLException {
        Trainer trainer = new Trainer();                         
        String email = generateEmailId(name);
        String id = generateEmployeeId(dateOfBirth);
        trainer.setId(id);                                                
        trainer.setName(name);                                             
        trainer.setDateOfBirth(dateOfBirth);                                                     
        trainer.setEmail(email);                                           
        trainer.setContactNumber(contactNumber);                           
        trainer.setAlternateContactNumber(alternateContactNumber);         
        trainer.setAddress(address);                                       
        trainer.setYearOfGraduation(graduation);                          
        trainer.setPrimaryLanguage(language);                              
        trainer.setAadharNumber(aadharNumber);                            
        trainer.setPancardNumber(panCard);                                 
        trainer.setTrainingExperience(trainingExperience);               
        trainer.setProjectCount(projectCount);                            
        trainer.setProjectName(projectName);                               
        return employeeDao.insertTrainer(trainer);                                // Setting the object using the insertTrainer() method
    }

    /**
     * <p>
     * To add trainee detail 
     * </p>
     *
     * @param name - name of the trainee
     * @param dateOfBirth - date of birth of the trainee
     * @param contactNumber - contact number of the trainee
     * @param alternateContactNumber - alternate contact number of the trainee 
     * @param address - address of the trainee
     * @param graduation - graduation of the trainee 
     * @param language - language of the trainee 
     * @param aadharNumber - aadharnumber of the trainee 
     * @param panCard - pancard of the trainee
     * @param skill - skill of the trainee
     * @param degree - degree of the trainee
     *
     * @return void
     */ 
    public boolean addTrainee(String name, LocalDate dateOfBirth, 
                              long contactNumber, long alternateContactNumber, 
                              String address, int graduation, String language, 
                              long aadharNumber, String panCard, 
                              String skill, String degree) throws SQLException {
        Trainee trainee = new Trainee();
        String email = generateEmailId(name);
        String id = generateEmployeeId(dateOfBirth);
        trainee.setId(id);                                                
        trainee.setName(name);                                              
        trainee.setDateOfBirth(dateOfBirth);                             
        trainee.setEmail(email);                                        
        trainee.setContactNumber(contactNumber);                           
        trainee.setAlternateContactNumber(alternateContactNumber);          
        trainee.setAddress(address);                                    
        trainee.setYearOfGraduation(graduation);                           
        trainee.setPrimaryLanguage(language);                              
        trainee.setAadharNumber(aadharNumber);                           
        trainee.setPancardNumber(panCard);                                 
        trainee.setSkill(skill);                                         
        trainee.setDegree(degree);                                         
        return employeeDao.insertTrainee(trainee);                                // Setting the object using the insertTrainee() method
    }
   
    /**
     * <p>
     * To delete Trainer Detail
     * </p>
     *
     * @param id - id of the trainer
     *
     * @return boolean
     */
    public boolean deleteTrainerById(String id) throws SQLException {    
        return employeeDao.deleteTrainer(id);
    }

    /**
     * <p>
     * To Remove Trainee Detail
     * </p>
     *
     * @param id - id of the trainee
     *
     * @return boolean
     */
    public boolean deleteTraineeById(String id) throws SQLException {        
        return employeeDao.deleteTrainee(id);    
    }

    /**
     * <p>
     * To update trainer detail
     * </p>
     *
     * @param idUpdate - id of the trainer
     * @param trainerUpdate - update option of the trainer
     * @param updateNewValue - update new value of the trainer
     *
     * @return boolean
     */
    public boolean updateTrainerById(String id, int trainerUpdate, String updateNewValue) throws SQLException {
        return employeeDao.updateTrainer(id, trainerUpdate, updateNewValue);
    }

    /**
     * <p>
     * To update trainee detail
     * </p>
     *
     * @param idUpdate - id of the trainee
     * @param traineeUpdate - traineeUpdate of the trainee
     * @param updateNewValue - updateNewValue of the trainee
     *
     * @return boolean
     */
    public boolean updateTraineeById(String id, int traineeUpdate, String updateNewValue) throws SQLException {
        return employeeDao.updateTrainee(id, traineeUpdate, updateNewValue);       
    }
       
    /**
     * <p>
     * To display trainer detail
     * </p>
     *
     * @param Id - trainer id
     *
     * @return boolean
     */
    public Trainer displayTrainer(String id) throws SQLException {            
        return employeeDao.retrieveTrainer(id);               
    }

    /**
     * <p>
     * To display trainee detail
     * </p>
     *
     * @param Id - trainee id
     *
     * @return boolean
     */
    public Trainee displayTrainee(String id) throws SQLException {
        return employeeDao.retrieveTrainee(id);    
    }

    /**
     * <p>
     * To display all trainers detail
     * </p>
     *
     * @return trainers
     */
    public List<Trainer> displayTrainers() throws SQLException {
        return employeeDao.retrieveTrainers();
    }

    /**
     * <p>
     * To display all trainees detail
     * </p>
     *
     * @return trainers
     */
    public List<Trainee> displayTrainees() throws SQLException {
        return employeeDao.retrieveTrainees();        
    }

    /**
     * <p>
     * This method used for assign trainer to trainee
     * </p>
     *
     * @param trainerId
     * @param traineeId
     *
     * @return boolean
     */
    public boolean assignTrainerToTrainees(String trainerId, String traineeId) throws SQLException {
        return employeeDao.assignTrainerToTrainee(trainerId, traineeId);      
    }
    
    /**
     * <p>
     * This method used to checking trainer exist contact number 
     * </p>
     *
     * @param contactNumber - trainer contact number
     *
     * @return boolean
     */
    public boolean isTrainerContactNumberExist(Long contactNumber) throws SQLException {
        return employeeDao.getTrainerContactNumber(contactNumber);
    }
    
    /**
     * <p>
     * This method used to checking trainee exist contact number 
     * </p>
     *
     * @param contactNumber - trainee contact number
     *
     * @return boolean
     */
    public boolean isTraineeContactNumberExist(Long contactNumber) throws SQLException {
        return employeeDao.getTraineeContactNumber(contactNumber);
    }
    
    /**
     * <p>
     * This method used for retrieve trainee aadhar number 
     * </p>
     *
     * @param aadharNumber = aadharcard number of the trainee
     *
     * @return boolean
     */
    public boolean isTraineeAadharNumberExist(Long aadharNumber) throws SQLException {
        return employeeDao.getTraineeAadhartNumber(aadharNumber);
    }
    
    /**
     * <p>
     * This method used for retrieve trainer aadhar number 
     * </p>
     *
     * @param aadharNumber = aadharcard number of the trainer
     *
     * @return boolean
     */ 
    public boolean isTrainerAadharNumberExist(Long aadharNumber) throws SQLException {
        return employeeDao.getTrainerAadhartNumber(aadharNumber);
    }
    
    /**
     * <p>
     * This method used for retrieve trainer pancard number 
     * </p>
     *
     * @param panCard = pancard number of the trainer
     *
     * @return boolean
     */
    public boolean isTrainerPancardNumberExist(String panCard) throws SQLException {
        return employeeDao.getTrainerPancardNumber(panCard);
    }
    
    /**
     * <p>
     * This method used for retrieve trainee pancard number 
     * </p>
     *
     * @param panCard = pancard number of the trainee
     *
     * @return boolean
     */  
    public boolean isTraineePancardNumberExist(String panCard) throws SQLException {
        return employeeDao.getTraineePancardNumber(panCard);
    }

    /**
     * <p>
     * To generate employee gmail id using this method
     * </p>
     *
     * @param name - employee name
     *
     * @return String
     */ 
    public String generateEmailId(String name) {  
        return name.toLowerCase() + "@ideas2it.com";
    }

    /**
     * <p>
     * This method used for retrieve trainees 
     * </p>
     *
     * @param id = id of the trainee
     *
     * @return trainees
     */
    public List<Trainee> displayAssignedTrainerToTrainees(String id) throws SQLException {
        return employeeDao.displayAssignedTrainerToTrainees(id); 
    }

    /**
     * <p>
     * To generate employee id using this method
     * </p>
     *
     * @param dateOfBirth - employee date of birth
     *
     * @return String
     */     
    public String generateEmployeeId(LocalDate dateOfBirth) {
        String conversionYear = dateOfBirth.toString().substring(2,4);
        int year = Integer.parseInt(conversionYear); 
        year = year % 100;
        employeeIdCount = employeeIdCount + 1;    
        return EMPLOYEEPREFIX + year + employeeIdCount;       
    }                      
}