/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaBinhNuoc;



/**
 *
 * @author phanh
 */
public class BaBinhNuoc_truoc_sau {
    	public int binh_truoc_1;//trạng thái bình 1 trước khi thực hiện
	public int binh_truoc_2;
        public int binh_truoc_3;
	public int binh_sau_1;
	public int binh_sau_2;
        public int binh_sau_3;
        //dung tich cac binh nuoc(lit)
	private int binh1_ml=3;
        private int binh2_ml=5;
        private int binh3_ml=8;
        //luong nuoc can do(lit)
        public int timbinhml=4;
	BaBinhNuoc_truoc_sau(int truoc1,int truoc2,int truoc3,int sau1,int sau2,int sau3){
		binh_truoc_1=truoc1;
		binh_truoc_2=truoc2;
                binh_truoc_3=truoc3;
		binh_sau_1=sau1;
		binh_sau_2=sau2;
                binh_sau_3=sau3;
		
	}
        BaBinhNuoc_truoc_sau(){
		binh_truoc_1=0;
		binh_truoc_2=0;
                binh_truoc_3=0;
		binh_sau_1=0;
		binh_sau_2=0;
                binh_sau_3=0;
		
	}
        BaBinhNuoc_truoc_sau(BaBinhNuoc_truoc_sau w){
                    binh_truoc_1=w.binh_truoc_1;
                    binh_truoc_2=w.binh_truoc_2;
                    binh_truoc_3=w.binh_truoc_3;
                    binh_sau_1=w.binh_sau_1;
                    binh_sau_2=w.binh_sau_2;
                    binh_sau_3=w.binh_sau_3;

        }
 
        void assignW(BaBinhNuoc_truoc_sau w_bandau) {
                    this.binh_truoc_1=w_bandau.binh_truoc_1;
                    this.binh_sau_1=w_bandau.binh_sau_1;
                    this.binh_truoc_2=w_bandau.binh_truoc_2;
                    this.binh_sau_2=w_bandau.binh_sau_2;
                    this.binh_truoc_3=w_bandau.binh_truoc_3;
                    this.binh_sau_3=w_bandau.binh_sau_3;
	}
        public void print_babinhnuoc(){
        System.out.print("("+this.binh_sau_1+" "+this.binh_sau_2+" "+this.binh_sau_3+ ")");
        }
        public void print_data_Status(){
            System.out.print("("+this.binh_truoc_1+","+this.binh_truoc_2+","+this.binh_truoc_3+","+this.binh_sau_1+","+this.binh_sau_2+ ","+this.binh_sau_3+")");
        }
        void assign_Value_BaBinhNuoc(int truoc1,int truoc2,int truoc3,int sau1,int sau2,int sau3){
		binh_truoc_1=truoc1;
		binh_truoc_2=truoc2;
                binh_truoc_3=truoc3;
		binh_sau_1=sau1;
		binh_sau_2=sau2;
		binh_sau_3=sau3;
	}
         
	public boolean is_equal_status(BaBinhNuoc_truoc_sau w){
            return this.binh_truoc_1==w.binh_truoc_1&&this.binh_truoc_2==w.binh_truoc_2&&this.binh_truoc_3==w.binh_truoc_3&&this.binh_sau_1==w.binh_sau_1&&this.binh_sau_2==w.binh_sau_2&&this.binh_sau_3==w.binh_sau_3;
        }
	
	public void Full_1() {
			this.binh_sau_1=binh1_ml;
	
	}
	public void Full_2() {
			binh_sau_2=binh2_ml;
	
	}
        public void Full_3() {
			binh_sau_3=binh3_ml;
	
	}
	public void Empty_1() {
		binh_sau_1=0;
		
	}
	public void Empty_2() {
		binh_sau_2=0;
		
	}
        public void Empty_3() {
		binh_sau_3=0;
		
	}
        //return trang thai sau cua 3 binh
        public BaBinhNuoc get_binh_sau() {
		return new BaBinhNuoc(binh_sau_1,binh_sau_2,binh_sau_3);
		
	}
	public void _1To2() {
		binh_sau_2=binh_sau_2+binh_truoc_1;
                binh_sau_1=binh_sau_2-binh2_ml;
                if(binh_sau_1<0){
                    binh_sau_1=0;
                }
                if(binh_sau_2>binh2_ml) {
			binh_sau_2=binh2_ml;
		}
                
		
	}
        public void _1To3() {
		binh_sau_3=binh_sau_3+binh_truoc_1;
                binh_sau_1=binh_sau_3-binh3_ml;
                if(binh_sau_1<0){
                    binh_sau_1=0;
                }
                if(binh_sau_3>binh3_ml) {
			binh_sau_3=binh3_ml;
		}
                
		
	}
	public void _2To1() {
		binh_sau_1=binh_sau_1+binh_truoc_2;
		
                binh_sau_2=binh_sau_1-binh1_ml;
                if(binh_sau_2<0){
                    binh_sau_2=0;
                }
                if(binh_sau_1>binh1_ml) {
			binh_sau_1=binh1_ml;
		}
                
	}
        public void _2To3() {
		binh_sau_3=binh_sau_3+binh_truoc_2;
		
                binh_sau_2=binh_sau_3-binh3_ml;
                if(binh_sau_2<0){
                    binh_sau_2=0;
                }
                if(binh_sau_3>binh3_ml) {
			binh_sau_3=binh3_ml;
		}
                
	}
        
         public void _3To1() {
		binh_sau_1=binh_sau_1+binh_truoc_3;
		
                binh_sau_3=binh_sau_1-binh1_ml;//* sai binh
                if(binh_sau_3<0){
                    binh_sau_3=0;
                }
                if(binh_sau_1>binh1_ml) {
			binh_sau_1=binh1_ml;
		}
                
	}
          public void _3To2() {
		binh_sau_2=binh_sau_2+binh_truoc_3;
		
                binh_sau_3=binh_sau_2-binh2_ml;
                if(binh_sau_3<0){
                    binh_sau_3=0;
                }
                if(binh_sau_2>binh2_ml) {
			binh_sau_2=binh2_ml;
		}
                
	}
        public boolean IsChild(int binh_sau_1,int binh_sau_2,int binh_sau_3){
            if(this.binh_truoc_1==binh_sau_1 && this.binh_truoc_2==binh_sau_2 &&this.binh_truoc_3==binh_sau_3 && ((this.binh_truoc_1!=this.binh_sau_1 || this.binh_sau_2!=this.binh_truoc_2 || this.binh_sau_3!=this.binh_truoc_3))){
                return true;
            }
            return false;
        }
	public boolean  KiemTraThoaMan() {
		if(binh_truoc_1==timbinhml || binh_truoc_2==timbinhml ||binh_truoc_3==timbinhml || binh_sau_1 ==timbinhml || binh_sau_2==timbinhml||binh_sau_3 ==timbinhml ) {
			return true;
		}
		return false;
		
	}
}
