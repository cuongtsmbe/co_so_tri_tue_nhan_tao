
package ToMau;

public class ToMau {
    
    public static void  main(String[] args){
        int[][] Arr = {         {0,1,1,1,0,0,0,0,0,0,1,1},
                                {1,0,1,1,0,0,0,0,0,0,0,0},
                                {1,1,0,1,0,0,0,0,0,0,0,0},
                                {1,1,1,0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,1,1,0,0,1,0,0},
                                {0,0,0,0,1,0,1,0,0,1,0,0},
                                {0,0,0,0,1,1,0,0,0,1,0,0},
                                {0,0,0,0,0,0,0,0,1,1,0,0},
                                {0,0,0,0,0,0,0,1,0,1,0,0},
                                {0,0,0,0,1,1,1,1,1,0,0,0},
                                {1,0,0,0,0,0,0,0,0,0,0,1},
                                {1,0,0,0,0,0,0,0,0,0,1,0},
        };
       ToMauThamLam ToMauThamLam=new ToMauThamLam();
       ToMauThamLam.ToMauThamLam(Arr);
       SXThuTuKetHopThamLam ToMauThuTu=new SXThuTuKetHopThamLam();
       ToMauThuTu.ToMauThuTuThamLam(Arr);
       ToMauToiUu TMTU=new ToMauToiUu();
       TMTU.ToMauToiUu(Arr);
    }
}
