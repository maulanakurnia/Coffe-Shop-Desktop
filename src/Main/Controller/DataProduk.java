package Main.Controller;

public class DataProduk {
	private static String idPemesanan;
	String idKopi;
	int stok;
	float harga;
	String namaKopi;

	public DataProduk(String vidKopi){
		idKopi 		= vidKopi;
	}

    public DataProduk() {

    }

    public String getIdKopi(){
				return idKopi;
		}
	public String getNamaKopi(){
			return namaKopi;
	}
	public float getHarga(){
			return harga;
	}
	public int getStok(){
			return stok;
	}

	public void setIdKopi(String vidKopi){ idKopi = vidKopi;}
	public void setNamaKopi(String vnamaKopi){
			namaKopi = vnamaKopi;
	}
	public void setHarga(float vHarga){
			harga = vHarga;
	}
	public void setStok(int vstok){
			stok = vstok;
	}

	public String getIdPemesanan(){return idPemesanan;}
	public void setIdPemesanan(String vidPemesanan){ idPemesanan = vidPemesanan;}

}
