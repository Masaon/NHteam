package wiki;

import java.sql.Timestamp;

public class WikiPage{
	private String name;
	private String content;
	private String updateTime;
	
	public String getFormatedContent(){
		WikiFormater wf = new WikiFormater();
		return wf.formatText(content);
	}
	
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
}