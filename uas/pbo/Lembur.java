package uas.pbo;

class Lembur {
    private int gol;
    private String date;
    private int jlembur;

    public Lembur(int gol, int jlembur) {
        this.gol = gol;
        this.date = date;
        this.jlembur = jlembur;
    }

    public double hitungLembur(int gol, int jlembur) {
        int glembur = 0;
        switch(gol){
            case 1 :                      ;
                    glembur=10000 * jlembur;
                    break;
            case 2 :
                    glembur=7500 * jlembur;
                    break;
            case 3 :
                    glembur=5000 * jlembur;
                    break;
            case 4 :
                    glembur=5000 * jlembur;
                    break;
            default :
                    glembur=0;
        }
        return glembur; 
        /* hasil perhitungan bayaran lembur */
    }
}
