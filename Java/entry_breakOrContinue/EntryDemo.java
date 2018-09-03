class EntryDemo {
	public static void main(String[] args){
		entry:
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(i==1){
					continue entry;
				}
				if(i==3){
					break entry;
				}
				System.out.print(i+","+j+"  ");
			}
			System.out.println("");
		}
	}
}
