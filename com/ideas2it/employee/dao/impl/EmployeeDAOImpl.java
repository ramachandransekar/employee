/**
 * <p>
 * This is the package for dao class
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employee.common.Constants;
import com.ideas2it.employee.dao.EmployeeDAO;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer;
import com.ideas2it.employee.util.ConnectionUtil;


/**
 * <p>
 * class EmployeeDAOImpl used to implements EmployeeDAO
 * </p>
 *
 * @author  Ramachandran
 * @version 1
 * @since   2022-07-18 
 */

public class EmployeeDAOImpl implements EmployeeDAO {
    
    /**
     * <p>
     * To retrive trainees detail
     * </p>
     *
     * @return trainees
     */
    public List<Trainee> displayAssignedTrainerToTrainees(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;        
	try {
            List<Trainee> trainees = new ArrayList<Trainee> ();
            connection = ConnectionUtil.getInstance();
            String query = "select trainee.* from trainer inner join trainee  on trainer.id = trainee.trainer_id where trainer.id = ? and trainee.is_active = 1 ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet traineeDetails = preparedStatement.executeQuery();
            while (traineeDetails.next()) {
                Trainee trainee = new Trainee();
                trainee.setId(traineeDetails.getString(Constants.employeeId)); 
                trainee.setName(traineeDetails.getString(Constants.employeeName));
                trainee.setDateOfBirth(traineeDetails.getDate(Constants.employeeDateOfBirth).toLocalDate()); 
                trainee.setEmail(traineeDetails.getString(Constants.employeeEmail));
                trainee.setContactNumber(traineeDetails.getLong(Constants.employeeContactNumber));
                trainee.setAlternateContactNumber(traineeDetails.getLong(Constants.employeeAlternateContactNumber));
                trainee.setAddress(traineeDetails.getString(Constants.employeeAddress));
                trainee.setYearOfGraduation(traineeDetails.getInt(Constants.employeeYearOfGraduation));
                trainee.setPrimaryLanguage(traineeDetails.getString(Constants.employeePrimaryLanuage));
                trainee.setAadharNumber(traineeDetails.getLong(Constants.employeeAadharNumber));
                trainee.setPancardNumber(traineeDetails.getString(Constants.employeePancardNumber));
                trainee.setSkill(traineeDetails.getString(Constants.traineeSkill));
                trainee.setDegree(traineeDetails.getString(Constants.traineeDegree));  
                trainees.add(trainee); 
            }
            return trainees;
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainer not assigned to trainee");
        } finally {
            preparedStatement.close();
            connection.close();
        }        		
    }
    
    /**
     * <p>
     * To retrive trainers detail
     * </p>
     *
     * @return trainers
     */         
    public List<Trainer> retrieveTrainers() throws SQLException { 
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            List<Trainer> trainers = new ArrayList<Trainer>();
            connection = ConnectionUtil.getInstance();
            String query = "select * from trainer where is_active = 1";
            preparedStatement = connection.prepareStatement(query);
            ResultSet trainerDetails = preparedStatement.executeQuery();
            while (trainerDetails.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(trainerDetails.getString(Constants.employeeId)); 
                trainer.setName(trainerDetails.getString(Constants.employeeName));
                trainer.setDateOfBirth(trainerDetails.getDate(Constants.employeeDateOfBirth).toLocalDate()); 
                trainer.setEmail(trainerDetails.getString(Constants.employeeEmail));
                trainer.setContactNumber(trainerDetails.getLong(Constants.employeeContactNumber));
                trainer.setAlternateContactNumber(trainerDetails.getLong(Constants.employeeAlternateContactNumber));
                trainer.setAddress(trainerDetails.getString(Constants.employeeAddress));
                trainer.setYearOfGraduation(trainerDetails.getInt(Constants.employeeYearOfGraduation));
                trainer.setPrimaryLanguage(trainerDetails.getString(Constants.employeePrimaryLanuage));
                trainer.setAadharNumber(trainerDetails.getLong(Constants.employeeAadharNumber));
                trainer.setPancardNumber(trainerDetails.getString(Constants.employeePancardNumber));
                trainer.setTrainingExperience(trainerDetails.getInt(Constants.trainerTrainingExperience));
                trainer.setProjectCount(trainerDetails.getInt(Constants.trainerProjectCount));
                trainer.setProjectName(trainerDetails.getString(Constants.trainerProjectname));  
                trainers.add(trainer);             
            } 
            return trainers;
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainer not found");
        } finally {
            preparedStatement.close();
            connection.close();
        }             
    }

    /**
     * <p>
     * To retrive trainees detail
     * </p>
     *
     * @return trainees
     */ 
    public List<Trainee> retrieveTrainees() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            List<Trainee> trainees = new ArrayList<Trainee>();
            connection = ConnectionUtil.getInstance();
            String query = "select * from trainee where is_active = 1";
            preparedStatement = connection.prepareStatement(query);
            ResultSet traineeDetails = preparedStatement.executeQuery();
            while (traineeDetails.next()) {
                Trainee trainee = new Trainee();
                trainee.setId(traineeDetails.getString(Constants.employeeId)); 
                trainee.setName(traineeDetails.getString(Constants.employeeName));
                trainee.setDateOfBirth(traineeDetails.getDate(Constants.employeeDateOfBirth).toLocalDate()); 
                trainee.setEmail(traineeDetails.getString(Constants.employeeEmail));
                trainee.setContactNumber(traineeDetails.getLong(Constants.employeeContactNumber));
                trainee.setAlternateContactNumber(traineeDetails.getLong(Constants.employeeAlternateContactNumber));
                trainee.setAddress(traineeDetails.getString(Constants.employeeAddress));
                trainee.setYearOfGraduation(traineeDetails.getInt(Constants.employeeYearOfGraduation));
                trainee.setPrimaryLanguage(traineeDetails.getString(Constants.employeePrimaryLanuage));
                trainee.setAadharNumber(traineeDetails.getLong(Constants.employeeAadharNumber));
                trainee.setPancardNumber(traineeDetails.getString(Constants.employeePancardNumber));
                trainee.setSkill(traineeDetails.getString(Constants.traineeSkill));
                trainee.setDegree(traineeDetails.getString(Constants.traineeDegree));  
                trainees.add(trainee); 
            }
            return trainees;
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainee not found");
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    /**
     * <p>
     * To udate trainer details using trainer id and update option 
     * and update new value
     * </p>
     *
     * @param id - trainer id
     * @param trainerUpdate - update option of the trainer
     * @param updateNewValue - update the new value of trainer
     *
     * @return boolean
     */
    public boolean updateTrainer(String id, int trainerUpdate, String updateNewValue) throws SQLException { 
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "";
            switch(trainerUpdate) {
            case 1:
                query = "update trainer set name = ? where id = ? and is_active = 1";                                  
                break;
            case 2:
                query = "update trainer set date_of_birth = ? where id = ? and is_active = 1";                                  
                break;
            case 3:
                query = "update trainer set contact_number = ? where id = ? and is_active = 1";                                  
                break;
            case 4:
                query = "update trainer set alternate_contact_number = ? where id = ? and is_active = 1";                                  
                break;
            case 5:
                query = "update trainer set address = ? where id = ? and is_active = 1";                                  
                break;
            case 6:
                query = "update trainer set year_of_graduation = ? where id = ? and is_active = 1";
                break;
            case 7:
                query = "update trainer set primary_language = ? where id = ? and is_active = 1";
                break;
            case 8:
                query = "update trainer set aadharcard_number = ? where id = ? and is_active  = 1";
                break;
            case 9:
                query = "update trainer set pancard_number = ? where id = ? and is_active = 1";
                break;
            case 10:
                query = "update trainer set training_experience = ? where id = ? and is_active = 1";
                break;
            case 11:
                query = "update trainer set project_count = ? where id = ? and is_active = 1";
                break;
            case 12:
                query = "update trainer set project_name = ? where id = ? and is_active = 1"; //is_active
                break;          
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateNewValue);
            preparedStatement.setString(2, id);
            return (1 == preparedStatement.executeUpdate()) ? true : false;  
        } catch (SQLException sqlException) { 
            throw new SQLException(sqlException.getMessage() + "Trainer not updated");
        } finally {
            preparedStatement.close();
            connection.close();
        }        
    }
    
    /**
     * <p>
     * To udate trainee details using trainee id and update option 
     * and update new value
     * </p>
     *
     * @param id - trainer id
     * @param trainerUpdate - update option of the trainee
     * @param updateNewValue - update new value of the trainee
     *
     * @return boolean
     */        
    public boolean updateTrainee(String id, int traineeUpdate, String updateNewValue) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "";
            switch(traineeUpdate) {
            case 1:
                query = "update trainee set name = ? where id = ? and is_active = 1";                                  
                break;
            case 2:
                query = "update trainee set date_of_birth = ? where id = ? and is_active = 1";                                  
                break;
            case 3:
                query = "update trainee set contact_number = ? where id = ? and is_active = 1";                                  
                break;
            case 4:
                query = "update trainee set alternate_contact_number = ? where id = ? and is_active = 1";                                  
                break;
            case 5:
                query = "update trainee set address =? where id = ? and is_active = 1";                                  
                break;
            case 6:
                query = "update trainee set year_of_graduation = ? where id = ? and is_active = 1";
                break;
            case 7:
                query = "update trainee set primary_language = ? where id = ? and is_active = 1";
                break;
            case 8:
                query = "update trainee set aadharcard_number = ? where id = ? and is_active = 1";
                break;
            case 9:
                query = "update trainee set pancard_number = ? where id = ? and is_active = 1";
                break;
            case 10:
                query = "update trainee set skill = ? where id = ? and is_active = 1";
                break;
            case 11:
                query = "update trainee set degree = ? where id = ? and is_active = 1";
                break;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateNewValue);
            preparedStatement.setString(2, id); 
            return (1 == preparedStatement.executeUpdate()) ? true : false;  
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainee not updated");
        } finally {
            preparedStatement.close();
            connection.close();
        }  
    }

    /**
     * <p>
     * To retrieve trainer detail from database
     * by trainer id
     * </p>
     *
     * @param id - trainer id
     *
     * @return trainer
     */         
    public Trainer retrieveTrainer(String id) throws SQLException {        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "select * from trainer where id = ? and is_active = 1";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet trainerDetail = preparedStatement.executeQuery();
	    trainerDetail.next(); 
            Trainer trainer = new Trainer();
            trainer.setId(trainerDetail.getString(Constants.employeeId)); 
            trainer.setName(trainerDetail.getString(Constants.employeeName));
            trainer.setDateOfBirth(trainerDetail.getDate(Constants.employeeDateOfBirth).toLocalDate()); 
            trainer.setEmail(trainerDetail.getString(Constants.employeeEmail));
            trainer.setContactNumber(trainerDetail.getLong(Constants.employeeContactNumber));
            trainer.setAlternateContactNumber(trainerDetail.getLong(Constants.employeeAlternateContactNumber));
            trainer.setAddress(trainerDetail.getString(Constants.employeeAddress));
            trainer.setYearOfGraduation(trainerDetail.getInt(Constants.employeeYearOfGraduation));
            trainer.setPrimaryLanguage(trainerDetail.getString(Constants.employeePrimaryLanuage));
            trainer.setAadharNumber(trainerDetail.getLong(Constants.employeeAadharNumber));
            trainer.setPancardNumber(trainerDetail.getString(Constants.employeePancardNumber));
            trainer.setTrainingExperience(trainerDetail.getInt(Constants.trainerTrainingExperience));
            trainer.setProjectCount(trainerDetail.getInt(Constants.trainerProjectCount));
            trainer.setProjectName(trainerDetail.getString(Constants.trainerProjectname));        
            return trainer;
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainer not found");
        } finally {
            preparedStatement.close();
            connection.close();
        }  
    }

    /**
     * <p>
     * To retrieve trainee detail from database
     * by trainee id
     * </p>
     *
     * @param id - trainee id
     *
     * @return trainee
     */
    public Trainee retrieveTrainee(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "select * from trainee where id = ? and is_active = 1";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet traineeDetail = preparedStatement.executeQuery();
	    traineeDetail.next();	
	    Trainee trainee = new Trainee();        
            trainee.setId(traineeDetail.getString(Constants.employeeId)); 
            trainee.setName(traineeDetail.getString(Constants.employeeName));
            trainee.setDateOfBirth(traineeDetail.getDate(Constants.employeeDateOfBirth).toLocalDate()); 
            trainee.setEmail(traineeDetail.getString(Constants.employeeEmail));
            trainee.setContactNumber(traineeDetail.getLong(Constants.employeeContactNumber));
            trainee.setAlternateContactNumber(traineeDetail.getLong(Constants.employeeAlternateContactNumber));
            trainee.setAddress(traineeDetail.getString(Constants.employeeAddress));
            trainee.setYearOfGraduation(traineeDetail.getInt(Constants.employeeYearOfGraduation));
            trainee.setPrimaryLanguage(traineeDetail.getString(Constants.employeePrimaryLanuage));
            trainee.setAadharNumber(traineeDetail.getLong(Constants.employeeAadharNumber));
            trainee.setPancardNumber(traineeDetail.getString(Constants.employeePancardNumber));
            trainee.setSkill(traineeDetail.getString(Constants.traineeSkill));
            trainee.setDegree(traineeDetail.getString(Constants.traineeDegree));
            return trainee;
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainee not found");
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    /**
     * <p>
     * To insert trainee detail into database
     * </p>
     *
     * @param trainee
     *
     * @return void
     */
    public boolean insertTrainee(Trainee trainee) throws SQLException { 
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance(); 
            String query = "insert into trainee (id, name, date_of_birth, email, contact_number,"
                           + "alternate_contact_number, address,"
                           + "year_of_graduation, primary_language,"
                           + "aadharcard_number, pancard_number, "
                           + "skill, degree)"
                           + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                           + "?, ? );";                              
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainee.getId());
            preparedStatement.setString(2, trainee.getName());
            preparedStatement.setDate(3, Date.valueOf(trainee.getDateOfBirth()));
            preparedStatement.setString(4, trainee.getEmail());
            preparedStatement.setLong(5, trainee.getContactNumber());
            preparedStatement.setLong(6, trainee.getAlternateContactNumber());
            preparedStatement.setString(7, trainee.getAddress());
            preparedStatement.setInt(8, trainee.getYearOfGraduation());
            preparedStatement.setString(9, trainee.getPrimaryLanguage());
            preparedStatement.setLong(10, trainee.getAadharNumber());
            preparedStatement.setString(11, trainee.getPancardNumber());
            preparedStatement.setString(12, trainee.getSkill());
            preparedStatement.setString(13, trainee.getDegree());            
            return (1 == preparedStatement.executeUpdate()) ? true : false ;  
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainee not inserted");
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    /**
     * <p>
     * To insert trainer detail into database
     * </p>
     *
     * @param trainer
     *
     * @return void
     */
    public boolean insertTrainer(Trainer trainer) throws SQLException {     
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "insert into trainer (id, name, date_of_birth, email, contact_number,"
                           + "alternate_contact_number, address,"
                           + "year_of_graduation, primary_language, "
                           + "aadharcard_number, pancard_number, "
                           + "training_experience, project_count,"
                           + "project_name)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                           + "?, ?, ? );";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainer.getId());
            preparedStatement.setString(2, trainer.getName());
            preparedStatement.setDate(3, Date.valueOf(trainer.getDateOfBirth()));
            preparedStatement.setString(4, trainer.getEmail());
            preparedStatement.setLong(5, trainer.getContactNumber());
            preparedStatement.setLong(6, trainer.getAlternateContactNumber());
            preparedStatement.setString(7, trainer.getAddress());
            preparedStatement.setInt(8, trainer.getYearOfGraduation());
            preparedStatement.setString(9, trainer.getPrimaryLanguage());
            preparedStatement.setLong(10, trainer.getAadharNumber());
            preparedStatement.setString(11, trainer.getPancardNumber());
            preparedStatement.setInt(12, trainer.getTrainingExperience());
            preparedStatement.setInt(13, trainer.getProjectCount());
            preparedStatement.setString(14, trainer.getProjectName());
            return (1 == preparedStatement.executeUpdate()) ? true : false ;  
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainer not inserted");
        } finally {
            preparedStatement.close();
            connection.close();
        }    
    }
    
    /**           
     * <p>
     * To delete trainer detail using by
     * trainer id from database
     * </p>
     *
     * @param id - trainer id
     *
     * @return boolean
     */
    public boolean deleteTrainer(String id) throws SQLException { 
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "update trainer set is_active = 0 where id = ?"; 
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            String sql = "update trainee set trainer_id = ? where trainer_id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "NULL");
            preparedStatement.setString(2, id);
            return (1 == preparedStatement.executeUpdate()) ? true : false;
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainer not deleted");
        } finally {
            preparedStatement.close();
            connection.close();
        }  
    }
    
    /**
     * <p>
     * To delete trainee detail using 
     * by trainee id from database
     * </p>
     *
     * @param id - trainee id
     *
     * @return boolean
     */
    public boolean deleteTrainee(String id)  throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();
            String query = "update trainee set is_active = 0 where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            return (1 == preparedStatement.executeUpdate()) ? true : false; 
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainee not deleted");
        } finally {
            preparedStatement.close();
            connection.close();
        } 
    }

    /**
     * <p>
     * This method is used for assign trainer to trainee
     * </p>
     *
     * @param trainerId - id of the trainer
     * @param traineeId - id of the trainee
     *
     * @return boolean
     */       
    public boolean assignTrainerToTrainee(String trainerId, String traineeId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getInstance();           
            String query = "update trainee set Trainer_id = ? where id = ? and is_active = 1 ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainerId);
            preparedStatement.setString(2, traineeId);
            return (1 == preparedStatement.executeUpdate()) ? true : false;  
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage() + "Trainer not assigned to trainee");
        } finally {
            preparedStatement.close();
            connection.close();
        } 
    }
    
    /**
     * <p>
     * This method is used retrieve trainer contact number
     * </p>
     *
     * @param contactNumber - contactNumber of the trainer
     *
     * @return boolean
     */
    public boolean getTrainerContactNumber(long contactNumber) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = true;
        try {
            connection = ConnectionUtil.getInstance(); 
            String sql = "select contact_number from trainer where is_active = 1";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet trainerDetail = preparedStatement.executeQuery();
            while (trainerDetail.next()) {
                if (contactNumber == trainerDetail.getLong(Constants.employeeContactNumber)) {
                    flag = false;
                }
            }
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        } 
        return flag;
    }

    /**
     * <p>
     * This method is used retrieve trainee contact number
     * </p>
     *
     * @param contactNumber - contactNumber of the trainee
     *
     * @return boolean
     */
    public boolean getTraineeContactNumber(long contactNumber) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = true;
        try {
            connection = ConnectionUtil.getInstance(); 
            String sql = "select contact_number from trainee where is_active = 1";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet traineeDetail = preparedStatement.executeQuery();
            while (traineeDetail.next()) {
                if (contactNumber == traineeDetail.getLong(Constants.employeeContactNumber)) {
                    flag = false;
                }
            }
        } catch (SQLException sqlException) {
            throw new SQLException(sqlException.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return flag;
    }
    
    /**
     * <p>
     * This amethod is used retrieve trainee aadharcard number
     * </p>
     *
     * @param aadharNumber - aadharNumber of the trainee
     *
     * @return boolean
     */
    public boolean getTraineeAadhartNumber(long aadharNumber) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = true;
        try {
            connection = ConnectionUtil.getInstance(); 
            String sql = "select aadharcard_number from trainee where is_active = 1";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet traineeDetail = preparedStatement.executeQuery();
            while(traineeDetail.next()) {
                if (aadharNumber == traineeDetail.getLong(Constants.employeeAadharNumber)) {
                    flag = false;
                }
            }
        } catch (SQLException sqlException) {
          throw new SQLException(sqlException.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return flag;
    }

    /**
     * <p>
     * This amethod is used retrieve trainer aadharcard number
     * </p>
     *
     * @param aadharNumber - aadharNumber of the trainer
     *
     * @return boolean
     */
    public boolean getTrainerAadhartNumber(long aadharNumber) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = true;
        try {
            connection = ConnectionUtil.getInstance(); 
            String sql = "select aadharcard_number from trainer where is_active = 1";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet trainerDetail = preparedStatement.executeQuery();
            while(trainerDetail.next()) {
                if (aadharNumber == trainerDetail.getLong(Constants.employeeAadharNumber)) {
                    flag = false;
                }
            }
        } catch (SQLException sqlException) {
          throw new SQLException(sqlException.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return flag;   
    }

    /**
     * <p>
     * This method is used retrieve trainer pancard number
     * </p>
     *
     * @param panCard - pancard number of the trainer
     *
     * @return boolean
     */ 
    public boolean getTrainerPancardNumber(String panCard) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = true;
        try {
            connection = ConnectionUtil.getInstance(); 
            String sql = "select pancard_number from trainer where is_active = 1";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet trainerDetail = preparedStatement.executeQuery();
            while(trainerDetail.next()) {
                if (panCard.equals(trainerDetail.getString(Constants.employeePancardNumber))) {
                    flag = false;
                }
            }
        } catch (SQLException sqlException) {
          throw new SQLException(sqlException.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return flag;    
    }

    /**
     * <p>
     * This method is used retrieve trainee pancard number
     * </p>
     *
     * @param panCard - pancard number of the trainee
     *
     * @return boolean
     */ 
    public boolean getTraineePancardNumber(String panCard) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = true;
        try {
            connection = ConnectionUtil.getInstance(); 
            String sql = "select pancard_number from trainee where is_active = 1";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet traineeDetail = preparedStatement.executeQuery();
            while(traineeDetail.next()) {
                if (panCard.equals(traineeDetail.getString(Constants.employeePancardNumber))) {
                    flag = false;
                }
            }
        } catch (SQLException sqlException) {
          throw new SQLException(sqlException.getMessage());
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return flag;    
    }
}