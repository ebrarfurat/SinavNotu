import java.util.Random;
public class project02 {

	public static void main(String[] args) {
		Random random = new Random();
	    int kisi = 100;
	    int soru = 50;
	    double toplamNot = 0;
	    
	    int[][] result = new int[kisi][soru];
	    for (int i = 0; i < kisi; i++) {
	        for (int j = 0; j < soru; j++) {
	            int answer = random.nextInt(5); 
	            result[i][j] = answer;
	        }
	    }

	    int[] cevapAnahtar = new int[soru];
	    for (int i = 0; i < soru; i++) {
	        cevapAnahtar[i] = random.nextInt(4); 
	    }

	   
	    double minNot = Double.MAX_VALUE;
	    double maxNot = Double.MIN_VALUE;
	    for (int i = 0; i < kisi; i++) {
	        int dogru = 0;
	        int yanlis = 0;
	        int bos = 0;

	        for (int j = 0; j < soru; j++) {
	            if (result[i][j] == cevapAnahtar[j]) {
	                dogru++;
	            } else if (result[i][j] == 4) {
	                bos++;
	            } else {
	                yanlis++;
	            }
	        }

	        double not = (dogru * 1.0 - yanlis * 0.25) / soru * 100;
	        if (not < minNot) {
	            minNot = not;
	        }
	        if (not > maxNot) {
	            maxNot = not;
	        }
	        toplamNot += not;

	        System.out.println("Öğrenci " + (i + 1) + " : " + dogru + " Doğru, " + yanlis + " Yanlış, "
	                + bos + " Boş cevap= " + not + " puan");
	    }

	    double ortalamaNot = toplamNot / kisi;
	    System.out.println("Ortalama not: " + ortalamaNot);
	    System.out.println("Min not: " + minNot);
	    System.out.println("Max not: " + maxNot);
	}

	}


