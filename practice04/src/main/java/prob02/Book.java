package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;	// 1은 재고 있음, 0은 대여중
	
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;		// 최초 생성 시 1로 세팅
	}

	public void rent() {
		this.stateCode = 0;	// 대여중 상태로 전환
		System.out.println(this.title + "이(가) 대여 됐습니다.");
	}
	
	public void print() {
		String state;
		if(this.stateCode == 1) {
			state = "재고있음";
		} else {
			state = "대여중";
		}
		System.out.println(
				"책 제목:" + this.title +
				", 작가:" + this.author +
				", 대여 유무:" + state
				);
	}
	
	public final int getBookNo() {
		return bookNo;
	}

	public final void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getAuthor() {
		return author;
	}

	public final void setAuthor(String author) {
		this.author = author;
	}

	public final int getStateCode() {
		return stateCode;
	}

	public final void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	

	
}
