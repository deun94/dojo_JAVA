package com.moon.caresoftinterfaces;

import java.util.ArrayList;
import java.util.Date;

//extend first then implement
public class Physician extends User implements HIPAACompliantUser {
	
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician (Integer id) {
    	this.id = id;
    }
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
//        \n for the break line
        this.patientNotes.add(report);
    }
    // TO DO: Setters & Getters

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
//	checking four digits
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		
		int lengthOfPin = String.valueOf(pin).length();
		if(lengthOfPin == 4) {
			this.pin = pin;
			//pin is in the user class
			return true;
		}else {
			return false;
		}
	}


	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if( this.id == confirmedAuthID) {
			return true;
		}else {
			return false;
		}
	}
	

  

}
