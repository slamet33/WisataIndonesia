package id.slametriyadi.wisataindonesia.Response;

import com.google.gson.annotations.SerializedName;

public class ListDataDaerah {

	@SerializedName("nama_daerah")
	private String namaDaerah;

	@SerializedName("id_daerah")
	private String idDaerah;

	@SerializedName("id")
	private String id;

	@SerializedName("image_daerah")
	private String imageDaerah;

	public void setNamaDaerah(String namaDaerah){
		this.namaDaerah = namaDaerah;
	}

	public String getNamaDaerah(){
		return namaDaerah;
	}

	public void setIdDaerah(String idDaerah){
		this.idDaerah = idDaerah;
	}

	public String getIdDaerah(){
		return idDaerah;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setImageDaerah(String imageDaerah){
		this.imageDaerah = imageDaerah;
	}

	public String getImageDaerah(){
		return imageDaerah;
	}

	@Override
 	public String toString(){
		return 
			"ListDataDaerah{" +
			"nama_daerah = '" + namaDaerah + '\'' + 
			",id_daerah = '" + idDaerah + '\'' + 
			",id = '" + id + '\'' + 
			",image_daerah = '" + imageDaerah + '\'' + 
			"}";
		}
}