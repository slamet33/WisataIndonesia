package id.slametriyadi.wisataindonesia.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseReadLogo{

	@SerializedName("data")
	private List<ListKategori> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<ListKategori> data){
		this.data = data;
	}

	public List<ListKategori> getData(){
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
			"ResponseReadLogo{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}