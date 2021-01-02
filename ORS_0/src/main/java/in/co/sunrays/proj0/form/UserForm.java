package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.util.Util;
import in.co.sunrays.proj0.validator.Custom;

/**
 * Contains User form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator 
 */
public class UserForm extends BaseForm{
	
	@NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z_-]+$") */
	 @Custom(regex = "^[a-zA-Z_-]+$",message = "{error.firstName.invalid}")  
    private String firstName;
    /**
     * Last Name of User
     */
    @NotEmpty
    @Custom(regex = "^[a-zA-Z_-]+$",message = "{Custom.form.lastName}")
    private String lastName;
    
    @NotEmpty
    @Email
    private String login;
    /**
     * Password of User
     */
    @NotEmpty(message =
	  "{Custom.form.password}")
	 //@Custom(regex="^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
    private String password;
    
    

    /**
     * Date of Birth of User
     */
    @NotEmpty
    private String dob;

    /**
     * MobielNo of User
     */
    @NotEmpty
	@Phone(message = "{Phone.form.mobileNo}")
    private String mobileNo;

    /**
     * Role of User
     */
    @Min(value=1,message="{Min.form.roleId}")
    private long roleId;
    
    private String roleName;
    
    /**
     * Number of unsuccessful login attempt
     */
    private int unSuccessfulLogin;
    /**
     * Gender of User
     */
    @NotEmpty
    private String gender;
    /**
     * Last login long
     */
    private long lastLogin;
    /**
     * User Lock
     */
    private String lock;

    /**
     * IP Address of User from where User was registred.
     */

    private String registeredIP;
    /**
     * IP Address of User of his last login
     */

    private String lastLoginIP;

    /*
     * Accesor Methods
     */
    @NotEmpty
    private String confirmPassword;
    
    
  
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getUnSuccessfulLogin() {
		return unSuccessfulLogin;
	}

	public void setUnSuccessfulLogin(int unSuccessfulLogin) {
		this.unSuccessfulLogin = unSuccessfulLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
    public BaseDTO getDto() {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmailId(login);
        
      /*  if(!password.matches(confirmPassword))
        {
        	dto.setPassword(password);
        	 dto.setConfirmPassword(confirmPassword);  	
        }
      */ 
        if(dob!=""){
        dto.setDob(Util.getDate(dob));
        }
        dto.setPassword(password);
        dto.setMobileNo(mobileNo);
        dto.setRoleId(roleId);
        dto.setRoleName(roleName);
        //dto.setLastLogin(new Timestamp(lastLogin));
        dto.setGender(gender);
       // dto.setRegisteredIP(registeredIP);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

        return dto;
    }

    @Override
    public void populate(BaseDTO bDto) {

        UserDTO dto = (UserDTO) bDto;

        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        login = dto.getEmailId();
        password = dto.getPassword();
        confirmPassword=dto.getConfirmPassword();
        gender=dto.getGender();
        dob = Util.getDate(dto.getDob());
        
        mobileNo = dto.getMobileNo();
        roleId = dto.getRoleId();
        
       /* if (dto.getLastLogin() != null) {
            lastLogin = dto.getLastLogin().getTime();
        }
        gender = dto.getGender();
        registeredIP = dto.getRegisteredIP();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        if (dto.getCreatedDatetime() != null) {
            createdDatetime = dto.getCreatedDatetime().getTime();
        }
        if (dto.getModifiedDatetime() != null) {
            modifiedDatetime = dto.getModifiedDatetime().getTime();
        }*/

    }

}

