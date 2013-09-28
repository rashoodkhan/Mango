package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


@Entity
public class AccountDetails extends Model
{
	@Id
	String userId;

	@Constraints.Required
	String emailId;

	@Constraints.Required
	String password;

	//personal details of the user
	PersonalDetails p_details;


	// -- Queries
	public static Model.Finder<String,AccountDetails> find = new Model.Finder<String,AccountDetails>(String.class, AccountDetails.class);

	/*
     * Retrieve AccountDetails from email.
     */
    public static AccountDetails findByEmail(String email) {
    	
        return find.where().eq("emailId", email).findUnique();
    }
}