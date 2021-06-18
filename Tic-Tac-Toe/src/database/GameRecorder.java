
package database;


public class GameRecorder {
    int pos1;
    int pos2;
    int pos3;
    int pos4;
    int pos5;
    int pos6;
    int pos7;
    int pos8;
    int pos9;
    String player1,player2,winner;

    public GameRecorder() {
    }

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }

    public int getPos3() {
        return pos3;
    }

    public void setPos3(int pos3) {
        this.pos3 = pos3;
    }

    public int getPos4() {
        return pos4;
    }

    public void setPos4(int pos4) {
        this.pos4 = pos4;
    }

    public int getPos5() {
        return pos5;
    }

    public void setPos5(int pos5) {
        this.pos5 = pos5;
    }

    public int getPos6() {
        return pos6;
    }

    public void setPos6(int pos6) {
        this.pos6 = pos6;
    }

    public int getPos7() {
        return pos7;
    }

    public void setPos7(int pos7) {
        this.pos7 = pos7;
    }

    public int getPos8() {
        return pos8;
    }

    public void setPos8(int pos8) {
        this.pos8 = pos8;
    }

    public int getPos9() {
        return pos9;
    }

    public void setPos9(int pos9) {
        this.pos9 = pos9;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
    

    public GameRecorder(int pos1, int pos2, int pos3, int pos4, int pos5, int pos6, int pos7, int pos8, int pos9, String player1, String player2, String winner) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
        this.pos5 = pos5;
        this.pos6 = pos6;
        this.pos7 = pos7;
        this.pos8 = pos8;
        this.pos9 = pos9;
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }
    
    
}
