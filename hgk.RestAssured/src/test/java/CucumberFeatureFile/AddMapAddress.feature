Feature: Place Management API Functionalit
@AddPlace
  Scenario Outline: Verify if Place is successfully added using AddPlace API
    Given Add Place Payload <name> <language> <address> with the following details
       
    Examples:
     | name  				 | language  | address 					 |
     | John Doe House| French-IN | side layout cohen |