package Main.Controller;

public class DataProduk {
	String idKopi;
	int stok;
	float harga;
	String namaKopi;

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
}
