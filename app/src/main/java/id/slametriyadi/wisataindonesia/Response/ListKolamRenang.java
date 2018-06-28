package id.slametriyadi.wisataindonesia.Response;

import com.google.gson.annotations.SerializedName;

public class ListKolamRenang {

	@SerializedName("desk_kolamrenang")
	private String deskKolamrenang;

	@SerializedName("img_kolamrenang")
	private String imgKolamrenang;

	@SerializedName("tiket_kolamrenang")
	private String tiketKolamrenang;

	@SerializedName("id_daerah")
	private String idDaerah;

	@SerializedName("nama_kolamrenang")
	private String namaKolamrenang;

	@SerializedName("id")
	private String id;

	public void setDeskKolamrenang(String deskKolamrenang){
		this.deskKolamrenang = deskKolamrenang;
	}

	public String getDeskKolamrenang(){
		return deskKolamrenang;
	}

	public void setImgKolamrenang(String imgKolamrenang){
		this.imgKolamrenang = imgKolamrenang;
	}

	public String getImgKolamrenang(){
		return imgKolamrenang;
	}

	public void setTiketKolamrenang(String tiketKolamrenang){
		this.tiketKolamrenang = tiketKolamrenang;
	}

	public String getTiketKolamrenang(){
		return tiketKolamrenang;
	}

	public void setIdDaerah(String idDaerah){
		this.idDaerah = idDaerah;
	}

	public String getIdDaerah(){
		return idDaerah;
	}

	public void setNamaKolamrenang(String namaKolamrenang){
		this.namaKolamrenang = namaKolamrenang;
	}

	public String getNamaKolamrenang(){
		return namaKolamrenang;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ListKolamRenang{" +
			"desk_kolamrenang = '" + deskKolamrenang + '\'' + 
			",img_kolamrenang = '" + imgKolamrenang + '\'' + 
			",tiket_kolamrenang = '" + tiketKolamrenang + '\'' + 
			",id_daerah = '" + idDaerah + '\'' + 
			",nama_kolamrenang = '" + namaKolamrenang + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}