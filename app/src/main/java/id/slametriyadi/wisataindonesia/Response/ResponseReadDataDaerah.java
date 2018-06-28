package id.slametriyadi.wisataindonesia.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseReadDataDaerah {

	@SerializedName("data")
	private List<ListDataDaerah> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<ListDataDaerah> data){
		this.data = data;
	}

	public List<ListDataDaerah> getData(){
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
			"ResponseReadDataDaerah{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}