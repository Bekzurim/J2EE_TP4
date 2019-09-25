public class Bowling{
	int[] points;
	int tour;

	public Bowling(){
            points=new int[21];
	}

	public void lancer(int nombreDeQuillesAbattues){
            points[tour++]=nombreDeQuillesAbattues;   
        }

	public int score(){
            int score=0;
            int tir=0;
            for (int i=0; i<10; i++){
                if(Strike(tir)){
                    score+=10+StrikeDeSuite(tir);
                    tir++;
                } 
                else if(Spare(tir)){
                    score+=10+SpareDeSuite(tir);
                    tir+= 2;
                }
                else{
                    score+= points[tir]+points[tir+1];
                    tir+= 2;
                }
            }
            return score;
        }
        
	public boolean Strike(int tir){
            return points[tir]==10;
	}
        
        public int StrikeDeSuite(int tir){
            return points[tir+1]+points[tir+2];
	}

	public boolean Spare(int tir){
            return points[tir]+points[tir+1] == 10;
	}

	public int SpareDeSuite(int tir){
            return points[tir+2];
	}
}