package id.slametriyadi.wisataindonesia.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseReadAirTerjun{

	@SerializedName("data")
	private List<ListAirTerjun> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<ListAirTerjun> data){
		this.data = data;
	}

	public List<ListAirTerjun> getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseReadAirTerjun{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}