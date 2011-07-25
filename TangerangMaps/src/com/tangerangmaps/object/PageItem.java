package com.tangerangmaps.object;

public class PageItem {
	
	ButtonItem btnR1C1, btnR1C2, btnR2C1, btnR2C2, 
	btnR3C1, btnR3C2;
//	int btnItem[][] = new int[2][1];
//	
//	
//	private PageItem(int[][] btnItem) {
//		super();
//		this.btnItem = btnItem;
//		this.btnR1C1 = new ButtonItem(btnItem[0][0], btnItem[0][1]);
//		
//	}

	public PageItem(ButtonItem btnR1C1, ButtonItem btnR1C2,
			ButtonItem btnR2C1, ButtonItem btnR2C2, ButtonItem btnR3C1,
			ButtonItem btnR3C2) {
		super();
		this.btnR1C1 = btnR1C1;
		this.btnR1C2 = btnR1C2;
		this.btnR2C1 = btnR2C1;
		this.btnR2C2 = btnR2C2;
		this.btnR3C1 = btnR3C1;
		this.btnR3C2 = btnR3C2;
	}
	
	public PageItem(){
		
	}

	public ButtonItem getBtnR1C1() {
		return btnR1C1;
	}

	public void setBtnR1C1(ButtonItem btnR1C1) {
		this.btnR1C1 = btnR1C1;
	}

	public ButtonItem getBtnR1C2() {
		return btnR1C2;
	}

	public void setBtnR1C2(ButtonItem btnR1C2) {
		this.btnR1C2 = btnR1C2;
	}

	public ButtonItem getBtnR2C1() {
		return btnR2C1;
	}

	public void setBtnR2C1(ButtonItem btnR2C1) {
		this.btnR2C1 = btnR2C1;
	}

	public ButtonItem getBtnR2C2() {
		return btnR2C2;
	}

	public void setBtnR2C2(ButtonItem btnR2C2) {
		this.btnR2C2 = btnR2C2;
	}

	public ButtonItem getBtnR3C1() {
		return btnR3C1;
	}

	public void setBtnR3C1(ButtonItem btnR3C1) {
		this.btnR3C1 = btnR3C1;
	}

	public ButtonItem getBtnR3C2() {
		return btnR3C2;
	}

	public void setBtnR3C2(ButtonItem btnR3C2) {
		this.btnR3C2 = btnR3C2;
	}
	
	
	
	
	
}
