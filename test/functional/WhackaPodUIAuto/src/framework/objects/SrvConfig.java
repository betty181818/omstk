package framework.objects;

import org.apache.log4j.Logger;

/**
* Date : 2017-03-28
* Owner : lixia.yuan
* @author lixia.yuan
*/

public class SrvConfig{
	
	private String UIUrl;
	private String UIAdvancedUrl;
	private String AppUrl;
	
public static final Logger logger = Logger.getLogger(SrvConfig.class);
	
	public void setUIUrl(String UIUrl) {
		this.UIUrl = UIUrl;	
	}
	
	public String getUIUrl() {	
		return this.UIUrl;
	}
	
	public void setUIAdvancedUrl(String UIAdvancedUrl) {
		this.UIAdvancedUrl = UIAdvancedUrl;	
	}
	
	public String getUIAdvancedUrl() {	
		return this.UIAdvancedUrl;
	}
	public void setAppUrl(String AppUrl) {
		this.AppUrl = AppUrl;	
	}
	
	public String getAppUrl() {	
		return this.AppUrl;
	}

}