package Main.Controller;

public class DataProduk {
		int idKopi, stok;
		float harga;
		String namaKopi;

		public DataProduk(int vidKopi, String vnamaKopi, Float vharga, int vstok){
				idKopi 		= vidKopi;
				namaKopi 	= vnamaKopi;
				harga 		= vharga;
				stok 			= vstok;
		}

		public int getIdKopi(){
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
