package GenericUtilityPack;

public enum EnumClass
{

addPlaceAPI("/maps/api/place/add/json"),
getPlaceAPI("/maps/api/place/get/json"),
updatePlaceAPI("/maps/api/place/update/json"),
deletePlaceAPI("/maps/api/place/delete/json");

 private String resources;
EnumClass(String enumRes)
{
	this.resources=enumRes;
}

public String getAPIResource()
{
	return resources;
}
	
	
}
