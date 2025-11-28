package POJO_Deserialization_Json_Response;

import java.util.List;

public class ParentClassCourses 
{
private List<WebAutomationChild> webAutomation;
private List<APIChild> api;
private List<MobileChild> mobile;
public List<WebAutomationChild> getWebAutomation() {
	return webAutomation;
}
public void setWebAutomation(List<WebAutomationChild> webAutomation) {
	this.webAutomation = webAutomation;
}
public List<APIChild> getApi() {
	return api;
}
public void setApi(List<APIChild> api) {
	this.api = api;
}
public List<MobileChild> getMobile() {
	return mobile;
}
public void setMobile(List<MobileChild> mobile) {
	this.mobile = mobile;
}


}
