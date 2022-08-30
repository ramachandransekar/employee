/**
 * <p>
 * This is the package for employeecontroller class
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.controller;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ideas2it.employee.common.Constants;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Trainee; 
import com.ideas2it.employee.model.Trainer;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employee.util.CommonUtil;
import com.ideas2it.employee.util.DateUtil;
import com.ideas2it.employee.util.StringUtil;

/**             
 * <p>
 * EmployeeController class with the helps of getting inputs 
 * from user and passing to employeeservice. 
 * </p>
 *
 * @author Ramachandran
 *
 * @version 1
 *
 * @since 2022-07-18
 */
public class EmployeeController {
  
    private Logger employeeLogger = Logger.getLogger(EmployeeController.class);    

    private EmployeeService employeeService = new EmployeeServiceImpl();

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String log4jPath = Constants.log4jPath;
        PropertyConfigurator.configure(log4jPath);
        EmployeeController employeeController = new EmployeeController();
	employeeController.init();
    }

    /**
     * <p>
     * To create a employee menu using create, read, update, delete operation add
     * employee detail,display employee eetails,update employee detail,delete
     * employee detail
     * </p>
     *
     * @return void
     *
     */
    public void init() {
        boolean choice = true;
	String id; 
	while (choice) {		
	    employeeLogger.info("Enter 1 add employee detail");
	    employeeLogger.info("Enter 2 display employee detail");
	    employeeLogger.info("Enter 3 delete employee detail");
	    employeeLogger.info("Enter 4 update employee detail");
            employeeLogger.info("Enter 5 assign trainer to trainee");           
            employeeLogger.info("Enter 6 display trainers and trainees");
            employeeLogger.info("Enter 7 display assigned trainer to trainees");
	    employeeLogger.info("Enter 8 exit");
	    String input = scanner.next();
	    switch (input) {
	    case "1":
                try {
	            addEmployee(); 
                } catch (SQLException sqlException) {
                    employeeLogger.error(sqlException.getMessage() + "Employee not inserted");
                }
	        break;
	    case "2":
	        employeeLogger.info("Enter 1 display trainer detail");
		employeeLogger.info("Enter 2 display trainee detail");
		String displayOption = scanner.next();
		employeeLogger.info("Enter id to display:");
	        id = scanner.next();
		switch (displayOption) {
		case "1":
                    try {
		        displayTrainerDetail(id);
                    } catch(SQLException sqlException) {
                        employeeLogger.error(sqlException.getMessage() + "Trainer Not Found");
                    }
		    break;
		case "2":
                    try {
		        displayTraineeDetail(id);
                    } catch(SQLException sqlException) {
                        employeeLogger.error(sqlException.getMessage() + "Trainee Not Found");
                    }		    
		    break;
		default:
		    employeeLogger.error("Invalid selection");
		}      
	        break;
	    case "3":
                employeeLogger.info("Enter 1 delete trainer detail");
		employeeLogger.info("Enter 2 delete trainee detail");
		String deleteOption = scanner.next();
		employeeLogger.info("Enter id to delete :");
		id = scanner.next();
		switch (deleteOption) {
		case "1":
                    try {
		        if (employeeService.deleteTrainerById(id)) {
	                    employeeLogger.info("Successfully Deleted");
		        } 
                    } catch(SQLException sqlException) {
                         employeeLogger.error(sqlException.getMessage() + "Employee Not Found");
                    }
		    break;
		case "2":
                    try {
		        if (employeeService.deleteTraineeById(id)) {
	                    employeeLogger.info("Successfully Deleted");
		        } 
                    } catch(SQLException sqlException) {
                         employeeLogger.error(sqlException.getMessage() + "Employee Not Found");
                    }
		    break;
		default:
	            employeeLogger.error("Invalid selection");   
		} 
	        break;
	    case "4":
                try {
                    employeeLogger.info("Enter 1 update trainer detail");
	            employeeLogger.info("Enter 2 update trainee detail");
		    int updateOption = scanner.nextInt();
	 	    employeeLogger.info("Enter id to update:");
		    id = scanner.next();
		    updateEmployeeDetail(updateOption, id);
                } catch(SQLException sqlException) {
                    employeeLogger.error(sqlException.getMessage() + "Invalid! to update");
                }
		break;
            case "5":
                assignTrainerToTrainee();
                break;
            case "6":
                employeeLogger.info("Enter 1 display  trainers details");
	        employeeLogger.info("Enter 2 display  trainees details");
                String displayChoice = scanner.next();
                switch (displayChoice) {
                case "1":
                    try {
                        displayTrainers();
                    } catch (SQLException sqlException) {
                        employeeLogger.error(sqlException.getMessage() + "Empty database of trainer");
                    }
                    break;
                case "2":
                    try {
                        displayTrainees();
                    } catch (SQLException sqlException) {
                        employeeLogger.error(sqlException.getMessage() + "Empty database of trainer");
                    }
                    
                    break;
                default:
                    employeeLogger.info("Invalid selection"); 
                }
                break;     
            case "7":
                try {
                    employeeLogger.info("Eneter trainer id ");
                    id = scanner.next();
                    displayAssignedTrainerToTrainees(id); 
                } catch (SQLException sqlException) {
                    employeeLogger.error(sqlException.getMessage());
                } 
                break;                
            case "8":
		choice = false;
		break;
	    default:
		employeeLogger.error("Invalid selection");
	    }
        } 			
    }

    /**
     * <p> 
     * To display all the trainees under the trainer
     * </p>
     *
     * @return void
     */
    public void displayAssignedTrainerToTrainees(String id) throws SQLException {
        employeeLogger.info("Trainer detail :");
	employeeLogger.info(employeeService.displayTrainer(id).toString()); 
        employeeLogger.info("Trainee detail :");
        for (Trainee trainee : employeeService.displayAssignedTrainerToTrainees(id)) {
            employeeLogger.info(trainee.toString()); 
        }
    }

    /**
     * <p> 
     * To display all the trainer details when its called
     * </p>
     *
     * @return void
     */
    public void displayTrainers() throws SQLException {          
        for (Trainer trainer : employeeService.displayTrainers()) {
            employeeLogger.info(trainer.toString());                                                  
        }
    }
 
    /**
     * <p> 
     * To display all the trainee details when its called
     * </p>
     *
     * @return void
     */
    public void displayTrainees() throws SQLException {       
        for (Trainee trainee : employeeService.displayTrainees()) {
            employeeLogger.info(trainee.toString());                                                
	}             
    }	

    /**
     * <p> 
     * To display specific trainee detail using trainee id 
     * </p>
     *
     * @param id - employee id
     *
     * @return void
     */
    public void displayTraineeDetail(String id) throws SQLException {        
        employeeLogger.info(employeeService.displayTrainee(id).toString());
    }	

    /**
     * <p>
     * To display specific trainer detail using trainer id 
     * </p>
     *
     * @param id - employee id
     *
     * @return void
     */	
    public void displayTrainerDetail(String id) throws SQLException {        
        employeeLogger.info(employeeService.displayTrainer(id).toString());     
    }
     
    /**
     * <p>
     * To update employee details and getting new value and update option 
     * </p>
     *
     * @param updateOption - employee updateOption    
     * @param id - employe id
     *
     * @return void
     */
    public void updateEmployeeDetail(int updateOption, String id) throws SQLException {
        String updateNewValue = "";
	switch (updateOption) {
	case 1:
	    updateEmployee();
	    employeeLogger.info("Enter 10 update trainingexperience");
	    employeeLogger.info("Enter 11 update project count");
	    employeeLogger.info("Enter 12 update project name");
	    int trainerUpdate = scanner.nextInt();
	    employeeLogger.info("Enter the new value to update");
	    updateNewValue = scanner.next();
	    boolean isTrainerUpdated = employeeService.updateTrainerById(id, trainerUpdate, updateNewValue);
	    if (isTrainerUpdated) {
	        employeeLogger.info("Successfully Updated");
	    } else {
                employeeLogger.error("Employee Not Found");
	    }
	    break;
	case 2:
	    updateEmployee();
	    employeeLogger.info("Enter 10 update skill");
	    employeeLogger.info("Enter 11 update degree");
	    int traineeUpdate = scanner.nextInt();
	    employeeLogger.info("Enter the new value to update");
	    updateNewValue = scanner.next();
	    boolean isTraineeUpdated = employeeService.updateTraineeById(id, traineeUpdate, updateNewValue);
	    if (isTraineeUpdated) {
	        employeeLogger.info("Successfully Updated");
	    } else {
		employeeLogger.error("Employee Not Found ");
	    }
	    break;
	default:
	    employeeLogger.error("Invalid selection");
	}
    }

    /**
     * <p>
     * This method used for showing common update's selection
     * for update the employee details
     * </p>
     *
     * @return void
     */
    public void updateEmployee() {
        employeeLogger.info("Enter 1 update name");
	employeeLogger.info("Enter 2 update date of birth");
	employeeLogger.info("Enter 3 update contact number");
	employeeLogger.info("Enter 4 update alternate contact number");
	employeeLogger.info("Enter 5 update address");
	employeeLogger.info("Enter 6 update year of graduation");
	employeeLogger.info("Enter 7 update primary language");
	employeeLogger.info("Enter 8 update aadharcard number");
	employeeLogger.info("Enter 9 update pancard number");
    }
    
    /**
     * <p>
     * This method used to provide trainers availability to assign
     * trainee
     * </p>
     *
     * @return void 
     */
    public void displayTrainerNameAndId() throws SQLException {          
        for (Trainer trainer : employeeService.displayTrainers()) {             
            employeeLogger.info("Name : " + trainer.getName().toString() + " Id : "+trainer.getId().toString());
	}  
    }

    /**
     * <p>
     * This method used to provide trainees availability to assign 
     * trainer
     * </p>
     *
     * @return void 
     */
    public void displayTraineeNameAndId() throws SQLException {  
        for (Trainee trainee : employeeService.displayTrainees()) {
            employeeLogger.info("Name : "+trainee.getName().toString()+" Id : "+trainee.getId().toString());            
	}  
    }

    /**
     * <p>
     * This method used to associate trainer and trainee
     * by using id
     * </p>
     *
     * @return void
     */
    public void assignTrainerToTrainee() {    
        try {            
            employeeLogger.info("Available tainers");
            displayTrainerNameAndId();
            employeeLogger.info("Available tainees");
            displayTraineeNameAndId();	
            employeeLogger.info("Enter trainer id ");
	    String trainerId = scanner.next();
            employeeLogger.info("Enter trainee id ");      
            String traineeId = scanner.next();	
            if (employeeService.assignTrainerToTrainees(trainerId, traineeId)) {
                employeeLogger.info("trainer assigned to trainee");
            } else {
                employeeLogger.info("Invalid trainee id");
            }
        } catch(SQLException sqlException) { 
            employeeLogger.info(sqlException.getMessage()); 
        }	
    }

    /**
     * <p>
     * This method used for add employee details
     * </p>
     *
     * @return void
     */
    public void addEmployee() throws SQLException { 
        employeeLogger.info("Enter name:");
        String name = stringValidation();                               
        employeeLogger.info("Enter date of birth this format yyyy-mm-dd:");
        LocalDate dateOfBirth = dateValidation();
        employeeLogger.info("Enter contact number:");
        long contactNumber = contactNumberValidation();
        employeeLogger.info("Enter alternate contact number:");
        long alternateContactNumber = contactNumberValidation();
        employeeLogger.info("Enter address detail:");
        String address = stringValidation();                             
        employeeLogger.info("Enter year of graduation:");
        int graduation = graduationValidation();
        employeeLogger.info("Enter primary language:");
        String language = stringValidation();                               
        employeeLogger.info("Enter aadharcard number:");
	long aadharNumber = longValidation();
        employeeLogger.info("Enter pancard number:");
        String panCard = pancardValidation();
	selectTrainerOrTrainee(name, dateOfBirth, contactNumber, alternateContactNumber, address, graduation,
			       language, aadharNumber, panCard);		
    }

    /**
     * <p>
     * This method is used for select trainer or 
     * trainee to add
     * </p>
     *
     * @param name - employee name
     * @param dateOfBirth - employee dateOfBirth 
     * @param contactNumber - employee contactNumber 
     * @param alternateContactNumber - employee alternateContactNumber 
     * @param address - employee address 
     * @param graduation - employee graduation 
     * @param language - employee language 
     * #param aadharNumber - employee aadharNumber 
     * @param panCard - employee panCard 
     *
     * @return void
     */	
    public void selectTrainerOrTrainee(String name, LocalDate dateOfBirth, long contactNumber,                
			               long alternateContactNumber, String address, int graduation,
                                       String language, long aadharNumber, String panCard) throws SQLException {
        employeeLogger.info("Enter 1 add trainer:");
	employeeLogger.info("Enter 2 add trainee:");
	int employeeType = scanner.nextInt();  
	if (1 == employeeType) {	
            employeeLogger.info("Enter training experience:");
            int trainingExperience = integerValidation();
            employeeLogger.info("Enter project count:");
            int projectCount = integerValidation();   			
            employeeLogger.info("Enter project name:");
	    String projectName = scanner.next();            				
	    boolean isTrainerUpdated = employeeService.addTrainer(name, dateOfBirth, contactNumber, alternateContactNumber, address, graduation,
				                                language, aadharNumber, panCard, trainingExperience, projectCount, projectName);
            if (isTrainerUpdated) {
                employeeLogger.info("Trainer Added successfully");
            } else {
                employeeLogger.error("Trainer not added successfully");
            }            
	} else if (2 == employeeType) {
	    employeeLogger.info("Enter skill:");
	    String skill = scanner.next();
	    employeeLogger.info("Enter degree:");
	    String degree = scanner.next();
	    boolean isTraineeUpdated = employeeService.addTrainee(name, dateOfBirth, contactNumber, alternateContactNumber, address, graduation,
                                                                language, aadharNumber, panCard, skill, degree);	  
            if (isTraineeUpdated) {
                employeeLogger.info("Trainee added successfully");
            } else {
                employeeLogger.error("Trainee not added successfully");
            } 
           			       
	} else {
	    employeeLogger.error("invalid selection! Enter again");
	    employeeType = scanner.nextInt();			
	}				
    }
   
    /**
     * <p>
     * This method is used for long validation for all 
     * long inputs getting from employee
     * </p> 
     *
     * @return long
     */
    private long longValidation() throws SQLException {
        boolean flag = true;
        long aadharNumber = 0;
        while (flag) {
            try {			
	        aadharNumber = scanner.nextLong();   
                if (CommonUtil.isValidAadharNumber(aadharNumber) && 
                        employeeService.isTrainerAadharNumberExist(aadharNumber) && 
                            employeeService.isTraineeAadharNumberExist(aadharNumber)) {
                    flag = false;
                } else {
                    employeeLogger.error("Invalid! Enter again");
                }                      
            } catch (InputMismatchException inputMismatchException) {
                employeeLogger.error(" Invalid! Enter again");
                scanner.nextLine();
            }
        } 
        return aadharNumber;                      	
    }

    /**
     * <p>
     * This method is used for date validation 
     * </p>
     *
     * @return LocalDate
     */    
    private LocalDate dateValidation() {    
        boolean flag = true;
        LocalDate dateOfBirth = null;
        String date ="";
        while (flag) {
            try {
                date = scanner.next();
                dateOfBirth = DateUtil.convertStringToDate(date);
                flag = false;
            } catch(DateTimeParseException dateTimeParseException) {
                employeeLogger.error("Invalid! Enter again");
                scanner.nextLine();
            }
        }
        return dateOfBirth;       		
    }

    /**
     * <p>
     * This method is used for graduation validation 
     * </p>
     *
     * @return int
     */
    private int graduationValidation() { 
        boolean flag = true;
	int graduation = 0;
        while (flag) {
            try {
                graduation = scanner.nextInt();
                if (CommonUtil.isValidGraduation(graduation)) {
                    flag = false;
                } else {
                    employeeLogger.error("Invalid ! Enter again");
                }
            } catch (InputMismatchException inputMismatchException) {
                employeeLogger.error("Invalid! Enter again");
                scanner.nextLine();
            }     
        }
        return graduation;
    } 
    
    /**
     * <p>
     * This method is used for common integer validation for 
     * employee
     * </p>
     *
     * @return int
     */        	    	
    private int integerValidation() {
        boolean flag = true;
        int trainingExperience = 0;           
	while (flag) {
            try {
                trainingExperience = scanner.nextInt();
	        if(CommonUtil.isValidTrainingExperience(trainingExperience)) {
                    flag = false;
		} else {
		    employeeLogger.error("Invalid ! Enter again");
	        }
            } catch (InputMismatchException inputMismatchException) {
                employeeLogger.error("Invalid! Enter again");
                scanner.nextLine();
            } 
        }
        return trainingExperience;   				
    }
             
    /**
     * <p>
     * This method is used for contact number validation 
     * </p>
     *
     * @return String
     */
    public long contactNumberValidation() throws SQLException {              
        boolean flag = true;
        long contactNumber = 0;
        while (flag)  {
            try {
                contactNumber = scanner.nextLong();                                                                    
                if (CommonUtil.isValidMobileNumber(contactNumber) && 
                        employeeService.isTrainerContactNumberExist(contactNumber) && 
                            employeeService.isTraineeContactNumberExist(contactNumber)) {     
                    flag = false;
                } else {
                    employeeLogger.error("Invalid! Enter again");
                } 
            } catch (InputMismatchException inputMismatchException) {
                employeeLogger.error("Invalid! Enter again");
                scanner.nextLine();
            }                       
        }
        return contactNumber;
    }
    
    /**
     * <p>
     * This method is used for String number validation 
     * </p>
     *
     * @return String
     */    
    public String stringValidation() {	
        boolean flag = true;
        String name = null;
        while (flag) {
            try {
                name = scanner.next(); 
                if (StringUtil.isValidName(name)) {
                    flag = false;
                } else {
                    employeeLogger.error("Invalid! Enter again");
                } 
            } catch (InputMismatchException inputMismatchException) {
                employeeLogger.error("Invalid! Enter again");
                scanner.nextLine();
            }
        }
        return name;   
    }      
    
    /**
     * <p>
     * This method is used for pancard validation 
     * </p>
     *
     * @return String
     */ 
    public String pancardValidation() throws SQLException {
        boolean flag = true;
        String panCard = null;
	while (flag) {
            try {
                panCard = scanner.next();
                if (StringUtil.isValidPanNumber(panCard) && 
                        employeeService.isTrainerPancardNumberExist(panCard) && 
                            employeeService.isTraineePancardNumberExist(panCard)) {
	            flag = false;
		} else {
		    employeeLogger.error("Invalid! Enter again");
                }
            } catch (InputMismatchException inputMismatchException) {
                employeeLogger.error("Invalid! Enter again");
                scanner.nextLine();
            }                
        }
        return panCard;	    
    }				
}
    	

