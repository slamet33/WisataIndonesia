package id.slametriyadi.wisataindonesia.Response;

import com.google.gson.annotations.SerializedName;

public class ListKategori{

	@SerializedName("logo")
	private String logo;

	@SerializedName("id")
	private String id;

	@SerializedName("nama_kategori")
	private String namaKategori;

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNamaKategori(String namaKategori){
		this.namaKategori = namaKategori;
	}

	public String getNamaKategori(){
		return namaKategori;
	}

	@Override
 	public String toString(){
		return 
			"ListAirTerjun{" +
			"logo = '" + logo + '\'' + 
			",id = '" + id + '\'' + 
			",nama_kategori = '" + namaKategori + '\'' + 
			"}";
		}
}