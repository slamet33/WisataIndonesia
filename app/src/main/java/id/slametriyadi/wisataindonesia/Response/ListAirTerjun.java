package id.slametriyadi.wisataindonesia.Response;

import com.google.gson.annotations.SerializedName;

public class ListAirTerjun {

	@SerializedName("nama_airterjun")
	private String namaAirterjun;

	@SerializedName("tiket_airterjun")
	private String tiketAirterjun;

	@SerializedName("desk_airterjun")
	private String deskAirterjun;

	@SerializedName("id_daerah")
	private String idDaerah;

	@SerializedName("id")
	private String id;

	@SerializedName("img_airterjun")
	private String imgAirterjun;

	public void setNamaAirterjun(String namaAirterjun){
		this.namaAirterjun = namaAirterjun;
	}

	public String getNamaAirterjun(){
		return namaAirterjun;
	}

	public void setTiketAirterjun(String tiketAirterjun){
		this.tiketAirterjun = tiketAirterjun;
	}

	public String getTiketAirterjun(){
		return tiketAirterjun;
	}

	public void setDeskAirterjun(String deskAirterjun){
		this.deskAirterjun = deskAirterjun;
	}

	public String getDeskAirterjun(){
		return deskAirterjun;
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

	public void setImgAirterjun(String imgAirterjun){
		this.imgAirterjun = imgAirterjun;
	}

	public String getImgAirterjun(){
		return imgAirterjun;
	}

	@Override
 	public String toString(){
		return 
			"ListAirTerjun{" +
			"nama_airterjun = '" + namaAirterjun + '\'' + 
			",tiket_airterjun = '" + tiketAirterjun + '\'' + 
			",desk_airterjun = '" + deskAirterjun + '\'' + 
			",id_daerah = '" + idDaerah + '\'' + 
			",id = '" + id + '\'' + 
			",img_airterjun = '" + imgAirterjun + '\'' + 
			"}";
		}
}