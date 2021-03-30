package dto;

import java.sql.Date;

public class LibraryDto {
		private int bookNo;
		private String bookTitle;
		private String bookWriter;
		private Date pubDate;
		
		public LibraryDto () {}
		
		public LibraryDto(int bookNo, String bookTitle, String bookWriter, Date pubDate) {
			super();
			this.bookNo = bookNo;
			this.bookTitle = bookTitle;
			this.bookWriter = bookWriter;
			this.pubDate = pubDate;
		}

		public int getBookNo() {
			return bookNo;
		}

		public void setBookNo(int bookNo) {
			this.bookNo = bookNo;
		}

		public String getBookTitle() {
			return bookTitle;
		}

		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}

		public String getBookWriter() {
			return bookWriter;
		}

		public void setBookWriter(String bookWriter) {
			this.bookWriter = bookWriter;
		}

		public Date getPubDate() {
			return pubDate;
		}

		public void setPubDate(Date pubDate) {
			this.pubDate = pubDate;
		}

		@Override
		public String toString() {
			return "\n================================\n"+"[책 번호: " + bookNo + ", 책 제목: " + bookTitle + ", 책 저자: " + bookWriter
					+ ", 출판일: " + pubDate + "]\n"+"================================\n";
		}
		
		
		
}
