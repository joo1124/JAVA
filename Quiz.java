import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

class Word { 
	private String eng; 
	private String kor; 
	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	public String getEnglish() { return eng; }
	public String getKorean() { return kor; }
	
}
public class Quiz {
	private String name;
	private Scanner scanner = new Scanner(System.in);
	private Vector<Word> v;

	public Quiz(String name) {
		this.name = name;
		v = new Vector<Word>();
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "애인"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}
	
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; 
		int index;
		for(int i=0; i<n.length; i++) {
			do {
				index = (int)(Math.random()*v.size());
			} while(index == answerIndex || exists(n, index)); 
			n[i] = index;
		}

		for(int i=0; i<n.length; i++) ex[i] = n[i];
		return (int)(Math.random()*n.length); 
	}
	
	private boolean exists(int n[], int index) {
		for(int i=0; i<n.length; i++) {
			if(n[i] == index)
				return true;
		}
		return false;
	}
	
	public void run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****"); 
		while(true) {
			System.out.print("단어 테스트:1, 단어 삽입:2. 종료:3>> ");
			try {
				int menu = scanner.nextInt();
				switch(menu) {
					case 1: wordQuiz(); break;					
					case 2: insertWords(); break;
					case 3: finish(); return;
					default :
						System.out.println("잘못 입력하였습니다.");
				}
			}
			catch(InputMismatchException e) { 
				scanner.next(); 
				System.out.println("숫자를 입력하세요 !!");
			}
			System.out.println(); 
		}
	}

	private void insertWords() {
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while(true) {
			System.out.print("영어 한글 입력 >> ");
			String engWord = scanner.next(); 
			if(engWord.equals("그만"))
				break;
			
			String korWord = scanner.next(); 
			v.add(new Word(engWord, korWord));
		}		
	}

	private void finish() {
		System.out.println("\"" + name + "\"를 종료합니다.");
		scanner.close();
	}
		
	private void wordQuiz() {
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
		while(true) { 
			int answerIndex = (int)(Math.random()*v.size()); 
			String eng = v.get(answerIndex).getEnglish(); 
			
			int example[] = new int [4];
			
			int answerLoc = makeExample(example, answerIndex); 
			example[answerLoc] = answerIndex; 

			System.out.println(eng + "?");
			
			for(int i=0; i<example.length; i++)
				System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " "); 
			
			System.out.print(":>"); 
			try {
				int in = scanner.nextInt(); 
				if(in == -1) 
					break; 
				
				in--; 
				if(in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No. !!");
			}
			catch(InputMismatchException e) {
				scanner.next(); 
				System.out.println("숫자를 입력하세요 !!");
				
			}
		}		
	}
	
	public static void main(String[] args) {
		Quiz quiz = new Quiz("명품영어");
		quiz.run();
	}

}