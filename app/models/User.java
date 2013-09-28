package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model
{
	@Id
	@Constraints.Required
    @Formats.NonEmpty
	String userId;

	//book currently being read by the usser
	OpenBook current;

	//books bookmarked by the user
	Bookmark bookmark;

	//books read in the past
	BookList history;

	//books user wants to read in the future
	BookList wishlist;

	@Constraints.Required
	AccountDetails accDetails;

	UserSettings userSett;


	// -- Queries
	public static Model.Finder<String,User> find = new Model.Finder<String,User>(String.class, User.class);

	/*
     * Retrieve a User from email.
     */
    public static User findByEmail(String email) 
    {
    	String tempId = AccountDetails.findByEmail(email).userId;

        return find.where().eq("userId", tempId).findUnique();
    }

    /*
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) 
    {
    	String tempId = AccountDetails.findByEmail(email).userId;
    	
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }
}